package com.revature.pom;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**
 * @author Ed M
 * @date May 10, 2018
 * @time time 3:16:59 PM
 */
public class dev_assignforce_revaturelabs_com_TestNG {
	static WebDriver wd;

	/**
	 * 
	 */
	@Test(priority = 0)
	public void VerifyValidLogin() {
		openApplication();
		LoginPage.user(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.pass(wd).sendKeys("trainer123");
		LoginPage.loginButton(wd).click();
		Assert.assertTrue(true);
	}

	public static void openApplication() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("https://dev.assignforce.revaturelabs.com");
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		
		wd.close();
	}

}
