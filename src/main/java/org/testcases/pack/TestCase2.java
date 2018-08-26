package org.testcases.pack;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestCase2 {
	/*@Test
	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter html = new ExtentHtmlReporter("./report/result.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		ExtentTest createTest = extent.createTest("TestCase1","create a new sample test case for extent report");
		createTest.assignAuthor("yuvaraj");
		createTest.assignCategory("sample test");
		createTest.pass("hi this is the step 1 in extent report:entered user name");
		createTest.fail("step2:entered ur password");
		createTest.pass("step3:clicked the login button",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
		extent.flush();

	}*/

	

}