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

public class ReferralsCard {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def clickOnGearIcon(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/gearIcon"));
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/moreDetailsOption"), "Gear icon does not showing options");
	}

	@Keyword
	def clickOnMoreDetails(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/moreDetailsOption"));
		//verifications.verifyElementNotPresent(findTestObject("Object Repository/MainPage/Cards/AppoinmentsCard/moreDetailsOption"), "More details in appoinments card is not functional");
	}

	@Keyword
	def getUpcomingReferrals(){
		return actions.getText(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/upComingReferralsNumber")).trim();
	}

	@Keyword
	def getClosedReferrals(){
		return actions.getText(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/closedReferralsNumber")).trim();
	}

	@Keyword
	def verifyUpcomingReferrals(def upcomingReferrals){
		def currentUpcomingReferrals = getUpcomingReferrals();
		verifications.verifyTextMatch(currentUpcomingReferrals, upcomingReferrals, "The upcoming referrals data does not matched in pending referrals card")
	}

	@Keyword
	def verifyClosedReferrals(def closedReferrals){
		def currentClosedReferrals = getClosedReferrals();
		verifications.verifyTextMatch(currentClosedReferrals, closedReferrals, "The closed referrals data does not matched in pending referrals card")
	}
}