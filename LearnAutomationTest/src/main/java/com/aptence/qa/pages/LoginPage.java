package com.aptence.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aptence.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OjectRepository
	@FindBy(xpath="//button[@class='close basecamp-close-btn']")
	WebElement popup;
	
	@FindBy(xpath="//button[contains(text(),'LOGIN')]")
	WebElement loginformbutton;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	@CacheLookup		//The WebElement which are executed multiple times are stored in a diff memory so selenium do not have to fetch xpath from browser, limitation: if DOM changes or page refreshes than element stale exception
	WebElement loginbtn;
	
	@FindBy(xpath="//button[@class='btn register-btn shadow-sm']")
	@CacheLookup
	WebElement signupbtn;
	
	@FindBy(id="logo")
	WebElement aptencelogo;
	
	@FindBy(xpath="//input[@id='login-email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='login-password']")
	WebElement password;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);      //this mean current class object i.e LoginPage.class
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateLoginPageLogo() {
		return aptencelogo.isDisplayed();
	}
	public HomePage loginup(String un, String pwd) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(popup));
		wait.until(ExpectedConditions.elementToBeClickable(popup));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", popup);
		
		
//		Actions action = new Actions(driver);
//		action.moveToElement(popup).click().build().perform();
		try{
		wait.until(ExpectedConditions.invisibilityOf(popup));
		}catch(org.openqa.selenium.TimeoutException e) {
			popup.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(loginformbutton));		
		js.executeScript("arguments[0].click();", loginformbutton);
		//Thread.sleep(2000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		//Thread.sleep(5000);
		return new HomePage();
	}
	
	public HomePage multipleLogin(String eusername,String ePassword) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(popup));
		wait.until(ExpectedConditions.elementToBeClickable(popup));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", popup);
		
		
//		Actions action = new Actions(driver);
//		action.moveToElement(popup).click().build().perform();
		try{
		wait.until(ExpectedConditions.invisibilityOf(popup));
		}catch(org.openqa.selenium.TimeoutException e) {
			popup.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(loginformbutton));		
		js.executeScript("arguments[0].click();", loginformbutton);
		//Thread.sleep(2000);
		username.sendKeys(eusername);
		password.sendKeys(ePassword);
		loginbtn.click();
		
		return new HomePage();
		
	}
	public void closePopUp() {
		 popup.click();
		 
	}

}
