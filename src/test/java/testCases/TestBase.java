package testCases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase 
{
		public static WebDriver driver;
		
//		Use to Chose a browser to open and run on it the TestNG.xml file
//		You will need to provide a browser name on the TestNG.xml file
		@BeforeSuite
		@Parameters({"browser"})
		public void StartDriver(@Optional ("chrome") String browserName)
		{
		if (browserName.equalsIgnoreCase("chrome")) 
			{
			driver = new ChromeDriver();
			}
		else if (browserName.equalsIgnoreCase("firefox"))
			{
			driver = new FirefoxDriver();
			}
		else if (browserName.equalsIgnoreCase("ie")) 
			{
			driver = new InternetExplorerDriver();
			}
		else if (browserName.equalsIgnoreCase("edge"))
			{
			driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		}

		@SuppressWarnings("deprecation")
		@BeforeClass
		public void openURL() 
		{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.navigate().to("https://knowledgy.ai/");
		}
		
//		Use To Scroll Up to the Top of the Page
//		nothing is need to be provided on execute, only call the function name
		public void ScrollUp()
		{
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	    }
		
//		Use To Scroll Down to the bottom of the Page
//		nothing is need to be provided on execute, only call the function name
		public void ScrollDown() 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
//		Use To Scroll Up or Down to a specific Element is been shown on the page
//		you will need to provide an element on execute
		public void ScrollToView(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
//		Use To Wait until a Specific Element to be Click-able
//		You will need to provide driver & an Element on execute
		public void WaitElementToBeClickable(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
//		Use To Wait until a Specific Element to be Visible
//		You will need to provide an Element on execute
		public void WaitElementToBeVisible(WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			 wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
//		Use to Click on an element, it will be used on the Page Classes
//		You will need to provide an element
		public static void Clickbutton(WebElement element) 
		{
			element.click();
		}
		
//		Use To Check if  a Specific Element is Visible
//		You will need to provide an Element on execute
		public void CheckifTheElementIsVisibleToClickOnIt(WebElement element, WebElement Button) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			if (wait.until(ExpectedConditions.visibilityOf(element)) != null) 
			{
				Clickbutton(Button);
			}
			
		}
		
		public void WaitThePresenceOfAllElementsOnThePage() 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/app-root/app-topic-detail/div/div/div[2]/div/div[2]/div/div[6]/img")));
		}
		
//		Use To Wait until a Specific Text To be Presented on an Element
//		You will need to provide an Element & a String Text that need to be Presented on execute
		public void WaitTextToPresentedOnElement(WebElement element, String text) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
		
//		Use To Wait until a value of Specific Element to returned from APIs...
//		...to be able to take action on the input after the data returned
//		You will need to provide an Element on execute
		public void WaitInputElementNotToBeEmpty(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(element, "value", "")));
		}
		
//		Use To Assert on a Specific Element that it's text contains a specific text
//		You will need to provide an Element & a String Text that need to be compared on execute
		public void AssertElementContainText(WebElement element, String text) 
		{
			assertTrue(element.getText().contains(text));
		}
		
		public void AssertElementnotdisplayed(WebElement element) 
		{
			assertTrue(!element.isDisplayed());
		}
		
		
//		Use to Take ScreenShot if the method failed, this runs Automatically after each method
		@AfterMethod
		public void TakeScrrenShots(ITestResult result) throws IOException 
		{
		if (ITestResult.FAILURE== result.getStatus()) 
			{
			TakesScreenshot ScrShot = (TakesScreenshot)driver;
			File Screens = ScrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screens, new File("./ScreenShots/"+ result.getName() + ".png"));	
			}						
		}
	
		@AfterSuite(enabled = false)
		public void StopDriver()
		{
			driver.quit();
		}
		
		public void ScrollByJS () 
		{
			JavascriptExecutor JS = (JavascriptExecutor) driver;
			JS.executeScript("scrollBy(0,3000)");
		}
		
		public void scrollToElementByJS(WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'instant'})", element);
		}
		
		public void WaitAllElementByJS(WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    long BTNs = (long) js.executeScript("var BTNs = document.getElementsByTagName('button')");
		    
		    }
		public void waitAllButtonsByJS2() throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    boolean areButtonsPresent = (boolean) js.executeScript("return document.getElementsByTagName('button').length > 0;");
		    
		    // Wait until buttons are present on the page
		    while (!areButtonsPresent) {
		        Thread.sleep(500); // Sleep for a short duration before checking again
		        areButtonsPresent = (boolean) js.executeScript("return document.getElementsByTagName('button').length > 0;");
		    }
		}
		
		 public void assertElementNotVisible(WebElement markCompleteBTN) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
		        Boolean  element = wait.until(ExpectedConditions.invisibilityOfElementLocated((By) markCompleteBTN));
		        Assert.assertTrue(element, "Element is not visible");
		 }
}