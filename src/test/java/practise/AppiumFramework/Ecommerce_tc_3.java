package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;

public class Ecommerce_tc_3 extends Base{

	
		// TODO Auto-generated method stub
		@Test
		public void e2eValidation() throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver<AndroidElement>driver=capabilities("GeneralStoreApk");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FormPage f=new FormPage(driver);
		f.nameField.sendKeys("TestApp");
		driver.hideKeyboard();
		f.femaleField.click();
		f.countryDropDown.click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))");
		Helper h=new Helper(driver);
		h.scrollToText("Angola");
		f.countrySelection.click();
		f.shopBtn.click();
		
		ProductsPage p=new ProductsPage(driver);
		p.itemOneToClick.click();
		p.itemTwoToClick.click();
		p.cartBtn.click();
		Thread.sleep(3000);	
		CheckOutPage c=new CheckOutPage(driver);
		int count=c.productList.size();
		double sum=0;
		for(int i=0;i<count;i++) {
			String amount1=c.productList.get(i).getText();
			double pAmount1=getSum(amount1);
			sum=sum+pAmount1;

		}

		System.out.println(sum);
		String finalAmount=c.totalPurchaseAmount.getText();
		double fAmount=getSum(finalAmount);

		System.out.println(fAmount);
		Assert.assertEquals(sum,fAmount);
		System.out.println("happy testing!!!!!!!!!!");
		
		System.out.println("sample test1");
		System.out.println("sample test1");
		service.stop();
		
		
		
	}

		@BeforeTest
		public void killAllNodes() throws IOException {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");	
		}
	
	public static double getSum(String value) {
		value=value.substring(1);
		double pAmount1=Double.parseDouble(value);
		return pAmount1;

	}

}
