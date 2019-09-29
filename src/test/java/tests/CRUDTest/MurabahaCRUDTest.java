package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CRUD.MurabahaCRUDPage;
import TestData.JsonDataReader;
import tests.TestBase;

public class MurabahaCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "1500900011";
	String ParentframeID="frame_1500900011";
	String filterAreaFrame="parentModuleID1500900011";
	
	
	
	//Updating data
	String updateDateValue="01022018";
	
	public String ActualSectorCode;
	
	@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
	@Test (priority = 1)
	public void CheckLogin()
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}
	
	@Test (dependsOnMethods = {"CheckLogin"})
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		MurabahaCRUDPage moduleHandlerObj = new MurabahaCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		MurabahaCRUDPage moduleHandlerObj = new MurabahaCRUDPage(driver);
		moduleHandlerObj.updateData(updateDateValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"},priority=4)
	public void checkDeleteTestCase() throws InterruptedException
	{
		MurabahaCRUDPage moduleHandlerObj = new MurabahaCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"},priority=5)
	public void checkFilterArea() throws InterruptedException {
		MurabahaCRUDPage moduleHandlerObj = new MurabahaCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"},priority=6)
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		MurabahaCRUDPage moduleHandlerObj = new MurabahaCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
