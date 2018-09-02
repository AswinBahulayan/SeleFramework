package org.testcases.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.helper.com.SeleniumHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZoomCar extends SeleniumHelper {

	@BeforeClass(groups="common")
	public void setdata() {
		TestCaseDescription = "Zoom car highest valued car";
		TestCaseName = "Zoom car";
		Author = "Aswin";
		category = "Smoke";

	}

	@Test(/*timeOut=1000,*/enabled=true,groups="regression")
	public void zoomCar() throws InterruptedException {
		try {
			int i, temp1 = 0;
			startApp("Chrome", "https://www.zoomcar.com/chennai");
			click(locateElement("linkText", "Start your wonderful journey"));
			click(locateElement("className", "items"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			// Thread.sleep(5000);
			// click(locateElement("(//div[@class='month picked'])[1]"));
			click(locateElement("(//div[@class='day'])[1]"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			// Map<Integer, String > obj=new HashMap<>();

			/*List<WebElement> CarList = driver.findElements(By.className("car-item"));
			int size = CarList.size();
			System.out.println(size);*/

			List<WebElement> Elementsprice = driver.findElements(By.className("price"));

			List<Integer> prices = new ArrayList<Integer>();

			for (WebElement price : Elementsprice) {
				String text = price.getText().replaceAll("\\D", "");
				prices.add(Integer.parseInt(text));
			}

			int max = Collections.max(prices);
			System.out.println(max);

			String brandname = getText(locateElement("(//div[contains(text(),'"+max+"') and @class='price']/preceding::h3)[1]"));
			reportstatus("Highest valued car "+brandname, "Pass");

			click(locateElement("(//div[contains(text(),'"+max+"') and @class='price']/following::button)[1]"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("Test case failed", "Fail");
		}

	}
	
	

}
