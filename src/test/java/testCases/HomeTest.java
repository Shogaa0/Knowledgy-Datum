package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.CourseSearchPage;

public class HomeTest extends TestBase 
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	CourseSearchPage SearchCoursePageObject;
	
	
	@BeforeMethod
	public void BeforeHome() 
	{
		HomePageObject = new HomePage(driver);
		LoginPageObject = new LoginPage(driver);
		SearchCoursePageObject = new CourseSearchPage(driver);
	}
	
	
	@Test
	public void CreateNewCourseLogedInUserHappyScienario() 
	{
		HomePageObject.OpenLoginPage();
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		SearchCoursePageObject.SearchCourse("gravity law");
		HomePageObject.CreateCourse();
		assertTrue(HomePageObject.enrollCourseBTN.getText().contains("Enroll Now"));
	}
	
	@Test
	public void ViewCourseLogedInUserHappyScienario() 
	{
		HomePageObject.OpenLoginPage();
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		SearchCoursePageObject.SearchCourse("Course");
		HomePageObject.ViewCourse();
		assertTrue(HomePageObject.enrollCourseBTN.getText().contains("Enroll Now"));
	}
	
	@Test
	public void ClickButtonBasedOnVisibilityCourse() 
	{
		HomePageObject.OpenLoginPage();
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		SearchCoursePageObject.SearchCourse("Italy Learning");
		try 
		{
			if (HomePageObject.SearchCourseResult.isDisplayed()) 
			{
				HomePageObject.CreateCourse();
			}
		} 
		catch (NoSuchElementException e)
		{
			System.out.println("no element" + e.getMessage());
			HomePageObject.ViewCourse();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		assertTrue(HomePageObject.enrollCourseBTN.getText().contains("Enroll Now"));
	}

	
	@Test(priority = 6)
	public void CheckElementsonparent() 
	{
		HomePageObject.OpenLoginPage();
		LoginPageObject.Login("Sh6@mailinator.com", "11112222");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		SearchCoursePageObject.SearchCourse("course");
		
		List<WebElement> SearchChilds = HomePageObject.SearchParentIndicator.findElements(By.className("flexitem"));
        
		CheckSearchedCoursesResults(SearchChilds);
		
		assertTrue(HomePageObject.enrollCourseBTN.getText().contains("Enroll Now"));

	}
	
	
	public void CheckSearchedCoursesResults(List<WebElement> SearchChilds) {
		int searchChiledSize = SearchChilds.size();
		if(searchChiledSize  == 0) {
			HomePageObject.CreateCourse();
		}else {
			Random random = new Random();
            int randomIndex = random.nextInt(searchChiledSize -1);
            WebElement randomCourseCard = SearchChilds.get(randomIndex);
            System.out.println("Random number: " + randomIndex);
            int randomIndexPlusOne = randomIndex +1;
            WebElement viewCourseButton = randomCourseCard.findElement(By.xpath("/html/body/app-root/app-search-result/div/section/div/div["+randomIndexPlusOne+"]/div[3]/a"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-search-result/div/section/div/div["+randomIndexPlusOne+"]/div[3]/a")));
            viewCourseButton.click();
			
		}
	}
}
