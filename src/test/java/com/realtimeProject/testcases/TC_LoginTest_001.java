package com.realtimeProject.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.realtimeProject.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened....");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username provided");
		
		lp.setpassword(password);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Login clicked");
		
		Thread.sleep(4000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
			
		}
	}
	
	

	
}
