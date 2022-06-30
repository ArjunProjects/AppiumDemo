package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AndroidDriver<AndroidElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("test");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	//driver.findElement(By.xpath("//*[@text='Female']")).click();
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleField;
	//driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement countryDropDown;
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))");
	//driver.findElement(By.xpath("//*[@text='Angola']")).click();
	@AndroidFindBy(xpath="//*[@text='Angola']")
	public WebElement countrySelection;
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopBtn;

}
