package AppiumLearning.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAction extends AppiumUtilities{
	AndroidDriver driver;
	
	public  AndroidAction(AndroidDriver driver) 
	{
	    super(driver);
		this.driver=driver;	
		
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		}
		
		
		public void scrollToEndAction()
		{
			boolean canScrollMore;
			do
			{
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
			}while(canScrollMore);
		}
		
		public void scrollToElement(String ele) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"ele\"));"));
		}
		
		
		public void swipeAction (WebElement ele,String direction)
		{
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
					   "elementId",((RemoteWebElement)ele).getId(),
					    "direction", direction,
					    "percent", 0.75
					));
		}
		
		
		
		
}
