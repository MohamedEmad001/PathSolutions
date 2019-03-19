package tests;

import java.io.IOException;
import org.testng.annotations.Test;
import Pages.FundPage;
import Pages.LoginPage;
import Pages.SettlementPage;

public class FundTest extends TestBase {


	FundPage fundPageObj;
	SettlementPage settlePage;


	String UserName = "administrator";
	String UserPass = "admin12";


	String FundName = "bbc-cnn-automated-script22";
	String CreationDate = "01/01/2019";
	String MaturityDate = "01/01/2020";
	String CurrencyName = "EGP";
	String RequiredDonorCode = "201";
	String RequiredContributorAmo = "100000";
	String classCodeNumber = "1000";
	String classPercentageAmount = "100";
	String ParentframeID = "frame_15002003";
	String SubFramesID = "parentModuleID15002003";
	String SettlementFrame = "frame_108";
	//create two var of already posted fund code and donor code from checkAddFund() TC
	String postedFundCode;
	String postedDonorCode;


	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

	@Test (dependsOnMethods = {"CheckLogin"})	
	public void checkAddFund() throws InterruptedException, IOException 
	{

		fundPageObj = new FundPage(driver);
		fundPageObj.openFundMocule(FundName, CreationDate, MaturityDate,ParentframeID,SubFramesID, CurrencyName, RequiredDonorCode, RequiredContributorAmo,classCodeNumber,classPercentageAmount);
		//retreieve the fund code generated and pass it to postedFundCode variable then pass it as paramater to the needed TC
		postedFundCode = FundPage.actualFundCode;
	}


	
	@Test (dependsOnMethods = {"checkAddFund"})
	public void checkSettlement() throws InterruptedException
	{
		settlePage = new SettlementPage(driver);
		System.out.println("Posted Fund Code: " + postedFundCode);
		settlePage.checkSettlement(SettlementFrame,postedFundCode);
	}
	


}
