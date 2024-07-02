package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import QAUtilities.Wait_Utility;

public class UsersPage 
{
	
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchfield;
	
	@FindBy(xpath="//*[@id=\"users_table\"]/tbody/tr/td[4]")
	WebElement found_user;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	WebElement Addbutton;
	
	@FindBy(className = "toast-success")
	WebElement success_message;

	public void enter_email_insearchfield(String searched_user) 
	{
		searchfield.sendKeys(searched_user);	}
	public String FoundUser() 
	{
		return found_user.getText();
	}
	public void waitforusers() 
	{
		Wait_Utility.waitForElementToBeVisible(driver, found_user);
	}
	public AddUserPage clickonAdd() 
	{
		Addbutton.click();
		return new AddUserPage(driver);
	}
	public String waitForTextToBeInvisible() 
	{
		String msg_text = success_message.getText();
		Wait_Utility.waitForElementToBeInvisible(driver, success_message);
		return msg_text;
	}
}
