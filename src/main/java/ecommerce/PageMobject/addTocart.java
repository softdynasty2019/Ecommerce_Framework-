package ecommerce.PageMobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ecommerce.AbstractComponent.AbstractComponents;

public class addTocart extends AbstractComponents {

	WebDriver driver;

	public addTocart(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css = ".cartSection h3")
	List<WebElement>  cartPdts;
	

	@FindBy(css = ".totalRow button")
	WebElement  checkout;
	
	By cartitem=(By.cssSelector(".cartSection h3"));
	
	
	
	public Boolean verifyProductDisply(String ProductName)  {
		
		waitForTheElement(cartitem);
		
		Boolean match = cartPdts.stream().anyMatch(cartPdt -> cartPdt.getText().equalsIgnoreCase(ProductName));
		
		return match;
		
	}

	
	public void goTocheckout () {
		
		checkout.click();
		
		
		
	}
	
	
	

}
