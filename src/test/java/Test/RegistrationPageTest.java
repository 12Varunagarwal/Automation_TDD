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
	    homepage.openRegistrationPage();           // navigate to registration page
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

	    // Click continue with wait
	    loginpage.clickOnContinueButton();

	    // Validate "new to Amazon" text
	    String text = registrationpage.getTextLooksLikeNewToAmazon();
	    Assert.assertEquals(text, "It looks like you are new to Amazon", "Text are not matching");

	    // Click create account
	    registrationpage.clickOnProceedToCreateAnAccountButton();

	    // Validate Create Account text
	    String text2 = registrationpage.getCreateAccountText();
	    Assert.assertEquals(text2, "Create Account", "Text are not matching");

	    // Fill mobile number form
	    registrationpage.checkMobileNumberFunctionality("7905409667", "Varun", "dzfgdr12");
	    
		/*
		 * //Validate Solve Puzzle Page and Text String text3 =
		 * registrationpage.getSolvePuzzleText(); Assert.assertEquals(text3,
		 * "Solve this puzzle to protect your account", "Text are not matching");
		 */
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
