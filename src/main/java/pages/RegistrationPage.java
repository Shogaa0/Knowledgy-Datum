package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RegistrationPage extends PageBase
{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[1]/mat-form-field/div[2]/div/mat-error")
	public WebElement FirstNameTXBErrors;

	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[2]/mat-form-field/div[2]/div/mat-error")
	public WebElement LastNameTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[3]/mat-form-field/div[2]/div/mat-error")
	public WebElement EmailTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/p")
	public WebElement EmailHasBeenTakenError;
	
	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[4]/mat-form-field/div[2]/div/mat-error")
	public WebElement PasswordTXBErrors;
	
	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[5]/mat-form-field/div[2]/div/mat-error")
	public WebElement ConfirmPasswordEmptyError;
	
	@FindBy(xpath = "/html/body/app-root/app-register/section/div/div[1]/div/form/div[5]/p")
	public WebElement ConfirmPasswordMatchError;
	
	@FindBy(name  = "first_nameregister")
	public WebElement FirstNameTXB;

	@FindBy(name =  "last_nameregister")
	WebElement LasttNameTXB;

	@FindBy(name =  "emailregister")
	WebElement EmailTXB;

	@FindBy(name =  "passwordregister")
	WebElement PasswordTXB;

	@FindBy(name =  "password_confirmationregister")
	WebElement ConfirmPasswordTXB;

	@FindBy(xpath  =  "//button[@name=' submit Sign up Register']")
	public WebElement confirmSignUpBTN;

	public void UserRegister(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) 
	{
		CleartxtBox(FirstNameTXB);
		SendText(FirstNameTXB, FirstName);

		CleartxtBox(LasttNameTXB);
		SendText(LasttNameTXB, LastName);

		CleartxtBox(EmailTXB);
		SendText(EmailTXB, Email);

		CleartxtBox(PasswordTXB);
		SendText(PasswordTXB, Password);

		CleartxtBox(ConfirmPasswordTXB);
		SendText(ConfirmPasswordTXB, ConfirmPassword);
	}
	
	public void ClickSignupButton()
	{
		Clickbutton(confirmSignUpBTN);
	}
}

