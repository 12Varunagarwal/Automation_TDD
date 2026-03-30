package com.amazon.utilities;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public CustomWait(WebDriver driver , Duration timeout) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,timeout);
		
		
	}
	
	public void waitForVisibilityOfElement(WebElement element) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    } catch (TimeoutException e) {
	        //e.printStackTrace();
	        System.err.println("Element is not visible after waiting : " + e.getMessage());
	    }
	}

	// Wait for an element to be clickable
	public void waitForElementToBeClickable(WebElement element) {

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    } catch (TimeoutException e) {
	        //e.printStackTrace();
	        System.err.println("Element is not clickable after waiting : " + e.getMessage());
	    }
	}

	// Wait for an element to be invisible
	public void waitForInvisibilityOfElement(WebElement element) {

	    try {
	        wait.until(ExpectedConditions.invisibilityOf(element));
	    } catch (TimeoutException e) {
	        //e.printStackTrace();
	        System.err.println("Element is not invisible after waiting : " + e.getMessage());
	    }
	}
	
	
	
}
