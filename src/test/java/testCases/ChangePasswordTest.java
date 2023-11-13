package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class ChangePasswordTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	MyAccountPage MyAccountPageObject;
	ChangePasswordPage ChangePasswordPageObject;

	@BeforeClass
	public void beforeOpenMyAccountPage() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		LoginPageObject.OpenMYAccountPage();
		MyAccountPageObject = new MyAccountPage(driver);
		MyAccountPageObject.OpenChangePasswordPage();
		ChangePasswordPageObject = new ChangePasswordPage(driver);
	}

	@AfterClass
	public void LogOutAfterClass() 
	{
		LoginPageObject.LogOut();
	}

	@Test(priority = 10)
	public void ChangePasswordHappyScienario()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "22221111", "22221111");
		ScrollDown();
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);		
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(HomePageObject.ContinueLearningBTN, "Continue Learning");
	}

	@Test(priority = 1)
	public void ChangePasswordOldPasswordEmptyError()
	{	
		ChangePasswordPageObject.ChangePassword("", "22221111", "22221111");		
		ScrollDown();		
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.OldPasswordTXBErrors, "Password is required");
	}

	@Test(priority = 2)
	public void ChangePasswordOldPasswordMinLengthError()
	{	
		ChangePasswordPageObject.ChangePassword("2222", "22221111", "22221111");		
		ScrollDown();		
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);		
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.OldPasswordTXBErrors, "Password less than 8 chars");
	}

	@Test(priority = 3)
	public void ChangePasswordOldPasswordNotMatchError()
	{	
		ChangePasswordPageObject.ChangePassword("22224444", "11113333", "11113333");		
		ScrollDown();		
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);		
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.OldPasswordTXBNotWrongValidationError, "the current password is wrong");
	}

	@Test(priority = 4)
	public void ChangePasswordNewPasswordEmptyError()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "", "22221111");		
		ScrollDown();		
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);		
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.NewPasswordTXBErrors, "Password is required");
	}

	@Test(priority = 5)
	public void ChangePasswordNewPasswordMinLengthError()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "1111", "22221111");		
		ScrollDown();		
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);		
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.NewPasswordTXBErrors, "Password less than 8 chars");
	}

	@Test(priority = 6)
	public void ChangePasswordConfirmNewPasswordEmptyError()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "22221111", "");
		ScrollDown();
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.ConfirmNewPasswordTXBErrors, "Password does not match");
	}

	@Test(priority = 7)
	public void ChangePasswordConfirmNewPasswordMinLengthError()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "22221111", "1111");
		ScrollDown();
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.ConfirmNewPasswordTXBErrors, "Password does not match");
	}

	@Test(priority = 8)
	public void ChangePasswordConfirmNewPasswordNotMatchError()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "22221111", "11113333");
		ScrollDown();
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.ConfirmNewPasswordTXBErrors, "Password does not match");
	}

	@Test(priority = 9)
	public void ChangePasswordCurrentPasswordSameNewPassword()
	{	
		ChangePasswordPageObject.ChangePassword("11112222", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(ChangePasswordPageObject.SaveChangePasswordBTN);
		ChangePasswordPageObject.ClickChangePasswordButton();
		AssertElementContainText(ChangePasswordPageObject.OldPasswordTXBNotWrongValidationError, "Please use diffrent password from the current password");
	}
}
