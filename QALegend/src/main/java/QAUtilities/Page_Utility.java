package QAUtilities;

import org.openqa.selenium.WebElement;
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
	
	public static void selectByRoleIndex(WebElement element)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	
}

