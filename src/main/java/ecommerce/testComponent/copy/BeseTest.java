package ecommerce.testComponent.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerce.PageMobject.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BeseTest {

	public WebDriver driver;
	public landingPage lanpage;

	public  WebDriver initilizeDriver() throws IOException {//System.getProperty("user.dir")+

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ecommerce\\testComponent\\copy\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
		

	}
 @BeforeMethod 
 public void launchApplication() throws IOException {
		driver =initilizeDriver();
		lanpage=new landingPage(driver);
		lanpage.goTo();
		lanpage.loginApplication("softdynasty2019@gmail.com", "Test123@");
		
		

	}
 
 @AfterMethod 
 public  void teardown() {
	 driver.close();
	 
	 
 }

}
