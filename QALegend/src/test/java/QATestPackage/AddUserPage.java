package QATestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Page_Object.Homepage;
import Page_Object.LoginPage;
import Page_Object.UsersPage;
import Page_Object.userManagementpage;
import QAUtilities.QAExcelUtility;
import QAUtilities.QARandomDataUtility;
import QA_Automation_Core.QABase;

public class AddUserPage extends QABase
{
	@Test
	public void verifyadduser() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		String username=QAExcelUtility.readStringData(0, 0, "LoginPage");
		String password=QAExcelUtility.readIntegerData(1, 0, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickonloginbutton();
		
		Homepage home=new Homepage(driver);
		home.clickonendtour();
		
		userManagementpage usermngmtpage=new userManagementpage(driver);
		usermngmtpage.clickon_usermanagementoption();
		
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Users')]")));

		usermngmtpage.clickon_usersoption();
		
		UsersPage userpage=new UsersPage(driver);
		
		
		String firstname=QARandomDataUtility.getusername();
		String lastname=QARandomDataUtility.getlastname();
		String prefix=QARandomDataUtility.getprefix();
		String email=firstname+"."+lastname+"@gmail.com";
		String username1=firstname+lastname;
		String password1=firstname+"@911";
		String commission=QARandomDataUtility.getPercent();
		
		userpage.enterprefix(prefix);
		userpage.enterfirstname(firstname);
		userpage.enterlastname(lastname);
		userpage.enteremail(email);
		userpage.selectfromdropdownlist();
		userpage.enterusername(username1);
		userpage.enterpassword(password1);
		userpage.confirmpassword(password1);
		userpage.clickon_savebutton();
				
	}
	
	@Test
	public void verifynewuser() throws Exception
	{
		driver.get("https://qalegend.com/billing/public/home");
		
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String un=QAExcelUtility.readStringData(0, 0, "Homepage");
		username.sendKeys(un);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String pwd=QAExcelUtility.readIntegerData(1, 0, "Homepage");
		password.sendKeys(pwd);
			
		WebElement login_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
		
		WebElement endtourbutton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		endtourbutton.click();
		
		WebElement usermanagementoption=driver.findElement(By.xpath("//span[text()='User Management']"));
		usermanagementoption.click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and contains(text(),'Users')]")));

		WebElement usersoption=driver.findElement(By.xpath("//span[@class='title' and contains(text(),'Users')]"));
		//boolean usersoptionenabledornot=usersoption.isEnabled();	
		//System.out.println(usersoptionenabledornot);
		
		usersoption.click();
		
		WebElement addbutton=driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		addbutton.click();
		
		String firstname=QARandomDataUtility.getusername();
		String lastname=QARandomDataUtility.getlastname();
		String prefix=QARandomDataUtility.getprefix();
		String email=firstname+"."+lastname+"@gmail.com";
		String username1=firstname+lastname;
		String password1=firstname+"@911";
		String commission=QARandomDataUtility.getPercent();
		
		
		WebElement prefixfield=driver.findElement(By.xpath("//input[@id='surname']"));
		prefixfield.sendKeys(prefix);
		
		WebElement firstnamefield=driver.findElement(By.xpath("//input[@id='first_name']"));
		firstnamefield.sendKeys(firstname);
		
		WebElement lastnamefield=driver.findElement(By.xpath("//input[@id='last_name']"));
		lastnamefield.sendKeys(lastname);
		
		WebElement emailfield=driver.findElement(By.xpath("//input[@id='email']"));
		emailfield.sendKeys(email);
				
		WebElement roledropdownlist=driver.findElement(By.xpath("//select[@id='role']"));
		//roledropdownlist.click();
		Select selectobj=new Select(roledropdownlist);
		selectobj.selectByIndex(1);
		
		WebElement username_field=driver.findElement(By.xpath("//input[@id='username']"));
		username_field.sendKeys(username1);
		
		WebElement password_field=driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(password1);
		
		WebElement confirmpassword_field=driver.findElement(By.xpath("//input[@id='confirm_password']"));
		confirmpassword_field.sendKeys(password1);
		
		WebElement cmmsnfield=driver.findElement(By.xpath("//input[@id='cmmsn_percent']"));
		cmmsnfield.sendKeys(commission);
		
		WebElement savebutton=driver.findElement(By.xpath("//button[@id='submit_user_button']"));
		savebutton.click();
		
		//wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle']//span")));
		driver.navigate().to("https://qalegend.com/billing/public/home");

		WebElement Userprofilebutton=driver.findElement(By.xpath("//a[@class='dropdown-toggle']//span"));
		Userprofilebutton.click();
		
		WebElement signoutbutton=driver.findElement(By.xpath("//a[@href='https://qalegend.com/billing/public/logout']"));
		signoutbutton.click();
		
		username.sendKeys(email);
		password.sendKeys(password1);
		
		login_button.click();
		
	}
}
