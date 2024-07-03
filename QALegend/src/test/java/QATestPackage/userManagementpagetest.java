package QATestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.userManagementpage;
import QA_Automation_Core.QABase;
import qaconstants.Constants;
import qaconstants.Messages;
import utilities.ExcelUtility;

public class userManagementpagetest extends QABase
{
	@Test
	public void verifyRolesOptionIsEnabled() throws Exception
	{
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		
		userManagementpage usermanage=home.clickUserManagement();
		boolean rolesisenabledornot=usermanage.role_status();
		Assert.assertTrue(rolesisenabledornot,Messages.OPTION_NOT_ENABLED);
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
		Assert.assertTrue(userisenabledornot,Messages.OPTION_NOT_ENABLED);
	}
}
