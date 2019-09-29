package tests.CRUDTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CRUD.INDIVIDUALFINANCIERSCRUDPage;
import TestData.JsonDataReader;
import tests.TestBase;

@Test(groups = {"CustomerTitlesCRUDTest"})
public class INDIVIDUALFINANCIERSCRUDTest extends TestBase {

	String jsonFilePath = "/src/test/java/TestData/Login.json";
	String jsonFilePath2= "/src/test/java/TestData/Login.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};

	String moduleID = "15002731";
	String ParentframeID="frame_15002731";
	String filterAreaFrame="parentModuleID15002731";


	//Filling Data
	
	String FirstValue = "AAaUpdateTT";

	//Updating data
	String updateNameValue= "Customers CRUD Update";

	@Test (priority = 0)
	public void CheckLogin() 
			throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);

	}

	
	@Test(dependsOnMethods= {"CheckLogin"})
	public void checkFilterArea() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		INDIVIDUALFINANCIERSCRUDPage moduleHandlerObj = new INDIVIDUALFINANCIERSCRUDPage(driver);
		moduleHandlerObj.FillModuleFields(moduleID, ParentframeID);
		moduleHandlerObj.fillDataToGrid(FirstValue);
		moduleHandlerObj.filterByRecords(filterAreaFrame, ParentframeID);
				
	}

	@Test(dependsOnMethods= {"checkFilterArea"})
	public void checkRetrieveAllAndPaging() throws InterruptedException {
		INDIVIDUALFINANCIERSCRUDPage moduleHandlerObj = new INDIVIDUALFINANCIERSCRUDPage(driver);
		moduleHandlerObj.retrieveAllAndPaging();	
	}


}
