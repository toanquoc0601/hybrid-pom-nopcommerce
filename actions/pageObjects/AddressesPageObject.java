package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class AddressesPageObject extends AbstractPage{
	WebDriver driver;
	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
