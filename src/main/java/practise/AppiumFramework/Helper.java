package practise.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Helper {
	
	AndroidDriver<AndroidElement> driver;
	
	public Helper(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
	}

}
