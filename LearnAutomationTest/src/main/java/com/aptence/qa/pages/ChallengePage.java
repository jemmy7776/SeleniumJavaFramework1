package com.aptence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aptence.qa.base.TestBase;

public class ChallengePage extends TestBase{
	@FindBy(xpath="//span[@class='total-score']")
	WebElement totalScore;
	
	@FindBy(xpath="//div[@id='question-1']//div[@data-optionname='option1']")
	WebElement questionAttempt1;
	
	@FindBy(xpath="//a[@id='next-que-nav']")
	WebElement nextButton;
	
	@FindBy(xpath="//div[@id='question-2']//div[@data-optionname='option1']")
	WebElement questionAttempt2;
	
	@FindBy(xpath="//div[@id='question-3']//div[@data-optionname='option1']")
	WebElement questionAttempt3;
	
	@FindBy(xpath="//div[@id='question-4']//div[@data-optionname='option1']")
	WebElement questionAttempt4;
	
	@FindBy(xpath="//div[@id='question-5']//div[@data-optionname='option1']")
	WebElement questionAttempt5;
	
	@FindBy(xpath="//a[@id='submit-btn']")
	WebElement submitButton;
	
	@FindBy(xpath="//span[@class='nav-btn-text'][contains(text(),'Finish')]")
	WebElement finishButton;
	
	public ChallengePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyChallengeScore() {
		 String score =totalScore.getAttribute("innerText");
	return score;
	}
	public ChallengeReportPage verifyQuestionAttempt() {
		questionAttempt1.click();
		nextButton.click();
		questionAttempt2.click();
		nextButton.click();
		questionAttempt3.click();
		finishButton.click();
		return new ChallengeReportPage();
	}
	

		
		


}
