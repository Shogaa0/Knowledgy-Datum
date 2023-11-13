package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchResultPage extends PageBase
{

	public SearchResultPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath =  "/html/body/app-root/app-search-result/div/section/div")
	public WebElement SearchResultParentDivThatContainsCards;
	
	@FindBy(className =  "flexitem")
	public List<WebElement> CourseListOnSearchResult;
	
	@FindBy(xpath = "/html/body/app-root/app-search-result/div/section/h1")
	public WebElement SearchCourseResultText;
	
	@FindBy(xpath = "/html/body/app-root/app-search-result/div/section/div/button")
	public WebElement createCourseBTN;

	@FindBy(className = "view")
	public WebElement viewCourseBTN;
	
	public void CreateCourse() 
	{
		Clickbutton(createCourseBTN);
	}	
	
	public void ViewCourse() 
	{
		Clickbutton(viewCourseBTN);
	}	
	
	public void CreateOrViewCourseDependsOnTheSearchResult(WebElement ResultText, String IfConditionText)
	{
		if (ResultText.getText().contentEquals(IfConditionText))
		{
			CreateCourse();
		}
		else 
		{
			ViewCourse();
		}
//		AssertElementContainTextFromPageBase(AssetrionElement, ButtonAssertionText);
	}	
	
	public void CreateOrViewCourseDependsOnResultsContainCourseCardsOrEmpty(List<WebElement> CourseList) 
	{
		if(CourseList.isEmpty()) 
		{
			CreateCourse();
		}
		else 
		{
//			int numb = CourseList.size();
//			Random  random = new Random();
//			int randomIndex = random.nextInt(4, numb);
//			WebElement randomCourseCard = CourseList.get(randomIndex-1);
//			System.out.println("this is the number" +randomIndex);
//			WebElement RandomBTN = randomCourseCard.findElement(By.className("view")); // You can adjust the CSS selector based on your HTML structure
//			ScrollToView(driver, RandomBTN, 60);
//			WaitElementToBeClickableFromPageBse(driver, RandomBTN);
//			Actions actions = new Actions(driver);
//			actions.moveToElement(RandomBTN).click();
			

//			RandomBTN.click();
//			System.out.println("this is the number" +randomIndex);
			ViewCourse();
		}
//		AssertElementContainTextFromPageBase(AssetrionElement, ButtonAssertionText);
	}
}
