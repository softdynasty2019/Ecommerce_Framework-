package ecommerce.PageMobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.AbstractComponent.AbstractComponents;

public class landingPage extends AbstractComponents {

	WebDriver driver;

	public landingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userpass;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	
	WebElement errorMessges;
	

	public ProductCatalogue loginApplication(String email, String password) {

		userEmail.sendKeys(email);

		userpass.sendKeys(password);

		submit.click();
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	

	}
	
	
	public  String getErrorMeg() {
		
		waitForTheelemement(errorMessges);
		return errorMessges.getText();
		
	}
	

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

	}

}
