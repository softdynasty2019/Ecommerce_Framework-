package ecommerce.PageMobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ecommerce.AbstractComponent.AbstractComponents;

public class orderConf extends AbstractComponents {

	WebDriver driver;

	public orderConf(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement OrderConf;

	public String confiramtionMessage() {

		waitForTheelemement(OrderConf);

		return OrderConf.getText();

	}



}
