package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;
import Pages.ProductSetupPage;
import TestData.JsonDataReader;

@Test (groups = { "ProductSetupTest"})
public class ProductSetupTest extends TestBase {
<<<<<<< HEAD
	
	ProductSetupPage productSetupObj;
	
	//Master Data
	String UserName = "administrator";
	String UserPass = "admin12";
=======


	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
>>>>>>> ca3db4572fd3e215eab740ad2f9f1fe3391ea11d
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "Testcompositerules";
	String curCode = "OMR";
	String DateValue = "01/01/2018";
	
	//Repayment Data
	
	String repaymentcode="859";
	
	//Business Rules
	
	String Rulecode = "61";
	String RuleActionValue="APP";
	String ProductFactor="MAXT";
	
	//OverRide
	String ProdFactValue="MAXT";
	String OverRideOptionsValue="MIN";
		
	//Switches between frames
	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";
<<<<<<< HEAD
	public static String ProductCode;
	
	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException
=======


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
>>>>>>> ca3db4572fd3e215eab740ad2f9f1fe3391ea11d
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData("CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test
	public void FillData() throws InterruptedException, IOException
	{
		productSetupObj = new ProductSetupPage(driver);
		//System.out.println("x" + BusinessRulesPage.ActualRuleCode);
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue,curCode, DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
		productSetupObj.BusinessRules(SubFramesID ,Rulecode, RuleActionValue, ProductFactor, ParentframeID);
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
