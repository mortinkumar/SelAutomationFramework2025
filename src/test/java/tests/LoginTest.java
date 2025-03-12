package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportsManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	private static final String String = null;

	@Test
	
	public void testValidLogin() throws InterruptedException {
		
		Log.info("Starting login test...");
		test = ExtentReportsManager.createTest("Login Test");
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterCompanyName("RCOM");
		loginPage.selectCompanyName("Reliance Communications Limited");
		System.out.println("Title of the page is : "+driver.getTitle());
		Log.info("Verifing page title...");
		test.info("Verfying page title");
		String highStock = loginPage.getStockHighPrice();
		System.out.println("This is latest stock price" +highStock);
	
		

//		Assert.assertEquals(stockPrice, "Just a moment");
		
//		loginPage.weekhightValues();
//		loginPage.weekLowValues();
	
		
//		Assert.assertEquals(driver.getTitle(), "Just a moment");
//		test.pass("Login successfully");
		
}

}
