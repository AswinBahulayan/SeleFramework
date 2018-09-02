/*package org.testcases.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.helper.com.SeleniumHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZoomCar2 extends SeleniumHelper {

	@BeforeClass
	public void setdata()
	{
		TestCaseDescription="Zoom car highest valued car";
		TestCaseName="Zoom car";
		Author="Aswin";
		category="Smoke";

	}
	@Test
	public void zoomCar() throws InterruptedException
	{
		try {
			int i,temp1=0;
			startApp("Chrome", "https://www.zoomcar.com/chennai");
			click(locateElement("linkText", "Start your wonderful journey"));
			click(locateElement("(//div[@class='component-popular-locations']//div[@class='items'])[1]"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			Thread.sleep(5000);
			//click(locateElement("(//div[@class='month picked'])[1]"));
			click(locateElement("(//div[@class='day'])[1]"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			click(locateElement("//button[contains(@class,'proceed')]"));
			//Map<Integer, String > obj=new HashMap<>();
			
			List<WebElement> Elementsprice = driver.findElements(By.xpath("//div[@class='component-car-item']//div[*]"));
			int size = Elementsprice.size();
			
			
			//int number=Elementsprice.size();
			List<String> brandName=new ArrayList<>();
			
			for(i=0;i<=size;i++)
			{
				brandName.add(Elementsprice.get(i).findElement(By.tagName("h3")).getText());
			}
			List<String> 
			
			
			
			
			List<WebElement> elementsname = driver.findElements(By.xpath("//div[@class='details']/h3"));
			for(i=0;i<elementsname.size();i++)
			{
				String temp=Elementsprice.get(i).getText();

				obj.put(Integer.parseInt(Elementsprice.get(i).getText()), elementsname.get(i).getText());
			}

			for (WebElement webElement : Elementsprice) {
				obj.put(Integer.parseInt(webElement.findElement(By.xpath("//div[@class='price']")).getText()),webElement.getAttribute("h3"));
			}
			Set<Integer> keySet2 = obj.keySet();
			System.out.println();
			System.out.println(obj.values());
			
			Set<Integer> keySet = obj.keySet();
			Collection<String> values = obj.values();
			List<Integer> val= new ArrayList<>();
			val.addAll(keySet);
			reportstatus("the highest value is "+obj.get(val.get(val.size()-1)), "Pass");
 
			for(int j=0;j<val.size();j++)
			{
				for(i=j;i<val.size();i++)
				{
					int swap1=val.get(i);
					int swap2=val.get(j);
					if(swap1>swap2)
					{
						temp1=swap1;
						swap1=swap2;
						swap2=temp1;
						
						
					}
				}
			}
			reportstatus("the highest valued car is "+obj.get(temp1), "Pass");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("Test case failed", "Fail");
		}

	}

}
*/