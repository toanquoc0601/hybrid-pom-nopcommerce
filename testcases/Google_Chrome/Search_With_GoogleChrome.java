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

public class Search_With_GoogleChrome {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	WebElement element;
	public String valueSearch = "Demo with selenium";
	public String searchTextbox = "//input[@title='Tìm kiếm']";

	@BeforeClass
	public void beforeClass() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Search_And_Verify_Google_With_Submit() {

		driver.get("https://www.google.com.vn/");

		waitToElementVisuble(driver, searchTextbox);

		highlightElement(driver, searchTextbox);

		getElement(driver, searchTextbox).sendKeys(valueSearch);

		getElement(driver, searchTextbox).submit();

		Assert.assertEquals(getElement(driver, "//input[@role='combobox']").getAttribute("value"), valueSearch);
		
		Assert.assertTrue(getElement(driver, "//div[@id='search']//h3[text()= '" + valueSearch + "']").isDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
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
