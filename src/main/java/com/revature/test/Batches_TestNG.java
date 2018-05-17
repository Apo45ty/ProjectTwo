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

import com.revature.pom.LoginPage;

/**
 * @author Howard Chung
 */
public class Batches_TestNG {

	static WebDriver wd;
	Thread thread;

	/**
	 * Tests if Sort By Name updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByName() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[2]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Curriculum updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByCurriculum() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[3]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Focus updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByFocus() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[4]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Trainer updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByTrainer() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[5]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Location updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByLocation() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[6]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Building updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByBuilding() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[7]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Room updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByRoom() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[8]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests if Sort By Date updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so should be done through Karma/Jasmine tests.
	 */
	@Test(groups = { "Sanity" })
	public void testSortByDate() {
		String batchPageSource = wd.getPageSource();
		String sortBy = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/thead/tr/th[9]";
		clickWhenReady(wd.findElement(By.xpath(sortBy)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}
	
	/**
	 * Tests if the Edit Button updates the page source. Does not ensure that the
	 * page is updated correctly. Doing so would require database access.
	 */
	@Test(groups = { "Sanity" })
	public void testEditButton() {
		String batchPageSource = wd.getPageSource();
		String editBtn = "//*[@id=\"view\"]/md-card/md-content[2]/div/md-table-container/table/tbody/tr[1]/td[11]/button[1]";
		clickWhenReady(wd.findElement(By.xpath(editBtn)), 10);
		Assert.assertNotEquals(batchPageSource, wd.getPageSource());
	}

	/**
	 * Tests whether the page remains the same after refresh. Surprisingly,
	 * refreshing the Batches page takes you to the Overview page??
	 */
	@Test
	public void testRefreshBatchPage() {
		String batchPageSource = wd.getPageSource();
		wd.navigate().to(wd.getCurrentUrl());
		Assert.assertEquals(batchPageSource, wd.getPageSource());
	}

	@Test(groups = { "VP", "PositiveTest" })
	public void testCreateNewBatch() {
		// Click on the first select field, core curriculum
		clickWhenReady(wd.findElement(By.id("select_9")), 10);
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
	 * @param element
	 * @param timelimit
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
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		wd.quit();
	}
}
