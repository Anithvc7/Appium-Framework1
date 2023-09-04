package AppiumLearning;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import AppiumLearning.pageObjects.android.CartPage;
import AppiumLearning.pageObjects.android.FormPage;
import AppiumLearning.pageObjects.android.ProductCatalogue;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;

@Test
public class GeneralStoreTestcase4_hybrid extends BaseTest {

public void GeneralStoreTestcase3test() throws InterruptedException
{
	FormPage formPage = new FormPage (driver);
     formPage.setNameField("Anith vc");
     formPage.setGenter("Female");
     formPage.selectCountrySelection("Argentina");
     ProductCatalogue productCatalogue = formPage.letsShopSelection();
	 //or we can create object like below
    // ProductCatalogue productCatalogue = new ProductCatalogue(driver);
     productCatalogue.addItemToCartByIndex(0);
     productCatalogue.addItemToCartByIndex(0);
     CartPage cartPage = productCatalogue.clickCartIcon();
	
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); // this is introduced to wait till the next page open as the element id are same 
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		Thread.sleep(3000);
	//int productCount =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size(); -- changing this to easy way 
		
		List<WebElement> productPrice =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count =productPrice.size();
		double sum =0;
		for(int i = 0; i < count ; i++)
		{
			
			String amountString =productPrice.get(i).getText();			
			
			Double price =Double.parseDouble(amountString.substring(1));// --TO REMOVE THE $ FROM PRICE
			
			sum = sum + price ;
			
			
		}
		
		
		String displayPrice= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	Double displayPrices= Double.parseDouble(displayPrice.substring(1));
		Assert.assertEquals(sum, displayPrices);
		Thread.sleep(3000);
	WebElement checkBox=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)checkBox).getId(),"duration",2000));
		Thread.sleep(2000);
		String cancelButton =driver.findElement(By.id("android:id/button1")).getText();
		Assert.assertEquals(cancelButton, "CLOSE");
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		String purchase =driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).getText();
		Assert.assertEquals(purchase, "Visit to the website to complete purchase");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		// hybrid 
		
		//driver.getContextHandles();
		//driver.context("");   // context name may be diffrernt -- these can be used if we get the context name
		
		//can also get context name by appium -- using the bellow "system printin "
		//advance for-loop methord 
		
		Set<String> contexts =driver.getContextHandles();
		for (String contextName :contexts)
		{
			System.out.println(contextName);
		
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Anith vc");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
}
	
	
	
	
	
	
	
}
