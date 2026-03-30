package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class HomePage extends BaseClass {
	 
	
	private BaseClass basepage;
	 
	
	@FindBy(xpath="//div[@id='nav-link-accountList']")
	public WebElement accountsAndLists;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	public WebElement btnSignIn;
	

	@FindBy(xpath="//a[@class='nav-a']")
	public WebElement btnNewCustomerStartHere;
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	
		
		
	}

	public void openRegistrationPage() {
		
		basepage.moveToElement(accountsAndLists);
		basepage.click(btnNewCustomerStartHere);
		
		
	}

	public void openSignInPage() {
			
		basepage.moveToElement(accountsAndLists);
		basepage.click(btnSignIn);
		
		
	}

	public String getTitleOfThePage() {
		// TODO Auto-generated method stub
		return getTitle();
	}

}
