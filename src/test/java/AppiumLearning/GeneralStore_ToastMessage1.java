package AppiumLearning;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;


public class GeneralStore_ToastMessage1 extends AndroidBaseTest {
	
@Test
	@BeforeMethod
	public void preSetup()
{
Activity activity = new Activity ("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
			
	}

public void GeneralStore_ToastMessagetest() throws InterruptedException
{
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anith vc");
	//driver.hideKeyboard();
	driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); 
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); //tagName[@attribute='value'] -- xpath  ==> (//tagName) -- only 
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    Thread.sleep(3000);
  String toastMessage =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"); // here we cant use getText methord --
  Assert.assertEquals(toastMessage, "Please enter your name");
  
	
}
	@Test
public void GeneralStore_Positive() throws InterruptedException
{
	
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anith vc");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); 
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); //tagName[@attribute='value'] -- xpath  ==> (//tagName) -- only 
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    Thread.sleep(3000);
    Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
  
    
	
	
}
	
	
	
}
