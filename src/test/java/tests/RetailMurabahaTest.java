package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.ProductSetupPage;
import Pages.RetailMurabahaPage;


@Test (groups = { "RetailMurabahaTest"})
public class RetailMurabahaTest extends TestBase {

	
	//object from product setup testcase to call generated product code
	//ProductSetupTest productSetupObj = new ProductSetupTest();
	
	
	//Objects from RetailMurabahaPage
	
	
	RetailMurabahaPage RetailMurabahaObject ;
	//Global Variables
	WebDriver driver1;
	//For Login
	String UserName = "administrator";
	String UserPass = "admin12";
	
	//For Retail Murabaha Filling  Data
	String RequestedDate = "01012018";
	String ValueDate ="01012018";
	String CustomerID="194";

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

/*			
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}
*/
	@Test(dependsOnGroups = {"ProductSetupTest"})
	public void CheckOpenRetailMurabah() throws InterruptedException {
	
		RetailMurabahaObject = new RetailMurabahaPage(driver);
		RetailMurabahaObject.OpenRetailMurabaha(ParentframeID, RetailMurabahamoduleID);
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah"})
	public void CheckInsertAllMandatoryFields() throws InterruptedException, IOException
	{
		System.out.println("x" + ProductSetupPage.ActualProductCode);
		RetailMurabahaObject.FillRequiredFields(RequestedDate, ValueDate, 
				CustomerID, ProductSetupPage.ActualProductCode,
				NonListedVendor, CurrencyCode,
				ItemName, ItemCategory, Price,
				Cost, ParentframeID,SubFramesID);
	}
	
	@Test (dependsOnMethods = {"CheckInsertAllMandatoryFields"})
	public void CheckSaveRetailMurabaha() throws InterruptedException

	{
		RetailMurabahaObject.SaveRetailMurabaha();
		//RMurabahaCode = RetailMurabahaObject.MurabahaCode;
		//System.out.println("Retail Murabaha Code=: "+ RMurabahaCode);
		//RMurabahaCode = RetailMurabahaPage.MurabahaCode;

	}
	
	
}
