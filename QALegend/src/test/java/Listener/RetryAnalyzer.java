package Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count =0;
	int retry_limit=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<retry_limit)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
