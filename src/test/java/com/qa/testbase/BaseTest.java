package com.qa.testbase;

import java.util.*;
import java.io.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static Properties prop;
	public ThreadLocal<WebDriver> tdriver=new ThreadLocal<>();

	@BeforeSuite
	public Properties readConfig() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

	@BeforeMethod
	public void setUp() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			option.addArguments("--headless");
			//Adding here
			WebDriver driver=new ChromeDriver(option);
			tdriver.set(driver);
		}else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new FirefoxDriver();
			tdriver.set(driver);
		}
		tdriver.get().manage().window().maximize();
		tdriver.get().get(prop.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
	}

	@AfterMethod
	public void tearDown() {
		if (tdriver.get() != null) {
			tdriver.get().quit();
		}
	}

}
