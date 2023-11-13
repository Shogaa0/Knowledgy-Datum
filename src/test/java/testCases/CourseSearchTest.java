package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.CourseSearchPage;
import pages.SearchResultPage;

public class CourseSearchTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	CourseSearchPage CourseSearchPageObject;
	SearchResultPage SearchResultPageObject;
	
	@BeforeClass
	public void BeforeHome() 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		CourseSearchPageObject = new CourseSearchPage(driver);
		SearchResultPageObject = new SearchResultPage(driver);
		WaitElementToBeVisible(CourseSearchPageObject.searchBarTXB);		
	}
	
	@AfterClass(enabled = true)
	public void LogOutAfterClass() 
	{
		LoginPageObject.LogOut();
	}
		
	@Test(priority = 7)
	public void SearchCourseHappyScienarioByCheckingOnSearchResultByText() 
	{
		CourseSearchPageObject.SearchCourse("Course");
		CourseSearchPageObject.CheckIfTheSearchedCourseIsNewOrExisted(SearchResultPageObject.SearchCourseResultText, "No matching courses found.", "No matching courses found.", "results");
	}
	
	@Test(priority = 8)
	public void SearchCourseHappyScienarioByCheckOnSearchResultByListCourseCardsIndex() 
	{
		CourseSearchPageObject.SearchCourse("Pyramids Building");
		CourseSearchPageObject.CheckSearchedCoursesResultsContainCourseCardsOrEmpty(SearchResultPageObject.CourseListOnSearchResult, SearchResultPageObject.SearchCourseResultText, "No matching courses found.", "results");
		System.out.println("The List Size is: " + SearchResultPageObject.CourseListOnSearchResult.size());
	}
	
	@Test(priority = 1)
	public void EmptyCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Enter the name of the course");
	}
	
	@Test(priority = 2)
	public void MinLengthCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("Ab");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Minimum Course Name is 3 characters");
	}
	
	@Test(priority = 3)
	public void MaxLengthCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("Abasdfasdf Abasdfasdf Abasdfasdf Abasdfasdf Abasdfasdf");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Maximum Course Name is 50 characters");
	}
	
	@Test(priority = 4)
	public void NumbersOnlyCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("123456");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Please enter a valid course name");
	}
	
	@Test(priority = 5)
	public void FirstCharNumberCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("12Course");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Course name should start with Alphabetical Letter");
	}
	
	@Test(priority = 6)
	public void SpecialCharNumberCourseNameError() 
	{
		CourseSearchPageObject.SearchCourse("as@course");
		AssertElementContainText(CourseSearchPageObject.CourseNameValidationsError, "Course name couldn’t contain a special character");
	}
}
