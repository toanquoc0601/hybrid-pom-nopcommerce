package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
		return PageGeneratorManager.getLoginPage(driver);
	}


	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisuble(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	
	}

	public boolean isLoginLinkDisplayed() {
		waitToElementVisuble(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);	
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}


}
