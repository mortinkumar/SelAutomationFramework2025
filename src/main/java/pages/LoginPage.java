package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	

	@FindBy(id = "header-search-input")
	WebElement comSearchBox;

	@FindBy(css = "p[class='line1'] span")
	List<WebElement> selectCompany;
	
	@FindBy(id = "week52highVal")
	WebElement stockPriceElement;
//	WebElement hight_value;
	
	@FindBy(id = "week52lowVal")
	WebElement low_value;
	
//	@FindBy(xpath ="//*[@id='currentPrice']" )
//	WebElement stockPriceElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void enterCompanyName(String companyName) {
		comSearchBox.sendKeys(companyName);

	}

	public void selectCompanyName(String selCompay) {
		System.out.println("count= " + selectCompany.size());
		for (WebElement option : selectCompany)
			if (option.getText().equalsIgnoreCase(selCompay)) {
				option.click();
				break;
			}
		
	

	}
	public String  getStockHighPrice() throws InterruptedException {
		
		Thread.sleep(5);
		
		String stockprice = stockPriceElement.getText();
		 return stockprice;

//        String stockPrice = stockPriceElement.getText();
//        System.out.println("Stock Price of RELIANCE: " + stockPrice);
        
        
//        Assert.assertEquals("52 week high price : " +stockPrice, 2.58);
        
//        assert !stockPrice.isEmpty() : "Stock price is empty!";
		
//	String hightPrice = hight_value.
//	
//	
//	System.out.println(hightPrice);
//	System.out.println(hightPrice);
//	System.out.println(hightPrice);
		
//	Assert.assertEquals("52 week high price : " +hightPrice, hightPrice);
//	Assert.assertEquals("52 week high price : " +hightPrice, 2.58);
		 
	}
	public void weekLowValues() {
	String lowPrice =	low_value.getText();
	System.out.println(lowPrice);
//	Assert.assertEquals(lowPrice, 1.45);
	}

	
	
	

}
