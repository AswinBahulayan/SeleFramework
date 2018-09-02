package org.testcases.pack;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.selenium.helper.com.SeleniumHelper;
import org.testdatamanager.com.Getdata;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class ProjectMethod extends SeleniumHelper {
	
	@DataProvider(name="getdata")
	public Object[][] data() throws IOException
	{
		Object[][] getdata = Getdata.getdata(excelfilename);
		
		return getdata;
	}

	@BeforeMethod
	public  void login()
	{
		try {
			startApp("chrome", "http://leaftaps.com/opentaps");
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, "DemoSalesManager");
			WebElement elePassword = locateElement("id","password");
			type(elePassword, "crmsfa");
			//WebElement eleLogin = locateElement("class","decorativeSubmit");
			click(locateElement("//form[@id='login']/child::p/input[@type='submit']"));
			//WebElement crmsfa = locateElement("LinkText", "CRM/SFA");
			click(locateElement( "(//div[@id='button']/child::a/img)[1]"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
