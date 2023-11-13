package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CourseSearchPage extends PageBase
{
	public CourseSearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/app-root/app-header/div/nav/div[1]/form/p")
	public WebElement CourseNameValidationsError;
	
	@FindBy(name = "search")
	public WebElement searchBarTXB;
	
	public void SearchCourse(String CourseTitle) 
	{
		CleartxtBox(searchBarTXB);
		SendText(searchBarTXB, CourseTitle);
		ClickEnterFromKeyBoardToSubmitOnInput(searchBarTXB);
	}	
	
	public void CheckIfTheSearchedCourseIsNewOrExisted(WebElement ResultText, String IfConditionText,String NewCourseAssertionText, String ExistedCourseAssertionText)
	{
		if (ResultText.getText().contentEquals(IfConditionText))
		{
			AssertElementContainTextFromPageBase(ResultText, NewCourseAssertionText);
		}
		else 
		{
			AssertElementContainTextFromPageBase(ResultText, ExistedCourseAssertionText);
		}
	}	
	
		public void CheckSearchedCoursesResultsContainCourseCardsOrEmpty(List<WebElement> CourseList, WebElement AssetrionElement, String NewCourseAssertionText, String ExistedCourseAssertionText) 
		{
			if(CourseList.isEmpty())	
			{
				AssertElementContainTextFromPageBase(AssetrionElement, NewCourseAssertionText);
			}
			else 
			{
				AssertElementContainTextFromPageBase(AssetrionElement, ExistedCourseAssertionText);
			}
		}
}
