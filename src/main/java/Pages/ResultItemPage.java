package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultItemPage extends PageBase{

	public ResultItemPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy (css = "strong.current-item")
	public WebElement resultTitle;
	

}
