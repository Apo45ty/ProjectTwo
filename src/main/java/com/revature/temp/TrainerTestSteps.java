package com.revature.temp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrainerTestSteps {
	WebDriver driver;
	@Given("^Launches Chrome Browser and login$")
	public void launches_Chrome_Browser_and_login() throws Throwable {
		String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + path);
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://dev.assignforce.revaturelabs.com");
        driver.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
        driver.findElement(By.id("password")).sendKeys("yuvi1712");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@When("^Clicks on the trainers tab$")
	public void clicks_on_the_trainers_tab() throws Throwable {
	   
	}

	@Then("^Clicks on first trainer$")
	public void clicks_on_first_trainer() throws Throwable {
	    
	}

	@Then("^Verifies that the profile page loaded$")
	public void verifies_that_the_profile_page_loaded() throws Throwable {
	    
	}
	@Then("^Logs Out$")
	public void logs_Out() throws Throwable {
		 TimeUnit.SECONDS.sleep(3);
	        try {
	            driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
	        } catch (NullPointerException e) {
	            e.printStackTrace();
	        }
	        driver.quit();
	}
}
