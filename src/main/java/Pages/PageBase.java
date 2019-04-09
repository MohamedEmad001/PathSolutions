package Pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	//define protect webdriverclass object to be visible through this class or child classes only
	//public static WebDriver driver;
	//Create Constructor to centralize the webdriver

	protected WebDriver driver1;
	public Select select;
	public Actions Action;

	public PageBase(WebDriver driver)

	{

		//this.driver = driver;
		PageFactory.initElements(driver, this);
		driver1=driver;

	}


	//create generic method to click function
	//create generic method to send keys function with passing the key words string

	protected static void DropListSelect (WebElement dropList, String Value)
	{
		Select dropMenuSelect = new Select(dropList);
		dropMenuSelect.selectByValue(Value);
	}

	protected void clickButton(WebElement button)
	{
		button.click();
	}

	protected void setTextElementText (WebElement textbox , String text)
	{
		textbox.sendKeys(text);
	}

	protected void Checkingcheckbox (WebElement Checkbox)
	{
		Checkbox.click();
	}

	protected void DoubleClickonElement(WebElement button)
	{
		Action = new Actions(driver1);
		Action.doubleClick(button).perform();
		
	}
	
	protected void SingleClickonElement(WebElement button)
	{
		Action = new Actions(driver1);
		Action.doubleClick(button).perform();
		
	}

	protected void switchFrame (String frameID)
	{
		//WebDriverWait wait = new WebDriverWait(driver1,3000);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
		driver1.switchTo().frame(frameID);
	}

	protected void waitMethod(int timeInSeconds)
	{
		driver1.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

	}



	protected void ConfirmAlert()
	{
		driver1.switchTo().alert().accept();
	}


	/*	protected void SearchModule (WebElement textbox , String moduleName , String frameID) throws InterruptedException
	{
		Thread.sleep(20000);
		textbox.sendKeys(moduleName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		textbox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		textbox.sendKeys(Keys.ALT, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame(frameID);

	}*/


	public void TakeScreenShots(WebDriver driver , String ScreenShortname) throws IOException
	{

		Path dest = Paths.get("./ScreenShots" , ScreenShortname +".png");
		Files.createDirectories(dest.getParent());		
		FileOutputStream out = new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();

	}


	protected String  StoreData (WebElement textbox)
	{
		return textbox.getAttribute("value");
	}
	

	public WebElement waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		element = wait.until(ExpectedConditions.elementToBeClickable(element));


		return element;
	}
	
	

	
	
	public Boolean waitForCheckResult(WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public Boolean waitForGeneratedCode(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	
		String GeneratedValue = element.getAttribute("Value");
		return wait.until(ExpectedConditions.attributeToBe(element, "Value", GeneratedValue));
	}
	
	
	
	public WebDriver waitForFrame(String FrameID) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameID));

	}
	
	
	public Alert waitForConfirmationMsg() {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.alertIsPresent());

	}
	
	/*public Boolean waitForLoading(WebElement element , Boolean selected) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));

	}*/
	
	
}
