package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CRUD.ReconciliationsCRUDPage;
import TestData.JsonDataReader;
import tests.TestBase;

public class ReconciliationsCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "130001";
	String ParentframeID="frame_130001";
	String filterAreaFrame="parentModuleID130001";
	
	
	
	//Updating data
	String latinNameValue="CRUD_Reconciliations_Update";
	
	//public String ActualSectorCode;
	
	//@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
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
		ReconciliationsCRUDPage moduleHandlerObj = new ReconciliationsCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		ReconciliationsCRUDPage moduleHandlerObj = new ReconciliationsCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"},priority=4)
	public void checkDeleteTestCase() throws InterruptedException
	{
		ReconciliationsCRUDPage moduleHandlerObj = new ReconciliationsCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"},priority=5)
	public void checkFilterArea() throws InterruptedException {
		ReconciliationsCRUDPage moduleHandlerObj = new ReconciliationsCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"},priority=6)
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		ReconciliationsCRUDPage moduleHandlerObj = new ReconciliationsCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
