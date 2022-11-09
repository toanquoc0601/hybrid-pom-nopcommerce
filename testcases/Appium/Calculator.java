package Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Calculator {
	WebDriver driver;
	@Test
	public void AppiumFirstTestCase() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("deviceName", "");
		cap.setCapability("appPackage", "");
		cap.setCapability("appActivity", "");
		driver = new AndroidDriver(new URL(""), cap);
	}
 
	
	
}
