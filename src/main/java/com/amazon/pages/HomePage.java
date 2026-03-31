package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class HomePage extends BaseClass {

    // ================= LOCATORS =================

    @FindBy(xpath = "//div[@id='nav-link-accountList']")
    WebElement accountsAndLists;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    WebElement btnSignIn;

    @FindBy(xpath = "//a[@class='nav-a']")
    WebElement btnNewCustomerStartHere;

    // ================= CONSTRUCTOR =================

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ================= METHODS (CUSTOM WAIT BASED) =================

    // Open Registration Page
    public void openRegistrationPage() {
        waitForVisibility(accountsAndLists, 10);     // hover se pehle wait
        moveToElement(accountsAndLists);             // hover
        clickWithWait(btnNewCustomerStartHere, 10);  // click with wait
    }

    // Open SignIn Page
    public void openSignInPage() {
        waitForVisibility(accountsAndLists, 10);
        moveToElement(accountsAndLists);
        clickWithWait(btnSignIn, 10);
    }

    // Get Page Title
    public String getTitleOfThePage() {
        return driver.getTitle();
    }
}