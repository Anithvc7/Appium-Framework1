package AppiumLearning.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AppiumLearning.utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidAction {
AndroidDriver driver;


 

//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();




	public ProductCatalogue (AndroidDriver driver) {
	    super(driver);
		this.driver=driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	 private List<WebElement> addToCart;
	 
	 
	 @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	 private WebElement cartIcon;
	 
	 
	//driver.findElement(By.id()).click();
	
      public void addItemToCartByIndex(int index) 
     {
    	  addToCart.get(index).click();
    }
	
	public CartPage clickCartIcon() throws InterruptedException 
	{
		cartIcon.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
}
