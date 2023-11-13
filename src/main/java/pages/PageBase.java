package pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase 
{
		public static WebDriver driver;
	
//		Create constructor
		public PageBase (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
//		Use to Submit an Input with a data, it is not used now on any Page class because it's not working need to investigate on it
//		You will need to provide an element
		public static void SubmitOnTXB(WebElement element) 
		{
			element.submit();
		}
		
//		Use to Click on an element, it will be used on the Page Classes
//		You will need to provide an element
		public static void Clickbutton(WebElement element) 
		{
			element.click();
		}
		
//		Use to Simulate Clicking on Enter key from Keyboard, to click enter after typing on input when there is no submit button
//		it will be used on the Page Classes
//		You will need to provide an element
		public static void ClickEnterFromKeyBoardToSubmitOnInput (WebElement element)
		{	
			element.sendKeys(Keys.RETURN);
		}
		
//		Its the Used Method now because its the one working and clear the data from the inputs
//		Use to Clear any value from Input, it will be used on the Page Classes
//		You will need to provide an element
		public static void CleartxtBox (WebElement element)
		{	
			element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		}
		
//		Not used because its not really clear data from input need to investigate on it later on
//		Use to Clear any value from Input, it will be used on the Page Classes
//		You will need to provide an element	
		public static void CleartxtBoxNotWorkingMethod (WebElement element)
		{	
			element.clear();
		}
		
//		Use to Send a value to an Input, it will be used on the Page Classes
//		You will need to provide an element & a string data
		public static void SendText(WebElement element, String value) 
		{
//			System.out.println(value); //Use To Print the Data that is Used on the Console after execute
			element.sendKeys(value);
		}
		
		public void AssertElementContainTextFromPageBase(WebElement element, String text) 
		{
			assertTrue(element.getText().contains(text));
		}
		
		public void WaitElementToBeVisibleFromPageBase(WebDriver driver, WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void WaitElementToBeClickableFromPageBse(WebDriver driver, WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void ScrollToView(WebDriver driver, WebElement element, int offset) 
		{
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({ block: 'end' });", element);
	        js.executeScript("window.scrollBy(0, -arguments[1]);", offset);

//	        js.executeScript("window.scrollBy(0, -arguments[1]);", 100);
		}
}
