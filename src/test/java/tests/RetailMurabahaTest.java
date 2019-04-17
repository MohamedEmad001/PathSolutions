package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.IndividualProspectPage;
import Pages.LoginPage;
import Pages.ProductSetupPage;
import Pages.RetailMurabahaPage;
import TestData.JsonDataReader;


@Test (groups = { "RetailMurabahaTest"})
public class RetailMurabahaTest extends TestBase {

	//object from product setup testcase to call generated product code
	ProductSetupTest productSetupObj = new ProductSetupTest();
	
	
	//Objects from RetailMurabahaPage
	
	RetailMurabahaPage RetailMurabahaObject ;

	WebDriver driver1;
	
	String jsonFilePath = "/src/test/java/TestData/FundData.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	//For Retail Murabaha Filling  Data
	String RequestedDate = "01012018";
	String ValueDate ="01012018";
	String CustomerID="352425171";

	String NonListedVendor="Non Listed Item";
	String CurrencyCode="EGP";
	String ItemName="Test Item";
	String ItemCategory="47";
	String Price ="12000";
	String Cost="12000";
	String ParentframeID = "frame_1500900011";
	String SubFramesID = "parentModuleID1500900011";
	String RetailMurabahamoduleID= "1500900011";
	
	String RMurabahaCode;

		
	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath,"CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);
	}

	//(dependsOnGroups = {"ProductSetupTest"})
	@Test(dependsOnMethods = {"CheckLogin"})
	public void CheckOpenRetailMurabah() throws InterruptedException {
	
		RetailMurabahaObject = new RetailMurabahaPage(driver);
		RetailMurabahaObject.OpenRetailMurabaha(ParentframeID, RetailMurabahamoduleID);
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah"})
	public void CheckInsertAllMandatoryFields() throws InterruptedException, IOException
	{
		System.out.println("x" + ProductSetupPage.ActualProductCode);
		RetailMurabahaObject.FillRequiredFields(RequestedDate, ValueDate,
				//IndividualProspectPage.generatedProspectCode
				"352425264", 
				//ProductSetupPage.ActualProductCode,
				"772",
				NonListedVendor, CurrencyCode,
				ItemName, ItemCategory, Price,
				Cost, ParentframeID,SubFramesID);
	}
	
	@Test (dependsOnMethods = {"CheckInsertAllMandatoryFields"})
	public void CheckSaveRetailMurabaha() throws InterruptedException

	{
		RetailMurabahaObject.SaveRetailMurabaha();
		RMurabahaCode = RetailMurabahaPage.MurabahaCode;
		System.out.println("Retail Murabaha Code=: "+ RMurabahaCode);
		RMurabahaCode = RetailMurabahaPage.MurabahaCode;

	}
	
	@Test (dependsOnMethods = {"CheckSaveRetailMurabaha"})
	public void RequestForApprove() throws InterruptedException {
		
		RetailMurabahaObject.CheckRequestApproval();
	}
	
	
}
