package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.basetest.BaseTest;
import com.amazon.pages.HomePage;
import com.amazon.pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeMethod
	public void setupPage() {
	    homepage = new HomePage(driver);           // driver from BaseTest
	    registrationpage = new RegistrationPage(driver);
	    homepage.openRegistrationPage();   
	    // navigate to registration page
	}
	
	/*
	 * @Test
	 * 
	 * public void logoPresentTest() {
	 * 
	 * Assert.assertTrue(registrationpage.verifyLogo(), "--Logo is not Present--");
	 * }
	 */
	
	@Test

	public void pageTitleTest() {
		String title = registrationpage.getTitle();
		Assert.assertEquals(title, "Amazon Sign-In", "--Page Title does not Match--");
	}

	@Test

	public void verifyMobileNumberTest() {
		loginpage.enterEmailId("varun.18bce1089@gmail.com");
		loginpage.clickOnContinueButton();
		String text=registrationpage.getTextLooksLikeNewToAmazon();
		Assert.assertEquals(text, "It looks like you are new to Amazon","Text are not matching");
		registrationpage.clickOnProceedToCreateAnAccountButton();
		String text2=registrationpage.getCreateAccountText();
		Assert.assertEquals(text, "Create Account","Text are not matching");
		registrationpage.checkMobileNumberFunctionality("7905409667","Varun","dzfgdr12");
		
	}
	

	/*
	 * @Test
	 * 
	 * public void siginLinkTest() {
	 * 
	 * registrationpage.clickOnSignInLink();
	 * Assert.assertEquals(registrationpage.getTitle(), "Amazon Sign In",
	 * "--Page Title does not Match--"); }
	 * 
	 * 
	 * @Test public void createBussinessAccountLinkTest() {
	 * 
	 * registrationpage.clickOnCreateBussinessLinkTest();
	 * Assert.assertEquals(registrationpage.getTitle(), "Amazon Bussiness",
	 * "--Page Title does not Match--"); }
	 * 
	 * @Test public void verifyPresenceOfElementOnPage() {
	 * 
	 * registrationpage.verifyPresenceOfElementsOnPage(); }
	 */
}
