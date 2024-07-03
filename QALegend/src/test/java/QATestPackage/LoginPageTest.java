package QATestPackage;

import QA_Automation_Core.QABase;
import QAdataproviders.qadataproviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import utilities.ExcelUtility;
import Page_Object.Homepage;
import Page_Object.LoginPage;


public class LoginPageTest extends QABase
{
	@Test
	public void verifyuserloginwithvalidcredentials()
	{
		try
		{		
		String username=ExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String password=ExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		String welcometext=home.getwelcometext();
		System.out.println(welcometext);
		
		String expectedwelcometext=ExcelUtility.readStringData(2, 0, Constants.LOGINPAGE);
		System.out.println(expectedwelcometext);
		Assert.assertEquals(welcometext, expectedwelcometext, Messages.LOGIN_FAILED);
		}
		catch(Exception e)
		{
			throw new RuntimeException(Messages.EXCEL_SHEEETNOTFOUND);
		}				
	}
	
	@Test(groups = "Regression", dataProvider="Invalidusernameorpassword", dataProviderClass=qadataproviders.class)
	public void verifyerrormessagewhileuserloginwithinvalidcredentials(String usrnm,String pwd)
	{
		try
		{
		LoginPage login=new LoginPage(driver);
		login.enterusername(usrnm);
		login.enterpassword(pwd);
		login.clickonloginbutton();
		String actualerrormessage=login.geterrormessage();
		String expectederrormessage=ExcelUtility.readStringData(3, 0, Constants.LOGINPAGE);
		
		Assert.assertEquals(actualerrormessage, expectederrormessage, Messages.MESSAGE_MISMATCH);
		}
		catch(Exception e)
		{
			throw new RuntimeException(Messages.EXCEL_SHEEETNOTFOUND);
		}
	}
}
