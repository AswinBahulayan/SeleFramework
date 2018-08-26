package org.testcases.pack;

import org.openqa.selenium.WebElement;
import org.selenium.helper.com.SeleniumHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class TestCase0 extends SeleniumHelper {
	@BeforeClass
	public void setdata()
	{
		TestCaseName="testcase1";
		TestCaseDescription="createlead link click";
		Author="yuvaraj";
		category="sample";
	}
	@BeforeTest
	public  void login()
	{
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement crmsfa = locateElement("LinkText", "CRM/SFA");
		click(crmsfa);
	}
	 @AfterMethod
	  public void afterTest() {
		  closeBrowser();}

}
