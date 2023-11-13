package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	MyAccountPage MyAccountPageObject;
	
	public void WaitTheFirstNameAndLastNameToReturnValuesFromAPI() 
	{
		WaitInputElementNotToBeEmpty(MyAccountPageObject.firstNameProfileTXB);
		WaitInputElementNotToBeEmpty(MyAccountPageObject.lastNameProfileTXB);
	}
	
	@BeforeClass
	public void beforeOpenMyAccountPage()
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		WaitElementToBeClickable(LoginPageObject.AccountBTN);
		LoginPageObject.OpenMYAccountPage();
		MyAccountPageObject = new MyAccountPage(driver);
	}
	
	@AfterClass
	public void LogOutAfterClass() 
	{
		LoginPageObject.LogOut();
	}
	
	@BeforeMethod
	public void WaitDateToReturnToInputsFromAPI() 
	{
		WaitTheFirstNameAndLastNameToReturnValuesFromAPI();
	}
	@AfterMethod
	public void BeforEachMethodMyAccount() 
	{
		driver.navigate().refresh();
	}
	
	@Test(priority = 7)
	public void EditProfileHappyScienario()
	{	
		MyAccountPageObject.ChangeProfileData("Ssssh6", "Shoooooo6");	
		ScrollDown();		
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();		
		String fullName = MyAccountPageObject.firstNameProfileTXB.getText() + MyAccountPageObject.lastNameProfileTXB.getText();
		AssertElementContainText(MyAccountPageObject.userFullName, fullName);
	}
	
	@Test(priority = 1)
	public void EditProfileFirstNameMinLength() 
	{
		MyAccountPageObject.ChangeProfileData("q", "myLastLast");	
		ScrollDown();
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();
		WaitElementToBeVisible(MyAccountPageObject.firstNameProfileTXBErrors);
		AssertElementContainText(MyAccountPageObject.firstNameProfileTXBErrors, "Name Min length is 3");
	}
	
	@Test(priority = 2)
	public void EditProfileFirstNameMaxLength() 
	{
		MyAccountPageObject.ChangeProfileData("abcabcabcd abcabcabcd abcabcabcd", "myLastLast");	
		ScrollDown();		
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();		
		AssertElementContainText(MyAccountPageObject.firstNameProfileTXBErrors, "Name Max length is 30");
	}
	
	@Test(priority = 3)
	public void EditProfileLeaveFirstNameEmpty() 
	{
		MyAccountPageObject.ChangeProfileData("", "Sara 5");		
		ScrollDown();
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();	
		AssertElementContainText(MyAccountPageObject.firstNameProfileTXBErrors, "Name is required");
	}
	
	@Test(priority = 4)
	public void EditProfileLastNameMinLength() 
	{
		MyAccountPageObject.ChangeProfileData("Ashraf", "my");	
		ScrollDown();		
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();		
		AssertElementContainText(MyAccountPageObject.lastNameProfileTXBErrors, "Last name Min length is 3");
	}
	
	@Test(priority = 5)
	public void EditProfileLastNameMaxLength() 
	{
		MyAccountPageObject.ChangeProfileData("Ashraf", "abcabcabcd abcabcabcd abcabcabcd");	
		ScrollDown();
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();		
		AssertElementContainText(MyAccountPageObject.lastNameProfileTXBErrors, "Last name Max length is 30");
	}
	
	@Test(priority = 6)
	public void EditProfileLeavelastNameEmpty() 
	{
		MyAccountPageObject.ChangeProfileData("Ashraf", "");	
		ScrollDown();
		WaitElementToBeClickable(MyAccountPageObject.saveBTN);
		MyAccountPageObject.ClickSaveButton();
		AssertElementContainText(MyAccountPageObject.lastNameProfileTXBErrors, "Last name is required");
	}
}
