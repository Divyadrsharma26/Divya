package com.realtimeProject.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.realtimeProject.pageObject.LoginPage;
import com.realtimeProject.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
        logger.info("URL is opened....");

        driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);

		Thread.sleep(5000);

		lp.setUserName(user);
		logger.info("Username provided");
		
		lp.setpassword(pwd);
		logger.info("Password provided");

		lp.clickLogin();
		logger.info("Login clicked");

		Thread.sleep(5000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed");
		} else {
			
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("Login failed");
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
	
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/realtimeProject/testdata/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int columncount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][columncount];

		for (int i = 1; i <=rownum; i++)
		{
			for (int j = 0; j <columncount; j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);           // 1 0
			}
		}

		return logindata;

	}

	
}
