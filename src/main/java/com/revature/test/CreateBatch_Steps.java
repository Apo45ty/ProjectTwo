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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.revature.pom.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Tests for the Create Batch portion of the Batch page of AssignForce
 * @author Howard
 * @since May 18, 2018
 */
@Listeners(SafeForceResultListener.class)
public class CreateBatch_Steps {

	private static WebDriver wd;

	/**
	 * Background:
	 */
	@BeforeTest
	public void beforeTest() {
		go_to_assignforce_in_Chrome();
		vp_logs_in();
		navigate_to_the_Batch_tab();
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
			clickWhenReady(wd.findElement(By.xpath(navlink)), 15);
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

	@Given("^I complete the Create Batch form$")
	public void i_complete_the_Create_Batch_form() {
		try {
			// Click on the 1st input field, core curriculum, then select "Core Name"
			clickWhenReady(wd.findElement(By.id("select_9")), 10);
			clickWhenReady(wd.findElement(By.id("select_option_36")), 10);
			// Click on the 2nd input field, focus, then select "Focus Name"
			
			// Click on the 3rd input field, skills, then select some arbitrary skills
			
			// Click on the 4th input field, start date, then send keys for May 7th, 2018
			
			// 5th input field, end date, is auto-completed after inputting start date
			
			// 6th input field, name, is auto-completed after inputting core curriculum & start date
			
			// Click on 7th input field, trainer, then select an arbitrary trainer
			
			// Click on 8th input field, co-trainer, then select an arbitrary co-trainer
			
			// Click on 9th input field, location, then select Revature - Reston, VA
			
			// Click on 10th input field, building, then select Revature 11730
			
			// Click on 11th input field, room, then select 100
			
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
	public void i_can_see_the_new_batch_in_the_table() {
		wd.findElement(By.id("select_9")).getAttribute("value");
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
