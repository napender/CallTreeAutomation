package com.calltreepro.logic.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.calltreepro.constant.CallTreeProXpaths;
import com.calltreepro.interfaces.IBrowserSessionHelper;

/**
 * 
 * @author napendra
 * 
 */

public class BrowserSessionHelper implements IBrowserSessionHelper {

	private WebDriver driver;
	private Select dropDown;

	public BrowserSessionHelper() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Override
	public void open(String url) throws Exception {
		driver.get(url);
	}

	@Override
	public void findElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	@Override
	public void findElementAndEnterValue(String xpath, String key) {
		driver.findElement(By.id(xpath)).sendKeys(key);

	}

	@Override
	public void close() {
		driver.quit();

	}

	@Override
	public void findDropDownElement(String xpath, String key) {
		dropDown = new Select(driver.findElement(By.id(xpath)));
		dropDown.selectByVisibleText(key);

	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void commonInstructions(String userName, String passWord,
			String fName, String lName, String newPass, String street,
			String city, String state, String zip, String email, String phone,
			String social) {
		findElement(CallTreeProXpaths.LOGIN);
		findElementAndEnterValue(CallTreeProXpaths.USER_NAME, userName);
		findElementAndEnterValue(CallTreeProXpaths.PASSWORD, passWord);
		findElement(CallTreeProXpaths.LOGIN_BUTTON);
		findElement(CallTreeProXpaths.GO_TO_USERS);
		findElement(CallTreeProXpaths.ADD_USER_BUTTON);
		findElementAndEnterValue(CallTreeProXpaths.FIRST_NAME, fName);
		findElementAndEnterValue(CallTreeProXpaths.LAST_NAME, lName);
		findElementAndEnterValue(CallTreeProXpaths.NEW_PASSWORD, newPass);
		findElementAndEnterValue(CallTreeProXpaths.STREET, street);
		findElementAndEnterValue(CallTreeProXpaths.CITY, city);
		findElementAndEnterValue(CallTreeProXpaths.STATE, state);
		findElementAndEnterValue(CallTreeProXpaths.ZIP, zip);
		findElementAndEnterValue(CallTreeProXpaths.EMAIL, email);
		findElementAndEnterValue(CallTreeProXpaths.PHONE, phone);
		findElementAndEnterValue(CallTreeProXpaths.SOCIAL, social);

	}

}
