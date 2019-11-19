package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class ContactUsPage extends TestBase{
	@FindBy(xpath="//h1[contains(text(),'Contact Us')]")
	WebElement contactUsHeader;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement mobileNumber ;
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);      
	}
	public boolean verifyContactUsPageHeader() {
		return contactUsHeader.isDisplayed();
	}
	public String verifyUsername() {
		return userName.getAttribute("placeholder");
	}
	public String verifyMobileNumber() {
		String mob= mobileNumber.getAttribute("placeholder");
		if(mob=="phone") {
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9995554443");
		}
		else {
			driver.findElement(By.xpath("//input[@type='tel']")).getText();
		}
		return mob;
	}
	
		
	}

