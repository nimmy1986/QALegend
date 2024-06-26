package QATestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CONSTANTS.Constants;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QAUtilities.QAExcelUtility;
import QAUtilities.QARandomDataUtility;
import QAUtilities.Wait_Utility;
import QA_Automation_Core.QABase;

public class UsersPageTest extends QABase
{
	@Test
	public void verifySearchUser() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		String username=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		String searched_user=QAExcelUtility.readStringData(0, 0, Constants.USERSPAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterusername(username);
        login.enterpassword(password);
        
        Homepage home=login.clickonloginbutton();
        home.clickonendtour();
        
        userManagementpage usermanagement=home.clickUserManagement();
        usermanagement.waitforusers();
        
		UsersPage userspage= usermanagement.clickon_users();
		userspage.enter_email_insearchfield(searched_user);
		userspage.waitforusers();
		String found_user= userspage.FoundUser();
		Assert.assertEquals(searched_user, found_user,"invalid user");
		
	}
}
