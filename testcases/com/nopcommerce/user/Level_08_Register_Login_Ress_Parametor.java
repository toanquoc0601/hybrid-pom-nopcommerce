package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Level_08_Register_Login_Ress_Parametor extends AbstractTest {
	WebDriver driver;
	String firstName = "Toan", lastName = "Quoc", dateOfBirthDay = "6", dateOfBirthMonth = "March",
			dateOfBirthYear = "1996", email = generateEmail(), companyName = "Company", Password = "123123";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com");
	}

	@Test
	public void TC_01_Register() {
		// Register
		homePage = PageGeneratorManager.getHomePage(driver);
		//Chuyển page
		log.info("Click button RegisterLink");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("clickToGenderMailRadioButton");
		registerPage.clickToGenderMailRadioButton();
		
		log.info("clickToGenderMailRadioButton");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("clickToGenderMailRadioButton");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("selectDayDropdown");
		registerPage.selectDayDropdown(dateOfBirthDay);

		log.info("selectMonthDropdown");
		registerPage.selectMonthDropdown(dateOfBirthMonth);

		log.info("selectYearDropdown");
		registerPage.selectYearDropdown(dateOfBirthYear);

		log.info("inputToEmailTextBox");
		registerPage.inputToEmailTextBox(email);

		log.info("inputToPasswordTextBox");
		registerPage.inputToPasswordTextBox(Password);

		log.info("inputToConfirmPasswordTextBox");
		registerPage.inputToConfirmPasswordTextBox(Password);

		log.info("inputToCompanyTextbox");
		registerPage.inputToCompanyTextbox(companyName);

		log.info("clickToRegisterButton");
		registerPage.clickToRegisterButton();
		
		log.info("Hahaha");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		//Chuyển page
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_Login() {
		//Chuyển page
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(Password);
		//Chuyển Page
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		//Assert.assertTrue(homePage.isDropDownMultiple(driver, ""));
	}

	@Test
	public void TC_03_Verify_Account() {
		//Chuyển page
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPage.getFirstSelectedTextInDayDropdown(), dateOfBirthDay);
		Assert.assertEquals(customerInfoPage.getFirstSelectedTextInMonthDropdown(), dateOfBirthMonth);
		Assert.assertEquals(customerInfoPage.getFirstSelectedTextInYearDropdown(), dateOfBirthYear);
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
		Verify.verify(customerInfoPage.isGenderMaleRadioButtonSelected());
		
		log.info("Test Verify");
		verifyTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

	}
	@Test
	public void TC_04_Switch_Page() {
		customerInfoPage.openLinkWithPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressesPage(driver);
		
		addressPage.openLinkWithPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInfoPage.openLinkWithPageName(driver, "Downloadable products");
		downloadProductPage = PageGeneratorManager.getDownloadableProductsPage(driver);
		
		downloadProductPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getMyProductInfoPage(driver);
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
		driver.quit();
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
