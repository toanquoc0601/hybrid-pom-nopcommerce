package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageObject extends AbstracPage{

	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
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
	public String getFirstNameTextboxValue() {
		waitToElementVisuble(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox,"value");
	}
	public String getLastNameTextboxValue() {
		waitToElementVisuble(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox,"value");
	}
	public String getFirstSelectedTextInDayDropdown() {
		waitToElementVisuble(driver, dayDropdown);
		return getFirstSelectTextInDropDown(driver, dayDropdown);
	}
	public String getFirstSelectedTextInMonthDropdown() {
		waitToElementVisuble(driver, monthDropdown);
		return getFirstSelectTextInDropDown(driver, monthDropdown);
	}
	public String getFirstSelectedTextInYearDropdown() {
		waitToElementVisuble(driver, yearDropdown);
		return getFirstSelectTextInDropDown(driver, yearDropdown);
	}
	public String getEmailTextboxValue() {
		waitToElementVisuble(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox,"value");
	}
	public String getCompanyTextboxValue() {
		waitToElementVisuble(driver, companyTextBox);
		return getElementAttribute(driver, companyTextBox,"value");
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisuble(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	
	}

	

}
