package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ForgetPasswordResetPasswordTest extends TestBase
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
		ForgetPasswordPageObject.ForgetPasswordOTB("111111");
	}
	
	@Test(priority = 11)
	public void ForgetPasswordHappyScinario() 
	{
		ForgetPasswordPageObject.ForgetResetPassword("11112222", "11112222");
		AssertElementContainText(LoginPageObject.SubmitloginBTN, "Log in");
	}
	
	@Test(priority = 7)
	public void ForgetPasswordEmptyNewPassword() 
	{
		ForgetPasswordPageObject.ForgetResetPassword("", "11112222");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordNewPasswordTXBErrors, "Password is required");
	}
	
	@Test(priority = 8)
	public void ForgetPasswordMinLengthNewPassword() 
	{
		ForgetPasswordPageObject.ForgetResetPassword("1111", "11112222");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordNewPasswordTXBErrors, "Password less than 8 chars");
	}
	
	@Test(priority = 9)
	public void ForgetPasswordEmptyConfirmNewPassword() 
	{
		ForgetPasswordPageObject.ForgetResetPassword("11112222", "");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordConfirmNewPasswordTXBErrors, "Fill out all the form data correctly");
	}
	
	@Test(priority = 10)
	public void ForgetPasswordNotMatchConfirmNewPassword() 
	{
		ForgetPasswordPageObject.ForgetResetPassword("22223333", "11112222");
		AssertElementContainText(ForgetPasswordPageObject.ForgetPasswordConfirmNewPasswordTXBErrors, "The Password confirmation does not match");
	}
}
