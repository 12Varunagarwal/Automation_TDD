package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class LoginPage extends BaseClass {

    // ================= LOCATORS =================

    @FindBy(id = "ap_email_login")
    WebElement txtEmailOrMobileNumber;

    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//a[@id='ab-registration-ingress-link']")
    WebElement lnkCreateaBusinessAccount;

    @FindBy(id = "continue")
    WebElement btnSignInSubmit;

    // ================= CONSTRUCTOR =================

    public LoginPage(WebDriver driver) {
        super(driver);  // 🔥 MUST (BaseClass init)
        PageFactory.initElements(driver, this);
    }

    // ================= METHODS =================

    public String getTitleOfThePage() {
        return driver.getTitle();
    }

    public void enterEmailId(String email) {
        sendKeysWithWait(txtEmailOrMobileNumber, email, 10);
    }

    public void clickOnContinueButton() {
        clickWithWait(btnSignInSubmit, 10);
    }

    public void enterPassword(String password) {
        sendKeysWithWait(txtPassword, password, 10);
    }

    public void clickOnSignInButton() {
        clickWithWait(btnSignInSubmit, 10);
    }

    public void clickOnCreateBusinessAccount() {
        clickWithWait(lnkCreateaBusinessAccount, 10);
    }

    public void signInWithValidCredentials(String email, String password) {
        enterEmailId(email);
        clickOnContinueButton();
        enterPassword(password);
        clickOnSignInButton();
    }

    public String getUnregisteredEmailIdError(WebElement errorElement) {
        return getTextWithWait(errorElement, 10);
    }
}