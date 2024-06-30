package QATestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CONSTANTS.Constants;
import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.MyProfilePage;
import QAUtilities.QAExcelUtility;
import QAUtilities.QARandomDataUtility;
import QA_Automation_Core.QABase;

public class MyProfilePageTest extends QABase
{
	@Test
	public void verifyProfileEdit() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		
		LoginPage login=new LoginPage(driver);
		String un=QAExcelUtility.readStringData(0, 0, Constants.LOGINPAGE);
		String pwd=QAExcelUtility.readIntegerData(1, 0, Constants.LOGINPAGE);
		login.enterusername(un);
		login.enterpassword(pwd);
		login.clickonloginbutton();
		
		Homepage homepage=new Homepage(driver);
		homepage.clickonendtour();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle']//span")));
		homepage.clickon_userprofilebutton();	
		homepage.clickon_profilebutton();
		
		MyProfilePage myprofile=new MyProfilePage(driver);
		String firstnametext=myprofile.getfirstnametext();
		myprofile.clearlastnamefield();
		String editlastname=QARandomDataUtility.getlastname();
		myprofile.editlastnamefield(editlastname);
		myprofile.clickon_updatebutton();		
		String expectedtext=firstnametext+" "+editlastname;
		String actualtext=homepage.getuserprofiletext();
		Assert.assertEquals(actualtext, expectedtext, "Profile update unsuccessful!!!!!");
	}
}
