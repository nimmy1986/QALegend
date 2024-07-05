package QATestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import utilities.ExcelUtility;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QA_Automation_Core.QABase;

public class UsersPageTest extends QABase
{
	@Test
	public void verifySearchUser()
	{
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		String searched_user=ExcelUtility.readStringData(0, 0, Constants.USERSPAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterusername(username);
        login.enterpassword(password);
        
        Homepage home=login.clickonloginbutton();
        home.clickonendtour();
        
        userManagementpage usermanagement=home.clickUserManagement();
        //usermanagement.waitforusers();
        
		UsersPage userspage= usermanagement.clickon_users();
		userspage.enter_email_insearchfield(searched_user);
		String found_user= userspage.FoundUser();
		
		Assert.assertEquals(searched_user, found_user, Messages.INVALID_USER);
	}
}
