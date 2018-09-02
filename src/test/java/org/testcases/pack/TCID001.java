package org.testcases.pack;

import org.selenium.helper.com.SeleniumHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TCID001 extends SeleniumHelper {
	
	@BeforeClass(groups="common")
	public void testcase()
	{
		TestCaseDescription="Merge leads";
		TestCaseName="TCID001";
		Author="Aswin";
		category="Regression";
	}
	
	@Test(groups="regression")
	public void tcid001()
	{
		startApp("Chrome", "http://leaftaps.com/opentaps");
	}
	
	

}
