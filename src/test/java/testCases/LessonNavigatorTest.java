package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CourseSearchPage;
import pages.EnrollCoursePage;
import pages.HomePage;
import pages.LessonNavigatorPage;
import pages.LoginPage;
import pages.SearchResultPage;

public class LessonNavigatorTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	CourseSearchPage CourseSearchPageObject;
	SearchResultPage SearchResultPageObject;
	EnrollCoursePage EnrollCoursePageObject;
	LessonNavigatorPage LessonNavigatorPageObject;
	
	@BeforeClass
	public void BeforeHome() throws InterruptedException 
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		CourseSearchPageObject = new CourseSearchPage(driver);
		WaitElementToBeVisible(CourseSearchPageObject.searchBarTXB);
		CourseSearchPageObject.SearchCourse("Banking");
		SearchResultPageObject = new SearchResultPage(driver);
		SearchResultPageObject.CreateOrViewCourseDependsOnTheSearchResult(SearchResultPageObject.SearchCourseResultText, "No matching courses found.");
		EnrollCoursePageObject = new EnrollCoursePage(driver);
		EnrollCoursePageObject.ClickEnrollBTN();
		LessonNavigatorPageObject = new LessonNavigatorPage(driver);
		Thread.sleep(3000);
		scrollToElementByJS(LessonNavigatorPageObject.ButtonsGroup);
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void SimplifyLesson() throws InterruptedException 
	{
		LessonNavigatorPageObject.ClickSimplifyBTN();
		WaitElementToBeVisible(LessonNavigatorPageObject.LessonHelperTitle);
		AssertElementContainText(LessonNavigatorPageObject.LessonHelperTitle, "Simplified");
	}
	
	@Test(priority = 2)
	public void GetReferencesForLesson() throws InterruptedException 
	{
		LessonNavigatorPageObject.ClickGetReferencesBTN();
		WaitElementToBeVisible(LessonNavigatorPageObject.LessonHelperTitle);
		AssertElementContainText(LessonNavigatorPageObject.LessonHelperTitle, "References");
	}
	
	@Test(priority = 3)
	public void ExamplesOnLesson() throws InterruptedException 
	{
		LessonNavigatorPageObject.ClickExamplesBTN();
		WaitElementToBeVisible(LessonNavigatorPageObject.LessonHelperTitle);
		AssertElementContainText(LessonNavigatorPageObject.LessonHelperTitle, "Example");
	}
	
	@Test(priority = 4)
	public void QuizzesOnLesson() throws InterruptedException 
	{
		LessonNavigatorPageObject.ClickQuizzesBTN();
		WaitElementToBeVisible(LessonNavigatorPageObject.LessonHelperTitle);
		AssertElementContainText(LessonNavigatorPageObject.LessonHelperTitle, "Evaluate your knowledge with a quick test.");
	}
	
	@Test(priority = 5)
	public void AskQuestionِOnLessonHappyScinario() throws InterruptedException 
	{
		LessonNavigatorPageObject.AskQuestion("what was the introduction talking about");
		WaitElementToBeVisible(LessonNavigatorPageObject.LessonHelperTitle);
		AssertElementContainText(LessonNavigatorPageObject.LessonHelperTitle, "Answer");
	}
	
	@Test(priority = 6)
	public void AskQuestionِOnLessonEmpty() throws InterruptedException 
	{
		LessonNavigatorPageObject.AskQuestion("");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Please enter a question");
	}
	
	@Test(priority = 7)
	public void AskQuestionِOnLessonMinLength() throws InterruptedException 
	{
		scrollToElementByJS(LessonNavigatorPageObject.QuestionTXB);
		LessonNavigatorPageObject.AskQuestion("ab");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Min length is 3");
	}
	
	@Test(priority = 8)
	public void AskQuestionِOnLessonMaxLength() throws InterruptedException 
	{
		scrollToElementByJS(LessonNavigatorPageObject.QuestionTXB);
		LessonNavigatorPageObject.AskQuestion("aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc aaaaaaaabc");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Max length is 100");
	}
	
	@Test(priority = 9)
	public void AskQuestionِOnLessonNumbersOnly() throws InterruptedException 
	{
		scrollToElementByJS(LessonNavigatorPageObject.QuestionTXB);
		LessonNavigatorPageObject.AskQuestion("123456789");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Please Insert a Valid question");
	}
	
	@Test(priority = 10)
	public void AskQuestionِOnLessonFirstCharNumber() throws InterruptedException 
	{
		scrollToElementByJS(LessonNavigatorPageObject.QuestionTXB);
		LessonNavigatorPageObject.AskQuestion("1Course");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "The question should start with Alphabetical char");
	}
	
	@Test(priority = 11)
	public void AskQuestionِOnLessonSpecialChar() throws InterruptedException 
	{
		scrollToElementByJS(LessonNavigatorPageObject.QuestionTXB);
		LessonNavigatorPageObject.AskQuestion("Course@Test");
		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Special chars are not allowed");
	}
	
	@Test(priority = 12, enabled = false)
	public void MarkComplete() throws InterruptedException 
	{
		Thread.sleep(3000);
//		ScrollDown();
//		WaitElementToBeVisible(LessonNavigatorPageObject.MarkCompleteBTN);
//		WaitThePresenceOfAllElementsOnThePage();
		ScrollDown();
		Thread.sleep(2000);
//		CheckifTheElementIsVisibleToClickOnIt(LessonNavigatorPageObject.MarkCompleteBTN, LessonNavigatorPageObject.MarkCompleteBTN);
        WebElement markCompleteCheckBox = driver.findElement(By.xpath("/html/body/app-root/app-topic-detail/div/div/div[2]/div/div[1]/mat-accordion/mat-expansion-panel[1]/div/div/ul/div[2]/li"));
        String ariaHiddenValue = markCompleteCheckBox.getAttribute("markcomplet");
        	if ("true".equals(ariaHiddenValue)) 
        	{
            // If aria-hidden is true, assert that the Mark complete button is not visible
        		assertElementNotVisible(LessonNavigatorPageObject.MarkCompleteBTN);
//        		AssertElementnotdisplayed(LessonNavigatorPageObject.MarkCompleteBTN);
//            assert !LessonNavigatorPageObject.MarkCompleteBTN.isDisplayed();
        	}	
            else 
            {
                // If aria-hidden is false, click on the Mark complete button
                LessonNavigatorPageObject.ClickMarkCompleteBTN();

                // Rest of your test logic goes here after clicking the element
            }
//		ScrollToView(LessonNavigatorPageObject.MarkCompleteBTN);
//		WaitElementToBeVisible(LessonNavigatorPageObject.SimplifyBTN);
//		LessonNavigatorPageObject.AskQuestion("Course@Test");
//		AssertElementContainText(LessonNavigatorPageObject.AskQuestionErrors, "Special chars are not allowed");
		ScrollDown();
	}
}
