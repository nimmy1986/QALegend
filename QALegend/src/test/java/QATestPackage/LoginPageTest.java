package QATestPackage;

import QA_Automation_Core.QABase;
import QAdataproviders.qadataproviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Object.Homepage;
import Page_Object.LoginPage;
import QAUtilities.QAExcelUtility;


public class LoginPageTest extends QABase
{
	@Test
	public void verifyuserloginwithvalidcredentials() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		
		String username=QAExcelUtility.readStringData(0, 0, "LoginPage");
		String password=QAExcelUtility.readIntegerData(1, 0, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		Homepage home=login.clickonloginbutton();
		home.clickonendtour();
		String welcometext=home.getwelcometext();
		System.out.println(welcometext);
		
		String expectedwelcometext=QAExcelUtility.readStringData(2, 0, "LoginPage");
		System.out.println(expectedwelcometext);
		Assert.assertEquals(welcometext, expectedwelcometext, "User is not logged in");
				
	}
	@Test(dataProvider="Invalidusernameorpassword", dataProviderClass=qadataproviders.class)
	public void verifyerrormessagewhileuserloginwithinvalidcredentials(String usrnm,String pwd) throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		LoginPage login=new LoginPage(driver);
		login.enterusername(usrnm);
		login.enterpassword(pwd);
		login.clickonloginbutton();
		String actualerrormessage=login.geterrormessage();
		String expectederrormessage=QAExcelUtility.readStringData(3, 0, "LoginPage");
		
		Assert.assertEquals(actualerrormessage, expectederrormessage, "Error message is not same");
	}
}
