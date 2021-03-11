package webAutomation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Soterousers {

	WebActions actions = new WebActions()
	Verifications verifications = new Verifications()
	Random random = new Random()


	@Keyword
	def clickSoteromanagmentTab() {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/soteroUserManagementTab'))
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/addNewUserButton'), "Add new user button is not present in sotero user managment page")
	}

	@Keyword
	def clickaddNewUserButton() {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/addNewUserButton'))
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/addNewSoteroUserPageHeader'), "Add new sotero user page header is not present")
	}

	@Keyword
	def verifyManageSoterUsersPage() {

		actions.getUrlAndVerify("soteroUsers", "User is not in Manage Sotero Users page")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/manageSoteroUserHeader'), "manageSoteroUserHeader is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/addNewUserButton'), "Add new user button is not present")
	}


	@Keyword
	def verifySoteroUserHeader() {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUserTableHeader'), "Soter user header not present with Name username email org unit role and delete")
	}

	@Keyword
	def clickSaveButton() {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
	}

	@Keyword
	def addNewSoteroUser(def orgname,String role = 'ADMIN') {
		def name = "Testuser"+ random.nextInt(10000)
		def username = "Username_"+ random.nextInt(10000)
		def randomNumber = random.nextInt(100000)
		def emaild = "testUser"+randomNumber+"@qualitlabs.com"
		def password  = "password@"+ random.nextInt(1)
		clickaddNewUserButton()
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), name)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), emaild)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userName'), username)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/password'), password)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgunitdropdown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgName(name)',["orgname":orgname]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleOption(roleName)',["role":role]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return ["name":name,"username":username,"password":password,"emaild":emaild,"orgname":orgname,"role":role]
	}

	@Keyword
	def addNewSoteroUserWithEmailId(def orgname,String role,def emailid) {

		def name = "Testuser"+ random.nextInt(100)
		def username = "Username_"+ random.nextInt(100)
		def password  = "password"+ random.nextInt(1)
		clickaddNewUserButton()
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), name)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), emailid)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userName'), username)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/password'), password)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgunitdropdown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgName(name)',["orgname":orgname]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleOption(roleName)',["role":role]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
	}

	@Keyword
	def addNewSoteroUserWithUserName(def orgname,String role,def userName) {

		def name = "Testuser"+ random.nextInt(100)
		//def username = "Username_"+ random.nextInt(100)
		def randomNumber = random.nextInt(1000)
		def emailid = "testUser"+randomNumber+"@qualitlabs.com"
		def password  = "password"+ random.nextInt(1)
		clickaddNewUserButton()
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), name)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), emailid)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userName'), userName)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/password'), password)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgunitdropdown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgName(name)',["orgname":orgname]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleOption(roleName)',["role":role]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
	}

	@Keyword
	def addNewSoteroUserWithInvalidEmailAndCheckErrorMessage(def orgname,String role) {
		def name = "Testuser"+ random.nextInt(100)
		def username = "Username_"+ random.nextInt(100)
		def randomNumber = random.nextInt(1000)
		def emaild = "testUser"+randomNumber+"qualitlabs.com"
		def password  = "password"+ random.nextInt(1)
		clickaddNewUserButton()
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), name)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), emaild)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userName'), username)
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/password'), password)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgunitdropdown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgName(name)',["orgname":orgname]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleOption(roleName)',["role":role]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/validEmailAddressErrorMessage'), "Please enter an valid email address. is not shown when user enter invalid email address")
	}

	@Keyword
	def verifySoteroUserAdded(Map soterouserdetails) {


		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUser(soteroUserDetails)',["name":' '+soterouserdetails.name,"username":soterouserdetails.username,"emaild":soterouserdetails.emaild,"orgname":soterouserdetails.orgname,"role":soterouserdetails.role]), "Sotero user not added")
	}

	@Keyword
	def verifySoteroUserNotPresent(Map soterouserdetails) {


		verifications.verifyElementNotPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUser(soteroUserDetails)',["name":' '+soterouserdetails.name,"username":soterouserdetails.username,"emaild":soterouserdetails.emaild,"orgname":soterouserdetails.orgname,"role":soterouserdetails.role]), "Sotero user is still present even after deleting")
	}

	@Keyword
	def verifyMandatoryFields() {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Email"]), "Eamil mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Name"]), "Name mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Username"]), "Username mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Password"]), "Username mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Org Unit"]), "Org Unit mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Role"]), "Role mandatory field error message is not shown")
	}

	@Keyword
	def verifyAddNewUserSoteroPage() {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/addNewSoteroUserPageHeader'), "Add new sotro user page header is not present")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), "Eamil Text box is not present ")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/orgunitdropdown'), "Org unit field is not present")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), "Name text field is not present")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userName'), "Username text field is not present")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'), "Role drop down is not present")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'), "Save button not present")
	}

	@Keyword
	def getRandomSoteroUserEmailId() {

		def count = actions.getElementCount(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/coutOfSoteroUsers'))
		println "count"+count
		def index = random.nextInt(count)
		if(index == 0)
			index = index +1
		return actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/randomEmailId',["index":index]))
	}

	@Keyword
	def getRandomUserName() {

		def count = actions.getElementCount(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/coutOfSoteroUsers'))
		println "count"+count
		def index = random.nextInt(count)
		if(index == 0)
			index = index +1
		return actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/randomUserName(index)',["index":index]))
	}

	@Keyword
	def getRandomSoteroUserEmail() {

		def count = actions.getElementCount(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/coutOfSoteroUsers'))
		println "count"+count
		def index = random.nextInt(count)
		if(index == 0)
			index = index +1
		return actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/randomuSoteroUserEmail(index)',["index":index]))
	}

	@Keyword
	def verifyErrorMessage() {

		//Error message to be verified
		//verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'), "Save button not present")
		//verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'), "Save button not present")

	}

	@Keyword
	def clickDeleteButtonOfSoteroUser(def soteroUser) {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/deletebuttonOfSoteroUser(SoteroUserName)',["soteroUser":' '+soteroUser]))
	}

	@Keyword
	def cancelTheDelationProcess() {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/noNeverMindButton'))
		verifications.verifyElementNotPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/noNeverMindButton'), "No never mind is not present")
	}

	@Keyword
	def clickYesRemoveButtonInDoyoureallywanttoDeleteThisPopUp() {

		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/yesRemoveButton'))
		verifications.verifyElementNotPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/noNeverMindButton'), "No never mind is not present")
	}


	@Keyword
	def clickOnsoteroUser(def name) {
		println "name"+name
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soterousername(name)',["name":' '+name]), "The Sotero user"+name+" is not presenr")
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soterousername(name)',["name":' '+name]))
	}

	@Keyword
	def updateSoteroUserName() {

		def name = "Testuser"+ random.nextInt(10000)
		//WebUI.clearText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), Keys.chord(Keys.BACK_SPACE))
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), name)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return name
	}

	@Keyword
	def updateSoteroUserEmail(def email) {

		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.BACK_SPACE))
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), email)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return email
	}

	@Keyword
	def updateSoteroUserEmailid() {

		def randomNumber = random.nextInt(10000)
		def emaild = "testUser"+randomNumber+"@qualitlabs.com"
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.BACK_SPACE))
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), emaild)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return emaild
	}


	@Keyword
	def updateSoteroUserInfoWithEmptyValuesAndVerifyErrorMessage() {

		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/userNameTextField'), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/emailTextbox'), Keys.chord(Keys.BACK_SPACE))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Name"]), "Name mandatory field error message is not shown")
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/mandatoryField(fieldName)',["fieldName":"Email"]), "Eamil mandatory field error message is not shown")
	}

	@Keyword
	def updateRole() {

		String updatedrole
		String role = actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		if (role == 'ADMIN') {
			updatedrole = 'USER'
		}
		else {
			updatedrole = 'ADMIN'
		}
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleDropDown'))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/roleOption(roleName)',["role":updatedrole]))
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return updatedrole
	}

	@Keyword
	def updatePassword() {

		def updatedpassword  = "password0#"
		actions.sendKeys(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/password'), updatedpassword)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/saveButton'))
		return updatedpassword
	}

	@Keyword
	def verifySoteroUserPresent(def name ) {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soterousername(name)',["name":' '+name]), "The Sotero user"+name+" is not presenr")
	}

	@Keyword
	def verifyUserNameNotEditable( ) {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/disabledUserName'), "Username is editable")
	}

	@Keyword
	def verifyAnotherUserExistsWithThisEmailAddressToastMessage( ) {

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/anotherUserExistsWithThisEmailAddressToastMessage'), "Another user with this email address exists toast message is not shown")
	}



	@Keyword
	def verifySoteroUserNotPresent(def name ) {

		verifications.verifyElementNotPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soterousername(name)',["name":' '+name]), "The Sotero user"+name+" is not present")
	}


	@Keyword
	def verifySorting( ) {

		List names = []
		List sortednames = []

		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUsersInAscendingOrder'), "Soter users are not in ascending oder by default")
		def count = actions.getElementCount(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/coutOfSoteroUsers'))
		for(int i = 1;i<= count ;i++) {
			def name = actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/nameOfSoteroUser(index)',["index":i]))
			names.add(name)
		}

		WebUI.delay(5)
		actions.click(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUsersInAscendingOrder'))
		verifications.verifyElementPresent(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/soteroUsersDecendingOrder'), "Soter users are not in decending oder after clicking on name")

		for(int i = 1;i<= count ;i++) {
			def sortedname = actions.getText(findTestObject('Object Repository/UI/profileIcon/AccountSettings/SoteroUserManagment/nameOfSoteroUser(index)',["index":i]))
			sortednames.add(sortedname)
		}
		//println "names"+names
		//println "sort"+names.sort(null)
		//println "collections"+Collections.sort(names)
		//println "tosortedd"+names.toSorted()
		//println "names.reverse()"+names.reverse()
		List reverseoder = names.reverse()

		if(!(sortednames.size() == names.size())) {
			KeywordUtil.markFailedAndStop("size of org names and size of org name after sorting are different")
		}

		for(int i = 1 ;i< reverseoder.size();i++)
		{

			if(!(sortednames[i] == reverseoder[i]))
			{
				KeywordUtil.markFailedAndStop("Sorting is not functioning properly for "+sortednames[i]+" and "+reverseoder[i])
			}
		}

	}
}
