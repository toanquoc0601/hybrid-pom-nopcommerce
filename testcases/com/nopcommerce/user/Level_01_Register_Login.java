package com.nopcommerce.user;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_Login {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	Select select;
	public String firstName = "Toan", 
			lastName = "Quoc", 
			dateOfBirthDay = "6", 
			dateOfBirthMonth = "January", 
			dateOfBirthYear =  "1996", 
			email = generateEmail(),
			companyName = "Company", 
			Password = "123123";

	@BeforeClass
	public void beforeClass() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
	}
	@Test
	public void checkDataTableWithPagination() throws InterruptedException {
	  driver.get("https://datatables.net/");

	  By title_H1 = By.xpath("//div[@class='fw-hero']//h1");

	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(title_H1));

	  Thread.sleep(1000);

	  By button_Next = By.xpath("//a[@id='example_next']");
	  By label_Info_PageTotal = By.xpath("//div[@id='example_info']");
	  String info = driver.findElement(label_Info_PageTotal).getText(); //Showing 1 to 10 of 57 entries

	  System.out.println("Chu???i ch???a s??? item: " + info);

	  //M??nh t??ch c??i chu???i tr??n v???i k?? t??? kho???ng tr???ng r???i l???y ph???n t??? th??? 5 t??nh t??? 0
	  //????? b???t t???ng s??? Item
	  ArrayList < String > arrayListString = new ArrayList < > ();
	  for (String s: info.split(" ")) {
	    arrayListString.add(s);
	  }

	  int itemTotal = Integer.parseInt(arrayListString.get(5));
	  System.out.println("T???ng s??? item: " + itemTotal);

	  int itemTotalOnePage = 10; //m???c ?????nh nh?? m???u. Tu??? v??o h??? th???ng m??nh thay ?????i theo
	  System.out.println("S??? item tr??n 1 trang: " + itemTotalOnePage);

	  double pageTotal = (double) itemTotal / (double) itemTotalOnePage;

	  DecimalFormat df = new DecimalFormat("#"); //L??m tr??n s??? ?????n ph???n ????n v??? c???a ph???n th???p ph??n
	  //V?? d??? 5.7 th?? l??m tr??n 6 ki???u v???y
	  int pageTotalInt = Integer.parseInt(df.format(pageTotal));
	  System.out.println("T???ng s??? trang: " + df.format(pageTotalInt));

	  //FOR n??y ch???y t???i < pageTotalInt ????? n?? kh??ng click th??m l???n cu???i c??ng
	  //VD: 6 trang th?? n?? ch??? click 5 l???n th??i ch??? h??? =))
	  for (int i = 1; i < pageTotalInt; i++) {
	    //G???i h??m Check data b??n tr??n l???i
	    checkContainsSearchTableByColumn(1, "");
	    Thread.sleep(1000);
	    //Click Next
	    driver.findElement(button_Next).click();
	  }

	  Thread.sleep(2000);

	}

	public void checkContainsSearchTableByColumn(int column, String value) throws InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  List < WebElement > totalRows = driver.findElements(By.xpath("//div[@id='example_wrapper']//tbody/tr"));
		  Thread.sleep(1);
		  System.out.println("S??? k???t qu??? cho t??? kh??a (" + value + "): " + totalRows.size());

		  for (int i = 1; i <= totalRows.size(); i++) {
		    boolean res = false;
		    WebElement title = driver.findElement(By.xpath("//div[@id='example_wrapper']//tbody/tr[" + i + "]/td[" + column + "]"));
		    // js.executeScript("arguments[0].scrollIntoView(true);", title);
		    res = title.getText().toUpperCase().contains(value.toUpperCase());
		    System.out.println("D??ng th??? " + i + ": " + res + " - " + title.getText());
		    Assert.assertTrue(res, "D??ng th??? " + i + " (" + title.getText() + ")" + " kh??ng ch???a gi?? tr??? " + value);
		  }
		}
	public void Register_Login_Verify_() {
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		driver.findElement(By.xpath("//input[@name=\"FirstName\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name=\"LastName\"]")).sendKeys(lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(dateOfBirthDay);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(dateOfBirthMonth);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(dateOfBirthYear);
		
	
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name=\"Company\"]")).sendKeys(companyName);
		driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name=\"ConfirmPassword\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		sleepInSecond(3);
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isEnabled());
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dateOfBirthDay);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dateOfBirthMonth);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dateOfBirthYear);

		driver.findElement(By.xpath("//button[@id='save-info-button']")).click();
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		
	
	}
	
	public String generateEmail() {
		Random random = new Random();
		return "toanquoc" + random.nextInt(9999) + "@gmail.com";
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public WebElement elemetLocator(String Locator) {
		try { 
			driver.findElement(By.xpath(Locator));
		}catch (Exception e) {
			System.out.println(e);
		}
		return driver.findElement(By.xpath(Locator));
	}
	
	@AfterClass//(alwaysRun = true)
	public void afterClass() {
		//driver.quit();
	}
}
