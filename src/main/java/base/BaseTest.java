package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setAcceptInsecureCerts(true);
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
   
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--no-proxy-server");
        options.merge(dc);
         driver = new ChromeDriver(options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Log.info("Navigating to URL..");
		driver.get("https://www.nseindia.com");
		

	}

	@AfterMethod

	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = ExtentReportsManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed... see the screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}

		if (driver != null) {
//			Log.info("Closing Browser...");
//			driver.quit();
		}
	}

}
