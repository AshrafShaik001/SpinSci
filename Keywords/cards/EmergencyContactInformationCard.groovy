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

public class EmergencyContactInformationCard {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def getEmergencyContactDetails(){
		def emerContactDetails = [:];
		emerContactDetails.put('name', actions.getText(findTestObject("Object Repository/MainPage/Cards/EmergencyInfoCard/name")).split(':')[1].trim());
		emerContactDetails.put('contactNumber', actions.getText(findTestObject("Object Repository/MainPage/Cards/EmergencyInfoCard/contactNumber")).split(':')[1].trim());
		return emerContactDetails;
	}

	@Keyword
	def verifyEmergencyContactDetails(def name, def contactNumber){
		def emerContactDetails = getEmergencyContactDetails();
		println emerContactDetails;
		verifications.verifyTextMatch(emerContactDetails['name'], name, "Name does not matched in the Emergency Contact Information card");
		verifications.verifyTextMatch(emerContactDetails['contactNumber'], contactNumber, "contactNumber does not matched in the Emergency Contact Information card");
	}
}
