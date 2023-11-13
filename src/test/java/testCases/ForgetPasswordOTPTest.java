package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ForgetPasswordOTPTest extends TestBase
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
		ForgetPasswordPageObject.ForgotPassword("Sh6@mailinator.com");
	}
	
	@Test(priority = 11)
	public void ForgetPasswordHappyScinario() 
	{
		WaitElementToBeVisible(ForgetPasswordPageObject.OTBCodeTXB);
		ForgetPasswordPageObject.ForgetPasswordOTB("111111");
		AssertElementContainText(ForgetPasswordPageObject.ResetPasswordSubmitBTN, "Reset password");
	}
	
	@Test(priority = 4)
	public void ForgetPasswordEmptyOTPCode() 
	{
		WaitElementToBeVisible(ForgetPasswordPageObject.OTBCodeTXB);
		ForgetPasswordPageObject.ForgetPasswordOTB("");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordOTPCodeTXBErrors, "The otp field is required.");
	}
	
	@Test(priority = 5)
	public void ForgetPasswordNotValidOTPCode() 
	{
		WaitElementToBeVisible(ForgetPasswordPageObject.OTBCodeTXB);
		ForgetPasswordPageObject.ForgetPasswordOTB("1111");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordOTPCodeTXBErrors, "Please enter valid OTP");
	}
	
	@Test(priority = 6)
	public void ForgetPasswordWrongOTPCode() 
	{
		WaitElementToBeVisible(ForgetPasswordPageObject.OTBCodeTXB);
		ForgetPasswordPageObject.ForgetPasswordOTB("222222");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordOTPCodeTXBWrongError, "OTP does not match");
	}
}
