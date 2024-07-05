package QATestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import Page_Object.AddUserPage;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QA_Automation_Core.QABase;

public class AddUserPageTest extends QABase
{
	@Test
	public void verifyadduser()
	{
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		
		userManagementpage usermanagement=home.clickUserManagement();
        
		UsersPage userspage= usermanagement.clickon_users();
		AddUserPage adduser=userspage.clickonAdd();
		
		String firstname=RandomDataUtility.getusername();
		String lastname=RandomDataUtility.getlastname();
		String prefix=RandomDataUtility.getprefix();
		String email=firstname+"."+lastname+Constants.ID;
		String username1=firstname+lastname;
		String password1=firstname+Constants.NUMBER;
		String commission=RandomDataUtility.getPercent();
		
		adduser.enterprefix(prefix);
		adduser.enterfirstname(firstname);
		adduser.enterlastname(lastname);
		adduser.enteremail(email);
		int index=RandomDataUtility.getindex();
		adduser.selectfromdropdownlist(index);
		adduser.enterusername(username1);
		adduser.enterpassword(password1);
		adduser.confirmpassword(password1);
		adduser.commisionfield(commission);
		adduser.clickon_savebutton();
		
		userspage.enter_email_insearchfield(email);
		String found_email= userspage.FoundUser();
		Assert.assertEquals(email, found_email,Messages.USER_NOT_FOUND);
	}
	
	@Test
	public void verifynewlyaddeduser()
	{
		
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		
		userManagementpage usermanagement=home.clickUserManagement();
        //usermanagement.waitforusers();
        
		UsersPage userspage= usermanagement.clickon_users();
		userspage.clickonAdd();
		
		AddUserPage adduser=userspage.clickonAdd();
		
		String firstname=RandomDataUtility.getusername();
		String lastname=RandomDataUtility.getlastname();
		String prefix=RandomDataUtility.getprefix();
		String email=firstname+"."+lastname+ Constants.ID;
		String username1=firstname+lastname;
		String password1=firstname+ Constants.NUMBER;
		String commission=RandomDataUtility.getPercent();
		
		adduser.enterprefix(prefix);
		adduser.enterfirstname(firstname);
		adduser.enterlastname(lastname);
		adduser.enteremail(email);
		int index=RandomDataUtility.getindex();
		adduser.selectfromdropdownlist(index);
		adduser.enterusername(username1);
		adduser.enterpassword(password1);
		adduser.confirmpassword(password1);
		adduser.commisionfield(commission);
		adduser.clickon_savebutton();
		userspage.waitForTextToBeInvisible();
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
