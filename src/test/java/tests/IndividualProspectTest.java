package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.IndividualProspectPage;
import Pages.LoginPage;
import TestData.JsonDataReader;

public class IndividualProspectTest extends TestBase {
	
	String IndividualProspectModule = "frame_150027331";
	String IndividualcustomersModule = "frame_15002711";
	String jsonFilePath = "/src/test/java/TestData/CustomerData.json";
	String [] jkeys = {"Gender", "Employement","Birth Date","Salary","Finance Amount"};
	String [] testCaseInputs =  {"Gender", "Employement","Birth Date","Salary","Finance Amount"};
	
	
	@Test (priority = 1)
	public void addNewIndividualProspect_Case1() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "M_4_smaller than 60 Salary >=1000 FinanceAmount 3000" , jkeys, testCaseInputs);
		IndividualProspectPage individualProdspectObj = new IndividualProspectPage(driver);
		individualProdspectObj.OpenIndividualProspect(IndividualProspectModule, IndividualcustomersModule);
		individualProdspectObj.EditIndividualCustomerData(jData);
	}

}
