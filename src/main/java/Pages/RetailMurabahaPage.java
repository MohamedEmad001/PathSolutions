package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetailMurabahaPage extends PageBase {

	public RetailMurabahaPage(WebDriver driver) {
		super(driver);
		driver1=driver;

	}

	//Global Variables
	WebDriver driver1;

	@FindBy (id = "txt_PlaceHolder")WebElement searchBox;

	@FindBy(css="#FCON_CONTRACT_DATE") WebElement RequestedDateTxt;
	@FindBy(css="#FCON_VALUE_DATE")	WebElement ValueDateTxt;
	@FindBy(css="#CUS_CODE")WebElement CustomerIDTxt;
	@FindBy(css="#FPROD_CODE1")WebElement ProductCodeTxt;
	@FindBy(css="#NL_VND_NAME")	WebElement NonListedVendorTxt;
	@FindBy (css="#CUR_CODE2")WebElement CurrencyCodeTxt;
	@FindBy(id="V18TC_V8TP_V8AddButton")WebElement addNewRowbBtn;
	@FindBy(css="#V18TC_V8TP_V8LCRepeater_ctl00_AddButton")WebElement ViewItemBtn;
	@FindBy(css="#ITE_NAME") WebElement ItemNameTxt;
	@FindBy(id="IC_CODE") WebElement ItemCategoryDropdownSelect;
	@FindBy(css="#ITE_PRICE") WebElement PriceTxt;
	@FindBy(css="#ITE_COST") WebElement CostTxt;
	@FindBy(css="#SaveButton__Button") WebElement SaveAndCloseBtn;

	@FindBy(css="#V18SaveButton") WebElement MasterSaveBtn;
	@FindBy(id="FCON_CODE") WebElement ContractCodeTxt;
	public static String MurabahaCode;



	public void OpenRetailMurabaha(String ParentframeID, 
			String RetailMurabahamoduleID) 
					throws InterruptedException
	{
		//Search on RetailMurabahamoduleID and open it
		Thread.sleep(7000);
		searchBox.sendKeys(RetailMurabahamoduleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(ParentframeID);

		waitMethod(7);
	}

	public void FillRequiredFields(String RequestedDateValue,
			String ValueDateValue,
			String CustomerIDValue,
			String ProductCodeValue,
			String NonListedVendorValue,
			String CurrencyCodeValue,
			String ItemNameValue,
			String ItemCategoryValue,
			String PriceValue,
			String CostValue,
			String ParentframeID,
			String SubFrameID)
					throws InterruptedException, IOException
	{

		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		clickButton(addNewRowbBtn);
		Thread.sleep(500);
		clickButton(ViewItemBtn);
		Thread.sleep(2000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(1000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(2000);
		switchFrame(ParentframeID);
	}

	public void SaveRetailMurabaha()
	{
		clickButton(MasterSaveBtn);
		MurabahaCode = StoreData(ContractCodeTxt);				

	}


}
