package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstracPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement genderMaleRadio;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTextbox;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTextbox;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyTextBox;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement comfirmPasswordTextbox;
	@FindBy(xpath = "//button[@id='register-button']")
	WebElement registerButton;
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	WebElement successMessage;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement loginLink;

	public void clickToGenderMailRadioButton() {
		waitToElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisuble(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisuble(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void selectDayDropdown(String dateOfBirthDay) {
		waitToElementVisuble(driver, dayDropdown);
		selectItemInDropDown(driver, dayDropdown, dateOfBirthDay);
	}

	public void selectMonthDropdown(String dateOfBirthMonth) {
		waitToElementVisuble(driver, monthDropdown);
		selectItemInDropDown(driver, monthDropdown, dateOfBirthMonth);
	}

	public void selectYearDropdown(String dateOfBirthYear) {
		waitToElementVisuble(driver, yearDropdown);
		selectItemInDropDown(driver, yearDropdown, dateOfBirthYear);
	}

	public void inputToEmailTextBox(String email) {
		waitToElementVisuble(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitToElementVisuble(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPasswordTextBox(String password) {
		waitToElementVisuble(driver, comfirmPasswordTextbox);
		sendkeyToElement(driver, comfirmPasswordTextbox, password);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisuble(driver, companyTextBox);
		sendkeyToElement(driver, companyTextBox, companyName);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitToElementVisuble(driver, successMessage);
		return getElementText(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
