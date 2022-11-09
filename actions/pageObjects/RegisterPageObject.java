package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToGenderMailRadioButton() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}
	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisuble(driver, RegisterPageUI.FISTNAME_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.FISTNAME_TEXBOX, firstName);
		
	}
	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisuble(driver, RegisterPageUI.LASTNAME_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXBOX, lastName);
	}
	public void selectDayDropdown(String dateOfBirthDay) {
		waitToElementVisuble(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropDown(driver, RegisterPageUI.DAY_DROPDOWN, dateOfBirthDay);
	}
	public void selectMonthDropdown(String dateOfBirthMonth) {
		waitToElementVisuble(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropDown(driver, RegisterPageUI.MONTH_DROPDOWN, dateOfBirthMonth);
	}
	public void selectYearDropdown(String dateOfBirthYear) {
		waitToElementVisuble(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropDown(driver, RegisterPageUI.YEAR_DROPDOWN, dateOfBirthYear);
	}
	public void inputToEmailTextBox(String email) {
		waitToElementVisuble(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	public void inputToPasswordTextBox(String password) {
		waitToElementVisuble(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	public void inputToConfirmPasswordTextBox(String password) {
		waitToElementVisuble(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisuble(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
	}
	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	public String getRegisterSuccessMessage() {
		waitToElementVisuble(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}
	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	



}
