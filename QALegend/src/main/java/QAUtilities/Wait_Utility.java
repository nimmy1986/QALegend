package QAUtilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utility {
	
	public static final long IMPLICIT_WAIT=10;
	public static final long EXPLICIT_WAIT=30;
	public static final long PAGELOAD_WAIT=20;
	
	
	public static void waitUsingImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForElementTOBeClickableUsingFluentWait(WebDriver driver, WebElement element) 
	{

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(PAGELOAD_WAIT))
				.pollingEvery(Duration.ofSeconds(PAGELOAD_WAIT)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitForElementToBeClickableUsingExplicitWait(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}