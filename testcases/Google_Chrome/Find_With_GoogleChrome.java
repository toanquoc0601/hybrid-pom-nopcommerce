package Google_Chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Find_With_GoogleChrome {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	WebElement element;
	public String valueFind = "Demo with selenium";
	public String searchElement = "//input[@title='Tìm kiếm']";
	@BeforeClass
	public void beforeClass() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_Find_And_Verify_Google_With_Submit() {
		//submit
		driver.get("https://www.google.com.vn/");
		
		waitToElementVisuble(driver, searchElement);
		
		highlightElement(driver, searchElement);
		
		driver.findElement(By.xpath(searchElement)).sendKeys("Demo with selenium");
		
		driver.findElement(By.xpath(searchElement)).submit();
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@role='combobox']")).getAttribute("value"), "Demo with selenium");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitToElementVisuble(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
}
