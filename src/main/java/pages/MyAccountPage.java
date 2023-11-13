package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name  = "firstNameProfile")
	public WebElement firstNameProfileTXB;
	
	@FindBy(name  = "lastNameProfile")
	public WebElement lastNameProfileTXB;
	
	@FindBy(name = "saveProfile")
	public WebElement saveBTN;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-profile/div/div[1]/div/span")
	public WebElement userFullName;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-profile/div/div[1]/form/div[1]/div[1]/mat-form-field/div[2]/div/mat-error")
	public WebElement firstNameProfileTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-profile/div/div[1]/form/div[1]/div[2]/mat-form-field/div[2]/div/mat-error")
	public WebElement lastNameProfileTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer/div/p[4]")
	public WebElement changePasswordTab;
	
	public void ChangeProfileData(String firstName, String lastName) 
	{
		CleartxtBox(firstNameProfileTXB);
		SendText(firstNameProfileTXB, firstName);
		
		CleartxtBox(lastNameProfileTXB);
		SendText(lastNameProfileTXB, lastName);
	}
	

	public void ClickSaveButton() 
	{
		Clickbutton(saveBTN);
	}	
	
	public void OpenChangePasswordPage() 
	{
		Clickbutton(changePasswordTab);
	}	
}
