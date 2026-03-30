package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class RegistrationPage extends BaseClass{
	
	public BaseClass basepage;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement txtMobileNumber;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement btnVerifyMobileNumber;
	
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	public void enterMobileNumber(String number) {
		
		basepage.enterText(btnVerifyMobileNumber,number);
		
	}
	
	public void enterCustomerName(String name) {
		
		basepage.enterText(txtCustomerName,name);
		
	}
	
	public void enterPassword(String password) {
		
		basepage.enterText(txtPassword,password);
	}
	
	public void clickOnVerifyMobileNumberBtn() {
		
		basepage.click(btnVerifyMobileNumber);
	}
	

	public void checkMobileNumberFunctionality(String number , String name , String pwd) {
		// TODO Auto-generated method stub
		enterMobileNumber(number);
		enterCustomerName(name);
		enterPassword(pwd);
		clickOnVerifyMobileNumberBtn();
		
		
	}

	/*
	 * public void clickOnSignInLink() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * public void clickOnCreateBussinessLinkTest() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * public void verifyPresenceOfElementsOnPage() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 */
	
	
	

}