package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase
{

	public ChangePasswordPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(name = "OldPasswordChange")
	WebElement OldPasswordTXB;
	
	@FindBy(name = "NewPasswordChange")
	WebElement NewPasswordTXB;
	
	@FindBy(name = "ConfirmNewPasswordChange")
	WebElement ConfirmNewPasswordTXB;
	
	@FindBy(name = "SaveChangePasswordBTN")
	public WebElement SaveChangePasswordBTN;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-change-password/div/form/div[1]/mat-form-field/div[2]/div/mat-error")
	public WebElement OldPasswordTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-change-password/div/form/p")
	public WebElement OldPasswordTXBNotWrongValidationError;
	
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-change-password/div/form/div[2]/mat-form-field/div[2]/div/mat-error")
	public WebElement NewPasswordTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-my-account/div/mat-drawer-container/mat-drawer-content/div/app-change-password/div/form/div[3]/p")
	public WebElement ConfirmNewPasswordTXBErrors;
	
	public void ChangePassword(String oldPassword, String newPassword, String confirmNewPassword) 
	{
		CleartxtBox(OldPasswordTXB);
		SendText(OldPasswordTXB, oldPassword);
		
		CleartxtBox(NewPasswordTXB);
		SendText(NewPasswordTXB, newPassword);
		
		CleartxtBox(ConfirmNewPasswordTXB);
		SendText(ConfirmNewPasswordTXB, confirmNewPassword);
	}
	
	public void ClickChangePasswordButton() 
	{
		Clickbutton(SaveChangePasswordBTN);
	}		
}
