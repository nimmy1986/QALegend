package QATestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QAUtilities.ExcelUtility;
import QAUtilities.RandomDataUtility;
import QA_Automation_Core.QABase;

public class userManagementpagetest extends QABase
{
	@Test
	public void verifyRolesOptionIsEnabled() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		
		userManagementpage usermanage=home.clickUserManagement();
		boolean rolesisenabledornot=usermanage.role_status();
		Assert.assertTrue(rolesisenabledornot);
	}
	@Test
	public void verifyUsersOptionIsEnabled() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		
		userManagementpage usermanage=home.clickUserManagement();
		boolean userisenabledornot=usermanage.ifElementIsEnabled();
		Assert.assertTrue(userisenabledornot);
	}
}
