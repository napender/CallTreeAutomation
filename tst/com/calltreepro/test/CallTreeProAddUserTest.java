package com.calltreepro.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.calltreepro.constant.CallTreeProXpaths;
import com.calltreepro.logic.helper.BrowserSessionHelper;

/**
 * 
 * @author napendra
 * 
 */

public class CallTreeProAddUserTest {

	@Test(dataProvider = "testDataForUser")
	public void addEndUserTest(String userName, String passWord, String fName,
			String lName, String newPass, String street, String city,
			String state, String zip, String email, String phone,
			String social, String userType) throws Exception {

		BrowserSessionHelper browserHelper = new BrowserSessionHelper();
		browserHelper.open("https://app.calltreepro.com/");
		browserHelper.commonInstructions(userName, passWord, fName, lName,
				newPass, street, city, state, zip, email, phone, social);
		// Here selecting the user role
		browserHelper
				.findDropDownElement(CallTreeProXpaths.USER_ROLE, userType);
		browserHelper.findElement(CallTreeProXpaths.ADD_USER_SUB);
		Assert.assertTrue(browserHelper.getPageSource().contains("Users"),
				"End User is not added to users list");
		browserHelper.findElement(CallTreeProXpaths.LOGOUT);
		Assert.assertTrue(
				browserHelper.getPageSource().contains("Call Trees made easy!"),
				"User is not Logout");
		browserHelper.close();

	}

	@DataProvider(name = "testDataForUser")
	public Object[][] createDataForEndUser() {
		return new Object[][] {
				{ "demo@calltreepro.com", "aaa", "fName", "lName",
						"pass", "street", "city", "state", "123456",
						"user18@mail.com", "1234567890", "facebook.com",
						"End User" },
				{ "demo@calltreepro.com", "aaa", "firstName", "lastName",
						"pass", "street", "city", "state", "123456",
						"user12@mail.com", "1234567890", "facebook.com",
						"Coordinator" },
				{ "demo@calltreepro.com", "aaa", "firstName", "lastName",
						"pass", "street", "city", "state", "123456",
						"user12@mail.com", "1234567890", "facebook.com",
						"Administrator" } };
	}

}
