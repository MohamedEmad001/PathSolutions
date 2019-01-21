package Pages;

//import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	//define protect webdriverclass object to be visible through this class or child classes only
	protected WebDriver driver;

	//Create Constructor to centralize the webdriver
	public PageBase (WebDriver driver)

	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//create generic method to click function
	//create generic method to send keys function with passing the key words string
	protected static void DropListSelect (Select dropList, String text)
	{
		dropList.selectByVisibleText(text);
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
	
	
	
}
