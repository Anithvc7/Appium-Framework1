package AppiumLearning.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AppiumLearning.utils.AndroidAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class FormPage extends AndroidAction {
	AndroidDriver driver;
	
	public FormPage (AndroidDriver driver) {
	    super(driver);
		this.driver=driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	 
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	private WebElement nameField; 
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']") 
	private WebElement FemaleOption;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']") 
	private WebElement MaleOption;

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART'])[1]")
	private WebElement AddToCart;
	
	
	
	
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	 public void setGenter(String genter)
	 {
		 if (genter.contains("Female"))
			 FemaleOption.click();
		 else
			 MaleOption.click();
	 }
	
	 
	 public void selectCountrySelection(String countryName) 
	 {
		
		 countrySelection.click();
		 scrollToText(countryName);
		 driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		 
	 }
	 
	 public void letsShopSelection() throws InterruptedException 
	 {
		 letsShop.click();
		 Thread.sleep(3000);
	 }
	 public void addToCartSelection() 
	 {
		 AddToCart.click();
	 }
	

}
