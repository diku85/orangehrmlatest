package com.qa.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int maxRetry=2;
	private int count=0;
	
	@Override
	public boolean retry(ITestResult result) {
		
		while(count < maxRetry) {
			count++;
			return true;
		}
		
		return false;
	}
}
