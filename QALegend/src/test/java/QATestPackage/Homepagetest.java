package QATestPackage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CONSTANTS.Constants;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import QAUtilities.QAExcelUtility;
import QAUtilities.QARandomDataUtility;
import QA_Automation_Core.QABase;

public class Homepagetest extends QABase
{
	@Test
	public void homepagetitle() throws Exception
	
	{
		driver.get("https://qalegend.com/billing/public/login");
		String username=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		Homepage home=new Homepage(driver);
		login.clickonloginbutton();
		String actualhomepagetitleString=driver.getTitle();
		String expectedhomepagetitle=QAExcelUtility.readStringData(2, 0, Constants.HOMEPAGE);
		
		Assert.assertEquals(actualhomepagetitleString, expectedhomepagetitle, "Title mismatch!!!");
	}
	
	@Test
	public void verifyuserlogindate() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		String username=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);

		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		Homepage home=new Homepage(driver);
		home=login.clickonloginbutton();
		home.clickonendtour();
		String actual_logindate=home.getLoginDate();
		String expected_logindate=home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate,"Login date mismatch");
	}
}
