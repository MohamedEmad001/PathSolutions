package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;
import TestData.JsonDataReader;

public class BusinessRulesCRUD extends TestBase {


	//Global Variables
	WebDriver driver1;
	BusinessRulesPage BusinessRulesObject;
	//For Login
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
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
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData("CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

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



