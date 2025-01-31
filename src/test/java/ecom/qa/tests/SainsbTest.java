package ecom.qa.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecom.qa.base.BaseTest;
import ecom.qa.pages.CartPage;
import ecom.qa.pages.EmptyTrolley;
import ecom.qa.pages.LoginPage;
import ecom.qa.pages.SearchPage;
import ecom.qa.utils.JsonReader;

public class SainsbTest extends BaseTest{
	 @Test
	    public void testTescoShopping() {
	        JSONObject data = JsonReader.readJson("src/test/resources/testdata.json");

	        LoginPage.login();
	        SearchPage.search(data.get("searchTerm").toString());
	        SearchPage.addFirstTwoBroccolisToCart();
	        CartPage.viewBasket();
	        CartPage.verifyItemsInBasket();
	        CartPage.proceedToCheckout();
	        EmptyTrolley.emptyTrolley();	
	        
	    }

}
