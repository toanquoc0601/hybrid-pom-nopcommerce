package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DownloadableProductsPageObject extends AbstractPage{
	WebDriver driver;
	public DownloadableProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
