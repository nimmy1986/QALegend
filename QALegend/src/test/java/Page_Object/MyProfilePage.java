package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage 
{
	WebDriver driver;
	public MyProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastnamefield;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement updatebutton;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
		
	public void clearlastnamefield()
	{
		lastnamefield.clear();
	}
	public void editlastnamefield(String editlastname)
	{
		lastnamefield.sendKeys(editlastname);
	}
	public void clickon_updatebutton()
	{
		updatebutton.click();
	}
	public String getfirstnametext()
	{
		return firstname.getAttribute("value");
	}
	public String getlastnametext()
	{
		return lastnamefield.getText();
	}
}
