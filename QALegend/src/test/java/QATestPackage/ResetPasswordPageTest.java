package QATestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaconstants.Constants;
import qaconstants.Messages;
import utilities.ExcelUtility;
import Page_Object.ResetPasswordPage;
import QA_Automation_Core.QABase;

public class ResetPasswordPageTest extends QABase
{
	@Test(groups = "Sanity")
	public void verifyerrormessagewithinvalidemailid()
	{
		String invalidemailidfromexcel=ExcelUtility.readStringData(0, 0, Constants.RESETPAGE);

		ResetPasswordPage Reset=new ResetPasswordPage(driver);
		Reset.clickonforgotpasswordlink();
		Reset.enteremailid(invalidemailidfromexcel);
		Reset.clickonpasswordresetbutton();
		String errormessagetext=Reset.geterrormessage();
		String expectederrormessage=ExcelUtility.readStringData(1, 0, Constants.RESETPAGE);
		
		Assert.assertEquals(errormessagetext, expectederrormessage, Messages.RESET_FAILURE);
	}
	
	@Test(groups = "Smoke")
	public void verifytextmessagewithvalidemailid()
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
