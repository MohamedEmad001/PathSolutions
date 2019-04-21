package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(css="#CUS_NAME")WebElement CustomerNameTxt;
	@FindBy(css="#FPROD_CODE1")WebElement ProductCodeTxt;
	@FindBy(css = "#FPROD_LATIN_NAME") WebElement ProductNameTxt;
	@FindBy(css="#NL_VND_NAME")	WebElement NonListedVendorTxt;
	@FindBy (css="#CUR_CODE2")WebElement CurrencyCodeTxt;
	@FindBy(css="#V18TC_V8TP_V8AddButton")WebElement addNewRowbBtn;
	@FindBy(xpath="//*[@id=\"V18TC_V8TP_V8LCRepeater_ctl00_AddButton\"]")WebElement ViewItemBtn;
	@FindBy(css="#ITE_NAME") WebElement ItemNameTxt;
	@FindBy(id="IC_CODE") WebElement ItemCategoryDropdownSelect;
	@FindBy(css="#ITE_PRICE") WebElement PriceTxt;
	@FindBy(css="#ITE_COST") WebElement CostTxt;
	@FindBy(css="#SaveButton__Button") WebElement SaveAndCloseBtn;

	@FindBy(css="#V18NewButton") WebElement addNewButton;

	@FindBy(css="#V18SaveButton") WebElement MasterSaveBtn;

	@FindBy(css="#FCON_CODE") WebElement ContractCodeTxt;
	//Request for approv

	@FindBy(css= "#V18ApproveButton") WebElement RequestBtn;

	//Status
	@FindBy(css= "#APPROVAL_STATUS_NAME") WebElement StatusTxt;

	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn")
	WebElement saveConfirmationMsg;

	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement saveConfirmationBtn;


	@FindBy(css="#Body1 > div:nth-child(5)")
	WebElement approvalConfirmationMsg;


	@FindBy(css="#Body1 > div:nth-child(5) > div.lobibox-footer.text-center > button")
	WebElement approvalConfirmationBtn;


	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn")
	WebElement objectReferenceConfirmationMsg;


	@FindBy(css="#Body1 > div.lobibox.lobibox-info.draggable.animated-super-fast.zoomIn > div.lobibox-footer.text-center > button")
	WebElement objectReferenceConfirmationBtn;

	public static  String MurabahaCode;


	@FindBy(css="#CUS_NAME")
	WebElement customerName;

	@FindBy(css="#FPROD_LATIN_NAME")
	WebElement productSetupName;

	@FindBy(id="CUS_CODE_lovImage")
	WebElement customerLOVIcon;

	@FindBy(css="#filtergrid > div.k-grid-header > div > table > thead > tr:nth-child(2) > th:nth-child(1)")
	WebElement LOVQuickSearchField;

	String SubLovFrame = "parentModuleID1500900011";

	@FindBy(css="#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement LOVSearchResult;

	@FindBy(id="FPROD_CODE1_lovImage")
	WebElement productLOVIcon;


	//Search on RetailMurabahamoduleID and open it for RetailMurabahaTest

	public void OpenRetailMurabaha(String ParentframeID, 
			String RetailMurabahamoduleID) 
					throws InterruptedException
	{

		//Thread.sleep(7000);
		driver1.switchTo().defaultContent();
		//waitMethod(5);
		waitForElement(searchBox);
		searchBox.clear();
		//Thread.sleep(7000);
		searchBox.sendKeys(RetailMurabahamoduleID);
		//waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		//waitMethod(7);
		searchBox.sendKeys(Keys.SHIFT, Keys.ENTER);
		//Thread.sleep(5000);
		waitForFrame(ParentframeID);
		//switchFrame(ParentframeID);

		waitMethod(7);
	}

	//Search on RetailMurabahamoduleID and open it for RetailMurabahaCRUD
	public void OpenRetailMurabahaCrud(String ParentframeID, 
			String RetailMurabahamoduleID) 
					throws InterruptedException
	{
		//Thread.sleep(7000);
		waitForElement(searchBox);
		searchBox.sendKeys(RetailMurabahamoduleID);
		//waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.ENTER);
		//waitMethod(7);
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
		
		openLOVAndSearch(customerLOVIcon, SubLovFrame, LOVQuickSearchField, CustomerIDValue, LOVSearchResult, ParentframeID);
		//waitForFrame(ParentframeID);
		Thread.sleep(3000);
		
		openLOVAndSearch(productLOVIcon, SubLovFrame, LOVQuickSearchField, ProductCodeValue, LOVSearchResult, ParentframeID);
		//waitForFrame(ParentframeID);
		Thread.sleep(3000);
		
		waitForElement(NonListedVendorTxt);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		waitForElement(addNewRowbBtn);
		clickButton(addNewRowbBtn);
		//Thread.sleep(3000);
		//waitMethod(3);
		waitForElement(ViewItemBtn);
		clickButton(ViewItemBtn);
		//Thread.sleep(7000);
		//switchFrame(SubFrameID);
		waitForFrame(SubFrameID);
		waitForElement(ItemNameTxt);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		//Thread.sleep(3000);
		waitForElement(SaveAndCloseBtn);
		clickButton(SaveAndCloseBtn);
		//Thread.sleep(8000);
		waitForFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer1(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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
		waitForElement(CustomerIDTxt);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_004_Appr"));
		Boolean state = waitForCheckResult(CustomerNameTxt, StoreData(CustomerNameTxt));
		if (state)
		{
			waitForElement(ProductCodeTxt);
			setTextElementText(ProductCodeTxt, ProductCodeValue);
			state = waitForCheckResult(ProductNameTxt, StoreData(ProductNameTxt));
			if (state)
			{

				waitForElement(NonListedVendorTxt);
				setTextElementText(NonListedVendorTxt, NonListedVendorValue);
				setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
				waitForElement(addNewRowbBtn);
				clickButton(addNewRowbBtn);
				//Thread.sleep(3000);
				//waitMethod(3);
				waitForElement(ViewItemBtn);
				clickButton(ViewItemBtn);
				Thread.sleep(7000);
				switchFrame(SubFrameID);
				waitForElement(ItemNameTxt);
				setTextElementText(ItemNameTxt, ItemNameValue);
				//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
				DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
				setTextElementText(PriceTxt, PriceValue);
				setTextElementText(CostTxt, CostValue);
				//Thread.sleep(3000);
				waitForElement(SaveAndCloseBtn);
				clickButton(SaveAndCloseBtn);
				Thread.sleep(8000);
				switchFrame(ParentframeID);
			}
		}
	}

	public void FillRequiredFieldsByCustomer2(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_004_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}

	public void FillRequiredFieldsByCustomer3(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_002_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer4(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_002_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer5(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_010_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer6(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_010_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer7(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("M_007_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer8(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("F_007_Appr"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		//setTextElementText(ItemCategoryDropdownSelect, ItemCategoryValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void FillRequiredFieldsByCustomer9(String RequestedDateValue,
			String ValueDateValue,
			Hashtable<String, String> CustomerIDValue,
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

		clickButton(addNewButton);
		Thread.sleep(4000);
		setTextElementText(RequestedDateTxt, RequestedDateValue);
		setTextElementText(ValueDateTxt, ValueDateValue);
		setTextElementText(CustomerIDTxt, CustomerIDValue.get("BBC_M_003_Reje"));
		Thread.sleep(12000);
		setTextElementText(ProductCodeTxt, ProductCodeValue);
		Thread.sleep(12000);
		setTextElementText(NonListedVendorTxt, NonListedVendorValue);
		setTextElementText(CurrencyCodeTxt, CurrencyCodeValue);
		Thread.sleep(3000);
		clickButton(addNewRowbBtn);
		Thread.sleep(3000);
		waitMethod(3);
		clickButton(ViewItemBtn);
		Thread.sleep(7000);
		switchFrame(SubFrameID);
		setTextElementText(ItemNameTxt, ItemNameValue);
		DropListSelect(ItemCategoryDropdownSelect, ItemCategoryValue);
		setTextElementText(PriceTxt, PriceValue);
		setTextElementText(CostTxt, CostValue);
		Thread.sleep(3000);
		clickButton(SaveAndCloseBtn);
		Thread.sleep(8000);
		switchFrame(ParentframeID);
	}


	public void SaveRetailMurabaha() throws InterruptedException
	{
		waitForElement(MasterSaveBtn);
		clickButton(MasterSaveBtn);
		MurabahaCode = StoreData(ContractCodeTxt);
		System.out.println(MurabahaCode);
	}

	public void CheckRequestApproval() throws InterruptedException {

		Thread.sleep(3000);
		//waitForElement(RequestBtn);
		clickButton(RequestBtn);		
		//waitForGeneratedValue(StatusTxt);
		Thread.sleep(3000);
		assertEquals(StatusTxt.getAttribute("Value"), "Ready");
		System.out.println(StatusTxt);

	}

}
