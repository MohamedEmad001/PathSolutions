package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;
import Pages.RepaymentPlanTemplatesPage;
import TestData.JsonDataReader;

@Test
public class ProductSetupCrud extends TestBase {
	
	ProductSetupPage productSetupObj;
	
	//Master Data
	String jsonFilePath = "/src/test/java/TestData/FundData.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "TestProductSetupCrud";
	String curCode = "OMR";
	String DateValue = "01/01/2018";
	
	//Repayment Data
	RepaymentPlanTemplatesPage repaymentPlanObj = new RepaymentPlanTemplatesPage(driver);
	
	String repaymentcode=RepaymentPlanTemplatesPage.repaymentCode;
	
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
	
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath,"CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void FillData() throws InterruptedException, IOException
	{
		productSetupObj = new ProductSetupPage(driver);
		productSetupObj.ProductSetupModuleCrud(productsetupTypeValue, ClassCodevalue ,curCode, DateValue, Namevalue, ParentframeID, SubFramesID, repaymentcode);
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
