package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyProductPageObject extends AbstractPage{
	WebDriver driver;
	public MyProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
