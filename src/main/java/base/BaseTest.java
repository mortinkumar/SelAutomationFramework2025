package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportsManager;
import utils.Log;

public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport() {
		
		extent = ExtentReportsManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}
	

	@BeforeMethod
	public void setUp() {
		
		
		Log.info("Setting up WebDriver..");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to URL..");
		driver.get("https://admin-demo.nopcommerce.com/login");

	}

	@AfterMethod

	public void tearDown(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			
			String screenshotPath = ExtentReportsManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed... see the screenshot", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());			
		}
		
		if (driver != null) {
			Log.info("Closing Browser...");
			driver.quit();
		}
	}

}
