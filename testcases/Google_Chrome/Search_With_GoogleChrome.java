package Google_Chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageFactory.AbstracPage;

public class Search_With_GoogleChrome extends AbstractPage{
	ChromeDriver driver;
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
		
		driver.get("https://789d.club/");
		waitToElementVisuble(driver, "//input[@id='username']");
		sendkeyToElement(driver, "//input[@id='username']", "kakute02");
		waitToElementVisuble(driver, "//div[@id='login']//input[@name='password']");
		sendkeyToElement(driver, "//div[@id='login']//input[@name='password']", "quoc782442");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).submit();
		

		WebElement canvasElement = driver.findElement(By.id(""));
		//Select the Pencil Tool
		Select toolDraw = new Select(driver.findElement(By.id("")));
		toolDraw.selectByValue("");
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvasElement).moveByOffset(10, 50).
		moveByOffset(50,10).
		moveByOffset(-10,-50).
		moveByOffset(-50,-10).release().perform();
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
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
