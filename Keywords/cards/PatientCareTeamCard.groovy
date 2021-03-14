package cards

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import webAutomation.Verifications
import webAutomation.WebActions

public class PatientCareTeamCard {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();
	
	@Keyword
	def getPcpDetails(){
		def details = [:];
		
		details.put('name', actions.getText(findTestObject("Object Repository/MainPage/Cards/PatientCareTeamCard/pcpName")).replaceAll("PCP Name:","").trim());
		details.put('center', actions.getText(findTestObject("Object Repository/MainPage/Cards/PatientCareTeamCard/pcpCenter")).replaceAll("PCP Center:","").trim());
		details.put('dept', actions.getText(findTestObject("Object Repository/MainPage/Cards/PatientCareTeamCard/pcpDep")).replaceAll("PCP Dept:","").trim());
		return details;
	}
	
	@Keyword
	def verifyPcpDetails(def name, def center, def dept){
		def pcpDetails = getPcpDetails();
		if(name!=''){
			verifications.verifyTextMatch(pcpDetails['name'], name, "pcp name does not matched in the pcp card")
		}
		if(center!=''){
			verifications.verifyTextMatch(pcpDetails['center'], center, "pcp center does not matched in the pcp card")
		}
		if(dept!=''){
			verifications.verifyTextMatch(pcpDetails['dept'], dept, "pcp dept does not matched in the pcp card")
		}
	}
	
	
}

