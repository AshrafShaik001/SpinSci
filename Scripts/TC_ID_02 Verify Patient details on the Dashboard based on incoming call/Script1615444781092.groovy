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


def patientCallerId = "6082719000";
def patientCalledTo = "4698991226";
def soucePatientName = "Cadence,Sam";
def sourcePatientDOB = "09-12-1949";
def subjectPatientName = "Cadence,Alyssa";
def subjectPatientDOB = "03-24-1978";
def subjectPatientlocation = "VERONA,Wisconsin,53593";
CustomKeywords.'mainPage.Mainpage.searchWith'(patientCallerId, patientCalledTo);
CustomKeywords.'mainPage.Mainpage.verifySource'(soucePatientName, sourcePatientDOB);
CustomKeywords.'mainPage.Mainpage.verifySubject'(subjectPatientName, subjectPatientDOB, subjectPatientlocation);
def soureCardDetails = CustomKeywords.'mainPage.Mainpage.getSourceCardDetails'();
println soureCardDetails
def subjectCardDetails = CustomKeywords.'mainPage.Mainpage.getSubjectCardDetails'();
println subjectCardDetails
