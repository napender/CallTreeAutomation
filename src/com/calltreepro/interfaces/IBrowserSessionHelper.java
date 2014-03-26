package com.calltreepro.interfaces;

/**
 * 
 * @author napendra
 * 
 */

public interface IBrowserSessionHelper {

	void open(String url) throws Exception;

	void findElement(String xpath);

	void findElementAndEnterValue(String xpath, String key);

	public void findDropDownElement(String xpath, String key);

	public String getPageSource();

	void close();

	void commonInstructions(String userName, String passWord, String fName,
			String lName, String newPass, String street, String city,
			String state, String zip, String email, String phone, String social);

}
