package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.CRUD.CustomerScoringAttributesCRUDPage;
import tests.TestBase;

@Test(groups = {"CustomerScoringAttributesCRUDTest"})
public class CustomerScoringAttributesCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "17005001";
	String ParentframeID="frame_17005001";
	String filterAreaFrame="parentModuleID17005001";


	//Filling Data
	String latinNameValue="Customer Scoring Attributes CRUD";
	String otherNameValue="Customer Scoring Attributes CRUD Arabic";
	String customerTypeValue="INDL"; 

	//Updating data
	String NameValue="Customer Scoring Attributes CRUD Update";

	public String ActualSectorCode;

	//@FindBy (id = "SEC_CODE")WebElement sectorCode;


	/*@Test (priority = 0)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}*/

  	@Test(dependsOnGroups = {"CompaniesCRUDTest"}) 	
	public void CheckSaveTestCase ()
			throws FileNotFoundException, InterruptedException, IOException, ParseException
	{
		CustomerScoringAttributesCRUDPage moduleHandlerObj = new CustomerScoringAttributesCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(latinNameValue, otherNameValue, customerTypeValue);
		//ActualSectorCode = sectorCode.getAttribute("Value");
	}
	@Test (dependsOnMethods= {"CheckSaveTestCase"})
	public void checkUpdateTestCase() throws InterruptedException
	{
		CustomerScoringAttributesCRUDPage moduleHandlerObj = new CustomerScoringAttributesCRUDPage(driver);
		moduleHandlerObj.updateData(NameValue);
	}
	@Test (dependsOnMethods= {"checkUpdateTestCase"})
	public void checkDeleteTestCase() throws InterruptedException
	{
		CustomerScoringAttributesCRUDPage moduleHandlerObj = new CustomerScoringAttributesCRUDPage(driver);
		moduleHandlerObj.deleteData();
	}
	@Test(dependsOnMethods= {"checkDeleteTestCase"})
	public void checkFilterArea() throws InterruptedException {
		CustomerScoringAttributesCRUDPage moduleHandlerObj = new CustomerScoringAttributesCRUDPage(driver);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);	
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		CustomerScoringAttributesCRUDPage moduleHandlerObj = new CustomerScoringAttributesCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
