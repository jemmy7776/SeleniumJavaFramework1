package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.ContactUsPage;
import com.aptence.qa.pages.EditProfilePage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LeaderboardPage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactUsPage contactuspage;
	EditProfilePage editprofilepage;
	LeaderboardPage leaderboardpage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.loginup(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String title=homepage.verifyHomePageTitle();
	Assert.assertEquals(title, "Aptence | Adaptive, Gamified & Rewarding Learning Platform for School Students", "HomePage title not matched");
	}
	@Test(priority=2)
	public void verifyNameTest() {
		Assert.assertTrue(homepage.verifyName());
	}
	@Test(priority=3)
	public LeaderboardPage verifyLeaderboardLinkTest() {
		leaderboardpage = homepage.clickOnLeaderboardLink();
		return new LeaderboardPage();
	}
	@Test(priority=4)
	public ContactUsPage verifyContactUsLinkTest() {
		contactuspage = homepage.clickOnContactUsLink();
		return new ContactUsPage();
	}
	@Test(priority=5) 
	public EditProfilePage verifyEditProfileLinkTest() {
		editprofilepage = homepage.clickOnEditProfileLink();
		return new EditProfilePage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
