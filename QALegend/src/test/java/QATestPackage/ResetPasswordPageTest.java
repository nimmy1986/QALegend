package QATestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import Page_Object.ResetPasswordPage;
import QAUtilities.ExcelUtility;
import QA_Automation_Core.QABase;

public class ResetPasswordPageTest extends QABase
{
	@Test
	public void verifyerrormessagewithinvalidemailid() throws Exception
	{
		String invalidemailidfromexcel=ExcelUtility.readStringData(0, 0, Constants.RESETPAGE);

		ResetPasswordPage Reset=new ResetPasswordPage(driver);
		Reset.clickonforgotpasswordlink();
		Reset.enteremailid(invalidemailidfromexcel);
		Reset.clickonpasswordresetbutton();
		String errormessagetext=Reset.geterrormessage();
		String expectederrormessage=ExcelUtility.readStringData(1, 0, Constants.RESETPAGE);
		
		Assert.assertEquals(errormessagetext, expectederrormessage, Messages.MESSAGE_MISMATCH);
	}
	
	@Test
	public void verifytextmessagewithvalidemailid() throws Exception
	{
		String validemailidfromexcel=ExcelUtility.readStringData(2, 0, Constants.RESETPAGE);

		ResetPasswordPage Reset=new ResetPasswordPage(driver);
		Reset.clickonforgotpasswordlink();
		Reset.enteremailid(validemailidfromexcel);
		Reset.clickonpasswordresetbutton();
		String actualsuccessmessage=Reset.getsuccessmessage();
		String expectedsuccessmessage=ExcelUtility.readStringData(3, 0, Constants.RESETPAGE);
		
		Assert.assertEquals(actualsuccessmessage, expectedsuccessmessage,Messages.MESSAGE_MISMATCH);
		
	}
	
}
