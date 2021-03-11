package mainPage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

import webAutomation.Verifications
import webAutomation.WebActions
public class Mainpage {

	WebActions actions = new WebActions()
	Verifications verifications = new Verifications()

	@Keyword
	def searchWith(def patientCallerId, def patientCalledTo) {
		actions.sendKeys(findTestObject('Object Repository/MainPage/patientCallerIdInputBox'), patientCallerId);
		actions.sendKeys(findTestObject('Object Repository/MainPage/patientCalledToInputBox'), patientCalledTo);
		actions.click(findTestObject('Object Repository/MainPage/submitButton'));
		verifications.verifyElementNotPresent(findTestObject('Object Repository/MainPage/noOngoingIterationText'), "Invalid pateintcaller id or invalid patient called to id")
	}

	@Keyword
	def reset() {
		actions.click(findTestObject('Object Repository/MainPage/resetButton'));
		verifications.verifyElementPresent(findTestObject('Object Repository/MainPage/noOngoingIterationText'), "Reset is not working")
	}

	@Keyword
	def verifySource(def patientName, def dataOfBirth = "", def location = ""){
		verifications.verifyElementPresent(findTestObject("MainPage/Verification/getTableRowsBasedonPatientName",["patient_name": patientName]), "No record found with the "+patientName+" name")
		actions.scrollToElement(findTestObject("MainPage/Verification/getTableRowsBasedonPatientName",["patient_name": patientName]));
		if(dataOfBirth!=""){
			def dobOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getDOBOfPatient", ["patient_name": patientName]));
			if(dobOfPatient!=dataOfBirth){
				if(location!=""){
					def locationOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getAddressOfPatient", ["patient_name": patientName]));
					if(location!=""){
						println "nothing matched"
					}
					else{
						clickOnCheckMarkOfPatinetInSourceTab(patientName);
					}
				}
			}
			else {
				clickOnCheckMarkOfPatinetInSourceTab(patientName);
			}
		}
		else if(location!=""){
			def locationOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getAddressOfPatient", ["patient_name": patientName]));
			if(location!=""){
				println "nothing matched"
			}
			else{
				clickOnCheckMarkOfPatinetInSourceTab(patientName);
			}
		}
	}

	@Keyword
	def verifySubject(def patientName, def dateOfBirth = "", def location = ""){
		verifications.verifyElementPresent(findTestObject("MainPage/Verification/getTableRowsBasedonPatientName",["patient_name": patientName]), "No record found with the "+patientName+" name")
		actions.scrollToElement(findTestObject("MainPage/Verification/getTableRowsBasedonPatientName",["patient_name": patientName]));
		if(dateOfBirth!=""){
			def dobOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getDOBOfPatient", ["patient_name": patientName]));
			if(dobOfPatient!=dateOfBirth){
				if(location!=""){
					def locationOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getAddressOfPatient", ["patient_name": patientName]));
					println locationOfPatient
					if(location!=locationOfPatient){
						println "nothing matched"
					}
					else{
						clickOnCheckMarkOfPatinetInSubjectTab(patientName);
					}
				}
			}
			else {
				clickOnCheckMarkOfPatinetInSubjectTab(patientName);
			}
		}
		else if(location!=""){
			def locationOfPatient = actions.getText(findTestObject("Object Repository/MainPage/Verification/getAddressOfPatient", ["patient_name": patientName]));
			println locationOfPatient
			if(location!=locationOfPatient){
				println "nothing matched"
			}
			else{
				clickOnCheckMarkOfPatinetInSubjectTab(patientName);
			}
		}
	}

	@Keyword
	def clickOnCheckMarkOfPatinetInSourceTab(String patientName){
		actions.click(findTestObject("Object Repository/MainPage/Verification/verifyCheckMarkOfPatient", ["patient_name": patientName]));
		String patient_full_name = patientName.replaceAll(",", " ");
		println patient_full_name
		def titleOfSourceTab = actions.getText(findTestObject("Object Repository/MainPage/Verification/sourceTabName"));
		verifications.verifyTextMatch(patient_full_name, titleOfSourceTab, "Source tab does not have the "+patientName+" name");
	}

	def clickOnCheckMarkOfPatinetInSubjectTab(String patientName){
		actions.click(findTestObject("Object Repository/MainPage/Verification/verifyCheckMarkOfPatient", ["patient_name": patientName]));
		verifications.verifyElementNotPresent(findTestObject("Object Repository/MainPage/Verification/subjectTabName"), "patient name not selected in the subject tab");
	}

	@Keyword
	def getSourceCardDetails(){
		def sourceCardDetails = [:]
		sourceCardDetails.put('sourceCardTitle',actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceTitle")));
		sourceCardDetails.put('sourceAddress',actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceAddress")).split(":")[1].trim());
		//		sourceCardDetails.put('sourceEmail', actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceEmail")).split(":")[1].trim());
		sourceCardDetails.put('sourceName', actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/SourceName")));
		sourceCardDetails.put('sourceDOB', actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceDOB")).split(":")[1].trim());
		//		sourceCardDetails.put('sourceEmpi', actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceEmpi")).split(":")[1].trim());
		//		sourceCardDetails.put('sourceContactNumber', actions.getText(findTestObject("Object Repository/MainPage/Cards/SourceCard/sourceContactNumber")).split(":")[1].trim());
		return sourceCardDetails;
	}

	@Keyword
	def getSubjectCardDetails(){
		def subjectCardDetails = [:]
		subjectCardDetails.put('subjectCardTitle',actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectTitle")));
		subjectCardDetails.put('subjectAddress',actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectAddress")).split(":")[1].trim());
		//		subjectCardDetails.put('subjectEmail', actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectEmail")).split(":")[1].trim());
		subjectCardDetails.put('subjectName', actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectName")));
		subjectCardDetails.put('subjectDOB', actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectDOB")).split(":")[1].trim());
		//		subjectCardDetails.put('subjectEmpi', actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectEmpi")).split(":")[1].trim());
		//		subjectCardDetails.put('subjectContactNumber', actions.getText(findTestObject("Object Repository/MainPage/Cards/SubjectCard/subjectContactNumber")).split(":")[1].trim());
		return subjectCardDetails;
	}
}
