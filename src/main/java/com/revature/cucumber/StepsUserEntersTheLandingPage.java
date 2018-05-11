package com.revature.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsUserEntersTheLandingPage {

	WebDriver driver;

	@When("^I login successfully$")
	public void i_login_successfully() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.assignforce.revaturelabs.com");		
		System.out.println("I login successfully");
	}

	@Given("^credentials are valid$")
	public void credentials_are_valid() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("trainer123");
		driver.findElement(By.id("Login")).click();
		System.out.println("credentials are valid");
	}

	@Then("^landing page should load batches table$")
	public void landing_page_should_load_batches_table() throws Throwable {
		System.out.println("landing page should load batches table");
	}

	@When("^Entering the home page$")
	public void entering_the_home_page() throws Throwable {
		System.out.println("Entering the home page");
	}

	@Then("^landing page should display \"([^\"]*)\"$")
	public void landing_page_should_display(String arg1) throws Throwable {
		System.out.println("landing page should display "+arg1);
	}
	@Then("^user should log out$")
	public void user_should_log_out() throws Throwable {
		driver.close();
		System.out.println("user should log out");
	}

}