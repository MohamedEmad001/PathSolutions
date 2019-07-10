package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;



public class TestBase {
	
	//define public object from webdriver 
	public static WebDriver driver;
	
	String Demo ="http://192.168.112.33/I50FINDemo/Default.aspx";
	String Demo2="http://192.168.113.4/i50qc/Default.aspx";
	String Client2 ="http://192.168.112.44/ITFCQC/Default.aspx";
	String i50QC = "http://192.168.112.44/I50QC/Security/SignIn.aspx";
	String i50Dev = "http://192.168.112.33/I50DEV/security/Signin.aspx";
	String ITFCQC="http://192.168.112.44/ITFCQC/Default.aspx";
	
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

		//driver.navigate().to(Demo);
		driver.navigate().to(Demo2);
		//driver.navigate().to(Client2);
		//driver.navigate().to(i50QC);
		//driver.navigate().to(i50Dev);
		//driver.navigate().to(ITFCQC);

	}
	
	@AfterMethod
	public void takeScreenshots(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
				
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
		}
		
		else
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
		}
			
	}
	
	//after suite annotation will execute code after any @Test annotation
	//here after @Test code finished will close the driver
	@AfterSuite
	public void stopDriver()
	{
		//driver.quit();
	}


}
