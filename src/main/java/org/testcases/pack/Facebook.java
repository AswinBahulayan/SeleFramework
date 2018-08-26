package org.testcases.pack;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.selenium.helper.com.SeleniumHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook extends SeleniumHelper {
	@BeforeClass(groups="common")
	public void setdata() {
		TestCaseDescription = "Zoom car highest valued car";
		TestCaseName = "Facebook";
		Author = "Aswin";
		category = "Smoke";

	}
	@Test(invocationCount=2,/*invocationTimeOut=5000*//*dependsOnMethods="org.testcases.pack.ZoomCar.zoomCar"*/priority=1,groups= {"sanity"})
	@Parameters({"browser","url","email","pwd"})
	public void facebook(String browser1,String url1,String email1, String pwd11)
	{
		
		try {
			startApp(browser1, url1);
			type(locateElement("id","email"), email1);
			type(locateElement("id","pass"), pwd11);
			click(locateElement("//input[@type='submit']"));
			type(locateElement("//input[@role='combobox']"), "testleaf");
			locateElement("//input[@role='combobox']").sendKeys(Keys.ENTER);
			click(locateElement("(//a[@href=\"https://www.facebook.com/TestleafSolutionsIncChennai/?ref=br_rs\"])[2]"));
			String a[]=getText(locateElement("//div[contains(text(),'people like this')]")).split(" ");
			reportstatus("Number of likes "+a[0], "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("Element not found "+e.getMessage(), "Fail");
		}
		
	}
}
