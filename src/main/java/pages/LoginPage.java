package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[1]/div/form/div[1]/mat-form-field/div[2]/div/mat-error")
	public WebElement LoginEmailTXBErrors;

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[1]/div/form/div[2]/mat-form-field/div[2]/div/mat-error")
	public WebElement LoginPasswordTXBErrors;

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[1]/div/form/p")
	public WebElement LoginWrongEmailorPasswordError;

	@FindBy(xpath = "/html/body/app-root/app-header/div/nav/div[1]/div/button")
	public WebElement AccountBTN;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/button[1]/span")
	public WebElement MyAccountTabBTN;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/button[4]/span")
	public WebElement LogoutTabBTN;
	
	@FindBy(xpath =  "/html/body/app-root/app-login/section/div/div[1]/div/form/div[4]/p/a")
	WebElement RegisterLNK;
	
	@FindBy(xpath   = "/html/body/app-root/app-header/div/nav/div[1]/div/div/div[1]/button")
	public WebElement headerRegisterBTN;

	@FindBy(name = "emaillogin")
	WebElement loginemailTXB;

	@FindBy(name = "passwordlogin")
	WebElement loginpasswordTXB;

	@FindBy(name = "submit login")
	public WebElement SubmitloginBTN;
	
	@FindBy (xpath = "/html/body/app-root/app-login/section/div/div[1]/div/form/div[3]/a")
	WebElement forgetPasswordLink;

	public void Login(String loginEmail, String loginPassword) 
	{
		CleartxtBox(loginemailTXB);
		SendText(loginemailTXB, loginEmail);
		
		CleartxtBox(loginpasswordTXB);
		SendText(loginpasswordTXB, loginPassword);	
		
		Clickbutton(SubmitloginBTN);
	}
	
	public void OpenMYAccountPage() 
	{
		Clickbutton(AccountBTN);
		Clickbutton(MyAccountTabBTN);
	}

	public void LogOut() 
	{
		Clickbutton(AccountBTN);
		Clickbutton(LogoutTabBTN);
	}

	public void OpenRegisterPage() 
	{
		Clickbutton(headerRegisterBTN);
	}
	
	public void OpenRegisterFromLink() 
	{
		Clickbutton(RegisterLNK);
	}
	
	public void OpenForgetPasswordLink() 
	{
		Clickbutton(forgetPasswordLink);
	}	
}

