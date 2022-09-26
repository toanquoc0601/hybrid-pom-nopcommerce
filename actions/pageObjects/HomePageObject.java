package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	//Biến toàn cục (global)
	WebDriver driver;

	// Hàm khởi tạo (Contructor method)
	// Khi new Class này lên HomePageObject thì nó sẽ chạy đầu tiên
	// Không có kiểu trả về/ no data type
	// Cùng tên với tên Class
	public HomePageObject(WebDriver driver) {
//		WebDriver driver gọi là biến cục bộ (Local)
		this.driver = driver;
	}


	public void clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
	}


	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisuble(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	
	}

	public boolean isLoginLinkDisplayed() {
		waitToElementVisuble(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);		
	}


}
