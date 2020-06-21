package com.gcr.script;

import org.testng.annotations.Test;

import com.gcr.Config.StartBrowser;
import com.grc.reuse.CommonFunctions;

public class Login_Logout extends StartBrowser {
	
	@Test 
	public void testLogin_Logout() throws Exception 
	{
		CommonFunctions cfs=new CommonFunctions();
		cfs.login();
	}

}
