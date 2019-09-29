package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.CRUD.DocumentTypesCRUDPage;
import Pages.CRUD.SectorCRUDPage;
import tests.TestBase;

@Test(groups = {"DocumentTypesCRUDTest"})
public class DocumentTypesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "150018";
	String ParentframeID="frame_150018";
	String filterAreaFrame="parentModuleID150018";



	//Updating data
	String NameValue="DOCUMENT TYPES CRUD Update";

	public String ActualDOCUMENTTYPESCode;

	//@FindBy (id = "SEC_CODE")WebElement sectorCode;


	/*@Test (priority = 1)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/

	@Test(dependsOnGroups = {"SectorsCRUDTest"}) 	
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		SectorCRUDPage moduleHandlerObj = new SectorCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		DocumentTypesCRUDPage moduleHandlerObj = new DocumentTypesCRUDPage(driver);
		moduleHandlerObj.updateData(NameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		DocumentTypesCRUDPage moduleHandlerObj = new DocumentTypesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		DocumentTypesCRUDPage moduleHandlerObj = new DocumentTypesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		DocumentTypesCRUDPage moduleHandlerObj = new DocumentTypesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}

	

}
