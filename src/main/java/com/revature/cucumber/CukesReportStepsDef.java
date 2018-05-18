package com.revature.cucumber;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CukesReportStepsDef {

	WebDriver wd;
	WebDriverWait wait;
	String username, password;
	boolean flag = false;

	@AfterSuite
	public void closeAll() {
		System.out.println("Closing all webdriver instances...");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]")));
			wd.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
					.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			wd.close();
		}
	}

	@Given("^VP opens salesforce$")
	public void vp_opens_salesforce() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Setting up Webdriver");

		try {

			ChromeOptions options = new ChromeOptions();
			// options.addArguments("user-data-dir=C:\\Users\\franc\\AppData\\Local\\Google\\Chrome\\User
			// Data");

			File location = new File("src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", location.getAbsolutePath());
			wd = new ChromeDriver();
			wait = new WebDriverWait(wd, 10);

			wd.get("https://dev.assignforce.revaturelabs.com");
			wait.until(ExpectedConditions.titleIs("Login | Salesforce"));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Given("^username is \"([^\"]*)\"$")
	public void username_is(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		username = arg1;
	}

	@Given("^password is \"([^\"]*)\"$")
	public void password_is(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		password = arg1;
	}

	@Then("^login to admin view$")
	public void login_to_admin_view() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		System.out.println("logging in...");
		try {
			System.out.println("Login using credentials username:" + username);
			System.out.println("And password: " + password);

			wd.findElement(By.id("username")).sendKeys(username);
			wd.findElement(By.id("password")).sendKeys(password);

			wd.findElement(By.id("password")).sendKeys(Keys.RETURN);
			wait.until(ExpectedConditions.titleIs("AssignForce"));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Then("^go to the reports page$")
	public void go_to_the_reports_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		System.out.println("logged in, moving to reports page...");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='reports']")));
			wd.findElement(By.cssSelector("a[href*='reports']")).click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@When("^page loads click batch toggle$")
	public void page_loads_click_batch_toggle() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("batchArrow")));
			wd.findElement(By.id("batchArrow")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-card-title/button")));

		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Then("^delete current card$")
	public void delete_current_card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			wd.findElement(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-card-title/button"))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Add New Card\"]")));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Then("^add new card$")
	public void add_new_card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			wd.findElement(By.xpath("//button[@aria-label=\"Add New Card\"]")).click();
		} catch (TimeoutException e) {
			e.printStackTrace();
			assertFalse(false);
		}
	}

	@Then("^insert data into new card$")
	public void insert_data_into_new_card() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		String[] splitter;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-input-container[1]/input")));
			wd.findElement(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-input-container[1]/input"))
					.sendKeys("5");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-input-container[3]/md-select")));
			WebElement selector = wd.findElement(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-input-container[3]/md-select"));

			selector.click();
			System.out.println("md-select was clicked");

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/md-select-menu/md-content/md-option")));
			List<WebElement> selection = wd
					.findElements(By.xpath("/html/body/div[3]/md-select-menu/md-content/md-option"));

			System.out.println(selection.size());

			for (int i = 1; i < 5; i++) {

				if (i != 1) {
					TimeUnit.MILLISECONDS.sleep(250);
					selector.click();
					System.out.println("ng-select was clicked");
				}
				splitter = selection.get(i).toString().split(":");

				System.out.println(
						splitter[0] + "   " + splitter[1] + "    " + splitter[2] + "   " + selection.get(i).getText());
				System.out.println(splitter[2].substring(0, splitter[2].length() - 1) + "[" + i + "]");

				wait.until(ExpectedConditions.visibilityOf(selection.get(i)));
				wd.findElement(By.xpath(splitter[2].substring(0, splitter[2].length() - 1) + "[" + i + "]")).click();

				System.out.println(
						splitter[2].substring(0, splitter[2].length() - 1) + "[" + i + "]" + "  option was clicked");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/md-input-container[3]/md-select")));
			}

			int count = selection.size();

			System.out.println("Size of the select container 85: " + count);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Then("^press create batch button$")
	public void press_create_batch_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/div[3]/div")));
			wd.findElement(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[1]/div/md-card/md-card-content/div[3]/div"))
					.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Then("^press creat all button$")
	public void press_creat_all_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[2]/div/md-card/md-card-content/div[7]/div")));
			wd.findElement(By.xpath(
					"//*[@id=\"batchCreate\"]/get-batch-gen-template/div/md-content[2]/div/md-card/md-card-content/div[7]/div"))
					.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
