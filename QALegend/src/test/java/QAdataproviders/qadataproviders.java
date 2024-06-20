package QAdataproviders;

import org.testng.annotations.DataProvider;

public class qadataproviders 
{
	@DataProvider(name="Invalidusernameorpassword")
	public Object[][] usercredentials()
	{
		Object[][] invaliusernamepwds=new Object[3][2];
		invaliusernamepwds[0][0]="Wadmin";
		invaliusernamepwds[0][1]="123456";
		
		invaliusernamepwds[1][0]="admin";
		invaliusernamepwds[1][1]="w123456";
		
		invaliusernamepwds[2][0]="Wadmin";
		invaliusernamepwds[2][1]="W123456";	
		
		return invaliusernamepwds;
	}
}
