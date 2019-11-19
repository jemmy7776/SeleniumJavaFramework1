package com.aptence.qa.pages;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//h5//b[contains(text(),'Raghav Pruthi')]")
	WebElement nameLabel;
	
	@FindBy(xpath="//li[@id='contact-us']")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Leaderboard')]")
	WebElement leaderboardLink;
	
	@FindBy(xpath="//a[contains(text(),'Edit Profile')]")
	WebElement editProfileLink;
	
	@FindBy(xpath="(//span[@class='ml-3'])[1]")
	WebElement startChallengeSubject;
	
	@FindBy(xpath="(//span[@class='ml-3'])[2]")
	WebElement challengeTopic;
	
	@FindBy(xpath="//a[contains(text(),'Start Now')]")
	WebElement clickOnStartNow;
	
	@FindBy(xpath="//a[contains(text(),'Start Challenge')]")
	WebElement clickOnStartChallenge;
	
	public HomePage() {
		PageFactory.initElements(driver, this);      //this mean current class object i.e LoginPage.class
	}
	
	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyName() {
		return nameLabel.isDisplayed();
	}
	
	public ContactUsPage clickOnContactUsLink() {
		contactUsLink.click();
		return new ContactUsPage();
	}
	
	public LeaderboardPage clickOnLeaderboardLink() {
		leaderboardLink.click();
		return new LeaderboardPage();
	}
	
	public EditProfilePage clickOnEditProfileLink() {
		editProfileLink.click();
		return new EditProfilePage();
	}

	public String verifyChallengeSubject() {
		
		String text = startChallengeSubject.getAttribute("innerText");
		 String lasttext[] = text.split("\\s+");
		return (lasttext[2]);
		
	}
	public String verifyChallengeTopic() {
		return challengeTopic.getAttribute("innerText");
		
	}
	public String clickOnStartNow() {
		return clickOnStartNow();
	}
	
	public ChallengePage startChallenge() {
		clickOnStartNow.click();
		clickOnStartChallenge.click();
		return new ChallengePage();
		
	}
		
		
	

}
