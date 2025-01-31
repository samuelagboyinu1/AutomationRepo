package ecom.qa.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ecom.qa.base.BasePage;

public class SearchPage extends BasePage{
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	private static final By searchBox = By.id("search-bar-input");
    private static final By searchButton = By.xpath("//button[@type='submit']");
    private static final By productNames = By.xpath("//a[contains(text(),'Broccoli')]");
    private static final By addToCartButtons = By.xpath("//button[@data-testid='add-button']");

    public static void search(String item) {
        enterText(searchBox, item);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        click(searchButton);
        try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public static void addFirstTwoBroccolisToCart() {
        List<WebElement> products = getElements(productNames);
        List<WebElement> addButtons = getElements(addToCartButtons);

        // Sorting broccoli alphabetically and selecting the first two
        List<String> sortedBroccoli = products.stream()
            .map(WebElement::getText)
            .sorted()
            .collect(Collectors.toList());

        for (int i = 0; i < 2; i++) {
            addButtons.get(i).click();
            
           js.executeScript("window.scrollBy(0,350)", "");
        }
    }

}
