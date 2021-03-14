import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

def patientCallerId = "6082719000";
def patientCalledTo = "4698991226";
def soucePatientName = "Cadence,Anna";
def sourcePatientDOB = "09-09-1983";
def subjectPatientName = "Cadence,Anna";
def subjectPatientDOB = "09-09-1983";
def pharmacyName = "EMC Prescription Pharmacy South";
def pharmacyNumber = "555-555-5555";


// Search with caller ID and called to and verify source and subject
CustomKeywords.'mainPage.Mainpage.searchWith'(patientCallerId, patientCalledTo);
CustomKeywords.'mainPage.Mainpage.verifySource'(soucePatientName, sourcePatientDOB);
CustomKeywords.'mainPage.Mainpage.verifySubject'(subjectPatientName, subjectPatientDOB);

// Verify pharmacy information in pharmacies card
CustomKeywords.'cards.PharmaciesCard.verifyPatientPharmacyDetails'(pharmacyName, pharmacyNumber);

// Navigate to more details of pharmacies information
CustomKeywords.'cards.PharmaciesCard.clickOnGearIcon'();
CustomKeywords.'cards.PharmaciesCard.clickOnMoreDetails'();

// When we click on more details in pharmacy no information is shown