package com.calltreepro.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.calltreepro.constant.CallTreeProXpaths;
import com.calltreepro.logic.helper.BrowserSessionHelper;

/**
 * 
 * @author napendra
 *
 */

public class CallTreeProAddEventTest {
	
	@Test(dataProvider = "testDataForAddEvent")
	public void addEventTest(String userName, String passWord, String eventName, String tag, String description, String time, String respondTime, String responceOptOne, String responceOptTwo) throws Exception{
		BrowserSessionHelper browserHelper = new BrowserSessionHelper();
		browserHelper.open("https://app.calltreepro.com/");
		browserHelper.findElement(CallTreeProXpaths.LOGIN);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.USER_NAME, userName);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.PASSWORD, passWord);
		browserHelper.findElement(CallTreeProXpaths.LOGIN_BUTTON);
		browserHelper.findElement(CallTreeProXpaths.GO_TO_EVENT);
		browserHelper.findElement(CallTreeProXpaths.CREATE_EVENT);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_NAME, eventName);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_TAG, tag);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_DESCRIPTION, description);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_DATE, time);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_TIME_RESPOND, respondTime);
		browserHelper.findElement(CallTreeProXpaths.EVENT_GPS_CHECKBOX);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_BUTTON_ONE, responceOptOne);
		browserHelper.findElementAndEnterValue(CallTreeProXpaths.EVENT_BUTTON_TWO, responceOptTwo);
		browserHelper.findElement(CallTreeProXpaths.EVENT_SUB_BUTTON);
		
		
	}
	
	
	
	
	
	@DataProvider(name = "testDataForAddEvent")
	public Object[][] createDataForEndUser() {
		return new Object[][] {
				{ "demo@calltreepro.com", "aaa", "fName", "lName",
						"pass", "street", "city", "state", "123456",
						"user18@mail.com", "1234567890", "facebook.com",
						"End User" }
		};
	}

}
