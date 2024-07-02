package QATestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import QAUtilities.ExcelUtility;
import QA_Automation_Core.QABase;

public class Homepagetest extends QABase
{
	@Test
	public void homepagetitle() throws Exception
	{
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickonloginbutton();
		String actualhomepagetitleString=driver.getTitle();
		String expectedhomepagetitle=ExcelUtility.readStringData(2, 0, Constants.HOMEPAGE);
		
		Assert.assertEquals(actualhomepagetitleString, expectedhomepagetitle, Messages.HOME_TITLEMISMATCH);
	}
	
	@Test
	public void verifyuserlogindate() throws Exception
	{
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);

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
