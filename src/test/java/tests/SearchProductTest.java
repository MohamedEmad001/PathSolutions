package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ResultItemPage;
import Pages.SearchPage;
import Pages.SearchResultsPage;

public class SearchProductTest extends TestBase
{

	HomePage homepage;
	SearchPage searchPageObject;
	String productinput = "Apple MacBook Pro 13-inch";

	@Test
	public void CheckSearchProductTest()
	{
	
		searchPageObject = new SearchPage(driver);
		searchPageObject.ProdcutSearch(productinput);
		SearchResultsPage SearchResultobj = new SearchResultsPage(driver);
		ResultItemPage resultItemObj = new ResultItemPage(driver);
		SearchResultobj.SelectSearchResultItem();
		Assert.assertTrue(resultItemObj.resultTitle.getText().equalsIgnoreCase(productinput));
	}


}
