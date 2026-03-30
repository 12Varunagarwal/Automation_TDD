package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class HomePage extends BaseClass {

    @FindBy(xpath="//div[@id='nav-link-accountList']")
    public WebElement accountsAndLists;

    @FindBy(xpath="//span[@class='nav-action-inner']")
    public WebElement btnSignIn;

    @FindBy(xpath="//a[@class='nav-a']")
    public WebElement btnNewCustomerStartHere;

    // ✅ Constructor that calls BaseClass constructor
    public HomePage(WebDriver driver) {
        super(driver);                  // Initialize BaseClass with driver
        PageFactory.initElements(driver, this); // Optional, but safe
    }

    // Open Registration Page
    public void openRegistrationPage() {
        moveToElement(accountsAndLists);    
        click(btnNewCustomerStartHere);     
    }

    // Open SignIn Page
    public void openSignInPage() {
        moveToElement(accountsAndLists);    
        click(btnSignIn);                   
    }

    // Get Page Title
    public String getTitleOfThePage() {
        return getTitle();                  
    }
}