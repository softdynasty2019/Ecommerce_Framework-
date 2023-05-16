package ecommerce;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce.PageMobject.ProductCatalogue;
import ecommerce.PageMobject.addTocart;
import ecommerce.PageMobject.checkOut;
import ecommerce.PageMobject.landingPage;
import ecommerce.PageMobject.orderConf;
import ecommerce.testComponent.copy.BeseTest;

public class testautomation extends BeseTest {

@Test	
public  void SubmitOrder() throws IOException, InterruptedException{

		String ProductName = "IPHONE 13 PRO";
				 		 
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);

		productcatalogue.addToCart(ProductName);// iphone

		// AddtoCart
		addTocart Addtocart = new addTocart(driver);
		Boolean match = Addtocart.verifyProductDisply(ProductName);
		Assert.assertTrue(match);
		Addtocart.goTocheckout();

		// Checkout
		checkOut Che = new checkOut(driver);
		Che.SelectCountry("Bangladesh");

		// OrderConf

		orderConf ord = new orderConf(driver);

		String message = ord.confiramtionMessage();

		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
