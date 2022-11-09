package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.DownloadableProductsPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class tesst extends AbstractTest {
	WebDriver driver;
	String firstName = "Toan", lastName = "Quoc", dateOfBirthDay = "6", dateOfBirthMonth = "March",
			dateOfBirthYear = "1996", email = generateEmail(), companyName = "Company", Password = "123123";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://789d.club/");
	}



	public void TC_02_Login() {
		//Chuyển page
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(Password);
		//Chuyển Page
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isDropDownMultiple(driver, ""));
	}
	@Test
	public void TC_01_Search_And_Verify_Google_With_Submit() {
		
		driver.get("https://789d.club/");
		driver.manage().window().setSize(new Dimension(1000	, 500));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kakute02");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("quoc782442");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).submit();
		
		sleepInSecond(40);
		WebElement canvasElement = driver.findElement(By.id("GameCanvas"));
		//Select the Pencil Tool
		Dimension canvasDimetion = canvasElement.getSize();
		int canvas_center_x = canvasDimetion.getWidth()/2;
		int canvas_center_y = canvasDimetion.getHeight()/2;
		int button_x = (canvas_center_x/3)*2;
		int button_y = canvas_center_y;
		
		Actions builder = new Actions(driver);
		builder.moveByOffset(button_x, button_y).doubleClick().perform();
		sleepInSecond(2);
		builder.moveByOffset(canvas_center_x, canvas_center_y).doubleClick().perform();
		sleepInSecond(2);
		builder.moveByOffset(button_x, button_y).doubleClick().perform();
		sleepInSecond(2);
		builder.moveByOffset(canvas_center_x, canvas_center_y).doubleClick().perform();
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
		} catch (Exception e) {
			System.out.println(e);
		}
		return driver.findElement(By.xpath(Locator));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	AddressesPageObject addressPage;
	DownloadableProductsPageObject downloadProductPage;
	MyProductPageObject myProductPage;
	OrdersPageObject oderPage;
}
