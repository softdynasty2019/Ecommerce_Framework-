package ecommerce.PageMobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ecommerce.AbstractComponent.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartClick;
	
	

	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By tostMessages = By.cssSelector("#toast-container");
	By alertDiag = By.cssSelector("div[role='alertdialog']");
	By cart=By.cssSelector("[routerlink*='cart']");
	

	public List<WebElement> getProductlist() {// All list of Product

		waitForTheElement(productBy);

		return products;

	}

	public WebElement getProductByName(String ProductName) {// Identify the Desire Product

		WebElement prod = getProductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);

		return prod;

	}

//Click the the add to cart 

	public addTocart addToCart(String ProductName) throws InterruptedException {// ipone

		WebElement prod = getProductByName(ProductName);

		prod.findElement(addToCart).click();
		waitForTheElement(tostMessages);
		waitForTheElementdisappear(alertDiag);
		//waitForTheElement(cart);
		cartClick.click();
		
		addTocart Addtocart = new addTocart(driver);
		return Addtocart;

	}

}
