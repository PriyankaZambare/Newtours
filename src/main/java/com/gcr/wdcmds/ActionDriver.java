package com.gcr.wdcmds;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gcr.Config.StartBrowser;
import com.grc.util.ConfiguratorSupport;

public class ActionDriver {

	WebDriver driver;
	ConfiguratorSupport cs=new ConfiguratorSupport("config.properties");
	
	public ActionDriver()
	{
		driver=StartBrowser.driver;
	}
	/**
	 * Useful for navigating to application
	 */
	
	public void navigateToApplication()
	{
		String url=cs.getProperty("url");
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully navigated to URL :"+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unsuccessful  navigate to URL :"+url);
		}
	}
	
	
	/**
	 * useful for clicking on button,radioBtn,ImageBtn,checkBoxes etc..
	 * @param locator --- Get it from Object repository
	 * @param eleName-----Name of the element which you are clicking
	 * @throws Exception 
	 */
	public void click(By locator,String eleName) throws Exception
	{
		try
		{
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Performed click operation  on :"+eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		}
		catch(Exception e) 
		{
			StartBrowser.childTest.fail("Unable to perform click operation on :"+eleName);
		     StartBrowser.childTest.info(e);
		     throw e;
		}
	}
	
	/**
	 * userful for type action in txtbox
	 * @param locator --- Get it from Object repository
	 * @param eleName-----Name of the element which you are clicking
	 */
	
	public void type(By locator,String Testdata,String eleName)
	{
	    try {
			driver.findElement(locator).sendKeys(Testdata);;
			StartBrowser.childTest.pass("Successfully perfored type action on :"+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perform click operation on :"+eleName);
		     StartBrowser.childTest.info(e);
		     throw e;
		}
	}
	
/*	public void (By locator ,String Testdata,String eleName)
	{
		
	}
	*/
	public String screenshot()
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
}
