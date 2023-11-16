package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase 
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	RegistrationPage RegisterPageObject;
	
	@BeforeClass
	public void beforRegister() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		WaitTextToPresentedOnElement(LoginPageObject.headerRegisterBTN, "Sign up");
		LoginPageObject.OpenRegisterPage();
		RegisterPageObject = new RegistrationPage(driver);
	}
	
	@BeforeMethod
	public void ScrollUpbeforStart() 
	{
		ScrollUp();
	}

	@Test(enabled  = true, priority = 14)
	public void RegisterHappyScinario() 
	{
		RegisterPageObject.UserRegister("Amr", "Moustafa", "AmrtShogaa0@Mailinator.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(LoginPageObject.SubmitloginBTN, "Log in");
	}

	@Test(enabled = true, priority = 1)
	public void RegisterEmptyFirstName() 
	{
		RegisterPageObject.UserRegister("", "Last Name", "Test@email.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.FirstNameTXBErrors, "Name is required");
	}

	@Test(enabled = true, priority = 2)
	public void RegisterMinFirstName() 
	{
		RegisterPageObject.UserRegister("ab", "Last Name", "Test@email.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.FirstNameTXBErrors, "Name Min length is 3");
	}

	@Test(enabled = true, priority = 3)
	public void RegisterMaxFirstName() 
	{
		RegisterPageObject.UserRegister("ababababab ababababab ababababab", "Last Name", "Test@email.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.FirstNameTXBErrors, "Name Max length is 30");
	}

	@Test(enabled = true, priority = 4)
	public void RegisterEmptyLastName() 
	{
		RegisterPageObject.UserRegister("First Name", "", "abc@dsd.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.LastNameTXBErrors, "Last name is required");
	}

	@Test(enabled = true, priority = 5)
	public void RegisterMinLastName() 
	{
		RegisterPageObject.UserRegister("First Name", "ac", "abc@dsd.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.LastNameTXBErrors, "Last name Min length is 3");
	}

	@Test(enabled = true, priority = 6)
	public void RegisterMaxLastName() 
	{
		RegisterPageObject.UserRegister("First Name", "ababababab ababababab ababababab", "abc@dsd.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.LastNameTXBErrors, "Last name Max length is 30");
	}

	@Test(enabled = true, priority = 7)
	public void RegisterEmptyEmail() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.EmailTXBErrors, "Email is required");
	}
	
	@Test(enabled = true, priority = 8)
	public void RegisterValidEmail() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "ab@cd", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.EmailTXBErrors, "Enter valid email");
	}
	
	@Test(enabled = true, priority = 9)
	public void RegisterEmailLreadyExist() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "Sh6@mailinator.com", "11112222", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.EmailHasBeenTakenError, "The email has already been taken.");
	}

	@Test(enabled = true, priority = 10)
	public void RegisterEmptyPassword() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "asd@shs.com", "", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.PasswordTXBErrors, "Password is required");
	}
	
	@Test(enabled = true, priority = 11)
	public void RegisterMinLengthPassword() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "asd@shs.com", "1111", "11112222");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.PasswordTXBErrors, "Password less than 8 chars");
	}
	
	@Test(enabled = true, priority = 12)
	public void RegisterEmptyConfirmPassword() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "asd@shs.com", "11112222", "");
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.ConfirmPasswordEmptyError, "Password is required");
	}
	
	@Test(enabled = true, priority = 13)
	public void RegisterMatchConfirmPassword() 
	{
		RegisterPageObject.UserRegister("First Name", "LastName", "asd@shs.com", "11112222", "11111111");
		ScrollDown();
		ScrollDown();
		WaitElementToBeClickable(RegisterPageObject.confirmSignUpBTN);
		RegisterPageObject.ClickSignupButton();
		AssertElementContainText(RegisterPageObject.ConfirmPasswordMatchError, "Password does not match");
	}
}
