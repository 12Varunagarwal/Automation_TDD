package com.amazon.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.CustomWait;
import com.amazon.utilities.configReader;

public class BaseClass {
    protected WebDriver driver;
    protected CustomWait wait;
    public Actions action;
    public configReader configreader;

    public BaseClass() {
        configreader = new configReader();
    }

    // Constructor that child classes can call
    public BaseClass(WebDriver driver) {
        this.driver = driver;
        configreader = new configReader();
        PageFactory.initElements(driver, this);
        this.wait = new CustomWait(driver, Duration.ofSeconds(configreader.getGlobalWait()));
        this.action = new Actions(driver);
    }

    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        else driver = new EdgeDriver();
        return driver;
    }


    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Common methods

    public boolean verifyLogo() {
        // Implementation here
        return false;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void moveToElement(WebElement element) {
        wait.waitForVisibilityOfElement(element);
        action.moveToElement(element).perform();
    }

    public void click(WebElement element) {
        wait.waitForVisibilityOfElement(element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        wait.waitForVisibilityOfElement(element);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void enterText(WebElement element, int number) {
        enterText(element, String.valueOf(number));
    }
    
    public String getText(WebElement element) {
        wait.waitForVisibilityOfElement(element);  // Wait until element is visible
        return element.getText().trim();           // Get text and remove leading/trailing spaces
    }
}