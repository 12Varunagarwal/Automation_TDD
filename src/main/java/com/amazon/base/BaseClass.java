package com.amazon.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utilities.CustomWait;
import com.amazon.utilities.configReader;

public class BaseClass {
	
	
	protected WebDriver driver;
	protected CustomWait wait;
	public Actions action;
	public configReader configreader;
	
	
	public BaseClass (WebDriver driver) {
	
		
		this.driver=driver;
		configreader = new configReader();
		PageFactory.initElements(driver,this);
		this.wait= new CustomWait(driver,Duration.ofSeconds(configreader.getGlobalWait()));
		
	}
	
	
	public WebDriver getDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){
			
		driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
			}
		
		else {
			
			driver = new EdgeDriver();
		}
		
		return driver;
				
	}
	
	public void quitDriver() {
		
		driver.quit();
	}
	
	//CommonMethods
	
	//logo
	public boolean verifyLogo() {
		
		return false;
	}
	
	
	//verifyTitle
	public String getTitle() {
		
		return driver.getTitle();
		
		}
	
	//currentURL
		public String getCurrentURL() {
		
		return driver.getCurrentUrl();
		
	}

		public void navigateBack() {
			// TODO Auto-generated method stub
			driver.navigate().back();
		}
	

		public void navigateForward() {
			// TODO Auto-generated method stub
			driver.navigate().forward();
		}

		public void refreshPage() {
			// TODO Auto-generated method stub
			driver.navigate().refresh();
			
		}
		
		public void moveToElement(WebElement element) {
			action=new Actions(driver);
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
		    wait.waitForVisibilityOfElement(element);
		    element.click();
		    element.clear();
		    element.sendKeys(String.valueOf(number));
		}
		
	

}
