package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CourseSearchPage;
import pages.EnrollCoursePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

public class SearchResultTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	CourseSearchPage CourseSearchPageObject;
	SearchResultPage SearchResultPageObject;
	EnrollCoursePage EnrollCoursePageObject;

	
	@BeforeClass
	public void BeforeHome() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		CourseSearchPageObject = new CourseSearchPage(driver);
		WaitElementToBeVisible(CourseSearchPageObject.searchBarTXB);
		SearchResultPageObject = new SearchResultPage(driver);
		EnrollCoursePageObject = new EnrollCoursePage(driver);
	}
	
	@AfterClass(enabled = false)
	public void LogOutAfterClass() 
	{
		LoginPageObject.LogOut();
	}
	
	@Test(priority = 1)
	public void CreateOrViewCourseHappyScienarioDependsOnTheSearchResult() 
	{
		CourseSearchPageObject.SearchCourse("Course");
		SearchResultPageObject.CreateOrViewCourseDependsOnTheSearchResult(SearchResultPageObject.SearchCourseResultText, "No matching courses found.");
		AssertElementContainText(EnrollCoursePageObject.enrollCourseBTN, "Enroll Now");
	}
	
	@Test(priority = 2)
	public void CreateOrViewCourseHappyScienarioDependsOnSearchResultByListCourseCardsIndex() 
	{
		CourseSearchPageObject.SearchCourse("Course");
		SearchResultPageObject.CreateOrViewCourseDependsOnResultsContainCourseCardsOrEmpty(SearchResultPageObject.CourseListOnSearchResult);
		AssertElementContainText(EnrollCoursePageObject.enrollCourseBTN, "View Course");

	}
	
}
