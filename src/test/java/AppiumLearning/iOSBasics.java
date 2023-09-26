package AppiumLearning;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSBasics extends iOSBaseTest {
	
	@Test
	public void iOSBasicsTest()
	{
	
		
		//x-path, classname ,ios, iosclasschain, iospredicatestring , accessibility id , id
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//driver.findElement(AppiumBy.accessibilityId("Text Entry")).click(); -- accessibility id 
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]")).click(); -- by xpath
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();  //-- by iosclasschain
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		//driver.findElement(AppiumBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND value =='Confirm / Cancel'")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm' ")).click();
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel' ")).click();
		String text=driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'A message'")).getText();
		System.out.println(text);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label =='Confirm'")).click();
		
		
		
		
		
		
	}
	
	
	

}
