package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class BussinessPage extends BaseClass{
	
	public BussinessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}

}
