package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc_4 extends Base{

	
		// TODO Auto-generated method stub
		@Test
		public void e2eValidation() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApk");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("test");
		driver.hideKeyboard();
		//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))");
		//driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.xpath("//*[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);	
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum=0;
		for(int i=0;i<count;i++) {
			String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			double pAmount1=getSum(amount1);
			sum=sum+pAmount1;

		}

		System.out.println(sum);
		String finalAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double fAmount=getSum(finalAmount);

		System.out.println(fAmount);
		Assert.assertEquals(sum,fAmount);

		
	}


	
	public static double getSum(String value) {
		value=value.substring(1);
		double pAmount1=Double.parseDouble(value);
		return pAmount1;

	}

}
