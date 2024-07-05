package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utility;
import utilities.Wait_Utility;

public class AddUserPage 
{
	
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement prefixfield; 
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstnamefield;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastnamefield;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	
	@FindBy(xpath="//select[@id='role']")
	WebElement roledropdownlist;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username_field;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password_field;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmpassword_field;
	
	@FindBy(xpath="//input[@id='cmmsn_percent']")
	WebElement cmmsnfield;
	
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement savebutton;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//span")
	WebElement userprofile;
	
	
	
	public void selectfromdropdownlist(int index)
	{
		Page_Utility.selectByRoleIndex(roledropdownlist, index);
		//Select selectobj=new Select(roledropdownlist);
		//selectobj.selectByIndex(1);
	}
	public void enterprefix(String prefix)
	{
		prefixfield.sendKeys(prefix);
	}
	public void enterfirstname(String firstname)
	{
		firstnamefield.sendKeys(firstname);
	}
	public void enterlastname(String lastname)
	{
		lastnamefield.sendKeys(lastname);
	}
	public void enteremail(String email)
	{
		emailfield.sendKeys(email);
	}
	public void enterusername(String username1)
	{
		username_field.sendKeys(username1);
	}
	public void enterpassword(String password1)
	{
		password_field.sendKeys(password1);
	}
	public void confirmpassword(String password1)
	{
		confirmpassword_field.sendKeys(password1);
	}
	public void commisionfield(String commission)
	{
		cmmsnfield.sendKeys(commission);
	}
	public UsersPage clickon_savebutton()
	{
		savebutton.click();
		return new UsersPage(driver);
	}
	public void clickon_userprofile() 
	{
		userprofile.click();
	}
	public void waitforusers() 
	{
		Wait_Utility.waitForElementToBeVisible(driver, userprofile);
	}
	
}
