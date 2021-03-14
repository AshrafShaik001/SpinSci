import internal.GlobalVariable
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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


def patientCallerId = "2158821126";
def patientCalledTo = "4698991226";
def soucePatientName = "Cadence,Anna";
def sourcePatientDOB = "09-09-1983";
def subjectPatientName = "Cadence,Anna";
def subjectPatientDOB = "09-09-1983";

// Search with caller ID and called to and verify source and subject
CustomKeywords.'mainPage.Mainpage.searchWith'(patientCallerId, patientCalledTo);
CustomKeywords.'mainPage.Mainpage.verifySource'(soucePatientName, sourcePatientDOB);
CustomKeywords.'mainPage.Mainpage.verifySubject'(subjectPatientName, subjectPatientDOB);

// Navigate to apointment details
CustomKeywords.'cards.AppoinmentCard.clickOnGearIcon'();
CustomKeywords.'cards.AppoinmentCard.clickOnMoreDetails'();

// Filter by No Show status
CustomKeywords.'tabs.AppoinmentsTab.switchToNoShowsAppoinments'();

// Verify one apointment details
CustomKeywords.'tabs.AppoinmentsTab.verifyAppoinment'("7/21/2020", "EMH PHX CTH DEPT", "Coordinator Phoenix, RN", "TRANSPLANT EVALUATION", "No Show", "4:30 PM");





