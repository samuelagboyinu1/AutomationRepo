package ecom.qa.pages;

import org.openqa.selenium.By;

import ecom.qa.base.BasePage;

public class EmptyTrolley extends BasePage{
	private static final By basketButton = By.xpath("//button[@data-testid='header-trolley']");
	private static final By acceptEmptyTrolleyButton = By.xpath("//button[@data-testid='modal-primary-button']");
	
	public static void emptyTrolley() {
		click(basketButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click(emptyTrolleyButton);
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/button")).click();
		click(acceptEmptyTrolleyButton);
	}

}
