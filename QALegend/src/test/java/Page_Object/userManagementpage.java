package Page_Object;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;
import utilities.WebElement_Utility;

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
	
	@FindBy(xpath="//i[@class='fa fa-user']//following-sibling::span")
	WebElement users;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/roles']//span")
	WebElement roles;
	
	public void clickon_addbutton()
	{
		addbutton.click();
	}

	public UsersPage clickon_users()
	{
		Wait_Utility.waitForElementToBeVisible(driver, users);
		users.click();
		return new UsersPage(driver);
	}

	public void clickon_usermanagementoption()
	{
		usermanagementoption.click();
	}
	public boolean ifElementIsEnabled()
	{
		return WebElement_Utility.isElementEnabled(users);
	}

	public boolean role_status() 
	{
		return WebElement_Utility.isElementEnabled(roles);	
	}
}
