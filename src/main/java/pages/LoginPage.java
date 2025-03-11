package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id ="Email" )
	WebElement usernameTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTexBox;
	
	@FindBy(xpath = "//*[@id=\\\"main\\\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
	
	
	
	
//	private By usernaneTexBox = By.id("Email");
//	private By passwordTexBox = By.id("Password");
//	private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		
//		driver.findElement(usernaneTexBox).clear();
//		driver.findElement(usernaneTexBox).sendKeys(username);
	}

	public void enterPasswork(String password) {
		
		passwordTexBox.clear();
		passwordTexBox.sendKeys(password);
		
		
//		driver.findElement(passwordTexBox).clear();
//		driver.findElement(passwordTexBox).sendKeys(password);
	}

	public void clickLogin() {
		
		
		loginButton.click();
		
		Log.info("Clicked on login button...");
//		driver.findElement(loginButton).click();
	}

}
