package practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Depend;
import pageObjects.HomePage;
import pageObjects.Preference;

public class HomeTest extends Base {

	
		@Test
		public void ApiDemo() throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver<AndroidElement>driver=capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage h = new HomePage(driver);
		h.preference.click();
		
		Preference p =new Preference(driver);
		p.dependencies.click();
		Depend d =new Depend(driver);
		d.wifiCheck.click();
		d.wifiSetting.click();
		d.editBox.sendKeys("testhybrid");
		d.okBtn.click();
		System.out.println("test git");
		service.stop();

	}

}
