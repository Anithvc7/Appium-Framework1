package AppiumLearning;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AppiumLearning.utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.service.local.AppiumServiceBuilder;

import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class startAppium   {
	AppiumDriverLocalService server;
	AndroidDriver driver ;
	


@Test
	
	//@BeforeClass

	public void startAppium12() throws MalformedURLException

	{



	HashMap<String, String> environment = new HashMap();

	     environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));



	     AppiumServiceBuilder builder = new AppiumServiceBuilder();

	     builder

	             .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))

	             .usingDriverExecutable(new File("/usr/local/bin/node"))

	             .usingPort(4723)

	             .withEnvironment(environment)

	             .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)

	             .withLogFile(new File("AppiumLog.txt"));



	     server = AppiumDriverLocalService.buildService(builder);

	     

	     System.out.println("Server started at :"+server.getUrl());

	   

	server.start();
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName ("Demo2");
	options.setChromedriverExecutable("//Users//apple//Downloads//Chrome driver//chromedriver");
	options.setApp("//Users//apple//eclipse-workspace//appiumlearning//appium//src//test//java//Resources//General-Store.apk");
    driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"), options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 

	System.out.println("Server is Started.");

	}



	@AfterTest

	public void tearDown() {

	server.stop();

	System.out.println("Service stopped.");

	}



	}


