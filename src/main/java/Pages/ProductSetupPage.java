package Pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSetupPage extends PageBase {

	public ProductSetupPage(WebDriver driver)

	{
		super(driver);
		driver1 = driver;
	}

	//public static WebDriver driver1;
	WebDriver driver1;

	String moduleID = "150082";

	//@FindBy (css = "#\\31 5002003 > div > span")
	//WebElement actualModule;

	@FindBy (id = "txt_PlaceHolder")
	WebElement searchBox;

	@FindBy (id = "FPROD_PRODUCT_TYPE")
	WebElement productsetupType;

	@FindBy(id= "PCL_CODE")
	WebElement ClassCodetxt;

	@FindBy(id="FPROD_LATIN_NAME")
	WebElement Nametxt;

	@FindBy(id= "FPROD_PRODUCT_START_DATE")
	WebElement Date;

	@FindBy (css="#REPT_DESCRIPTION1_lovImage")
	WebElement RepaymentLov;

	@FindBy (css = "#advancedFilter")
	WebElement repaymentcodeQuickSearch;

	@FindBy (css = "#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement RepaymentSearchResult;



	@FindBy (id = "SaveButton__Button")
	WebElement saveData;



	public void ProductSetupModule(	String productsetupTypeValue, String ClassCodevalue, String Namevalue, String ParentframeID, String SubFramesID, String repaymentcode) throws InterruptedException, IOException

	{

		Thread.sleep(7000);
		searchBox.sendKeys(moduleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(ParentframeID);

		waitMethod(7);

		DropListSelect(productsetupType, productsetupTypeValue);
		setTextElementText(ClassCodetxt, ClassCodevalue);
		setTextElementText(Nametxt, Namevalue);

		waitMethod(3);

		waitMethod(3);
		clickButton(RepaymentLov);
		Thread.sleep(5000);
		switchFrame(SubFramesID);
		Thread.sleep(5000);
		setTextElementText(repaymentcodeQuickSearch, repaymentcode);
		Thread.sleep(5000);
		DoubleClickonElement(RepaymentSearchResult);	
		switchFrame(ParentframeID);

		System.out.println("ay kalam");

	}
}
