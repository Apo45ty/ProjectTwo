package com.revature.test;

import org.testng.annotations.Test;

import com.revature.pom.BatchesPOM;
import com.revature.pom.LoginPage;
import com.revature.pom.NavbarPOM;

import org.testng.annotations.BeforeTest;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
//	@Test(priority = 0)
//	public void VerifyValidLogin() {
//		openApplication();
//		LoginPage.user(wd).sendKeys("test.trainer@revature.com.int1");
//		LoginPage.pass(wd).sendKeys("trainer123");
//		LoginPage.loginButton(wd).click();
//		wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
//		navbar.logout(wd).click();
//		wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
//		
//	}
	@Test
	public void temp() {
		openApplication();
		LoginPage.user(wd).sendKeys("test.vpoftech@revature.com.int1");
		LoginPage.pass(wd).sendKeys("yuvi1712");
		LoginPage.loginButton(wd).click();
		wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
		NavbarPOM.batches(wd).click();
		
		Actions builder = new Actions(wd);
		builder.moveToElement(BatchesPOM.core_curriculum(wd),10, 2).click().perform(); 
		//dropdown.selectByIndex(1);
		
		wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
		NavbarPOM.logout(wd).click();
		wd.quit();
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
