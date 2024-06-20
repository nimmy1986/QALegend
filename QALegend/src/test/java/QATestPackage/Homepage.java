package QATestPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import QAUtilities.QAExcelUtility;
import QA_Automation_Core.QABase;

public class Homepage extends QABase
{
	@Test
	public void homepagetitle() throws Exception
	
	{
		driver.get("https://qalegend.com/billing/public/login");
		
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		String un=QAExcelUtility.readStringData(0, 0, "Homepage");
		username.sendKeys(un);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		String pwd=QAExcelUtility.readIntegerData(1, 0, "Homepage");
		password.sendKeys(pwd);
			
		WebElement login_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
		
		String actualhomepagetitleString=driver.getTitle();
		String expectedhomepagetitle=QAExcelUtility.readStringData(2, 0, "Homepage");
		
		Assert.assertEquals(actualhomepagetitleString, expectedhomepagetitle, "Title mismatch!!!");
		
	}
	@Test
	public void verifyuserlogindate() throws Exception
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
		
		WebElement logindate=driver.findElement(By.xpath("//div[@class='m-8 pull-left mt-15 hidden-xs']//strong"));
		String actuallogindate=logindate.getText();
		//System.out.println(actuallogindate);
		LocalDate expecteddate=LocalDate.now();
		//System.out.println(expecteddate);
		
		Assert.assertEquals(actuallogindate, expecteddate, "Date Mismatch!!!!");
	}
	
	@Test
	
	public void ThisMonth() throws Exception
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
		
		//WebElement thismonthbutton=driver.findElement(By.xpath("//label[@class='btn btn-info active']//input[@data-start='2024-06-01']"));
		//thismonthbutton.click();
		
		WebElement totalpurchase=driver.findElement(By.xpath("//span[@class='info-box-number total_purchase']"));
		String totalpurchasevalue=totalpurchase.getText();
		System.out.println(totalpurchasevalue);
		
		WebElement purchasedue=driver.findElement(By.xpath("//span[@class='info-box-number purchase_due']"));
		String purchaseduevalue=purchasedue.getText();
		System.out.println(purchaseduevalue);
		
	}
}
