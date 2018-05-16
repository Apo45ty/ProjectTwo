package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.pom.BatchesPOM;
import com.revature.pom.LoginPage;

/**
 * @author Howard Chung
 */
public class Batches_TestNG {

	static WebDriver wd;
	Thread thread;

	@Test(groups = { "VP", "Positive", "SmartUser" })
	public void testCreateNewBatch() {
		// Click on the first input field with type=select and placeholder=core curriculum
		clickWhenReady(wd.findElement(By.id("select_9")), 10);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		WebElement element = null;
		try {
			element = wd.findElement(By.id("select_option_36"));
		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
		Assert.assertNotNull(element, "Select menu did not appear within 10 seconds.");
	}

	/**
	 * Clicks on specified @element if it is loaded to the page within the
	 * specified @timelimit.
	 * 
	 * @param locator
	 * @param timeout
	 */
	public void clickWhenReady(WebElement element, int timelimit) {
		WebDriverWait wait = new WebDriverWait(wd, timelimit);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	/**
	 * Logs in to assignforce as VP, then clicks on the batches link of the navbar
	 * if the page loads within 10 seconds.
	 */
	public void navigateToBatches() {
		String navlink = "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a";
		clickWhenReady(wd.findElement(By.xpath(navlink)), 15);
	}

	/**
	 * Enters a VP's credentials on the login page of the website, then click the
	 * log in button. Provide 3 seconds for execution.
	 */
	public void loginAsVP() {
		openApplication();
		try {
			LoginPage.user(wd).sendKeys("test.vpoftech@revature.com.int1");
			LoginPage.pass(wd).sendKeys("yuvi1712");
			LoginPage.loginButton(wd).click();
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (StaleElementReferenceException sere) {
			sere.printStackTrace();
		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
	}

	/**
	 * Enters a trainer's credentials on the login page of the website, then click
	 * the log in button. Provide 3 seconds for execution.
	 */
	public void loginAsTrainer() {
		openApplication();
		try {
			LoginPage.user(wd).sendKeys("test.trainer@revature.com.int1");
			LoginPage.pass(wd).sendKeys("trainer123");
			LoginPage.loginButton(wd).click();
			wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (StaleElementReferenceException sere) {
			sere.printStackTrace();
		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
	}

	/**
	 * Opens ChromeDriver and assigns it to the static WebDriver, then goes to the
	 * assignforce website.
	 */
	public static void openApplication() {
		try {
			File chrome = new File("src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		wd = new ChromeDriver();
		wd.get("https://dev.assignforce.revaturelabs.com");
	}

	/**
	 * Tests in this class will only operate on the Batches page
	 */
	@BeforeTest
	public void beforeTest() {
		loginAsVP();
		navigateToBatches();
	}

	@AfterTest
	public void afterTest() {
	}
}
