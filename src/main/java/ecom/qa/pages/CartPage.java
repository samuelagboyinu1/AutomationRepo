package ecom.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ecom.qa.base.BasePage;

public class CartPage extends BasePage{
	    private static final By basketButton = By.xpath("//button[@data-testid='header-trolley']");
	    private static final By bookASlot = By.cssSelector("button[type='button']");
	    private static final By itemCount = By.xpath("//*[@id='main']/div[2]/div[1]/section/div/ul/li");
	    static JavascriptExecutor js = (JavascriptExecutor) driver;

	    public static void viewBasket() {
	      click(basketButton);
	    }
	    
	    public static void verifyItemsInBasket() {
	    List<WebElement> count =	BasePage.getElements(itemCount);
	    if(count.size() ==2) {
	    	Assert.assertTrue(true);
	    }
	        
	 }

        public static void proceedToCheckout() {
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				   e.printStackTrace();
			}
	        click(bookASlot);
	        
	    }             
}
