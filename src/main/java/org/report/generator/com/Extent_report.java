package org.report.generator.com;

import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_report {
	public static ExtentReports extent;
	public static ExtentTest test;
	public String TestCaseName,TestCaseDescription,Author,category,excelfilename;
	public Date date;
	private long time;
	@BeforeSuite(groups="common")
	public void startreport()
	{

		date = new Date();
		String timeofinstance=String.valueOf(date);
		String trim = timeofinstance.replace(" ", "_");
		String finaldate = trim.replace(":", ".");
		System.out.println(timeofinstance);
		System.out.println(finaldate);
		//int i=1;
		ExtentHtmlReporter html=new ExtentHtmlReporter("./reports/results_"+finaldate+".html");
		html.setAppendExisting(true);
		extent=new ExtentReports();
		//makes the html report file editable
		extent.attachReporter(html);
		//i++;
	}
	@BeforeMethod(groups="common")
	public void atreport()
	{
		test=extent.createTest(TestCaseName, TestCaseDescription);
		//test is the 
		test.assignAuthor(Author);
		test.assignCategory(category);
	}

	public void reportstatus(String value, String status)
	{
		if(status.equalsIgnoreCase("Pass"))
		{
			test.pass(value);
		}
		else if (status.equalsIgnoreCase("Fail")) {
			test.fail(value);
		}
	}


	/*static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//creates a defeult report which is not editable
				to parse the test case name and description
		ExtentTest test=extent.createTest("TCDIA001", "Test case one");
//test is the 
		test.assignAuthor("Aswin");
		test.assignCategory("Regression");
		test.pass("login button clicked");
		test.pass("link clicked", MediaEntityBuilder.createScreenCaptureFromPath("./../ScreenShot/putty.png").build());
		ExtentTest test2=extent.createTest("TCDIA002", "Test case one");
		test2.assignAuthor("Aswin");
		test2.assignCategory("Regression");
		test2.pass("login button clicked");
		test2.pass("link clicked", MediaEntityBuilder.createScreenCaptureFromPath("./../ScreenShot/src.png").build());*/
	@AfterSuite(groups="common")
	public void flushreport()
	{
		extent.flush();
	}


}


