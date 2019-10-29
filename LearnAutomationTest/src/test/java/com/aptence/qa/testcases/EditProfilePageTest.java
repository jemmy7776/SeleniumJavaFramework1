package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.EditProfilePage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.util.TestUtil;

public class EditProfilePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	EditProfilePage editprofilepage;
	
	public EditProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.loginup(prop.getProperty("username"), prop.getProperty("password"));
		editprofilepage = homepage.clickOnEditProfileLink();
}
	@Test(priority=1)
	public void profilePageHeaderTest() {
		Assert.assertTrue(editprofilepage.verifyProfilePageHeader());
	}
	@Test(priority=2)
	public void profilePageUsernameTest() {
		String username = editprofilepage.verifyProfileUsername();
		Assert.assertEquals(username, prop.getProperty("username"));
  }
	@Test(priority=3)
	public void profilePageSchoolDetailsTest() {
		editprofilepage.clickOnEditSchoolButton();
		editprofilepage.enterSchoolDetails("HARYANA", "HISAR", "DAV PUBLIC SCHOOL");
		editprofilepage.clickOnSaveButton();
	}
	@Test(priority=4)
	public void profilePageSavedSchoolDetailsTest() {
		editprofilepage.clickOnEditSchoolButton();
		editprofilepage.enterSchoolDetails("HARYANA", "GURGAON", "Amity international");
		editprofilepage.clickOnSaveButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
