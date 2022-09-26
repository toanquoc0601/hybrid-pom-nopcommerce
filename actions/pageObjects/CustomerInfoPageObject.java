package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustumerInforUI;

public class CustomerInfoPageObject extends AbstractPage{

	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getFirstNameTextboxValue() {
		waitToElementVisuble(driver, CustumerInforUI.FISTNAME_TEXBOX);
		return getElementAttribute(driver, CustumerInforUI.FISTNAME_TEXBOX,"value");
		
	}
	public String getLastNameTextboxValue() {
		waitToElementVisuble(driver, CustumerInforUI.LASTNAME_TEXBOX);
		return getElementAttribute(driver, CustumerInforUI.LASTNAME_TEXBOX,"value");
	}
	public String getFirstSelectedTextInDayDropdown() {
		waitToElementVisuble(driver, CustumerInforUI.DAY_DROPDOWN);
		return getFirstSelectTextInDropDown(driver, CustumerInforUI.DAY_DROPDOWN);
	}
	public String getFirstSelectedTextInMonthDropdown() {
		waitToElementVisuble(driver, CustumerInforUI.MONTH_DROPDOWN);
		return getFirstSelectTextInDropDown(driver, CustumerInforUI.MONTH_DROPDOWN);
	}
	public String getFirstSelectedTextInYearDropdown() {
		waitToElementVisuble(driver, CustumerInforUI.YEAR_DROPDOWN);
		return getFirstSelectTextInDropDown(driver, CustumerInforUI.YEAR_DROPDOWN);
	}
	public String getEmailTextboxValue() {
		waitToElementVisuble(driver, CustumerInforUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustumerInforUI.EMAIL_TEXTBOX,"value");
	}
	public String getCompanyTextboxValue() {
		waitToElementVisuble(driver, CustumerInforUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustumerInforUI.COMPANY_TEXTBOX,"value");
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisuble(driver, CustumerInforUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustumerInforUI.GENDER_MALE_RADIO);
	
	}

	

}
