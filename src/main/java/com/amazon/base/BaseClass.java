package com.amazon.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utilities.CustomWait;
import com.amazon.utilities.configReader;

public class BaseClass {

    protected WebDriver driver;
    protected CustomWait wait;
    public Actions action;
    public configReader configreader;

    // ================= CONSTRUCTOR =================

    public BaseClass() {
        configreader = new configReader();
    }

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        configreader = new configReader();
        PageFactory.initElements(driver, this);
        this.wait = new CustomWait(driver, Duration.ofSeconds(configreader.getGlobalWait()));
        this.action = new Actions(driver);
    }

    // ================= DRIVER SETUP =================

    public WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // optional

        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ================= COMMON METHODS =================

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

    // ================= ACTION METHODS =================

    public void moveToElement(WebElement element) {
        wait.waitForVisibilityOfElement(element);
        action.moveToElement(element).perform();
    }

    public void click(WebElement element) {
        wait.waitForElementToBeClickable(element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        wait.waitForVisibilityOfElement(element);
        element.clear();
        element.sendKeys(text);
    }


    public void enterText(WebElement element, int number) {
        enterText(element, String.valueOf(number));
    }
    public String getText(WebElement element) {
        wait.waitForVisibilityOfElement(element);
        return element.getText().trim();
    }

    // ================= 🔥 CUSTOM WAIT METHODS =================

    public void clickWithWait(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysWithWait(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
        ele.clear();
        ele.sendKeys(text);
    }

    public WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
        
    }

    public boolean waitForInvisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getTextWithWait(WebElement element, int timeout) {
        return waitForVisibility(element, timeout).getText().trim();

    }
}