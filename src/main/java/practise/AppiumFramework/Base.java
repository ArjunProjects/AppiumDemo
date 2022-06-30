package practise.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer() {
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag) {
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e) {
			isServerRunning=true;
		}finally {
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		Properties p =new Properties();
		p.load(fs);
		File appDir = new File(System.getProperty("user.dir"));
		File app = new File(appDir,(String) p.get(appName));
		//"General-Store.apk"
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String deviceName=(String) p.get("device");
		startEmulator();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("newCommandTimeout", 60 * 10);
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		AndroidDriver <AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	
//	public static void getScreen(String s) throws IOException {
////		 AndroidDriver<AndroidElement> driver = null;
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+s+".png"));
//		
//	}

}
