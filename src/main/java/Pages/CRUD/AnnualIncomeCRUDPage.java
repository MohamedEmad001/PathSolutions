package Pages.CRUD;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;
import TestData.JsonDataReader;


public class AnnualIncomeCRUDPage extends PageBase {

	public AnnualIncomeCRUDPage(WebDriver driver1) {
		super(driver1);
		driver11 = driver1;
	}

	WebDriver driver11;
	public CRUDMainPage CRUDMainObject;

	@FindBy(xpath= "//*[@id=\"V0SaveButton\"]")public static WebElement master_SaveButton;
	
	
	@FindBy(id="INR_ARABIC_DESCRIPTION") WebElement OtherDescriptionNameTxt;
	@FindBy(id="V0DeleteButton") WebElement deleteBtn;

	//Retrieve All and Paging
	@FindBy(xpath="//*[@id=\"V0ResetButton\"]") WebElement retrieveAllBtn;
	@FindBy(id="V0Pagination__NextPage") WebElement nextPageBtn;
	@FindBy(id="V0Pagination__PreviousPage") WebElement previousPageBtn;
	@FindBy(id="V0Pagination__LastPage") WebElement lastPageBtn;
	@FindBy(id="V0Pagination__FirstPage") WebElement firstPageBtn;
	
	//Filter Area
	@FindBy(css="#FilterAreaContainer > input[type=image]") WebElement filterAreaBtn;
	
	//@FindBy(id="parentModuleID18") WebElement filterAreaFrame;
	@FindBy (css="#filtergrid > div.k-pager-wrap.k-grid-pager.k-widget > a.k-link.k-pager-nav.k-pager-last > span")
	WebElement goToLastPageBtn;
	@FindBy (css="#filtergrid > div.k-grid-content > table > tbody > tr:nth-child(1)")
	WebElement selectRowBtn;
	@FindBy (id="filterBtn") WebElement filterBtn;
	
	

	//Start Point
	public void FillModuleFields(String moduleID,String ParentframeID)
			throws InterruptedException, FileNotFoundException, IOException, ParseException 

	{
		CRUDMainObject = new CRUDMainPage(driver1);
		//1- Navigate To Module
		CRUDMainObject.NavigateToModuleWebPage(moduleID, ParentframeID);

		//2- Read Fields and Values from Json file
		JSONArray jsonObjects = JsonDataReader.ReadFromJsonSector(moduleID);

		//3- Add modules values to fields
		Boolean dataAdded = false;
		for (int i = 0; i < jsonObjects.size(); i++) {
			dataAdded = CRUDMainObject.AddModuleFieldsValues(moduleID, jsonObjects, i);
		}

		//4- Save module when dataAdded;
		if (dataAdded) {
			//JavascriptExecutor jse = (JavascriptExecutor) driver1;
			//jse.executeScript("document.getElementById('V1SaveButton').focus();");

			Thread.sleep(2000);
			master_SaveButton.click();
			Thread.sleep(5000);
			
		}
	}
	//5-Update 
	public void updateData(String updateNameValue) throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.updateData(OtherDescriptionNameTxt, updateNameValue);
		master_SaveButton.click();
		Thread.sleep(5000);
	}
	//6- Delete 
	public void deleteData() throws InterruptedException
	{
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.deleteData(deleteBtn);
	}
	//7- Open filter area and filter by any record
	public void filterByRecords(String filterAreaFrame,String ParentframeID)
			throws InterruptedException {
	
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.filterByRecords(filterAreaBtn, filterAreaFrame, goToLastPageBtn, 
				selectRowBtn, filterBtn, ParentframeID);
	}
	
	// 8- Retrieve All and Paging
	public void retrieveAllAndPaging() throws InterruptedException {
		
		CRUDMainObject = new CRUDMainPage(driver1);
		CRUDMainObject.retrieveAllAndPaging(retrieveAllBtn, nextPageBtn, previousPageBtn, lastPageBtn, firstPageBtn);
	}
}