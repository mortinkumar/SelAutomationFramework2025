package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportsManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	
	public void testValidLogin() {
		
		Log.info("Starting login test...");
		test = ExtentReportsManager.createTest("Login Test");
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Adding Credencials");
		Log.info("Adding credencial...");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPasswork("admin");
		test.info("Clicking on login button");
		loginPage.clickLogin();
		System.out.println("Title of the page is : "+driver.getTitle());
		Log.info("Verifing page title...");
		test.info("Verfying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...kumar123");
		test.pass("Login successfully");
		
}

}
