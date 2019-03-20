package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestData.JsonDataReader;

public class LoginTest extends TestBase {

	//String UserName = "administrator";
	//String UserPass = "admin12";
	
	
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		jsonFileReader.JsonReaderData();
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jsonFileReader.UserName, jsonFileReader.UserPass);

	}

}
