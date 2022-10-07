package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIs.HomePageUI;

public class HomePageObject extends AbstracPage{
	//Biến toàn cục (global)
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
//		WebDriver driver gọi là biến cục bộ (Local)
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logOutLink;
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement LogInLink;


	public void clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, LogInLink);
		clickToElement(driver, LogInLink);		
	}


	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisuble(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	
	}

	public boolean isLoginLinkDisplayed() {
		waitToElementVisuble(driver, logOutLink);
		return isElementDisplayed(driver, logOutLink);
	
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);		
	}


}
