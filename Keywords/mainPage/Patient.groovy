package mainPage

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

public class Patient {
	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();
	Mainpage mainPage = new Mainpage();

	@Keyword
	def verifyPatientDetails(def subjectCardTitle, def patientName, def patientDOB, def patinetContactNumber, def patientAddress){
		def subjectDetails = mainPage.getSubjectCardDetails();

		// Asserting basic details of the patient in the subject card
		verifications.verifyTextMatch(subjectDetails['subjectCardTitle'], subjectCardTitle, "patient card title does not matched");
		verifications.verifyTextMatch(subjectDetails['subjectAddress'], patientAddress, "patientAddress does not matched");
		verifications.verifyTextMatch(subjectDetails['subjectName'], patientName.replaceAll(',', ' '), "patientName does not matched");
		verifications.verifyTextMatch(subjectDetails['subjectDOB'], patientDOB, "patientDOB does not matched");
		verifications.verifyTextMatch(subjectDetails['subjectContactNumber'], patinetContactNumber, "patinetContactNumber does not matched");

		// Asserting all cards for the patient
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/AppoinmentsCard/cardTitle"), "Appoinments card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/BillingInformationCard/cardTitle"), "Billig information card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/EmergencyInfoCard/cardTitle"), "Emergenecy contact info card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/EmploymentInfoCard/cardTitle"), "Employment info card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/InsuranceDetails/cardTitle"), "Insurance Details card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/PatientCareTeamCard/cardTitle"), "Patient care team card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/PendingReferralsCard/cardTitle"), "Pending Referrals card does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Cards/Pharmacies/cardTitle"), "Pharmacies card does not there for the patient");

		// Asserting tabs for the patient
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/appoinmentsTab"), "Appoinments tab does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/billingTab"), "Billing tab does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/dashboardTab"), "Dashboard tab does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/medicationTab"), "Medication tab does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/ReferralsTab"), "Refarrals tab does not there for the patient");
		verifications.verifyElementPresent(findTestObject("Object Repository/MainPage/Navigations/traigeTab"), "Traige tab does not there for the patient");
	}
}
