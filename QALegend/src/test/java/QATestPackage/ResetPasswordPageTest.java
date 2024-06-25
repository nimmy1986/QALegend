package QATestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Object.ResetPasswordPage;
import QAUtilities.QAExcelUtility;
import QA_Automation_Core.QABase;

public class ResetPasswordPageTest extends QABase
{
	@Test
	public void verifyerrormessagewithinvalidemailid() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		String invalidemailidfromexcel=QAExcelUtility.readStringData(0, 0, "Resetpasswordpage");

		ResetPasswordPage Reset=new ResetPasswordPage(driver);
		Reset.clickonforgotpasswordlink();
		Reset.enteremailid(invalidemailidfromexcel);
		Reset.clickonpasswordresetbutton();
		String errormessagetext=Reset.geterrormessage();
		String expectederrormessage=QAExcelUtility.readStringData(1, 0, "Resetpasswordpage");
		
		Assert.assertEquals(errormessagetext, expectederrormessage, "Mismatch in error message text");
	}
	
	@Test
	public void verifytextmessagewithvalidemailid() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/login");
		String validemailidfromexcel=QAExcelUtility.readStringData(2, 0, "Resetpasswordpage");

		ResetPasswordPage Reset=new ResetPasswordPage(driver);
		Reset.clickonforgotpasswordlink();
		Reset.enteremailid(validemailidfromexcel);
		Reset.clickonpasswordresetbutton();
		String actualsuccessmessage=Reset.getsuccessmessage();
		String expectedsuccessmessage=QAExcelUtility.readStringData(3, 0, "Resetpasswordpage");
		
		Assert.assertEquals(actualsuccessmessage, expectedsuccessmessage,"Mismatch in success message");
		
	}
	
}
