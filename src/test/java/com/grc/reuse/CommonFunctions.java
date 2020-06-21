package com.grc.reuse;

import org.openqa.selenium.WebDriver;

import com.gcr.Config.StartBrowser;
import com.gcr.objectrepository.LoginPage;
import com.gcr.wdcmds.ActionDriver;

public class CommonFunctions {

	
	public WebDriver driver;
	public ActionDriver adriver;
	
	public CommonFunctions()
	{
		driver = StartBrowser.driver;
		adriver= new ActionDriver();
	}
	
	public void login() throws Exception
	{
		StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to New tours application");
		adriver.navigateToApplication();
		adriver.type(LoginPage.txtUsername,"mercury", "UserName text file");
		adriver.type(LoginPage.txtPassword, "mercury", "Password text fild");
		adriver.click(LoginPage.btnSignin, "Sign in button");
	}
}
