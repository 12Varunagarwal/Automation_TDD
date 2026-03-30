package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;
import com.amazon.utilities.CustomWait;
import com.amazon.utilities.configReader;

public class RegistrationPage extends BaseClass {

    @FindBy(xpath = "//input[@id='ap_phone_number']")
    WebElement txtMobileNumber;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    WebElement txtCustomerName;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnVerifyMobileNumber;

    // Constructor: call super(driver) to initialize BaseClass
    public RegistrationPage(WebDriver driver) {
    this.driver = driver;  // assign driver manually
    configreader = new configReader();
    PageFactory.initElements(driver, this);

}

    public void enterMobileNumber(String number) {
        // Use inherited method directly
        enterText(txtMobileNumber, number);
    }

    public void enterCustomerName(String name) {
        enterText(txtCustomerName, name);
    }

    public void enterPassword(String password) {
        enterText(txtPassword, password);
    }

    public void clickOnVerifyMobileNumberBtn() {
        click(btnVerifyMobileNumber);
    }

    public void checkMobileNumberFunctionality(String number, String name, String pwd) {
        enterMobileNumber(number);
        enterCustomerName(name);
        enterPassword(pwd);
        clickOnVerifyMobileNumberBtn();
    }
} 
 