package Pages;

import java.util.List;

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
	
	//get weblelemtn List content
	@FindBy (id = "ui-id-1")
	public List<WebElement> productAutoSuggestList;
	
	@FindBy (id = "ui-id-4")
	public WebElement productAutoSuggestselect;
	
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
	
	public void searchUsingAutoSuggesst(String productName) throws InterruptedException
	{
		setTextElementText(searchTxt, productName);
		Thread.sleep(3000);
		productAutoSuggestList.get(0).click();
		
	}
}
