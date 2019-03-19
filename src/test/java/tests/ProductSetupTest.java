package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductSetupPage;

public class ProductSetupTest extends TestBase {


	String UserName = "administrator";
	String UserPass = "admin12";


	String productsetupTypeValue = "R";
	String ClassCodevalue = "01/01/2018";
	String Namevalue = "Testcompositerules";
	String repaymentcode="846";


	String ParentframeID = "frame_150082";
	String SubFramesID = "parentModuleID150082";


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	public void SaveProductSetup() throws InterruptedException, IOException
	{
		ProductSetupPage productSetupObj = new ProductSetupPage(driver);
		productSetupObj.ProductSetupModule(productsetupTypeValue, ClassCodevalue, repaymentcode, Namevalue, ParentframeID, SubFramesID, repaymentcode);


	}

}
