package AppiumLearning.pageObjects.ios;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage extends IOSAction{
	
IOSDriver driver;
	
	public Homepage (AndroidDriver driver) {
	    super(driver);
	//	this.driver=driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	
	

}
