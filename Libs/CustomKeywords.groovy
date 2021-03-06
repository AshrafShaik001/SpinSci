
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.util.List

import java.util.Map



def static "mainPage.Patient.verifyPatientDetails"(
    	Object subjectCardTitle	
     , 	Object patientName	
     , 	Object patientDOB	
     , 	Object patinetContactNumber	
     , 	Object patientAddress	) {
    (new mainPage.Patient()).verifyPatientDetails(
        	subjectCardTitle
         , 	patientName
         , 	patientDOB
         , 	patinetContactNumber
         , 	patientAddress)
}


def static "tabs.AppoinmentsTab.verifyAppoinment"(
    	Object date	
     , 	Object department	
     , 	Object provider	
     , 	Object visitType	
     , 	Object status	
     , 	Object appointmentTime	) {
    (new tabs.AppoinmentsTab()).verifyAppoinment(
        	date
         , 	department
         , 	provider
         , 	visitType
         , 	status
         , 	appointmentTime)
}


def static "tabs.AppoinmentsTab.switchToFutureAppoinments"() {
    (new tabs.AppoinmentsTab()).switchToFutureAppoinments()
}


def static "tabs.AppoinmentsTab.switchToPastAppoinments"() {
    (new tabs.AppoinmentsTab()).switchToPastAppoinments()
}


def static "tabs.AppoinmentsTab.switchToCancelledAppoinments"() {
    (new tabs.AppoinmentsTab()).switchToCancelledAppoinments()
}


def static "tabs.AppoinmentsTab.switchToNoShowsAppoinments"() {
    (new tabs.AppoinmentsTab()).switchToNoShowsAppoinments()
}


def static "tabs.AppoinmentsTab.getAppoinmentDetailsBasedOnIndex"(
    	Object index	) {
    (new tabs.AppoinmentsTab()).getAppoinmentDetailsBasedOnIndex(
        	index)
}


def static "tabs.ReferralsTab.verifyReferral"(
    	Object referralId	
     , 	Object referralBy	
     , 	Object referralTo	
     , 	Object referraltype	
     , 	Object referralStatus	) {
    (new tabs.ReferralsTab()).verifyReferral(
        	referralId
         , 	referralBy
         , 	referralTo
         , 	referraltype
         , 	referralStatus)
}


def static "tabs.ReferralsTab.getReferralDetailsBasedOnIndex"(
    	Object index	) {
    (new tabs.ReferralsTab()).getReferralDetailsBasedOnIndex(
        	index)
}


def static "cards.ReferralsCard.clickOnGearIcon"() {
    (new cards.ReferralsCard()).clickOnGearIcon()
}


def static "cards.ReferralsCard.clickOnMoreDetails"() {
    (new cards.ReferralsCard()).clickOnMoreDetails()
}


def static "cards.ReferralsCard.getUpcomingReferrals"() {
    (new cards.ReferralsCard()).getUpcomingReferrals()
}


def static "cards.ReferralsCard.getClosedReferrals"() {
    (new cards.ReferralsCard()).getClosedReferrals()
}


def static "cards.ReferralsCard.verifyUpcomingReferrals"(
    	Object upcomingReferrals	) {
    (new cards.ReferralsCard()).verifyUpcomingReferrals(
        	upcomingReferrals)
}


def static "cards.ReferralsCard.verifyClosedReferrals"(
    	Object closedReferrals	) {
    (new cards.ReferralsCard()).verifyClosedReferrals(
        	closedReferrals)
}


def static "webAutomation.Verifications.verifyElementPresent"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementPresent(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyElementPresentAndContinueOnFailure"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementPresentAndContinueOnFailure(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyElementNotPresent"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementNotPresent(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyElementNotPresentAndContinuewOnFailure"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementNotPresentAndContinuewOnFailure(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyTextMatch"(
    	String actual	
     , 	String expected	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyTextMatch(
        	actual
         , 	expected
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementVisible"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementVisible(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotVisible"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementNotVisible(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotVisibleAndContinuewOnFailure"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementNotVisibleAndContinuewOnFailure(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyElementClickable"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementClickable(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotClickable"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementNotClickable(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyTextboxEditable"(
    	TestObject element	) {
    (new webAutomation.Verifications()).verifyTextboxEditable(
        	element)
}


def static "webAutomation.Verifications.verifyElementPresentInMobile"(
    	TestObject element	
     , 	String failureDescription	
     , 	int maxWaitTime	) {
    (new webAutomation.Verifications()).verifyElementPresentInMobile(
        	element
         , 	failureDescription
         , 	maxWaitTime)
}


def static "webAutomation.Verifications.verifyObjectsMatch"(
    	Object actual	
     , 	Object expected	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyObjectsMatch(
        	actual
         , 	expected
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementPresent"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementPresent(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementPresentAndContinueOnFailure"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementPresentAndContinueOnFailure(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotPresent"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementNotPresent(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotPresentAndContinuewOnFailure"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementNotPresentAndContinuewOnFailure(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementNotVisibleAndContinuewOnFailure"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementNotVisibleAndContinuewOnFailure(
        	element
         , 	failureDescription)
}


def static "webAutomation.Verifications.verifyElementPresentInMobile"(
    	TestObject element	
     , 	String failureDescription	) {
    (new webAutomation.Verifications()).verifyElementPresentInMobile(
        	element
         , 	failureDescription)
}


def static "cards.AppoinmentCard.clickOnGearIcon"() {
    (new cards.AppoinmentCard()).clickOnGearIcon()
}


def static "cards.AppoinmentCard.clickOnMoreDetails"() {
    (new cards.AppoinmentCard()).clickOnMoreDetails()
}


def static "cards.BillingInformationCard.clickOnGearIcon"() {
    (new cards.BillingInformationCard()).clickOnGearIcon()
}


def static "cards.BillingInformationCard.clickOnMoreDetails"() {
    (new cards.BillingInformationCard()).clickOnMoreDetails()
}


def static "cards.BillingInformationCard.getPatientBillingDetails"() {
    (new cards.BillingInformationCard()).getPatientBillingDetails()
}


def static "cards.BillingInformationCard.verifyPatientBillingDetails"(
    	Object bills	
     , 	Object patientBalance	
     , 	Object insuranceBalance	) {
    (new cards.BillingInformationCard()).verifyPatientBillingDetails(
        	bills
         , 	patientBalance
         , 	insuranceBalance)
}


def static "cards.PatientCareTeamCard.getPcpDetails"() {
    (new cards.PatientCareTeamCard()).getPcpDetails()
}


def static "cards.PatientCareTeamCard.verifyPcpDetails"(
    	Object name	
     , 	Object center	
     , 	Object dept	) {
    (new cards.PatientCareTeamCard()).verifyPcpDetails(
        	name
         , 	center
         , 	dept)
}


def static "cards.PharmaciesCard.clickOnGearIcon"() {
    (new cards.PharmaciesCard()).clickOnGearIcon()
}


def static "cards.PharmaciesCard.clickOnMoreDetails"() {
    (new cards.PharmaciesCard()).clickOnMoreDetails()
}


def static "cards.PharmaciesCard.getPatientPharmacyDetails"() {
    (new cards.PharmaciesCard()).getPatientPharmacyDetails()
}


def static "cards.PharmaciesCard.verifyPatientPharmacyDetails"(
    	Object pharmacyName	
     , 	Object pharmacyNumber	) {
    (new cards.PharmaciesCard()).verifyPatientPharmacyDetails(
        	pharmacyName
         , 	pharmacyNumber)
}


def static "webAutomation.WebActions.click"(
    	TestObject element	) {
    (new webAutomation.WebActions()).click(
        	element)
}


def static "webAutomation.WebActions.scrollToElement"(
    	TestObject element	) {
    (new webAutomation.WebActions()).scrollToElement(
        	element)
}


def static "webAutomation.WebActions.takeScreenshot"() {
    (new webAutomation.WebActions()).takeScreenshot()
}


def static "webAutomation.WebActions.sendKeys"(
    	TestObject element	
     , 	String text	) {
    (new webAutomation.WebActions()).sendKeys(
        	element
         , 	text)
}


def static "webAutomation.WebActions.sendKeysEncrypted"(
    	TestObject element	
     , 	String encryptedText	) {
    (new webAutomation.WebActions()).sendKeysEncrypted(
        	element
         , 	encryptedText)
}


def static "webAutomation.WebActions.getText"(
    	TestObject element	
     , 	int maxWaitTime	) {
    (new webAutomation.WebActions()).getText(
        	element
         , 	maxWaitTime)
}


def static "webAutomation.WebActions.wait"(
    	TestObject element	
     , 	int maxWaitTime	) {
    (new webAutomation.WebActions()).wait(
        	element
         , 	maxWaitTime)
}


def static "webAutomation.WebActions.getElementCount"(
    	TestObject element	
     , 	int waitTimeLocal	) {
    (new webAutomation.WebActions()).getElementCount(
        	element
         , 	waitTimeLocal)
}


def static "webAutomation.WebActions.getColumnIndex"(
    	List headers	
     , 	String columName	) {
    (new webAutomation.WebActions()).getColumnIndex(
        	headers
         , 	columName)
}


def static "webAutomation.WebActions.getUrlAndVerify"(
    	String name	
     , 	String failuredescription	) {
    (new webAutomation.WebActions()).getUrlAndVerify(
        	name
         , 	failuredescription)
}


def static "webAutomation.WebActions.getBrowser"() {
    (new webAutomation.WebActions()).getBrowser()
}


def static "webAutomation.WebActions.getTestExecutionName"() {
    (new webAutomation.WebActions()).getTestExecutionName()
}


def static "webAutomation.WebActions.getText"(
    	TestObject element	) {
    (new webAutomation.WebActions()).getText(
        	element)
}


def static "webAutomation.WebActions.wait"(
    	TestObject element	) {
    (new webAutomation.WebActions()).wait(
        	element)
}


def static "webAutomation.WebActions.getElementCount"(
    	TestObject element	) {
    (new webAutomation.WebActions()).getElementCount(
        	element)
}


def static "cards.EmergencyContactInformationCard.getEmergencyContactDetails"() {
    (new cards.EmergencyContactInformationCard()).getEmergencyContactDetails()
}


def static "cards.EmergencyContactInformationCard.verifyEmergencyContactDetails"(
    	Object name	
     , 	Object contactNumber	) {
    (new cards.EmergencyContactInformationCard()).verifyEmergencyContactDetails(
        	name
         , 	contactNumber)
}


def static "tabs.BillingInformationTab.verifyPatientBillingInformation"() {
    (new tabs.BillingInformationTab()).verifyPatientBillingInformation()
}


def static "tabs.BillingInformationTab.getPatientBillingInformation"() {
    (new tabs.BillingInformationTab()).getPatientBillingInformation()
}


def static "webAutomation.Soterousers.clickSoteromanagmentTab"() {
    (new webAutomation.Soterousers()).clickSoteromanagmentTab()
}


def static "webAutomation.Soterousers.clickaddNewUserButton"() {
    (new webAutomation.Soterousers()).clickaddNewUserButton()
}


def static "webAutomation.Soterousers.verifyManageSoterUsersPage"() {
    (new webAutomation.Soterousers()).verifyManageSoterUsersPage()
}


def static "webAutomation.Soterousers.verifySoteroUserHeader"() {
    (new webAutomation.Soterousers()).verifySoteroUserHeader()
}


def static "webAutomation.Soterousers.clickSaveButton"() {
    (new webAutomation.Soterousers()).clickSaveButton()
}


def static "webAutomation.Soterousers.addNewSoteroUser"(
    	Object orgname	
     , 	String role	) {
    (new webAutomation.Soterousers()).addNewSoteroUser(
        	orgname
         , 	role)
}


def static "webAutomation.Soterousers.addNewSoteroUserWithEmailId"(
    	Object orgname	
     , 	String role	
     , 	Object emailid	) {
    (new webAutomation.Soterousers()).addNewSoteroUserWithEmailId(
        	orgname
         , 	role
         , 	emailid)
}


def static "webAutomation.Soterousers.addNewSoteroUserWithUserName"(
    	Object orgname	
     , 	String role	
     , 	Object userName	) {
    (new webAutomation.Soterousers()).addNewSoteroUserWithUserName(
        	orgname
         , 	role
         , 	userName)
}


def static "webAutomation.Soterousers.addNewSoteroUserWithInvalidEmailAndCheckErrorMessage"(
    	Object orgname	
     , 	String role	) {
    (new webAutomation.Soterousers()).addNewSoteroUserWithInvalidEmailAndCheckErrorMessage(
        	orgname
         , 	role)
}


def static "webAutomation.Soterousers.verifySoteroUserAdded"(
    	Map soterouserdetails	) {
    (new webAutomation.Soterousers()).verifySoteroUserAdded(
        	soterouserdetails)
}


def static "webAutomation.Soterousers.verifySoteroUserNotPresent"(
    	Map soterouserdetails	) {
    (new webAutomation.Soterousers()).verifySoteroUserNotPresent(
        	soterouserdetails)
}


def static "webAutomation.Soterousers.verifyMandatoryFields"() {
    (new webAutomation.Soterousers()).verifyMandatoryFields()
}


def static "webAutomation.Soterousers.verifyAddNewUserSoteroPage"() {
    (new webAutomation.Soterousers()).verifyAddNewUserSoteroPage()
}


def static "webAutomation.Soterousers.getRandomSoteroUserEmailId"() {
    (new webAutomation.Soterousers()).getRandomSoteroUserEmailId()
}


def static "webAutomation.Soterousers.getRandomUserName"() {
    (new webAutomation.Soterousers()).getRandomUserName()
}


def static "webAutomation.Soterousers.getRandomSoteroUserEmail"() {
    (new webAutomation.Soterousers()).getRandomSoteroUserEmail()
}


def static "webAutomation.Soterousers.verifyErrorMessage"() {
    (new webAutomation.Soterousers()).verifyErrorMessage()
}


def static "webAutomation.Soterousers.clickDeleteButtonOfSoteroUser"(
    	Object soteroUser	) {
    (new webAutomation.Soterousers()).clickDeleteButtonOfSoteroUser(
        	soteroUser)
}


def static "webAutomation.Soterousers.cancelTheDelationProcess"() {
    (new webAutomation.Soterousers()).cancelTheDelationProcess()
}


def static "webAutomation.Soterousers.clickYesRemoveButtonInDoyoureallywanttoDeleteThisPopUp"() {
    (new webAutomation.Soterousers()).clickYesRemoveButtonInDoyoureallywanttoDeleteThisPopUp()
}


def static "webAutomation.Soterousers.clickOnsoteroUser"(
    	Object name	) {
    (new webAutomation.Soterousers()).clickOnsoteroUser(
        	name)
}


def static "webAutomation.Soterousers.updateSoteroUserName"() {
    (new webAutomation.Soterousers()).updateSoteroUserName()
}


def static "webAutomation.Soterousers.updateSoteroUserEmail"(
    	Object email	) {
    (new webAutomation.Soterousers()).updateSoteroUserEmail(
        	email)
}


def static "webAutomation.Soterousers.updateSoteroUserEmailid"() {
    (new webAutomation.Soterousers()).updateSoteroUserEmailid()
}


def static "webAutomation.Soterousers.updateSoteroUserInfoWithEmptyValuesAndVerifyErrorMessage"() {
    (new webAutomation.Soterousers()).updateSoteroUserInfoWithEmptyValuesAndVerifyErrorMessage()
}


def static "webAutomation.Soterousers.updateRole"() {
    (new webAutomation.Soterousers()).updateRole()
}


def static "webAutomation.Soterousers.updatePassword"() {
    (new webAutomation.Soterousers()).updatePassword()
}


def static "webAutomation.Soterousers.verifySoteroUserPresent"(
    	Object name	) {
    (new webAutomation.Soterousers()).verifySoteroUserPresent(
        	name)
}


def static "webAutomation.Soterousers.verifyUserNameNotEditable"() {
    (new webAutomation.Soterousers()).verifyUserNameNotEditable()
}


def static "webAutomation.Soterousers.verifyAnotherUserExistsWithThisEmailAddressToastMessage"() {
    (new webAutomation.Soterousers()).verifyAnotherUserExistsWithThisEmailAddressToastMessage()
}


def static "webAutomation.Soterousers.verifySoteroUserNotPresent"(
    	Object name	) {
    (new webAutomation.Soterousers()).verifySoteroUserNotPresent(
        	name)
}


def static "webAutomation.Soterousers.verifySorting"() {
    (new webAutomation.Soterousers()).verifySorting()
}


def static "webAutomation.Soterousers.addNewSoteroUser"(
    	Object orgname	) {
    (new webAutomation.Soterousers()).addNewSoteroUser(
        	orgname)
}


def static "mainPage.Mainpage.searchWith"(
    	Object patientCallerId	
     , 	Object patientCalledTo	) {
    (new mainPage.Mainpage()).searchWith(
        	patientCallerId
         , 	patientCalledTo)
}


def static "mainPage.Mainpage.reset"() {
    (new mainPage.Mainpage()).reset()
}


def static "mainPage.Mainpage.verifySource"(
    	Object patientName	
     , 	Object dataOfBirth	
     , 	Object location	) {
    (new mainPage.Mainpage()).verifySource(
        	patientName
         , 	dataOfBirth
         , 	location)
}


def static "mainPage.Mainpage.verifySubject"(
    	Object patientName	
     , 	Object dateOfBirth	
     , 	Object location	) {
    (new mainPage.Mainpage()).verifySubject(
        	patientName
         , 	dateOfBirth
         , 	location)
}


def static "mainPage.Mainpage.clickOnCheckMarkOfPatinetInSourceTab"(
    	String patientName	) {
    (new mainPage.Mainpage()).clickOnCheckMarkOfPatinetInSourceTab(
        	patientName)
}


def static "mainPage.Mainpage.getSourceCardDetails"() {
    (new mainPage.Mainpage()).getSourceCardDetails()
}


def static "mainPage.Mainpage.getSubjectCardDetails"() {
    (new mainPage.Mainpage()).getSubjectCardDetails()
}


def static "mainPage.Mainpage.verifySource"(
    	Object patientName	
     , 	Object dataOfBirth	) {
    (new mainPage.Mainpage()).verifySource(
        	patientName
         , 	dataOfBirth)
}


def static "mainPage.Mainpage.verifySource"(
    	Object patientName	) {
    (new mainPage.Mainpage()).verifySource(
        	patientName)
}


def static "mainPage.Mainpage.verifySubject"(
    	Object patientName	
     , 	Object dateOfBirth	) {
    (new mainPage.Mainpage()).verifySubject(
        	patientName
         , 	dateOfBirth)
}


def static "mainPage.Mainpage.verifySubject"(
    	Object patientName	) {
    (new mainPage.Mainpage()).verifySubject(
        	patientName)
}
