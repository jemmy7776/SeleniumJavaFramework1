package com.aptence.qa.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.ChallengePage;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.util.TestUtil;

public class ChallengePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ChallengePage challengepage;
	public ChallengePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage(); 
		homepage=loginpage.loginup(prop.getProperty("username"), prop.getProperty("password"));
		challengepage = homepage.startChallenge();
	}
	
	@Test
	public void challengeScore() {
		Assert.assertEquals(challengepage.verifyChallengeScore(),"/100");
	}
	@Test
	public void challengeAttempt() {
		challengepage.verifyQuestionAttempt();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
