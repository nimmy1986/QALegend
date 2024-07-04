package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility 
{
	static Faker qafaker;
	
	public static String getusername()
	{
		qafaker = new Faker();
		String username=qafaker.name().username();
		return username;
	}
	public static String getlastname()
	{
		qafaker=new Faker();
		String pwd=qafaker.name().firstName();
		return pwd;
	}
	public static String getprefix()
	{
		qafaker=new Faker();
		String prefix=qafaker.name().prefix();
		return prefix;
		
	}
	
	public static String getPercent()
	{
		qafaker = new Faker();
		String salecommission = qafaker.number().digit();
		return salecommission;
	}
}
