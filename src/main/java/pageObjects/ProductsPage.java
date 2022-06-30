package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

	public ProductsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public WebElement itemOneToClick;
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public WebElement itemTwoToClick;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartBtn;
	
}
