package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.PortfolioActivationDeActivationModuleHandler;
import TestData.JsonDataReader;

public class PortfolioActivationDeActivationCRUDTest extends TestBase {
	
	String moduleID = "1521212";
	String jsonFilePath = "/src/test/java/TestData/FundData.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};	
	

	
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
		PortfolioActivationDeActivationModuleHandler moduleHandlerObj = new PortfolioActivationDeActivationModuleHandler(driver);
		moduleHandlerObj.FillModuleFields(moduleID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
		
	}
	

}
