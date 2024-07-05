package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utility 
{
	
	static int index=3;
	public static void selectByValue(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String visibleText)
	{
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public static void selectByRoleIndex(WebElement element,int index)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	
	public static void doubleClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void contextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void drapAndDrop(WebDriver driver, WebElement dragelement, WebElement dropelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).build().perform();
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void simpleAlertWithAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	
}

