package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class RegistrationPage extends BaseClass {

    // ================= LOCATORS =================

    @FindBy(id = "ap_phone_number")
    WebElement txtMobileNumber;

    @FindBy(id = "ap_customer_name")
    WebElement txtCustomerName;

    @FindBy(id = "ap_password")
    WebElement txtPassword;

    @FindBy(id = "continue")
    WebElement btnVerifyMobileNumber;



    @FindBy(xpath = "//h1[contains(text(),'It looks like you are new')]")
    WebElement txtProceedToCreateAnAccount;

    @FindBy(xpath = "//input[@class='a-button-input']")
    WebElement btnProceedToCreateAnAccount;

    @FindBy(xpath = "//h1[contains(text(),'Create Account')]")
    WebElement txtCreateAccount;
    
    @FindBy(xpath = "//div[@class='a-row a-spacing-mini'][1]")
    WebElement txtSolvePuzzle;
    
    
    

    // ================= CONSTRUCTOR =================

    public RegistrationPage(WebDriver driver) {
        super(driver);   // 🔥 IMPORTANT (BaseClass init)
        PageFactory.initElements(driver, this);
    }

    // ================= METHODS (CUSTOM WAIT BASED) =================

    public void enterMobileNumber(String number) {
        sendKeysWithWait(txtMobileNumber, number, 10);
    }

    public void enterCustomerName(String name) {
        sendKeysWithWait(txtCustomerName, name, 10);
    }

    public void enterPassword(String password) {
        sendKeysWithWait(txtPassword, password, 10);
    }

    public void clickOnVerifyMobileNumberBtn() {
        clickWithWait(btnVerifyMobileNumber, 10);
    }

    public void checkMobileNumberFunctionality(String number, String name, String pwd) {
        enterMobileNumber(number);
        enterCustomerName(name);
        enterPassword(pwd);
        clickOnVerifyMobileNumberBtn();
    }




    public String getTextLooksLikeNewToAmazon() {
        return getTextWithWait(txtProceedToCreateAnAccount, 10);
    }

    public void clickOnProceedToCreateAnAccountButton() {
        clickWithWait(btnProceedToCreateAnAccount, 10);  // 🔥 FIXED
    }

    public String getCreateAccountText() {
        return getTextWithWait(txtCreateAccount, 10);
    }
    
    public String getSolvePuzzleText() {
        return getTextWithWait(txtSolvePuzzle, 10);
    }
}

