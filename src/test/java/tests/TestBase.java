package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {
	
	//define public object from webdriver 
	public static WebDriver driver;
	
	//before suite will run before any @Test annotation
	//at this before suite will open the browser ans maxmize the window, also wait for miximazation then pass the URL
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver(@Optional ("chrome") String browsername)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");
	}
	
	//after suite annotation will execute code after any @Test annotation
	//here after @Test code finished will close the driver
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}

}
