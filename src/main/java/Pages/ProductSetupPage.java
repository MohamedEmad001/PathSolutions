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
	
	@FindBy(css = "#CUR_CODE_lovImage")
	WebElement currencyLOVIcon;
	
	@FindBy(id = "advancedFilter")
	WebElement curQuickSearch;
	
	@FindBy(css= "#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement curSearchResult;

	@FindBy(id= "FPROD_PRODUCT_START_DATE")
	WebElement DateTxt;
	

	@FindBy (css="#REPT_DESCRIPTION1_lovImage")
	WebElement RepaymentLov;

	@FindBy (css = "#advancedFilter")
	WebElement repaymentcodeQuickSearch;

	@FindBy (css = "#filtergrid > div.k-grid-content > table > tbody > tr")
	WebElement RepaymentSearchResult;
	
	//Got ot BusinessRulesTab
	@FindBy(css= "#V1TC_V6TP_tab > span > span")
	WebElement BusinessRulesTab;

	@FindBy(id= "V1TC_V6TP_V6AddButton")
	WebElement AddNewRule;
	
	@FindBy(css = "#BR_CODE_lovImage")
	WebElement RuleLov;
	
	@FindBy (css = "#advancedFilter")
	WebElement RulecodeQuickSearch;

	@FindBy (css = "#filtergrid > div.k-grid-content > table > tbody")
	WebElement RuleSearchResult;
	
	@FindBy (id = "V1TC_V6TP_V6LCRepeater_ctl00_BR_WORKFLOW_ACTION")
	WebElement RuleActionTxt;
	
	@FindBy (css = "#V1TC_V6TP_V6TC_V4TP_V4AddButton")
	WebElement AffectionField;
	
	@FindBy (id = "V1TC_V6TP_V6TC_V4TP_V4LCRepeater_ctl00_PRODUCT_FACTOR1")
	WebElement ProductFactorList;
	
	@FindBy(css= "#V1TC_V6TP_V6TC_V4TP_V4LCRepeater_ctl00_PROAF_OVERRIDE_VALUE")
	WebElement ProductFactorValue;
	
	//Goto OverRide
	
	@FindBy(id= "__tab_V1TC_V12TP")
	WebElement OverRide;
	
	@FindBy(id="V1TC_V12TP_V12AddButton")
	WebElement AddNewRide;
	
	@FindBy(id="V1TC_V12TP_V12LCRepeater_ctl00_PRODUCT_FACTOR")
	WebElement ProdFactList;
	
	@FindBy (id="V1TC_V12TP_V12LCRepeater_ctl00_OVERRIDE_OPTIONS")
	WebElement OverRideOptions;
	
	
	//Save
	@FindBy (id = "SaveButton__Button")
	WebElement SaveData;
	
	//Post
	@FindBy (css="#POSTButton")
	WebElement Post;
	
	//ProductSetup Code
	@FindBy (id = "FPROD_CODE")
	public WebElement ProductCode;

	public static String ActualProductCode;



	public void ProductSetupModule(	String productsetupTypeValue, String ClassCodevalue,String curCode,String DateValue,String Namevalue, String ParentframeID, String SubFramesID, String repaymentcode) throws InterruptedException, IOException

	{
		Thread.sleep(7000);
		driver1.switchTo().defaultContent();
		waitMethod(5);
		searchBox.clear();
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
		waitMethod(3);
		setTextElementText(Nametxt , Namevalue);
		
		waitMethod(3);
		clickButton(currencyLOVIcon);
		switchFrame(SubFramesID);
		waitMethod(3);
		setTextElementText(curQuickSearch, curCode);
		Thread.sleep(5000);
		DoubleClickonElement(curSearchResult);

		switchFrame(ParentframeID);
		setTextElementText(DateTxt , DateValue);
		
		waitMethod(3);
		
		//Repayment Lov
		
		clickButton(RepaymentLov);
		Thread.sleep(5000);
		switchFrame(SubFramesID);
		Thread.sleep(5000);
		setTextElementText(repaymentcodeQuickSearch, repaymentcode);
		Thread.sleep(5000);
		DoubleClickonElement(RepaymentSearchResult);
		Thread.sleep(5000);
		switchFrame(ParentframeID);
		Thread.sleep(5000);
		

	}	
	public void ProductSetupModuleCrud(	String productsetupTypeValue, String ClassCodevalue,String curCode,String DateValue,String Namevalue, String ParentframeID, String SubFramesID, String repaymentcode) throws InterruptedException, IOException

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
		waitMethod(3);
		setTextElementText(Nametxt , Namevalue);
		
		waitMethod(3);
		clickButton(currencyLOVIcon);
		switchFrame(SubFramesID);
		waitMethod(3);
		setTextElementText(curQuickSearch, curCode);
		Thread.sleep(5000);
		DoubleClickonElement(curSearchResult);

		switchFrame(ParentframeID);
		setTextElementText(DateTxt , DateValue);
		
		waitMethod(3);
		
		//Repayment Lov
		
		clickButton(RepaymentLov);
		Thread.sleep(5000);
		switchFrame(SubFramesID);
		Thread.sleep(5000);
		setTextElementText(repaymentcodeQuickSearch, repaymentcode);
		Thread.sleep(5000);
		DoubleClickonElement(RepaymentSearchResult);
		Thread.sleep(5000);
		switchFrame(ParentframeID);
		Thread.sleep(5000);
		

	}	
	public void BusinessRules(String SubFramesID, String Rulecode,String RuleActionValue,String ProductFactor, String ParentframeID) throws InterruptedException 
	
	{
		//Rule 1

		clickButton(BusinessRulesTab);
		Thread.sleep(5000);
		/*clickButton(AddNewRule);
		Thread.sleep(5000);
		clickButton(RuleLov);
		Thread.sleep(5000);
		switchFrame(SubFramesID);
		*/
		Thread.sleep(5000);
		setTextElementText(RulecodeQuickSearch, Rulecode);
		Thread.sleep(5000);
		DoubleClickonElement(RuleSearchResult);	
		switchFrame(ParentframeID);
		DropListSelect(RuleActionTxt, RuleActionValue);
				
		//Affection of rule1
		clickButton(AffectionField);
		DropListSelect(ProductFactorList, ProductFactor);
		ProductFactorValue.sendKeys("100");
				
	}
	
	public void OverRideTab(String ProdFactValue, String OverRideOptionsValue) throws InterruptedException
	
	{
		
		//Go to OverRide Tab
		
		clickButton(OverRide);
		clickButton(AddNewRide);
		Thread.sleep(3000);
		DropListSelect(ProdFactList, ProdFactValue);
		Thread.sleep(3000);
		DropListSelect(OverRideOptions, OverRideOptionsValue);
	}
	
	public void SaveButton() throws InterruptedException {
		
		clickButton(SaveData);
		Thread.sleep(5000);
		ActualProductCode = StoreData(ProductCode);
	}
	
	public void PostButton() throws InterruptedException {
		
		clickButton(Post);
		ConfirmAlert();
		Thread.sleep(5000);
	}
}
