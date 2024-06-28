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
import CONSTANTS.Messages;
import Page_Object.AddUserPage;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QAUtilities.QAExcelUtility;
import QAUtilities.QARandomDataUtility;
import QA_Automation_Core.QABase;

public class AddUserPageTest extends QABase
{
	@Test
	public void verifyadduser() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		String username=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickonloginbutton();
		
		Homepage home=new Homepage(driver);
		home.clickonendtour();
		
		userManagementpage usermanagement=home.clickUserManagement();
        usermanagement.waitforusers();
        
		UsersPage userspage= usermanagement.clickon_users();
		userspage.clickonAdd();
		
		AddUserPage adduser=new AddUserPage(driver);
		
		String firstname=QARandomDataUtility.getusername();
		String lastname=QARandomDataUtility.getlastname();
		String prefix=QARandomDataUtility.getprefix();
		String email=firstname+"."+lastname+"@gmail.com";
		String username1=firstname+lastname;
		String password1=firstname+"@911";
		String commission=QARandomDataUtility.getPercent();
		
		adduser.enterprefix(prefix);
		adduser.enterfirstname(firstname);
		adduser.enterlastname(lastname);
		adduser.enteremail(email);
		adduser.selectfromdropdownlist();
		adduser.enterusername(username1);
		adduser.enterpassword(password1);
		adduser.confirmpassword(password1);
		adduser.clickon_savebutton();
		
		userspage.enter_email_insearchfield(email);
		userspage.waitforusers();
		String found_email= userspage.FoundUser();
		Assert.assertEquals(email, found_email,"invalid user");
			
	}
	
	@Test
	public void verifynewlyaddeduser() throws Exception
	{

		driver.get("https://qalegend.com/billing/public/home");
		String username=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickonloginbutton();
		
		Homepage home=new Homepage(driver);
		home.clickonendtour();
		
		userManagementpage usermanagement=home.clickUserManagement();
        usermanagement.waitforusers();
        
		UsersPage userspage= usermanagement.clickon_users();
		userspage.clickonAdd();
		
		AddUserPage adduser=new AddUserPage(driver);
		
		String firstname=QARandomDataUtility.getusername();
		String lastname=QARandomDataUtility.getlastname();
		String prefix=QARandomDataUtility.getprefix();
		String email=firstname+"."+lastname+"@gmail.com";
		String username1=firstname+lastname;
		String password1=firstname+"@911";
		String commission=QARandomDataUtility.getPercent();
		
		adduser.enterprefix(prefix);
		adduser.enterfirstname(firstname);
		adduser.enterlastname(lastname);
		adduser.enteremail(email);
		adduser.selectfromdropdownlist();
		adduser.enterusername(username1);
		adduser.enterpassword(password1);
		adduser.confirmpassword(password1);
		adduser.clickon_savebutton();
		adduser.waitforusers();
		driver.navigate().to("https://qalegend.com/billing/public/home");
		//Homepage home1=new Homepage(driver);
		home.clickon_userprofilebutton();
		home.clickon_signout();
		
		login.enterusername(username1);
		login.enterpassword(password1);
		login.clickonloginbutton();
		String actualusername=home.getuserprofiletext();
		String expectedusername=firstname+" "+lastname;
		System.out.println(expectedusername);
		Assert.assertEquals(actualusername, expectedusername, Messages.LOGIN_FAILED);
	}
}
