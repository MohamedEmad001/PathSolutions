package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id = "small-searchterms")
	WebElement searchTxt;
	
	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBtn;
	
//	@FindBy (id = "ui-id-6")
//	WebElement prodcutList;
	
	@FindBy (css = "div.product-selectors")
	public WebElement clickSearchResult;
	
	@FindBy (css = "div.product-name")
	public WebElement checkSearchResult;
	
	public void ProdcutSearch (String productName)
	{
		setTextElementText(searchTxt, productName);
		clickButton(searchBtn);
		clickButton(clickSearchResult);
	}
}
