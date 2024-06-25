package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage 
{
	WebDriver driver;
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotpasswordlink;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailaddressfield;
	
	@FindBy(xpath="//button[@class='btn btn-primary']") 
	WebElement passwordresetbutton;
	
	@FindBy(xpath="//span[@class='help-block']//strong")
	WebElement errormessage;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successmessage;
	
	public void clickonforgotpasswordlink()
	{
		forgotpasswordlink.click();
	}
	public void enteremailid(String emailid)
	{
		emailaddressfield.sendKeys(emailid);
	}
	public void clickonpasswordresetbutton()
	{
		passwordresetbutton.click();
	}
	public String geterrormessage()
	{
		return errormessage.getText();
	}
	public String getsuccessmessage() 
	{
		return successmessage.getText();
	}
	

}
