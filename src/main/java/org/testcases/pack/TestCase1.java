package org.testcases.pack;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.selenium.helper.com.SeleniumHelper;
import org.testdatamanager.com.Getdata;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCase1 extends SeleniumHelper {
	@BeforeClass
	public void setdata()
	{
		TestCaseName="testcase1";
		TestCaseDescription="createlead link click";
		Author="aswin";
		category="sample";
		excelfilename="workbk";
	}
	@Test(/*priority=2,invocationCount=2,groups="smoke",*/ dataProvider="getdata")
	public  void login(String username,String crmsfaval)
	{
		try {
			startApp("chrome", "http://leaftaps.com/opentaps");
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, username);
			WebElement elePassword = locateElement("id","password");
			type(elePassword, crmsfaval);
			WebElement eleLogin = locateElement("class","decorativeSubmit");
			click(eleLogin);
			WebElement crmsfa = locateElement("LinkText", "CRM/SFA");
			click(crmsfa);

			WebElement Leads = locateElement("LinkText", "Leads");
			click(Leads);
			WebElement createlead = locateElement("LinkText", "Create Lead");
			click(createlead);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	



}








