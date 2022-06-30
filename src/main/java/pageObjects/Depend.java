package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Depend {
	
	public Depend(AndroidDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="android:id/checkbox")
	public WebElement wifiCheck;
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement wifiSetting;
	@AndroidFindBy(id="android:id/edit")
	public WebElement editBox;
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement okBtn;
}
