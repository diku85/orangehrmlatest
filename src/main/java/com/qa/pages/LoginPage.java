package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.actiondriver.ActionDriver;

public class LoginPage {
	
	public ActionDriver actionDriver;
	
	public LoginPage(WebDriver driver){
		actionDriver=new ActionDriver(driver);
	}
	
	//locators
	private By userNameLocator=By.cssSelector("input[name='username']");
	private By passwordLocator=By.cssSelector("input[name='password']");
	private By loginLocator=By.cssSelector("button[type='submit']");
	private By loginErrorLocator=By.xpath("//p[text()='Invalid credentials']");
	
	public void validLogin(String userName,String password) {
		actionDriver.enterText(userNameLocator, userName);
		actionDriver.enterText(passwordLocator, password);
		actionDriver.clickObject(loginLocator);
	}
	
	public boolean invalidLogin(String userName,String password) {
		actionDriver.enterText(userNameLocator, userName);
		actionDriver.enterText(passwordLocator, password);
		actionDriver.clickObject(loginLocator); 
		actionDriver.waitForElement(loginErrorLocator);
		return actionDriver.validateElement(loginErrorLocator);
		
	}
	
	public boolean validateLoginButton() {
		return actionDriver.validateElement(loginLocator);
	}

}
