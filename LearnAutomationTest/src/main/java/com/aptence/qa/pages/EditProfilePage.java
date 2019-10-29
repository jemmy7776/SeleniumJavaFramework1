package com.aptence.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aptence.qa.base.TestBase;

public class EditProfilePage extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Profile')]")
	WebElement editProfileHeader;
	
	@FindBy(xpath="//label[contains(text(),'Username')]/following-sibling::input")
	WebElement profileUsername;
	
	@FindBy(id="editSchool")
	WebElement editschoolbutton;
	
	@FindBy(id="STATES")
	WebElement state;
	
	@FindBy(id="citySelect")
	WebElement city;
	
	@FindBy(id="profileSchool")
	WebElement school;
	
	@FindBy(id="saveProfile")
	WebElement savebutton;
		
	public EditProfilePage() {
		PageFactory.initElements(driver, this);      //this mean current class object i.e LoginPage.class
	}
	
	public boolean verifyProfilePageHeader() {
		return editProfileHeader.isDisplayed();
	}
	
	public String verifyProfileUsername() {
		return profileUsername.getAttribute("value");
	}
	 
	
	public void clickOnEditSchoolButton() {
		
		editschoolbutton.click();
	}
	
	public void enterSchoolDetails(String state1, String city1, String school1) {
			
		Select selectstate = new Select(state);
		selectstate.selectByValue(state1);
		
		Select selectcity = new Select(city);
		selectcity.selectByValue(city1);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(school));
		school.click();
		driver.findElement(By.id("profileSchool")).sendKeys(school1);
	}
	
	public void enterSavedSchoolDetails(String state1, String city1, String school1){
		Select selectstate = new Select(state);
		selectstate.selectByValue(state1);
		
		Select selectcity = new Select(city);
		selectcity.selectByValue(city1);
		
		Select selectschool = new Select(school);
		selectcity.selectByValue(school1);
	}
	
	public void clickOnSaveButton() {
		savebutton.click();
	}
	
	
	

}
