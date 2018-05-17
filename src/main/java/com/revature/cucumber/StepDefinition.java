package com.revature.cucumber;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver chrome;
	String username, password;

	@Given("^Open browser request is made by User$")
	public void open_browser_request_is_made() throws Throwable {
		System.out.println("Set the wd");
		File chromeFile = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
		chrome = new ChromeDriver();

	}

	@When("^Credentials are for a user Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void credentials_are_for_a_user_Username_and_Password(String arg1, String arg2) throws Throwable {
		username = arg1;
		password = arg2;
	}

	@Then("^Open chrome and enter assignforce$")
	public void open_chrome_and_enter_assignforce() throws Throwable {
		System.out.println("open chrome and go to assignforce");
		chrome.get("https://dev.assignforce.revaturelabs.com");
	}

	@Then("^login using User credentials$")
	public void login_using_credentials() throws Throwable {
		System.out.println("login using credentials");
		chrome.findElement(By.id("username")).sendKeys(username);
		chrome.findElement(By.id("password")).sendKeys(password);
		chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@When("^Login is successful$")
	public void login_is_successful() throws Throwable {
		System.out.println("something happens");
		chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		chrome.findElement(
				By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[1]/md-icon"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[2]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[3]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[4]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[5]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[6]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[7]"))
				.click();

		chrome.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[8]"))
				.click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		chrome.findElement(By.cssSelector("a[href*='home']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='batches']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='location']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='curriculum']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='trainers']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if ((chrome.findElement(By.cssSelector("a[href*='profile']")).isDisplayed())) {
			chrome.findElement(By.cssSelector("a[href*='profile']")).click();
		}

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='reports']")).click();

		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrome.findElement(By.cssSelector("a[href*='settings']")).click();

	}

	@Then("^Logout of assignforce$")
	public void logout_of_assignforce() throws Throwable {
		chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("click logout button and close wd");
		chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
				.click();

		chrome.quit();
	}
}
