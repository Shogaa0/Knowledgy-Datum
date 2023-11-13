package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends PageBase
{

	public ForgetPasswordPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/app-root/app-forget-password/section/div/div[1]/div/form/div/mat-form-field/div[2]/div/mat-error")
	public WebElement ForgetPasswordEmailTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-forget-password/section/div/div[1]/div/form/p")
	public WebElement ForgetPasswordEmailNotRegisteredError;
	
	@FindBy(xpath = "/html/body/app-root/app-forgetpassword-otp/section/div/div[1]/div/form/p[1]")
	public WebElement ForgetPasswordOTPCodeTXBErrors;
	
	@FindBy(className = "errorapi")
	public WebElement ForgetPasswordOTPCodeTXBWrongError;
	
	@FindBy(xpath = "/html/body/app-root/app-resetpassword/section/div/div[1]/div/form/div[1]/mat-form-field/div[2]/div/mat-error")
	public WebElement ForgetPasswordNewPasswordTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-resetpassword/section/div/div[1]/div/form/p")
	public WebElement ForgetPasswordConfirmNewPasswordTXBErrors;
	
	@FindBy (name = "emailforgetpassword")
	WebElement forgetPasswordEmailTXB;
	
	@FindBy (name = "submit forgetpassword")
	WebElement forgetPasswordContinueBTN;
	
	@FindBy (xpath = "/html/body/app-root/app-forgetpassword-otp/section/div/div[1]/div/form/code-input/span[1]/input")
	public WebElement OTBCodeTXB;
	
	@FindBy (name = "Verify")
	public WebElement OTBCodeVerifyBTN;
	
	@FindBy (name = "password resetpassword")
	public WebElement forgetResetPasswordTXT;
	
	@FindBy (name = "password_confirmation resetpassword")
	WebElement forgetResetConfirmPasswordTXT;
	
	@FindBy (name = " submit Reset password")
	public WebElement ResetPasswordSubmitBTN;
	
	public void ForgotPassword (String ForgotEmail)
	{
		CleartxtBox(forgetPasswordEmailTXB);
		SendText(forgetPasswordEmailTXB, ForgotEmail);
		Clickbutton(forgetPasswordContinueBTN);
	}
	
	public void ForgetPasswordOTB(String OTB) 
	{
		SendText(OTBCodeTXB, OTB);
		Clickbutton(OTBCodeVerifyBTN);
	}

	public void ForgetResetPassword(String NewPassword, String NewConfirmPassword) 
	{
		CleartxtBox(forgetResetPasswordTXT);
		SendText(forgetResetPasswordTXT, NewPassword);
		CleartxtBox(forgetResetConfirmPasswordTXT);
		SendText(forgetResetConfirmPasswordTXT, NewConfirmPassword);
		Clickbutton(ResetPasswordSubmitBTN);
	}
}
