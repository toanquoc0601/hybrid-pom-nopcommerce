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

public class Level_02_Abstract_Page_2 {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	Select select;
	AbstractPage abtractPage;
	
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
		abtractPage = new AbstractPage();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
	}

	@Test
	public void Register_Login_Verify_() {
		abtractPage.clickToElement(driver, "//a[@class=\"ico-register\"]");
		abtractPage.clickToElement(driver, "(//input[@type=\"radio\"])[1]");
		
		abtractPage.sendkeyToElement(driver, "//input[@name=\"FirstName\"]", firstName);
		abtractPage.sendkeyToElement(driver, "//input[@name=\"LastName\"]", lastName);
		
		abtractPage.selectItemInDropDown(driver, "//select[@name='DateOfBirthDay']" , dateOfBirthDay);
		abtractPage.selectItemInDropDown(driver, "//select[@name='DateOfBirthMonth']",dateOfBirthMonth);	
		abtractPage.selectItemInDropDown(driver, "//select[@name='DateOfBirthYear']",dateOfBirthYear);
		
		abtractPage.sendkeyToElement(driver, "//input[@name=\"Email\"]", email);
		abtractPage.sendkeyToElement(driver, "//input[@name=\"Company\"]", companyName);
		abtractPage.sendkeyToElement(driver, "//input[@name=\"Password\"]", Password);
		abtractPage.sendkeyToElement(driver, "//input[@name=\"ConfirmPassword\"]", Password);
		
		abtractPage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(abtractPage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		abtractPage.clickToElement(driver, "//a[@class='ico-logout']");
		
		abtractPage.clickToElement(driver, "//a[@class='ico-login']");
		
		abtractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abtractPage.sendkeyToElement(driver, "//input[@id='Password']", Password);

		abtractPage.clickToElement(driver, "//button[contains(text(),'Log in')]");
		
		Assert.assertTrue(abtractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		
		abtractPage.clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(abtractPage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(abtractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(abtractPage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(abtractPage.getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthDay']"), dateOfBirthDay);
		Assert.assertEquals(abtractPage.getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"), dateOfBirthMonth);
		Assert.assertEquals(abtractPage.getFirstSelectTextInDropDown(driver, "//select[@name='DateOfBirthYear']"), dateOfBirthYear);

		Assert.assertEquals(abtractPage.getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abtractPage.getElementAttribute(driver, "//input[@name='Company']", "value"), companyName);
		
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
