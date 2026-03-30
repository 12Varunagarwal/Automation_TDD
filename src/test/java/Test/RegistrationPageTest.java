package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.basetest.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeMethod

	public void setupPage() {

		homepage.openRegistrationPage();

	}

	@Test

	public void logoPresentTest() {

		Assert.assertTrue(registrationpage.verifyLogo(), "--Logo is not Present--");
	}

	@Test

	public void pageTitleTest() {

		Assert.assertEquals(registrationpage.getTitle(), "Amazon Registration", "--Page Title does not Match--");
	}

	@Test

	public void verifyMobileNumberTest() {

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
