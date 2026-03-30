package com.amazon.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.base.BaseClass;
import com.amazon.pages.RegistrationPage;
import com.amazon.utilities.configReader;
import com.amazon.pages.BussinessPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;

import Test.LoginPageTest;

public class BaseTest {
	
	public BaseClass basepage;
	public WebDriver driver;
	public LoginPage loginpage; 
	public RegistrationPage registrationpage;
	public HomePage homepage;
	public BussinessPage bussinesspage;
	public configReader configreader;
	
	@BeforeMethod
	public void baseSetup() {
		
		basepage = new BaseClass(driver);
		configreader=new configReader();
		String url=configreader.geturl();
		driver.get(url);
		driver=basepage.getDriver(configreader.getbrowser());
		driver.get("url of the app");
		registrationpage = new RegistrationPage(driver);
		loginpage= new LoginPage(driver);
		homepage = new HomePage(driver);
		bussinesspage  = new BussinessPage(driver);
	
		}
		
		@AfterMethod
		
		public void closeBrowser()
		
		{
			basepage.quitDriver();	
		}
		
		
	
	
	
	

}
