package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonNavigatorPage extends PageBase
{

	public LessonNavigatorPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath =  "/html/body/app-root/app-topic-detail/div/div/div[1]/p")
	public WebElement LessonNavigatorText;
                  
	@FindBy(xpath =  "/html/body/app-root/app-topic-detail/div/div/div[2]/div/div[2]/div/div[9]/h3")
	public WebElement LessonHelperTitle;
	
	@FindBy(css =  "div.buttongroub")
	public WebElement ButtonsGroup;
	
	@FindBy(name =  "AskQuestionErrors")
	public WebElement AskQuestionErrors;
	
	@FindBy(name =  "SimplifyBTN")
	public WebElement SimplifyBTN;
	
	@FindBy(name =  "GetReferencesBTN")
	public WebElement GetReferencesBTN;
	
	@FindBy(name =  "ExamplesBTN")
	public WebElement ExamplesBTN;
	
	@FindBy(name =  "QuizzesBTN")
	public WebElement QuizzesBTN;
	
	@FindBy(name =  "question")
	public WebElement QuestionTXB;
	
	@FindBy(name =  "AskQuestionBTN")
	public WebElement AskQuestionBTN;
	
	@FindBy(name =  "MarkCompleteBTN")
	public WebElement MarkCompleteBTN;
	
	@FindBy(name =  "PreviousLessonBTN")
	public WebElement PreviousLessonBTN;
	
	@FindBy(name =  "NextLessonBTN")
	public WebElement NextLessonBTN;
	
	public void ClickSimplifyBTN() 
	{
		Clickbutton(SimplifyBTN);
	}
	
	public void ClickGetReferencesBTN() 
	{
		Clickbutton(GetReferencesBTN);
	}
	
	public void ClickExamplesBTN() 
	{
		Clickbutton(ExamplesBTN);
	}
	
	public void ClickQuizzesBTN() 
	{
		Clickbutton(QuizzesBTN);
	}
	
	public void AskQuestion(String QuestionText) 
	{
		CleartxtBox(QuestionTXB);
		SendText(QuestionTXB, QuestionText);
		Clickbutton(AskQuestionBTN);
	}
	
	public void ClickMarkCompleteBTN() 
	{
		Clickbutton(MarkCompleteBTN);
	}

	public void GoToNextLesson() 
	{
		Clickbutton(NextLessonBTN);
	}
	
	public void GoToPreviousLesson() 
	{
		Clickbutton(PreviousLessonBTN);
	}

//	public void CheckIfElementisVisiableToClick() 
//	{
//		if (condition) {
//			
//		}
//		
//	}
}
