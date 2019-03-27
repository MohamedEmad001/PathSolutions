package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;

public class BusinessRulesTest extends TestBase {


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
	String NameValue="Test CompositeRule cycle";
	String FactorTypeValue="Module Fields";
	String AmountValue="Ahmed M G";
	
	// Call Rule Code
	
	public static String ActualRuleCode;
	

	@Test
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);
		Thread.sleep(3000);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void OpenBusinessRules() throws InterruptedException
	{
		BusinessRulesObject = new BusinessRulesPage(driver);
		BusinessRulesObject.OpenBussinessRule(BusinessRulesModuleID,ParentFrameIDValue);
		BusinessRulesObject.InsertAllMandatoryFields(NameValue, ParentFrameIDValue,
				SubFrameValue, ModuleIDValue, FactorTypeValue, AmountValue);

	}
	
	@Test (dependsOnMethods = {"OpenBusinessRules"})
	public void SaveBusinessRules() throws InterruptedException {
		Thread.sleep(2000);
		BusinessRulesObject.CheckSaveBusinessRule();
		Thread.sleep(2000);
		//RuleCode = BusinessRulesPage.ActualRuleCode;
		System.out.println(ActualRuleCode);
		
	}
	

}



