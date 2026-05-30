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

public class DashboardTest extends BaseTest {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	private static final Logger log=LogManager.getLogger(DashboardTest.class);

	@BeforeMethod
	public void createPage(ITestContext context) {
		loginPage = new LoginPage(tdriver.get());
		dashboardPage = new DashboardPage(tdriver.get());
		context.setAttribute("driver", tdriver.get());
	}

	@Test
	public void validateLogout() {
		loginPage.validLogin("Admin", "admin123");
		log.info("Validate Logout functionality:");
		Listener.logInfo("Validate Logout functionality:");
		dashboardPage.validateLogout();
		Assert.assertTrue(loginPage.validateLoginButton());
	}

}
