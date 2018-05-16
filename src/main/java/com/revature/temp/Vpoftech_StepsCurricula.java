package com.revature.temp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Vpoftech_StepsCurricula {
	
	WebDriver driver;
	
	@Given("^Launches Web Browser and initiates login$")
	public void launches_Web_Browser_and_initiates_login() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dev.assignforce.revaturelabs.com");
	}

	@When("^The VPofTechnology enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_VPofTechnology_enters_the_and(String username, String password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Then("^Browses through the VP options in the Curricula tab$")
	public void browses_through_the_VP_options_in_the_Curricula_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Logs out after testing$")
	public void logs_out_after_testing() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(8);
        driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
	}
}
