package OpenWT;

import java.util.List;
import java.util.Random;
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
	ChromeDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	WebElement element;
	String user = "thanh+strawpoll@novahub.vn";
	String password = "111111asdfgh";
	
	String Option1 = "Van A";
	String Option2 = "Van B";
	String Option3 = "Van C";
	String Option4 = "Van D";
	String TestTiltle = generateTest();
	
	@BeforeClass
	public void beforeClass() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Loggin_Page() {
		driver.get("https://strawpoll.com/account/");
		getElement(driver, "//input[@id='email']").sendKeys(user);
		getElement(driver, "//input[@id='password']").sendKeys(password);
		getElement(driver, "//button[@type='submit']").click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(), "https://strawpoll.com/account/");
	}
	@Test
	public void TC_02_Create_Poll_With_4_Option() {
		getElement(driver, "//a[contains(text(),'Create Poll')]").click();
		Assert.assertTrue(getElement(driver, "//h1[contains(text(),'Create a Poll')]").isDisplayed());
		getElement(driver, "//span[contains(text(),'Add option')]").click();
		sleepInSecond(1);
		getElement(driver, "//span[contains(text(),'Add option')]").click();
		Assert.assertEquals(driver.findElements(By.xpath("//div[@id='poll_options']//div")).size(), 4);
		
		getElement(driver, "//input[@id='title']").sendKeys(TestTiltle);
		getElement(driver, "//input[@id='option-0']").sendKeys(Option1);
		getElement(driver, "//input[@id='option-1']").sendKeys(Option2);
		getElement(driver, "//input[@id='option-2']").sendKeys(Option3);
		getElement(driver, "//input[@id='option-3']").sendKeys(Option4);
		
		getElement(driver, "//span[contains(text(),'Create poll')]").click();
		Assert.assertEquals(getElement(driver, "//h1[contains(text(),'"+TestTiltle+"')]").getText(), TestTiltle);
		
	}
	@Test
	public void TC_03_Voting_restrictions() {
		getElement(driver, "//span[contains(text(),'Van A')]//preceding::input[@type='radio']").click();
		Assert.assertTrue(getElement(driver, "//span[contains(text(),'Van A')]//preceding::input[@type='radio']").isSelected());
		getElement(driver, "//span[text()='Vote']").click();
	} 
	@Test
	public void TC_04_Check_Poll() {
		driver.get("https://strawpoll.com/account/");
		Assert.assertEquals(getElement(driver,"//span[contains(text(),'"+TestTiltle+"')]").getText(), TestTiltle);
		
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
	public String generateTest() {
		Random random = new Random();
		return "Test" + random.nextInt(9999);
	}

}
