package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageFactory.AbstracPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstracPage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButton;
	

	public void inputToEmailTextBox(String email) {
		waitToElementVisuble(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}
	public void inputToPasswordTextBox(String password) {
		waitToElementVisuble(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	} 

	public void clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}
	

}
