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

public class Level_01_Register_Login {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	Select select;
	public String firstName = "Toan", 
			lastName = "Quoc", 
			dateOfBirthDay = "6", 
			dateOfBirthMonth = "January", 
			DateOfBirthYear =  "1996", 
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
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		driver.findElement(By.xpath("//input[@name=\"FirstName\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name=\"LastName\"]")).sendKeys(lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(dateOfBirthDay);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(dateOfBirthMonth);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(DateOfBirthYear);
		
	
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name=\"Company\"]")).sendKeys(companyName);
		driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name=\"ConfirmPassword\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		sleepInSecond(3);
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isEnabled());
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dateOfBirthDay);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dateOfBirthMonth);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), DateOfBirthYear);

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
		//driver.quit();
	}
}
