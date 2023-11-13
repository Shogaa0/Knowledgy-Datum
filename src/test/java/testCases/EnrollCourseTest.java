package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CourseSearchPage;
import pages.EnrollCoursePage;
import pages.HomePage;
import pages.LessonNavigatorPage;
import pages.LoginPage;
import pages.SearchResultPage;

public class EnrollCourseTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	CourseSearchPage CourseSearchPageObject;
	SearchResultPage SearchResultPageObject;
	EnrollCoursePage EnrollCoursePageObject;
	LessonNavigatorPage LessonNavigatorPageObject;
	
	@BeforeClass
	public void BeforeHome() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		CourseSearchPageObject = new CourseSearchPage(driver);
		WaitElementToBeVisible(CourseSearchPageObject.searchBarTXB);
		CourseSearchPageObject.SearchCourse("Credit course in banking");
		SearchResultPageObject = new SearchResultPage(driver);
		SearchResultPageObject.CreateOrViewCourseDependsOnTheSearchResult(SearchResultPageObject.SearchCourseResultText, "No matching courses found.");
		EnrollCoursePageObject = new EnrollCoursePage(driver);
		LessonNavigatorPageObject = new LessonNavigatorPage(driver);
	}
	@Test
	public void EnrollOnCourse()
	{
//		EnrollCoursePageObject.EnrollOnCourseDependsOnTheSearchResult(driver, SearchResultPageObject.SearchCourseResultText, "No matching courses found.");
//		WaitElementToBeClickable(EnrollCoursePageObject.enrollCourseBTN);
		EnrollCoursePageObject.ClickEnrollBTN();
		AssertElementContainText(LessonNavigatorPageObject.LessonNavigatorText, "Challenge yourself to complete the lesson and grow professionally.");
	}
}
