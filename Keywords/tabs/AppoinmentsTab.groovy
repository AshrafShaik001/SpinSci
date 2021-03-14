package tabs

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

public class AppoinmentsTab {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def verifyAppoinment(def date, def department, def provider, def visitType, def status, def appointmentTime){
		def appointmentDetails = getAppoinmentDetailsBasedOnIndex(1);

		verifications.verifyTextMatch(date, appointmentDetails['Date'], "appointment date value does not matched");
		verifications.verifyTextMatch(department, appointmentDetails['Department'], "appointment department value does not matched");
		verifications.verifyTextMatch(provider, appointmentDetails['Provider'], "appointment provider value does not matched");
		verifications.verifyTextMatch(visitType, appointmentDetails['VisitType'], "appointment visitType value does not matched");
		verifications.verifyTextMatch(status, appointmentDetails['Status'], "appointment status value does not matched");
		verifications.verifyTextMatch(appointmentTime, appointmentDetails['AppointmentTime'], "appointment Time value does not matched");
	}

	@Keyword
	def switchToFutureAppoinments(){
		actions.click(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/futureAppoinments"));
	}
	
	@Keyword
	def switchToPastAppoinments(){
		actions.click(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/pastAppoinments"));
	}

	@Keyword
	def switchToCancelledAppoinments(){
		actions.click(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/cancelledAppoinments"));
	}

	@Keyword
	def switchToNoShowsAppoinments(){
		actions.click(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/noShowsAppoinments"));
	}

	@Keyword
	def getAppoinmentDetailsBasedOnIndex(def index){
		def appoinmentDetails = [:]
		appoinmentDetails.put('Date', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 1])));
		appoinmentDetails.put('Department', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 2])));
		appoinmentDetails.put('Provider', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 3])));
		appoinmentDetails.put('VisitType', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 4])));
		appoinmentDetails.put('Status', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 5])));
		appoinmentDetails.put('AppointmentTime', actions.getText(findTestObject("Object Repository/MainPage/Tabs/AppoinmentsTab/tableCell",["row_index": index, "column_index": 6])));
		return appoinmentDetails;
	}
}
