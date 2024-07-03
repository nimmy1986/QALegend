package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class Homepage
{
	
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtourbutton;
	

	@FindBy(tagName="h1")
	WebElement welcometext;
	
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
	WebElement logindate;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//span")
	WebElement Userprofilebutton;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-flat'and@href='https://qalegend.com/billing/public/user/profile']")
	WebElement profilebutton;
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signout;
	
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_datefield;
	
	public void clickonendtour()
	{
		endtourbutton.click();
	}

	public String getwelcometext()
	{
		return welcometext.getText();
	}
	
	public void clickon_userprofilebutton()
	{
		Userprofilebutton.click();
	}
	
	public MyProfilePage clickon_profilebutton()
	{
		profilebutton.click();
		return new MyProfilePage(driver);
	}
	
	public String getuserprofiletext()
	{
		return Userprofilebutton.getText();
	}

	public userManagementpage clickUserManagement() 
	{
		user_management.click();
		return new userManagementpage(driver);
	}
	
	public LoginPage clickon_signout() 
	{
		signout.click();
		return new LoginPage(driver);
	}

	public String getLoginDate()
	{
		String login_date=login_datefield.getText();
		return login_date;
	}
	
	public String getCurrentDate()
	{
		String current_date = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return current_date;
	}

	
}
