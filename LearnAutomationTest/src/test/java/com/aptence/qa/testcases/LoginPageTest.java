package com.aptence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aptence.qa.base.TestBase;
import com.aptence.qa.pages.HomePage;
import com.aptence.qa.pages.LoginPage;
import com.aptence.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object data[][]=TestUtil.getTestData("login");	//login is sheet name 
		return data;
	}
	
//	@Test(priority=1, dataProvider = "getLoginData")
//	public void loginTest(String eusername, String epassword) {	//dataprovider fetches data from getLoginData() so excel username and password we have to enter here
//		loginpage.multipleLogin(eusername, epassword);
//	}
//	
//	@Test(priority=2)
//	public void loginPageTitleTest() {
//		String title =loginpage.validateLoginPageTitle();
//		Assert.assertEquals(title, "Aptence | Adaptive, Gamified & Rewarding Learning Platform for School Students");
//		}
//	@Test(priority=3)
//	public void loginPageLogoTest() {
//		Boolean flag = loginpage.validateLoginPageLogo();
//		Assert.assertTrue(flag);
//	}
//	@Test(priority=4)
//	public void loginPagePopUpTest() {
//		loginpage.closePopUp();
//	}
	@Test(priority=5)
	public void loginPageLoginFormTest() {
		homepage=loginpage.loginup(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
