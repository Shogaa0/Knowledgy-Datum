package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ForgetPasswordEmailTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	ForgetPasswordPage ForgetPasswordPageObject;
	
	@BeforeClass
	public void BeforeForgetPassword() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.OpenForgetPasswordLink();
		ForgetPasswordPageObject = new ForgetPasswordPage(driver);
	}
	
	@Test(priority = 4)
	public void ForgetPasswordHappyScinario() 
	{
		ForgetPasswordPageObject.ForgotPassword("Sh6@mailinator.com");
		AssertElementContainText(ForgetPasswordPageObject.OTBCodeVerifyBTN, "Verify");
	}
	
	@Test(priority = 1)
	public void ForgetPasswordEmptyEmial() 
	{
		ForgetPasswordPageObject.ForgotPassword("");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordEmailTXBErrors, "Email is required");
	}
	
	@Test(priority = 2)
	public void ForgetPasswordNotValidEmial() 
	{
		ForgetPasswordPageObject.ForgotPassword("aa@bb");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordEmailTXBErrors, "Enter valid email");
	}
	
	@Test(priority = 3)
	public void ForgetPasswordNotRegisteredEmial() 
	{
		ForgetPasswordPageObject.ForgotPassword("aabb@bbaa.com");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordEmailNotRegisteredError, "The selected E-mail is invalid.");
	}
}
