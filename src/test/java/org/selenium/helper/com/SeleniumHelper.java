package org.selenium.helper.com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.report.generator.com.Extent_report;
import org.testdatamanager.com.Getdata;
import org.testng.annotations.DataProvider;
import org.webdriver.com.WebDriverFactory;

public class SeleniumHelper extends Extent_report implements WebDriverFactory {
	
	public RemoteWebDriver driver;
	public Select obj;
	public int i=1;
	public WebElement element;
	
	@Override
	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--disable-notifications");
				driver=new ChromeDriver(opt);
				reportstatus("Chrome browser started", "Pass");
											}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportstatus("Web driver exception", "Fail");
			System.err.println("Web driver exception");
			//e.printStackTrace();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
		switch (locator) {
		case "id":
			element=driver.findElement(By.id(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");
			break;
		case "xpath":
			element=driver.findElement(By.xpath(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");
			break;
		case "name":
			element=driver.findElement(By.name(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");

			break;
		case "linkText":
			element=driver.findElement(By.linkText(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");

			break;
		case "tagName":
			element=driver.findElement(By.tagName(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");

			break;
		case "className":
			element=driver.findElement(By.className(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");

			break;
		case "partialLinkText":
			element=driver.findElement(By.partialLinkText(locValue));
			reportstatus("Element "+locValue+" Found", "Pass");

			break;

		default:
			break;
		}
		}
		catch (InvalidSelectorException e) {
			// TODO: handle exception
			reportstatus("In valid locatorexception", "Fail");
			System.err.println("In valid locatorexception");
		}		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		 try {
			WebElement Element = driver.findElement(By.xpath(locValue));
			reportstatus("The element was found", "Pass");
			 return Element;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such element was found "+e.getMessage(), "Fail");
		}
		 return null;
		
	}

	@Override
	public void type(WebElement ele, String data) {
		// TODO Auto-generated method stub
		try {
			ele.sendKeys(data);
			System.out.println(data+" Entered");
			reportstatus("The text "+data+" entered", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such textbox was found", "Fail");
		}
	}

	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			ele.click();
			reportstatus("The element have been clicked", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("No element found");
			reportstatus("no such element found exception "+e.getMessage()+"Element not clickable", "Fail");
		}
		
		
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		try {
		String text;
		
			text = ele.getText();
			reportstatus("The text "+text+" retrived from the element", "Pass");
			return text;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportstatus("No such element found exception"+e.getMessage()+"Text could not be retrived", "Fail");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
		try {
			obj=new Select(ele);
			obj.selectByVisibleText(value);
			reportstatus("Element selected from dropdown", "Pass");
		} catch (UnexpectedTagNameException e) {
			reportstatus("the tag name is not supported "+e.getMessage(), "Fail");
			// TODO Auto-generated catch block
System.err.println("The tage name is unsupported");		}
		
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		try {
			obj=new Select(ele);
			obj.selectByIndex(index);
			reportstatus("The value have been selected", "Pass");
		} catch (UnexpectedTagNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("The following exception occurred "+e.getMessage(), "Fail");
		}
		
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		try {
			String title = driver.getTitle();
			if(title.equalsIgnoreCase(expectedTitle))
			{
				reportstatus("The title matches "+expectedTitle, "Pass");
				return true;
			}
			else
			{
			return false;
			}
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("Title not found "+e.getMessage(), "Fail");
		}
		return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(expectedText.equalsIgnoreCase(ele.getText()))
					{
				reportstatus("The element has the value "+expectedText, "Pass");
					}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportstatus("The element is not present "+e.getMessage(), "Fail");
		}
		
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(expectedText.contains(ele.getText()))
					{
				reportstatus("The element has the value "+expectedText, "Pass");
					}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportstatus("The element is not present "+e.getMessage(), "Fail");
		}
		
	}

	@Override                            
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String AttributeOfEle = ele.getAttribute(attribute);
			if(AttributeOfEle.equals(value))
			{
				reportstatus("Attribute "+AttributeOfEle+" is found", "Pass");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such element exception", "Fail");
		}
		
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			String AttributeOfEle = ele.getAttribute(attribute);
			if(AttributeOfEle.contains(value))
			{
				reportstatus("Attribute "+AttributeOfEle+" is found", "Pass");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such element exception", "Fail");
		}
		
	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			reportstatus("The element"+ele.isSelected(), "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such element found", "Fail");
		} 	
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			boolean displayed = ele.isDisplayed();
			reportstatus("Element "+ele+" Present" +displayed, "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("no such element found", "Fail");
		}
		
	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> setInto = new ArrayList<>();
			setInto.addAll(windowHandles);
			String HandleID = setInto.get(index);
			for (String windowhandleID : setInto) {
				if(HandleID.equals(windowhandleID))
				{
					driver.switchTo().window(windowhandleID);
				}
			}
			reportstatus("Switched to the window index "+index, "Pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such window found exception "+e.getMessage(), "Fail");
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
			reportstatus("switched to the frame", "Pass");
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			reportstatus("no such frame was found", "Fail");
		}
		
	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			reportstatus("Alert accepted", "Pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such alert found", "Fail");
		}
		
	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			reportstatus("Alert dismissed", "Pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such alert found", "Fail");
		}
		
	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		String AlertText;
		try {
			AlertText = driver.switchTo().alert().getText();
			reportstatus("The alert text is" + AlertText, "Pass");
			return AlertText;
			
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No such alert present "+ e.getMessage() , "Fail");
		}
		
		return null;
	}

	@Override
	public void takeSnap() {
		// TODO Auto-generated method stub
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./ScreenShot/img"+i+".png");
		try {
			FileUtils.copyDirectory(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found");
			reportstatus("No such file found", "Fail");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			reportstatus("Browser closed", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("No browser found", "Fail");
		}
		
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			reportstatus("All the Browser closed", "Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportstatus("Not a single browser was found", "Fail");
		}
	}

}
