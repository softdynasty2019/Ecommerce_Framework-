package ecommerce.PageMobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ecommerce.AbstractComponent.AbstractComponents;

public class checkOut extends AbstractComponents {

	WebDriver driver;

	public checkOut(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css = "input[placeholder ='Select Country']")
	WebElement SelectCountry;
	

	@FindBy(css = ".ta-item:last-of-type")
	WebElement  country;
	
	@FindBy(css = ".action__submit")
	WebElement  SubmitOrder;
	
	By countryList=(By.cssSelector(".ta-item"));
	
	
	public void SelectCountry (String CountryName) {
		
		Actions a = new Actions(driver);

		a.sendKeys(SelectCountry, CountryName).build().perform();
		waitForTheElement(countryList);
		country.click();
		SubmitOrder.click();

		
		
		
	}
	
	
	
	
	
	
	
	
	

}
