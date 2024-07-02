package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import QAUtilities.Wait_Utility;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='username']")
	WebElement username_field;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password_field;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement login_button;
	
	
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement errormessage;
	
	public void enterusername(String username)
	{
		Wait_Utility.waitForElementToBeVisible(driver, username_field);
		username_field.sendKeys(username);
	}
	
	public void enterpassword(String password)
	{
		password_field.sendKeys(password);
	}
	
	public Homepage clickonloginbutton()
	{
		login_button.click();
		return new Homepage(driver);
	}
	public String geterrormessage()
	{
		return errormessage.getText();
	}
	
}
