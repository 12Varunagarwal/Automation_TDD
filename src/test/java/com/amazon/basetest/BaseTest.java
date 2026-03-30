package com.amazon.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.base.BaseClass;
import com.amazon.pages.BussinessPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.RegistrationPage;
import com.amazon.utilities.configReader;

public class BaseTest {

    public BaseClass basepage;
    public WebDriver driver;
    public LoginPage loginpage; 
    public RegistrationPage registrationpage;
    public HomePage homepage;
    public BussinessPage bussinesspage;
    public configReader configreader;

    @BeforeMethod
    public void setup() {
        configreader = new configReader();

        // 1️⃣ Initialize BaseClass and driver
        basepage = new BaseClass();                     // No driver yet
        driver = basepage.getDriver(configreader.getbrowser()); // Initialize driver

        // 2️⃣ Initialize BaseClass with driver
        basepage = new BaseClass(driver);              // Now driver, wait, actions are ready

        // 3️⃣ Open the URL
        driver.get(configreader.geturl());

        // 4️⃣ Initialize Page Objects
        registrationpage = new RegistrationPage(driver);
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        bussinesspage = new BussinessPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        if (basepage != null) {
            basepage.quitDriver();
        }
    }
}