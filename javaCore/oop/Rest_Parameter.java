package oop;

public class Rest_Parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String SITE_LINK = "abc'%s'asdas'%s'asdasdas'%s'";
		clickToElement(SITE_LINK, "a1","b1","c1");
	}
	public static void clickToElement(String locator, String... value) {
		locator = String.format(locator, (Object[])value);
		System.out.println("Element thay doi:" + locator);
	}

}
