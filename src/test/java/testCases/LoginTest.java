package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase 
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	
	@BeforeClass
	public void beforlogin() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);					
	}

	@Test(priority = 7)
	public void LoginHappyScienario() 
	{
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		AssertElementContainText(HomePageObject.ContinueLearningBTN, "Continue Learning");
		LoginPageObject.LogOut();
	}
	
	@Test(priority = 1)
	public void LoginEmptyEmail() 
	{
		LoginPageObject.Login("", "11112222");
		AssertElementContainText(LoginPageObject.LoginEmailTXBErrors, "Email is required");
	}
	
	@Test(priority = 2)
	public void LoginValidEmail()
	{
		LoginPageObject.Login("ab@cd", "11112222");
		AssertElementContainText(LoginPageObject.LoginEmailTXBErrors, "Enter valid email");
	}
	
	@Test(priority = 3)
	public void LoginEmptyPassword()
	{
		LoginPageObject.Login("Sh6@mailinator.com", "");
		AssertElementContainText(LoginPageObject.LoginPasswordTXBErrors, "Password is required");
	}
	
	@Test(priority = 4)
	public void LoginMinLengthPassword() 
	{
		LoginPageObject.Login("Sh6@mailinator.com", "1111");
		AssertElementContainText(LoginPageObject.LoginPasswordTXBErrors, "Password less than 8 chars");
	}
	
	@Test(priority = 5)
	public void LoginWrongPassword()
	{
		LoginPageObject.Login("Sh6@mailinator.com", "11111111");
		AssertElementContainText(LoginPageObject.LoginWrongEmailorPasswordError, "Incorect email or password!");
	}
	
	@Test(priority = 6)
	public void LoginWrongEmail() 
	{
		LoginPageObject.Login("Sh6ha01vl@mailinator.com", "11112222");
		AssertElementContainText(LoginPageObject.LoginWrongEmailorPasswordError, "Incorect email or password!");
	}
}
