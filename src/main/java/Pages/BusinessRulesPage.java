package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessRulesPage extends PageBase {

	public BusinessRulesPage(WebDriver driver) {
		super(driver);
	}

	//Global Variables
	WebDriver driver1;
	String ConditionBuilderFram="parentModuleID2100000031";
	//Search Area Text 
	@FindBy (id="txt_PlaceHolder") WebElement searchBox;
	//Business Rule Elements
	@FindBy(id="BR_NAME") WebElement RuleNameTxt;
	@FindBy(css="#BTN_EDIT_EQ__Button") WebElement EditBtn;

	//find elements for Condition Builder
	@FindBy(id="txtModuleID") WebElement ModuleIDTxt;
	@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn;
	@FindBy(id="ddlTypes") WebElement FactorTypeDropdownSelect;	
	@FindBy(css="#grdColumns > tbody > tr:nth-child(3) > td:nth-child(1)") WebElement AmountFiledBtn;
	@FindBy(id="grdColumns_ctl03_txtField") WebElement AmountTxt;

	@FindBy(id="btnBetween__Button") WebElement BetweenBtn;
	@FindBy(id="btnEqual__Button") WebElement EqualBtn;
	@FindBy(id="btnAnd__Button") WebElement AndBtn;
	@FindBy(id="") WebElement OrBtn;
	@FindBy(id="btnAdd__Button") WebElement AddBtn;
	@FindBy(id="btnClear__Button") WebElement ClearBtn;
	@FindBy(id="txtFormula") WebElement TextAreatxt;
	@FindBy(id="btnValidate__Button") WebElement ValidateBtn;
	@FindBy(id="btnAccept__Button") WebElement SaveBtn;
	@FindBy(id="btnCancel__Button") WebElement CancelBtn;
	@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn2;
	@FindBy (id="V0SaveButton") WebElement MasterSaveBtn; 


	public void OpenBussinessRule(String BusinessRulesModuleID,String ParentFram) 
			throws InterruptedException
	{
		Thread.sleep(3000);
		searchBox.sendKeys(BusinessRulesModuleID);
		waitMethod(7);
		searchBox.sendKeys(Keys.ENTER);
		searchBox.sendKeys(Keys.SHIFT,Keys.ENTER);
		Thread.sleep(5000);
		switchFrame(ParentFram);
		waitMethod(7);
	}

	public void InsertAllMandatoryFields(String NameText,String FrameID,
			String SubFrame,String ModuleID, String FactorType, String Amount)
		throws InterruptedException {
		setTextElementText(RuleNameTxt, NameText);
		clickButton(EditBtn);
		Thread.sleep(2000);
		switchFrame(SubFrame);
		Thread.sleep(1000);
		ModuleIDTxt.sendKeys(ModuleID);
		Thread.sleep(1500);
		DropListSelect(FactorTypeDropdownSelect, FactorType);
		DoubleClickonElement(AmountFiledBtn);
		clickButton(EqualBtn);
		AmountTxt.sendKeys(Amount);
		clickButton(AddBtn);
		clickButton(ValidateBtn);
		
	}


}
