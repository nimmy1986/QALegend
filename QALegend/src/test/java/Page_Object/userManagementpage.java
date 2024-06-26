package Page_Object;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QAUtilities.WebElement_Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userManagementpage 
{
	WebDriver driver;
	public userManagementpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement usermanagementoption;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Users')]")
	WebElement usersoption;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;
	
	
	
	public void clickon_addbutton()
	{
		addbutton.click();
	}

	public void clickon_usersoption()
	{
		usersoption.click();
	}
	public void clickon_usermanagementoption()
	{
		usermanagementoption.click();
	}
	public boolean ifElementIsEnabled()
	{
		return WebElement_Utility.isElementEnabled(usersoption);
	}
	
}
