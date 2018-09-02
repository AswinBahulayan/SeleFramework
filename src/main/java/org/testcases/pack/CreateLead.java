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


public class CreateLead extends ProjectMethod {
	@BeforeClass
	public void setdata()
	{
		TestCaseName="CreateLead";
		TestCaseDescription="create lead";
		Author="aswin";
		category="Sanity";
		excelfilename="workbk";
	}
	@Test(/*priority=2,invocationCount=2,groups="smoke",*/ dataProvider="getdata")
	public  void createLead(String companyName,String firstName,String Source,String MarketingCampaign
			,String PhoneNumber,String EmailID)
	{
		try {
		
			WebElement Leads = locateElement("linkText", "Leads");
			click(Leads);
			WebElement createlead = locateElement("linkText", "Create Lead");
			click(createlead); 
			type(locateElement("//input[@id='createLeadForm_companyName']"), companyName);
			type(locateElement("//input[@id='createLeadForm_firstName']"), firstName);
			selectDropDownUsingText(locateElement("//select[@id='createLeadForm_dataSourceId']"), Source);
			selectDropDownUsingText(locateElement("id", "createLeadForm_marketingCampaignId"), MarketingCampaign);
			type(locateElement("id", "createLeadForm_primaryPhoneNumber"), PhoneNumber);
			type(locateElement("id", "createLeadForm_primaryEmail"), EmailID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	



}








