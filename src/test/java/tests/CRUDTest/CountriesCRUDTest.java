package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Pages.CRUD.CountriesCRUDPage;
import tests.TestBase;

@Test(groups = {"CountriesCRUDTest"})
public class CountriesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};
	
	String moduleID = "47";
	String ParentframeID="frame_47";
	String filterAreaFrame="parentModuleID47";
	
	
	
	//Updating data
	String latinNameValue="CRUD_Countries_Update";
	
	public String ActualSectorCode;
	
	@FindBy (id = "SEC_CODE")WebElement sectorCode;
	
	
	/*@Test (priority = 0)
	public void CheckLogin() 
throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/
	
  	@Test(dependsOnGroups = {"RegionsCRUDTest"}) 	
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CountriesCRUDPage moduleHandlerObj = new CountriesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CountriesCRUDPage moduleHandlerObj = new CountriesCRUDPage(driver);
		moduleHandlerObj.updateData(latinNameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CountriesCRUDPage moduleHandlerObj = new CountriesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CountriesCRUDPage moduleHandlerObj = new CountriesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}
	
	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CountriesCRUDPage moduleHandlerObj = new CountriesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
