import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import webAutomation.WebActions

class XRayReporting {

	WebActions action = new WebActions()
//	@AfterTestCase
	def AfterTestCase(TestCaseContext testCaseContext)
	{
		postResultToXRay(testCaseContext)
	}

	def getTestCaseErrorMessage(String errorTrace)
	{
		def errors = errorTrace.split('\n')

		String errorString = null
		for(int i=0; i<errors.size(); i++)
		{
			if (errors[i]=="Reason:"){

				errorString = errors[i+1]
				break;
			}
		}

		println "errorString from Test CASE: " + errorString.split(':')[1]

		return (errorString.split(':')[1]).trim()
	}

	def SendRequestToXRAYGraphQL(Map bodyContent)
	{
		println "=======================Execuring SendRequestToXRAYGraphQL======================="
		println "Map bodyContent: " + bodyContent

		if(GlobalVariable.XrayApiToken == ""){
			def tokenResponse = WS.sendRequest(findTestObject('Object Repository/JiraApi/GetToken'))
			WS.verifyResponseStatusCode(tokenResponse, 200)

			String tokenString = tokenResponse.getResponseBodyContent()
			println "tokenString   :" + tokenString

			def XrayApiToken = tokenString.substring(1, tokenString.length()-1)

			println "XrayApiToken   :" + XrayApiToken

			GlobalVariable.XrayApiToken = XrayApiToken
		}

		String jsonBodyContent = ""

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			jsonBodyContent = objectMapper.writeValueAsString(bodyContent);
			println "GraphQL Query: "+ jsonBodyContent
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		HttpTextBodyContent httpBodyContent = new HttpTextBodyContent(jsonBodyContent);
		println "httpBodyContent:"+httpBodyContent

		RequestObject  requestObj = findTestObject('Object Repository/JiraApi/XRAYGraphQl')
		requestObj.setBodyContent(httpBodyContent)

		def response = WS.sendRequest(requestObj)

		println "response: "+ response
		//WS.verifyResponseStatusCode(response, 200)

		def responseBody = response.getResponseBodyContent()

		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		println "jsonResponseBody: "+ jsonResponseBody
		return jsonResponseBody
	}

	def AddTestToExecution(def testIssueId, def testExecIssueId)
	{

		Map addTestsToTestExecutionQuery =	["query":"mutation {\n    addTestsToTestExecution(\n        issueId: \""+ testExecIssueId +"\",\n        testIssueIds: [\""+ testIssueId +"\"]\n    ) {\n        addedTests\n        warning\n    }\n}"]
		def getTestRunJSONResponse = SendRequestToXRAYGraphQL(addTestsToTestExecutionQuery)
		return getTestRunJSONResponse

	}

	def postResultToXRay(TestCaseContext testCaseContext) 
	{
		def evidenceList = getEvidenceList(testCaseContext)

		// Get JIRA KeyId of the test case
		def keyId =  testCaseContext.testCaseVariables.get("JiraKeyId")

		// Get test execution result - PASSED/FAILED
		def testCaseStatus = testCaseContext.getTestCaseStatus()
        def testCaseErrorMessage = ""
		
        // Get error message
		if (testCaseStatus == "FAILED" || testCaseStatus == "ERROR") {
			testCaseStatus = "FAILED"
			testCaseErrorMessage= getTestCaseErrorMessage (testCaseContext.getMessage())
		}

		// Get test execution jira issue id, test jira issue id, test run id
		def execKeyId = GlobalVariable.XRAYTestExecutionKey
		def testExecIssueId 
		if(execKeyId == "")
		{
			def testExecutionName = action.getTestExecutionName()
			def executionId = getExistingTestExecutionId(testExecutionName)
			if(executionId == "not exists")
			{
				testExecIssueId = CreateTestExecution(testExecutionName)
			}
			else
			{
				testExecIssueId = executionId
			}
		}
		else
		{
			testExecIssueId =  getJiraIssueId(execKeyId)
		}
		def testIssueId = 	getJiraIssueId(keyId)
		Map getTestRunQuery = ["query":"{\n    getTestRun( testIssueId: \""+testIssueId+"\", testExecIssueId: \""+ testExecIssueId +"\") {\n        id\n    }\n}"]
		def getTestRunJSONResponse = SendRequestToXRAYGraphQL(getTestRunQuery)
		def testRunId
		if( getTestRunJSONResponse.data.getTestRun != null) {
			testRunId = getTestRunJSONResponse.data.getTestRun.id
		}
		else {
			AddTestToExecution(testIssueId, testExecIssueId)
			getTestRunJSONResponse = SendRequestToXRAYGraphQL(getTestRunQuery)
			testRunId = getTestRunJSONResponse.data.getTestRun.id
		}

		// Update the test run
		Map updateTestRunStatusQuery =  ["query":"mutation {\n    updateTestRunStatus( id: \""+testRunId+"\", status: \""+testCaseStatus+"\")\n}"]
		def updateTestRunStatusJSONResponse = SendRequestToXRAYGraphQL(updateTestRunStatusQuery)

		// Add Comment if the test is failed
		if(testCaseStatus == "FAILED")
		{
			Map updateTestRunCommentQuery =  ["query":"mutation {\n    updateTestRunComment( id: \""+testRunId+"\", comment: \""+testCaseErrorMessage+"\")\n}"]
			def updateTestRunCommentJSONResponse = SendRequestToXRAYGraphQL(updateTestRunCommentQuery)
		}

		// Add evidence screenshots
		for(int i=1; i<=GlobalVariable.screenshorts.size();i++)
		{	
			Map addEvidenceToTestRunQuery =  ["query":"mutation {\n    addEvidenceToTestRun(\n        id: \""+testRunId+"\",\n        evidence: [\n            {\n                filename: \"Screenshot"+i+".png\"\n                mimeType: \"png\"\n                data: \""+GlobalVariable.screenshorts[i-1]+"\"\n            }\n        ]\n    ) {\n        addedEvidence\n        warnings\n    }\n}"]
            def addEvidenceToTestRunJSONResponse = SendRequestToXRAYGraphQL(addEvidenceToTestRunQuery)
		}
		
		// Add debug log if the test NOT passed
		if(testCaseStatus != "PASSED")
		{
			if(evidenceList != null){
				for(int i=0; i<evidenceList.size();i++)
				{
					Map addEvidenceToTestRunQuery =  ["query":"mutation {\n    addEvidenceToTestRun(\n        id: \""+testRunId+"\",\n        evidence: [\n            {\n                filename: \"evidence.txt\"\n                mimeType: \"text/plain\"\n                data: \""+evidenceList[i]+"\"\n            }\n        ]\n    ) {\n        addedEvidence\n        warnings\n    }\n}"]
					def addEvidenceToTestRunJSONResponse = SendRequestToXRAYGraphQL(addEvidenceToTestRunQuery)
				}
			}
		}
	}

	def getJiraIssueId(def jiraKeyId)
	{
		def res = WS.sendRequest(findTestObject('Object Repository/JiraApi/GetIssueId', ['keyId' : jiraKeyId]))
		WS.verifyResponseStatusCode(res, 200)
		def resBody = res.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResBody = parser.parseText(resBody)
		def jiraIssueId = jsonResBody.id
		return jiraIssueId
	}

	def getEvidenceList(testCaseContext){

		def evidenceList = []

		// get test execution result - PASSED/FAILED
		def testCaseStatus = testCaseContext.getTestCaseStatus()

		def testCaseErrorMessage = ""

		if (testCaseStatus == "FAILED" || testCaseStatus == "ERROR") {
			testCaseErrorMessage = testCaseContext.getMessage()
			evidenceList.add(testCaseErrorMessage.bytes.encodeBase64().toString())
		}

		if(evidenceList.size() > 0)
			return evidenceList
		else
			return null
	}

	def CreateTestExecution(def testExecutionName)
	{

		Map createTestExecutionQuery =  ["query":"mutation {\n    createTestExecution(\n        jira: {\n            fields: { summary: \""+testExecutionName+"\", project: {key: \"SQ\"} }\n        }\n    ) {\n        testExecution {\n            issueId\n            \n        }\n        warnings\n        createdTestEnvironments\n    }\n}"]
		//Map addTestsToTestExecutionQuery =	["query":"mutation {\n    addTestsToTestExecution(\n        issueId: \""+ testExecIssueId +"\",\n        testIssueIds: [\""+ testIssueId +"\"]\n    ) {\n        addedTests\n        warning\n    }\n}"]
		def createTestExecutionResponse = SendRequestToXRAYGraphQL(createTestExecutionQuery)
		return createTestExecutionResponse.data.createTestExecution.testExecution.issueId

	}
	
	def getExistingTestExecutionId(def testExecutionName)
	{

		Map getExecutionsQuery = ["query":"{\n    getTestExecutions(jql: \"project = 'SQ'\", limit: 100) {\n        total\n        start\n        limit\n        results {\n            issueId\n            jira(fields: [\"summary\"])\n        }\n    }\n}"]
		def getAllTestExecutionResponse = SendRequestToXRAYGraphQL(getExecutionsQuery)
		def testExecutions = getAllTestExecutionResponse.data.getTestExecutions.results
		for(int i = 0; i<testExecutions.size();i++)
		{
			if(testExecutions[i].jira.summary == testExecutionName)
			{
				return testExecutions[i].issueId
			}
		}
		return "not exists"
	}
}