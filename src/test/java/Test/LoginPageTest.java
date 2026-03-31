package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.basetest.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@BeforeMethod
	public void setupPage() {
		 
		homepage.openSignInPage();
		
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

		Assert.assertEquals(registrationpage.getTitle(), "Amazon Registration", "--Page Title does not Match--");
	}
	
	@Test
	
	public void backAndForthScenerioTest() {
		
		basepage.navigateBack();
		Assert.assertEquals(homepage.getTitleOfThePage(), null);
		basepage.navigateForward();
		Assert.assertEquals(loginpage.getTitleOfThePage(), "Amazon Sign in");
		basepage.refreshPage();
		Assert.assertEquals(loginpage.getTitleOfThePage(), "Amazon Sign in");
		
		
	}
	
	/*
	 * @Test
	 * 
	 * public void signWithUnregisteredEmailId() {
	 * 
	 * loginpage.enterEmailId("abc@test.com"); loginpage.clickOnContinueButton();
	 * Assert.assertEquals(loginpage.getUnregisteredEmailIdError()
	 * ,"We cannot find an account with that email address");
	 * 
	 * }
	 */
	
	
	/*
	 * @Test public void signWithInvalidEmailIdTest() {
	 * 
	 * loginpage.enterEmailId("abc@test"); loginpage.clickOnContinueButton();
	 * Assert.assertEquals(loginpage.getUnregisteredEmailIdError()
	 * ,"Wrong or Invalid email address or mobile phone number");
	 * 
	 * }
	 */

	
	@Test
	public void  signWithValidCredentialsTest() {
		
		loginpage.signInWithValidCredentials("abc@test","dasdadas");
		loginpage.clickOnContinueButton();
		
	}
	
	@Test
	public void  fieldsOnThePageTest() {
		
		loginpage.clickOnContinueButton();
		
	}
	
	
	
	
	
	

	
		
	
		
		
	

}
