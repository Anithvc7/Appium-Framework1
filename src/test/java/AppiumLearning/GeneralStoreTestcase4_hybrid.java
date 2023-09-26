package AppiumLearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Test
public class GeneralStoreTestcase4_hybrid extends AndroidBaseTest {

public void GeneralStoreTestcase3test() throws InterruptedException, MalformedURLException
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
   double sum=  cartPage.getProductSum();
      
      double displayPrices= cartPage.getTotalAmoundDisplay();
      Assert.assertEquals(sum, displayPrices);
		Thread.sleep(3000);
		cartPage.acceptTermsConditions();
       String cancelButton = cartPage.acceptButtonClick();
       Assert.assertEquals(cancelButton, "CLOSE");
       cartPage.acceptButtonTwo();
		cartPage.checkBoxClick();
	   String purchase= cartPage.proceedBtn();
	   Assert.assertEquals(purchase, "Visit to the website to complete purchase");
        cartPage.proceedClick();
		
		
		
		
		
}
	
	
	
	
	
	
	
}
