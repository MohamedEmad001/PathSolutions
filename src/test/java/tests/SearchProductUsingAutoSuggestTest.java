package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ResultItemPage;
import Pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase

{
	
	String productinput = "Apple MacBook Pro 13-inch";
	
	@Test
	public void CheckAutoComplete() throws InterruptedException
	{
		SearchPage searchPageObj = new SearchPage(driver);
		searchPageObj.searchUsingAutoSuggesst("mac");
		ResultItemPage resultItemObj = new ResultItemPage(driver);
		Assert.assertTrue(resultItemObj.resultTitle.getText().equalsIgnoreCase(productinput));
	}
	
	
	

}
