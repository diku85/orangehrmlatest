package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.actiondriver.ActionDriver;

public class DashboardPage {

	public ActionDriver actionDriver;

	public DashboardPage(WebDriver driver) {
		actionDriver = new ActionDriver(driver);
	}

	private By dashboardTitleLocator = By.xpath("//h6[text()='Dashboard']");
	private By leaveUserLocator = By.xpath("//li[contains(@class,'userdropdown')]");
	private By logoutLocator = By.xpath("//ul[@role=\"menu\"]//li//a[text()='Logout']");

	public boolean validateDashboardText() {
		return actionDriver.validateElement(dashboardTitleLocator);
	}
	
	public void validateLogout() {
		actionDriver.clickObject(leaveUserLocator);
		actionDriver.clickObject(logoutLocator);
	}

}
