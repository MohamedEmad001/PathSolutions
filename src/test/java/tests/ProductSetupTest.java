package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;

@Test (groups = { "ProductSetupTest"})
public class ProductSetupTest extends TestBase {
	
	ProductSetupPage productSetupObj;
	
	//Master Data
	String UserName = "administrator";
	String UserPass = "admin12";
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "Testcompositerules";
	String curCode = "OMR";
	String DateValue = "01/01/2018";
	
	//Repayment Data
	
	String repaymentcode="859";
	
	//Business Rules
	
	String Rulecode = "3";
	String RuleActionValue="APP";
	String ProductFactor="MAXT";
	
	//OverRide
	String ProdFactValue="MAXT";
	String OverRideOptionsValue="MIN";
		
	//Switches between frames
	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";
	public static String ProductCode;
	
	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void FillData() throws InterruptedException, IOException
	{
		productSetupObj = new ProductSetupPage(driver);
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue ,curCode, DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
		productSetupObj.BusinessRules(SubFramesID, Rulecode, RuleActionValue, ProductFactor, ParentframeID);
		productSetupObj.OverRideTab(ProdFactValue, OverRideOptionsValue);
		
	}
	
	@Test (dependsOnMethods = {"FillData"})
	public void SaveProductSetup() throws InterruptedException {
		
		productSetupObj.SaveButton();
		//Call Product Code
		ProductCode=ProductSetupPage.ActualProductCode;
		System.out.println(ProductCode);
		
		
	}
		
	@Test (dependsOnMethods = {"SaveProductSetup"})
	public void PostButton() throws InterruptedException {
		
		productSetupObj.PostButton();
	}
	
}
