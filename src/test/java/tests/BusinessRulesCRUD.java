package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;

public class BusinessRulesCRUD extends TestBase {


	//Global Variables
	WebDriver driver1;
	BusinessRulesPage BusinessRulesObject;
	//For Login
	String UserName = "administrator";
	String UserPass = "admin12";
	
	//For Business Module Number
	String BusinessRulesModuleID= "2100000031";
	String ParentFrameIDValue="frame_2100000031";
	String SubFrameValue="parentModuleID2100000031";

	//Variables for Condition Builder
	String ModuleIDValue = "15002711";
	String NameValue="Test CRUD Business Rule";
	String FactorTypeValue="Module Fields";
	String AmountValue="Ahmed";
	
	//Variables for Update Business Rules
	String BRuleNameValue = "Update Test Business Rule";
	String BRNoteValue="Add Note";





	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);
		Thread.sleep(3000);

	}

	@Test(priority=2)
	public void OpenBusinessRules() throws InterruptedException
	{
		BusinessRulesObject = new BusinessRulesPage(driver);
		BusinessRulesObject.OpenBussinessRule(BusinessRulesModuleID,ParentFrameIDValue);
		BusinessRulesObject.InsertAllMandatoryFields(NameValue, ParentFrameIDValue,
				SubFrameValue, ModuleIDValue, FactorTypeValue, AmountValue);

	}
	
	@Test(priority=3)
	public void SaveBusinessRules() throws InterruptedException {
		Thread.sleep(2000);
		BusinessRulesObject.CheckSaveBusinessRule();
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void UpdateBusinessRules() throws InterruptedException
	{
		BusinessRulesObject.CheckUpdate(BRuleNameValue, BRNoteValue);
		BusinessRulesObject.CheckSaveBusinessRule();
	}
	
	@Test(dependsOnMethods= {"UpdateBusinessRules"})
	public void DeleteBusinessRule() throws InterruptedException
	{
		BusinessRulesObject.CheckDelete();
	}
}



