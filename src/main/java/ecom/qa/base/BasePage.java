package ecom.qa.base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
	
	protected static WebDriver driver;
	 public static void DriverSet(WebDriver webdriver){
		 if(driver==null){
			 driver = webdriver;
			 
		 } 
	    }
	 public static WebDriver getDriver() {
		 if(driver==null) {
			 throw new IllegalStateException("driver is not initialized");
			 
			 
		 }
		 return driver;
	 }
	 
	 private static boolean waitForElementVisibility(By locator) {
	        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
	        for (int i = 0; i < 10; i++) {
	            try {
	                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	                if (element.isDisplayed()) return true;
	            } catch (Exception e) {
	                
	            }
	            sleep(1000); // Wait 1 second before retry
	        }
	        return false;
	    }

	    // Helper to sleep for a specific amount of time (in ms)
	    private static void sleep(long milliseconds) {
	        try { Thread.sleep(milliseconds); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	    }
	    
	    public static WebElement getElement(By locator) {
	        if (waitForElementVisibility(locator)) {
	            return getDriver().findElement(locator);
	        }
	        throw new NoSuchElementException("Element not visible: " + locator);
	    }

	    // Get list of elements by locator
	    public static List<WebElement> getElements(By locator) {
	        if (waitForElementVisibility(locator)) {
	            return getDriver().findElements(locator);
	        }
	        return List.of(); // Return empty list if element is not found
	    }

    public static void click(By locator) {
        getElement(locator).click();
    }

    public static void enterText(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }
    
    public static int getElementCount(By locator) {
    	return getElements(locator).size();
    }
}
