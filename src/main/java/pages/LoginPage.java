package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By usernaneTexBox = By.id("Email");
	private By passwordTexBox = By.id("Password");
	private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernaneTexBox).clear();
		driver.findElement(usernaneTexBox).sendKeys(username);
	}

	public void enterPasswork(String password) {
		driver.findElement(passwordTexBox).clear();
		driver.findElement(passwordTexBox).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

}
