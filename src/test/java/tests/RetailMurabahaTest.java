package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RetailMurabahaPage;

public class RetailMurabahaTest extends TestBase {

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
	String ProductCodee="608";
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

		
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

	@Test(priority=2)
	public void CheckOpenRetailMurabah() throws InterruptedException {
	
		RetailMurabahaObject = new RetailMurabahaPage(driver);
		RetailMurabahaObject.OpenRetailMurabaha(ParentframeID, RetailMurabahamoduleID);
	}
	
	@Test (priority=3)
	public void CheckInsertAllMandatoryFields() throws InterruptedException, IOException
	{
		RetailMurabahaObject.FillRequiredFields(RequestedDate, ValueDate, 
				CustomerID, ProductCodee,
				NonListedVendor, CurrencyCode,
				ItemName, ItemCategory, Price,
				Cost, ParentframeID,SubFramesID);
	}
	
	@Test (priority=4)
	public void CheckSaveRetailMurabaha()
	{
		RetailMurabahaObject.SaveRetailMurabaha();
		RMurabahaCode = RetailMurabahaObject.MurabahaCode;
		System.out.println("Retail Murabaha Code=: "+ RMurabahaCode);

	}
	
	
}
