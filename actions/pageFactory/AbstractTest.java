package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver;

	public WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox_ui")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome_ui")) {
			WebDriverManager.chromedriver().setup();			
//			ChromeOptions option = new ChromeOptions();
//			option.setExperimentalOption("useAutomationExtention", false);
//			option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox_headless")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.setHeadless(true);
			driver = new FirefoxDriver(option);
		} else if (browserName.equals("chrome_headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(option);
		}else if(browserName.equals("edge_chromium")) {
//			WebDriverManager.edgedriver().setup();
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
