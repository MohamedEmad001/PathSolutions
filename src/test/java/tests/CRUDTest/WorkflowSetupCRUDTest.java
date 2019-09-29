package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CRUD.WorkflowSetupCRUDPage;
import TestData.JsonDataReader;
import tests.TestBase;

@Test(groups = {"SectorsCRUDTest"})
public class WorkflowSetupCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "150072";
	String ParentframeID="frame_150072";
	String filterAreaFrame="parentModuleID150072";
	
	
	
	//Updating data
	String update_Workflow_Value="Update_CRUD";
		
	@Test (priority = 0)
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
		WorkflowSetupCRUDPage moduleHandlerObj = new WorkflowSetupCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		WorkflowSetupCRUDPage moduleHandlerObj = new WorkflowSetupCRUDPage(driver);
		moduleHandlerObj.updateData(update_Workflow_Value);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		WorkflowSetupCRUDPage moduleHandlerObj = new WorkflowSetupCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		WorkflowSetupCRUDPage moduleHandlerObj = new WorkflowSetupCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		WorkflowSetupCRUDPage moduleHandlerObj = new WorkflowSetupCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
