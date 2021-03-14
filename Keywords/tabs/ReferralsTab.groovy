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

public class ReferralsTab {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def verifyReferral(def referralId, def referralBy, def referralTo, def referraltype, def referralStatus){
		def appointmentDetails = getReferralDetailsBasedOnIndex(1);

		verifications.verifyTextMatch(referralId, appointmentDetails['ReferralID'], " ReferralID value does not matched");
		verifications.verifyTextMatch(referralBy, appointmentDetails['ReferralBy'], "Referral By value does not matched");
		verifications.verifyTextMatch(referralTo, appointmentDetails['ReferralTo'], "Referral To  value does not matched");
		verifications.verifyTextMatch(referraltype, appointmentDetails['ReferralType'], "Referral Type  value does not matched");
		verifications.verifyTextMatch(referralStatus, appointmentDetails['ReferralStatus'], "Referral status value does not matched");
	}

	@Keyword
	def getReferralDetailsBasedOnIndex(def index){
		def referralDetails = [:]
		referralDetails.put('ReferralID', actions.getText(findTestObject("Object Repository/MainPage/Tabs/ReferralsTab/tableCell",["row_index": index, "column_index": 1])));
		referralDetails.put('ReferralBy', actions.getText(findTestObject("Object Repository/MainPage/Tabs/ReferralsTab/tableCell",["row_index": index, "column_index": 2])));
		referralDetails.put('ReferralTo', actions.getText(findTestObject("Object Repository/MainPage/Tabs/ReferralsTab/tableCell",["row_index": index, "column_index": 3])));
		referralDetails.put('ReferralType', actions.getText(findTestObject("Object Repository/MainPage/Tabs/ReferralsTab/tableCell",["row_index": index, "column_index": 4])));
		referralDetails.put('ReferralStatus', actions.getText(findTestObject("Object Repository/MainPage/Tabs/ReferralsTab/tableCell",["row_index": index, "column_index": 5])));
		return referralDetails;
	}
}
