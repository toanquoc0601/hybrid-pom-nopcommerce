package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class AbstractTest {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome_ui")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
//			ChromeOptions option = new ChromeOptions();
//			option.setExperimentalOption("useAutomationExtention", false);
//			option.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.setHeadless(true);
			driver = new FirefoxDriver(option);
		} else if (browserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(option);
		}else if(browserName.equals("edge_chromium")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please input valid browser name value!");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
