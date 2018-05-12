package com.revature.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class StepsCurricula {

    WebDriver driver;

    @Given("^Launches Chrome Browser and initiates login$")
    public void launches_Chrome_Browser_and_initiates_login() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dev.assignforce.revaturelabs.com");
    }

    @When("^The Trainer User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_Trainer_User_enters_the_and(String username, String password) throws Throwable {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
    }

    @Then("^Clicks on curricula tabs and navigates$")
    public void clicks_on_curricula_tabs_and_navigates() throws Throwable {
        TimeUnit.SECONDS.sleep(8);
        driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a/span/span")).click();
        driver.findElement(By.id("coreArrow")).click();
        driver.findElement(By.id("coreArrow")).click();
        driver.findElement(By.id("focusArrow")).click();
        driver.findElement(By.id("focusArrow")).click();

    }


@Then("^Quits session right after testing curricula$")
public void quits_session_right_after_testing_curricula() throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(8);
        driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }

}
