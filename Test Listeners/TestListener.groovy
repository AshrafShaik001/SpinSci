import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import mainPage.Mainpage

class TestListener {
	
	Mainpage mainpage = new Mainpage();
	
//	@BeforeTestCase
	def navigateToLoginPage() {
		GlobalVariable.screenshorts.clear();
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
	}

	@AfterTestCase
	def closeBrowserBeforeTestSuire(){
//		mainpage.reset();
		WebUI.refresh()
//		WebUI.closeBrowser()
	}
	
	@BeforeTestSuite
	def navigation(){
		GlobalVariable.screenshorts.clear();
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
	}
	
	@AfterTestSuite
	def closeBrowser(){
		WebUI.closeBrowser()
	}
	
	
}