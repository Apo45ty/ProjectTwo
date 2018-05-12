package com.revature.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trainer_Locations_Steps {
    WebDriver chrome;

    @Given("^Open browser and go to salesforce page$")
    public void open_browser_and_go_to_salesforce_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.get("https://dev.assignforce.revaturelabs.com");
        
    }

    @When("^Log in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void log_in_with_and(String username, String password) throws Throwable {
        chrome.findElement(By.id("username")).sendKeys(username);
		chrome.findElement(By.id("password")).sendKeys(password);
		chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);
        
    }

    @Then("^Test the LOCATIONS page by clicking all elements$")
    public void test_the_LOCATIONS_page_by_clicking_all_elements() throws Throwable {
        TimeUnit.SECONDS.sleep(8);
                
    }
    
    @Then("^Trainer logs out after testing LOCATIONS$")
    public void trainer_logs_out_after_testing_LOCATIONS() throws Throwable {
        TimeUnit.SECONDS.sleep(8);
        chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]")).click();
		chrome.quit();
        
    }
}