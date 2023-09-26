package AppiumLearning.pageObjects.ios;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import AppiumLearning.utils.AppiumUtilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IOSAction extends AppiumUtilities{
	AndroidDriver driver;
	
	public  IOSAction(AndroidDriver driver) 
	{
		super(driver);
		this.driver=driver;	
		
	}
	
	public void scrollToWebElement(WebElement ele)
	{
		HashMap<String, String> scrollObject = new HashMap<>();
		JavascriptExecutor js = driver; 
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement)ele).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}

	public void longPressActionIos(WebElement ele) {
		Map <String,Object>params = new HashMap<>();
	    params.put("elements", ((RemoteWebElement)ele).getId());
	    params.put("duration", 5);
			
	    driver.executeScript("mobile:touchAndHold", params);
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
