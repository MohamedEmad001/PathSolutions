package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessRulesPage;
import Pages.LoginPage;

public class BusinessRulesTest extends TestBase {
	
	
	   //Global Variables
		WebDriver driver1;
		BusinessRulesPage BusinessRulesObject;
		//For Login
		String UserName = "administrator";
		String UserPass = "admin12";
		//For Business Module Number
		String BusinessRulesModuleID= "2100000031";
		String ParentFrameIDValue="frame_2100000031";
		String SubFrameValue="parentModuleID2100000031";
		
		//For Murabaha Module
		
		String MurabahaModule = "1500900011";
		
		
		

		@Test (priority = 1)
		public void CheckLogin() throws InterruptedException
		{
			LoginPage loginPageObj = new LoginPage(driver);
			loginPageObj.UserLogin(UserName, UserPass);

		}
		
		@Test(priority=2)
		public void OpenBusinessRules() throws InterruptedException
		{
			BusinessRulesObject = new BusinessRulesPage(driver);
			BusinessRulesObject.OpenBussinessRule(BusinessRulesModuleID,ParentFrameIDValue);
			BusinessRulesObject.InsertAllMandatoryFields(NameText, FrameID, SubFrame);
			
		}
		
		
}
