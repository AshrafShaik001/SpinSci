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

public class PharmaciesCard {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def clickOnGearIcon(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/Pharmacies/gearIcon"));
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/Pharmacies/moreDetailsOption"), "Gear icon does not showing options");
	}

	@Keyword
	def clickOnMoreDetails(){
		actions.click(findTestObject("Object Repository/MainPage/Cards/Pharmacies/moreDetailsOption"));
		//verifications.verifyElementNotPresent(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/moreDetailsOption"), "More details in appoinments card is not functional");
	}

	@Keyword
	def getPatientPharmacyDetails(){
		def pharmacyDetails = [:];
		pharmacyDetails.put('pharmacyName', actions.getText(findTestObject("Object Repository/MainPage/Cards/Pharmacies/prefPharamacyName")).split(':')[1].trim());
		pharmacyDetails.put('pharmacyNumber', actions.getText(findTestObject("Object Repository/MainPage/Cards/Pharmacies/pharmacyNumber")).split(':')[1].trim());
		return pharmacyDetails;
	}

	@Keyword
	def verifyPatientPharmacyDetails(def pharmacyName, def pharmacyNumber){
		def pharmacyDetails = getPatientPharmacyDetails();
		println pharmacyDetails;
		verifications.verifyTextMatch(pharmacyDetails['pharmacyName'], pharmacyName, "pharmacyNumber does not matched in the pharmacies card");
		verifications.verifyTextMatch(pharmacyDetails['pharmacyNumber'], pharmacyNumber, "pharmacyNumber does not matched in the pharmacies card");
	}
}
