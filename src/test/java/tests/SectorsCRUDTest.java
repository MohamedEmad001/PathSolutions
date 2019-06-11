package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CashTransferModuleHandler;
import TestData.JsonDataReader;
import tests.TestBase;

public class SectorsCRUDTest extends TestBase {

	String moduleID = "18";
	String jsonFilePath = "/src/test/java/TestData/FundData.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	public String ActualSectorCode;
	
	@FindBy (id = "SEC_CODE")
	WebElement sectorCode;
	
	
	
	
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}
	
	@Test (dependsOnMethods = {"CheckLogin"})	
	public void CheckSaveTestCase () throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CashTransferModuleHandler moduleHandlerObj = new CashTransferModuleHandler(driver);
		moduleHandlerObj.FillModuleFields(moduleID);
		ActualSectorCode = sectorCode.getAttribute("Value");
		
	}


}
