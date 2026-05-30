package com.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.testbase.BaseTest;
import com.qa.utils.Listener;
import com.qa.utils.RetryAnalyzer;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	private static final Logger log=LogManager.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void createPage(ITestContext context) {
		loginPage=new LoginPage(tdriver.get());
		dashboardPage=new DashboardPage(tdriver.get());
		context.setAttribute("driver", tdriver.get()); 
	}
	
	@Test
	public  void validatePageTitle() {
		Listener.logInfo("Validate Orange HRM Page title:");
		log.info("Validate Orange HRM Page title:");
		Assert.assertEquals(tdriver.get().getTitle(), "OrangeHRM");	
	}
	
	@Test
	public void validateDashboardTitle() {
		loginPage.validLogin("Admin","admin123");
		log.info("Validate Dashboard title:");
		Listener.logInfo("Validate Dashboard title:");
		Assert.assertTrue(dashboardPage.validateDashboardText());
	}
	
	@Test
	public void validateInvalidLogin() {
		log.info("validateInvalidLogin:");
		Assert.assertTrue(loginPage.invalidLogin("Admin","admin123222"));
	}
}
