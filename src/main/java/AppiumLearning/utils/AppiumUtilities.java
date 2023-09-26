package AppiumLearning.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtilities {
	
	
AppiumDriver driver;
	
	public  AppiumUtilities(AppiumDriver driver) 
	
	{
	 
		this.driver=driver;	
		
	}
	
public Double getFormattedAmount(String amount) {
		
		Double displayPrices= Double.parseDouble(amount.substring(1));
		return displayPrices;
	}

public void waitForElementToAppear(WebElement ele) throws InterruptedException
{
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); // this is introduced to wait till the next page open as the element id are same 
wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
Thread.sleep(3000);
}
}

