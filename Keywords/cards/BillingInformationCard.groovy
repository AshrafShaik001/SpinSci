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

public class BillingInformationCard {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def clickOnGearIcon(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/gearIcon"));
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/moreDetailsOption"), "Gear icon does not showing options");
	}

	@Keyword
	def clickOnMoreDetails(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/moreDetailsOption"));
		//verifications.verifyElementNotPresent(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/moreDetailsOption"), "More details in appoinments card is not functional");
	}

	@Keyword
	def getPatientBillingDetails(){
		def billingDetails = [:];
		billingDetails.put('bills', actions.getText(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/patientBills")).trim());
		billingDetails.put('patientBalance', actions.getText(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/patientBalanceAmount")).trim());
		billingDetails.put('insuranceBalance', actions.getText(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/insuranceBalanceAmount")).trim());
//		billingDetails.put('serviceArea', actions.getText(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/serviceArea")).split(':')[1].trim());
		return billingDetails;
	}
	
	@Keyword
	def verifyPatientBillingDetails(def bills, def patientBalance, def insuranceBalance){
		def billingDetails = getPatientBillingDetails();
		println billingDetails;
		verifications.verifyTextMatch(billingDetails['bills'], bills, "bills count of patient does not matched in the billing information card");
		verifications.verifyTextMatch(billingDetails['patientBalance'], '$'+patientBalance, "patientBalance of patient does not matched in the billing information card");
		verifications.verifyTextMatch(billingDetails['insuranceBalance'], '$'+insuranceBalance, "insuranceBalance of patient does not matched in the billing information card");
		
	}
}
