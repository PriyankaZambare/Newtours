package com.gcr.Config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.grc.util.ConfiguratorSupport;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class StartBrowser {
 
	public static WebDriver driver;
    ConfiguratorSupport cs= new ConfiguratorSupport("config.properties");
	
    public static ExtentReports reports;
    public static ExtentTest parentTest;
    public static ExtentTest childTest; 
    ExtentHtmlReporter htmlReporter;
    String method;
    
    @BeforeTest
    public void generateReports()
    {
    	htmlReporter=new ExtentHtmlReporter("Reports/AutomationReport.html");
    	reports=new ExtentReports();
    	reports.attachReporter(htmlReporter);
    }
    
    @BeforeMethod
    public void methodName(Method method)
    {
    	parentTest=reports.createTest(method.getName());
    }
	
  @BeforeClass
  public void beforeClass() {
	  
	  String browser=cs.getProperty("browser");
	  switch (browser)  {
	case "Chrome":
		 WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	default:
		System.out.println("Please provide the correct browser" );
		break;
	}
	  
	 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  reports.flush();
  }

}
