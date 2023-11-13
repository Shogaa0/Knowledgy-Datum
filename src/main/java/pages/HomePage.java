package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	driver.navigate().to("https://knowledgy.ai/");
	}
	
	@FindBy(xpath =  "/html/body/app-root/app-search-result/div/section/div")
	public WebElement SearchParentIndicator;
	
	@FindBy(xpath =  "//button[@name='login header']")
	WebElement headerLoginBTN;
	
	@FindBy(xpath = "/html/body/app-root/app-search-result/div/section/h1")
	public WebElement SearchCourseResult;
	
	
	@FindBy(xpath = "/html/body/app-root/app-search-result/div/section/div/button")
	public WebElement createCourseBTN;
	
	@FindBy(xpath = "/html/body/app-root/app-search-result/div/section/div/div[1]/div[3]/a")
	public WebElement viewCourseBTN;
	
	@FindBy(xpath = "/html/body/app-root/app-creation-content/section/div[3]/div[1]/div/button")
	public WebElement enrollCourseBTN;
	
	@FindBy(name = "HomeContinueLearningBTN")
	public WebElement ContinueLearningBTN;

	public void OpenLoginPage() 
	{
		Clickbutton(headerLoginBTN);
	}
	
	public void CreateCourse() 
	{
		Clickbutton(createCourseBTN);
	}	
	
	public void ViewCourse() 
	{
		Clickbutton(viewCourseBTN);
	}	
	
}

