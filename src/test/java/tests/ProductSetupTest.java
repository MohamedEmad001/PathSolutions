package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;
import TestData.JsonDataReader;

public class ProductSetupTest extends TestBase {


	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	String productsetupTypeValue = "R";
	String ClassCodevalue = "1000";
	String Namevalue = "Testcompositerules";
	String repaymentcode="846";
	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData("CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void SaveProductSetup() throws InterruptedException, IOException
	{
		ProductSetupPage productSetupObj = new ProductSetupPage(driver);
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue, Namevalue, ParentframeID, SubFramesID, repaymentcode);


	}

}
