package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;
import Pages.RetailMurabahaPage;


@Test (groups = { "RetailMurabahaTest"})
public class RetailMurabahaTestCRUD extends TestBase {

	
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
	
	//String Cust1="M_004_Appr";
	//String Cust2="F_004_Appr";
	//String Cust3="M_002_Appr";
	//String Cust4="F_002_Appr";
	//String Cust5="M_010_Appr";
	//String Cust6="F_010_Appr";
	//String Cust7="M_007_Appr";
	//String Cust8="F_007_Appr";
	
	String ProductCodeID="608";
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

			
	@Test
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

	@Test(dependsOnMethods = {"CheckLogin"})
	public void CheckOpenRetailMurabah() throws InterruptedException {
	
		RetailMurabahaObject = new RetailMurabahaPage(driver);
		RetailMurabahaObject.OpenRetailMurabahaCrud(ParentframeID, RetailMurabahamoduleID);
	}
	
	@Test (dependsOnMethods = {"CheckOpenRetailMurabah"})
	public void CheckInsertAllMandatoryFields() throws InterruptedException, IOException
	{
		//System.out.println("x" + ProductSetupPage.ActualProductCode);
		RetailMurabahaObject.FillRequiredFields(RequestedDate, ValueDate, 
				CustomerID, ProductCodeID,
				NonListedVendor, CurrencyCode,
				ItemName, ItemCategory, Price,
				Cost, ParentframeID,SubFramesID);
	}
	
	@Test (dependsOnMethods = {"CheckInsertAllMandatoryFields"})
	public void CheckSaveRetailMurabaha() throws InterruptedException

	{
		RetailMurabahaObject.SaveRetailMurabaha();
		RetailMurabahaObject.CheckRequestApproval();
		//RMurabahaCode = RetailMurabahaObject.MurabahaCode;
		//System.out.println("Retail Murabaha Code=: "+ RMurabahaCode);
		//RMurabahaCode = RetailMurabahaPage.MurabahaCode;

	}
	
	@Test (dependsOnMethods = {"CheckSaveRetailMurabaha"})
	public void CheckRequestApproval() throws InterruptedException {
		
		RetailMurabahaObject.CheckRequestApproval();
	}
	
	
	
}
