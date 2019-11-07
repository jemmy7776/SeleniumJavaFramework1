/* AUTHOR -- JASHANDEEP */
package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.ContactUsPage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.util.TestUtil;

public class ContactUsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactUsPage contactuspage;
	public ContactUsPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactuspage = new ContactUsPage(); 
		homepage=loginpage.loginup(prop.getProperty("username"), prop.getProperty("password"));
		contactuspage = homepage.clickOnContactUsLink();
	}
	
	@Test(priority=3)
	public void verifyContactUsLabelTest() {
		Assert.assertTrue(contactuspage.verifyContactUsPageHeader());
	}
	@Test(priority=2)
	public void verifyContactUsUsernameTest() {
		contactuspage.verifyUsername();
	}
	@Test(priority=1)
	public void verifyMobileNumberTest() {
		String phone= contactuspage.verifyMobileNumber();
		Assert.assertEquals(phone, prop.getProperty("username"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
