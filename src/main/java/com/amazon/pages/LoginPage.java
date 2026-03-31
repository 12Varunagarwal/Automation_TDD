package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;
import com.amazon.utilities.configReader;

public class LoginPage extends BaseClass {
	
	@FindBy(id="ap_email_login")
	WebElement txtEmailOrMobileNumber;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement btnContinue;
	
	@FindBy(xpath="//a[@id='ab-registration-ingress-link']")
	WebElement lnkCreateaBussinessAccount;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSignInSubmit;
	

	
	
	
	
	
	
	 public LoginPage(WebDriver driver) {
	        super(driver);                  // Initialize BaseClass with driver
	        PageFactory.initElements(driver, this); // Optional, but safe
	    }
	
	 
	public String getTitleOfThePage() {
		
		return getTitle();
	}

	public void enterEmailId(String string) {
		// TODO Auto-generated method stub
		enterText(txtEmailOrMobileNumber,string);
		
		
	}

	public void clickOnContinueButton() {
		// TODO Auto-generated method stub
			click(btnSignInSubmit);
		
	}

	public void signInWithValidCredentials(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public String getUnregisteredEmailIdError() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
