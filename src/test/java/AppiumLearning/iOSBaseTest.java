package AppiumLearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest {
	public IOSDriver driver ;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	
	{
		
		
		        service = new AppiumServiceBuilder ().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
			   //.usingDriverExecutable(new File("/usr/local/lib/node_modules")
			   .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(60)).build();
		        service.start();
		     XCUITestOptions options = new XCUITestOptions();
		     options.setDeviceName("iPhone 14 Pro");
		     options.setApp("/Users/apple/Downloads/IOS Apps/ios-uicatalog/UIKitCatalog.app");
		     options.setPlatformVersion("16.4");
		     options.setWdaLaunchTimeout(Duration.ofSeconds(20));  
				 
		     driver = new IOSDriver(new URL ("http://127.0.0.1:4723"), options);
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
	
	}
	
	
	
	@AfterClass
	public void TearDown()
	{
		
				driver.quit();
			
		    	service.stop();	 
	
	}
}
