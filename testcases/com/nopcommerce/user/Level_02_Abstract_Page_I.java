package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_Abstract_Page_I extends AbstractPage{
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	Select select;
	
	public String firstName = "Toan", 
			lastName = "Quoc", 
			dateOfBirthDay = "6", 
			dateOfBirthMonth = "January", 
			dateOfBirthYear =  "1996", 
			email = generateEmail(),
			companyName = "Company", 
			Password = "123123";

	@BeforeClass
	public void beforeClass() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
	}

	@Test
	public void Register_Login_Verify_() {
		clickToElement(driver, "//a[@class=\"ico-register\"]");
		clickToElement(driver, "(//input[@type=\"radio\"])[1]");
		
		senkeyToElement(driver, "//input[@name=\"FirstName\"]", firstName);
		senkeyToElement(driver, "//input[@name=\"LastName\"]", lastName);
		
		selectItemInDropDown(driver, "//select[@name='DateOfBirthDay']" , dateOfBirthDay);
		selectItemInDropDown(driver, "//select[@name='DateOfBirthMonth']",dateOfBirthMonth);	
		selectItemInDropDown(driver, "//select[@name='DateOfBirthYear']",dateOfBirthYear);
		
		senkeyToElement(driver, "//input[@name=\"Email\"]", email);
		senkeyToElement(driver, "//input[@name=\"Company\"]", companyName);
		senkeyToElement(driver, "//input[@name=\"Password\"]", Password);
		senkeyToElement(driver, "//input[@name=\"ConfirmPassword\"]", Password);
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//a[@class='ico-logout']");
		
		clickToElement(driver, "//a[@class='ico-login']");
		
		senkeyToElement(driver, "//input[@id='Email']", email);
		senkeyToElement(driver, "//input[@id='Password']", Password);

		clickToElement(driver, "//button[contains(text(),'Log in')]");
		
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
		
		clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthDay']"), dateOfBirthDay);
		Assert.assertEquals(getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"), dateOfBirthMonth);
		Assert.assertEquals(getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthYear']"), dateOfBirthYear);

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@name='Company']", "value"), companyName);
		
		driver.findElement(By.xpath("//button[@id='save-info-button']")).click();
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		
	
	}
	
	public String generateEmail() {
		Random random = new Random();
		return "toanquoc" + random.nextInt(9999) + "@gmail.com";
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public WebElement elemetLocator(String Locator) {
		try { 
			driver.findElement(By.xpath(Locator));
		}catch (Exception e) {
			System.out.println(e);
		}
		return driver.findElement(By.xpath(Locator));
	}
	
	@AfterClass//(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
