package com.revature.test;

import java.io.File;
import java.util.List;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.revature.pom.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Tests for the Create Batch portion of the Batch page of AssignForce TODO:
 * Figure out why navigate_to_the_Batch_tab() works only some of the times
 * 
 * @author Howard
 * @since May 18, 2018
 */
@Listeners(SafeForceResultListener.class)
public class CreateBatch_Steps {

	private static WebDriver wd;

	/**
	 * Background: For some reason, BeforeTest does not always execute every
	 * method??
	 */
	@BeforeTest
	public void beforeTest() {
		// go_to_assignforce_in_Chrome();
		// vp_logs_in();
		// navigate_to_the_Batch_tab();
	}

	/**
	 * Opens ChromeDriver and assigns it to the static WebDriver, then goes to the
	 * assignforce website.
	 */
	@Given("^Go to assignforce in Chrome$")
	public void go_to_assignforce_in_Chrome() {
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
	 * Enters a VP's credentials on the login page of the website, then click the
	 * log in button. Provide 3 seconds for execution.
	 */
	@Given("^VP logs in$")
	public void vp_logs_in() {
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
	 * Clicks on the batches link of the navbar if the page loads within 15 seconds.
	 * Utilizes a fluent wait.
	 */
	@Given("^Navigate to the Batch tab$")
	public void navigate_to_the_Batch_tab() {
		try {
			String navlink = "/html/body/div[1]/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]/a";
			clickWhenReady(wd.findElement(By.xpath(navlink)), 20);
			System.out.println("I did it.");
		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
	}

	/**
	 * Clicks on specified WebElement if it is loaded to the page within the
	 * specified seconds.
	 * 
	 * @param element
	 *            The element to click on.
	 * @param timelimit
	 *            The maximum number of seconds to wait.
	 */
	public void clickWhenReady(WebElement element, int timelimit) {
		WebDriverWait wait = new WebDriverWait(wd, timelimit);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	/**
	 * Scenario: VP submits complete Create Batch form
	 */
	@Test
	public void vp_submits_complete_Create_Batch_form() {
		// Background
		go_to_assignforce_in_Chrome();
		vp_logs_in();
		navigate_to_the_Batch_tab();
		// Given
		i_complete_the_Create_Batch_form();
		// When
		i_press_the_submit_button();
		// Then
		Assert.assertTrue(i_can_see_the_new_batch_in_the_table());
	}

	@Given("^I complete the Create Batch form$")
	public void i_complete_the_Create_Batch_form() {
		try {
			WebDriverWait wait = new WebDriverWait(wd, 5);

			// ----- Click on the 1st input field, core curriculum -----//
			clickWhenReady(wd.findElement(By.id("select_9")), 15);
			// Wait for the select options to appear
			String selectOptions = "//*[@id=\"select_container_10\"]/md-select-menu/md-content";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Click on first select option
			List<WebElement> elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				break;
			}

			// ----- Click on the 2nd input field, focus -----//
			clickWhenReady(wd.findElement(By.id("select_11")), 5);
			// Wait for the select options to appear
			selectOptions = "//*[@id=\"select_container_12\"]/md-select-menu/md-content/div";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Click on first select option
			elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				break;
			}

			// ----- Click on the 3rd input field, skills, then select some arbitrary skills
			clickWhenReady(wd.findElement(By.id("select_13")), 5);
			// Wait for the select options to appear
			selectOptions = "//*[@id=\"select_container_14\"]/md-select-menu/md-content/div";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Iterate through select options and click on the first 3 checkboxes
			elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			int counter = 0;
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				if (++counter >= 3) {
					break;
				}
			}

			// ----- Send date to the 4th input field, start date -----//
			wd.findElement(By.id("input_16")).sendKeys("5/7/2018");

			// 5th input field, end date, is auto-completed after inputting start date
			// 6th input field, name, is auto-completed too. Needs core curr + start date

			// Click on 7th input field, trainer, then select the first trainer
			clickWhenReady(wd.findElement(By.id("select_21")), 5);
			// Wait for the select options to appear
			selectOptions = "//*[@id=\"select_container_22\"]/md-select-menu/md-content/div/div";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Click on first select option
			elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				break;
			}

			// Click on 8th input field, co-trainer, then select the first co-trainer
			clickWhenReady(wd.findElement(By.id("select_23")), 5);
			// Wait for the select options to appear
			selectOptions = "//*[@id=\"select_container_24\"]/md-select-menu/md-content/div";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Click on first select option
			elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				break;
			}

			// Click on 9th input field, location, then select the first location
			clickWhenReady(wd.findElement(By.id("select_25")), 5);
			// Wait for the select options to appear
			selectOptions = "//*[@id=\"select_container_26\"]/md-select-menu/md-content";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectOptions)));
			// Click on first select option
			elemList = wd.findElement(By.xpath(selectOptions)).findElements(By.tagName("md-option"));
			for (WebElement el : elemList) {
				clickWhenReady(el, 5);
				break;
			}

			// The other fields are optional, so I will skip them for brevity

		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
	}

	@When("^I press the submit button$")
	public void i_press_the_submit_button() {
		try {
			String btnXpath = "//*[@id=\"view\"]/md-card/md-content[1]/form/md-toolbar/button[1]";
			clickWhenReady(wd.findElement(By.xpath(btnXpath)), 10);
		} catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
	}

	@Then("^I can see the new batch in the table$")
	public boolean i_can_see_the_new_batch_in_the_table() {
		wd.findElement(By.id("select_9")).getAttribute("value");
		return true;
	}

	/***********
	 * Scenario: VP submits incomplete Create Batch form
	 ***********/

	@Given("^I fill out only one field$")
	public void i_fill_out_only_one_field() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I should see a warning$")
	public void i_should_see_a_warning() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@AfterTest
	public void afterTest() {
		wd.quit();
	}

}
