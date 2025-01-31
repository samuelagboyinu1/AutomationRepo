package ecom.qa.pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

import ecom.qa.base.BasePage;
import ecom.qa.utils.JsonReader;

public class LoginPage extends BasePage{
	    private static final By usernameField = By.id("username");
	    private static final By passwordField = By.id("password");
	    private static final By loginRegisterButton = By.linkText("Log in / Register");
	    private static final By cookiesAccept = By.id("onetrust-accept-btn-handler");
	    private static final By login = By.xpath("//button[@type='submit']");
	 
	    public static void login() {
	        JSONObject data = JsonReader.readJson("src/test/resources/testdata.json");        
	        click(cookiesAccept);
	        click(loginRegisterButton);
	        click(cookiesAccept);
	        enterText(usernameField, data.get("username").toString());
	        enterText(passwordField, data.get("password").toString());
	        click(login);
	      String pageTitle=  driver.getTitle();
	      System.out.println("page title is :"+ pageTitle);
	      Assert.assertEquals(pageTitle, "Sainsbury's online Grocery Shopping and Fresh Food Delivery");
	    }
}
