package AppiumLearning.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AppiumLearning.utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidAction {
	
	
AndroidDriver driver;
	
	public CartPage (AndroidDriver driver) {
	    super(driver);
		this.driver=driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List <WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	
	
	
	
	
	public List<WebElement> getProductList() {
		return productList;
	}
	
	public double getProductSum()
	{
		int count =productList.size();
		double sum =0;
		for(int i = 0; i < count ; i++)
		{
			
			String amountString =productList.get(i).getText();			
			
			Double price =Double.parseDouble(amountString.substring(1));// --TO REMOVE THE $ FROM PRICE
			
			sum = sum + price ;
			
			
		}
		return sum;
	}
	
	//public double getTotalAmoundDisplay() 
	
	{
		//return getFormattedAmount(totalAmount.getText());
		
	}
	
}
