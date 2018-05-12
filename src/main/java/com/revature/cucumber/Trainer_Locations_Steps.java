package com.revature.cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trainer_Locations_Steps {
    WebDriver chrome;

    @Given("^Trainer opens browser and goes to salesforce page to test LOCATIONS$")
    public void trainer_opens_browser_and_goes_to_salesforce_page_to_test_LOCATIONS() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.get("https://dev.assignforce.revaturelabs.com");

    }

    @When("^Trainer logs in with \"([^\"]*)\" and \"([^\"]*)\" to test LOCATIONS$")
    public void trainer_logs_in_with_and_to_test_LOCATIONS(String username, String password) throws Throwable {
        chrome.findElement(By.id("username")).sendKeys(username);
        chrome.findElement(By.id("password")).sendKeys(password);
        chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);

    }

    @Then("^Trainer tests the LOCATIONS page by clicking all elements$")
    public void trainer_tests_the_LOCATIONS_page_by_clicking_all_elements() throws Throwable {
        TimeUnit.SECONDS.sleep(8);

        chrome.findElement(
                By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
                .click();
        // chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/button")).click();
        // chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[2]/div[1]/button")).click();
        // chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[3]/div[1]/button")).click();

        TimeUnit.SECONDS.sleep(3);
        List<WebElement> list;
        list = chrome.findElements(By.cssSelector(".md-no-style.md-button.md-ink-ripple"));
        System.out.println("number of elements found: " + list.size());
        // count clicks then scroll
        int counter = 0;
        for (WebElement element : list) {
            if (counter == 5) {
                JavascriptExecutor jse = (JavascriptExecutor) chrome;
                jse.executeScript("window.scrollBy(0,250)", "");
                counter = 0;
            }
            element.click();
            counter++;
        }

    }

    @Then("^Trainer logs out after testing LOCATIONS$")
    public void trainer_logs_out_after_testing_LOCATIONS() throws Throwable {
        TimeUnit.SECONDS.sleep(8);
        chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
                .click();
        chrome.quit();

    }
}