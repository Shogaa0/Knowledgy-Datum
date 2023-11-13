package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnrollCoursePage extends PageBase
{

	public EnrollCoursePage(WebDriver driver) 
	{
		super(driver);
	}
	
	SearchResultPage SearchResultPageObject;


	@FindBy(xpath  = "/html/body/app-root/app-creation-content/section/div[3]/div[1]/div/button")
	public WebElement enrollCourseBTN;
	
	public void ClickEnrollBTN() 
	{
		Clickbutton(enrollCourseBTN);
	}
	
//	public void EnrollOnCourseDependsOnTheSearchResult(WebDriver driver, WebElement ResultText, String IfConditionText)
//	{
//		SearchResultPageObject = new SearchResultPage(driver);
//		if (ResultText.getText().contentEquals(IfConditionText))
//		{
//			SearchResultPageObject.CreateCourse();
//		}
//		else 
//		{
//			SearchResultPageObject.ViewCourse();
//		}
//		ClickEnrollBTN();
//		AssertElementContainTextFromPageBase(AssetrionElement, ButtonAssertionText);
//	}	
}
