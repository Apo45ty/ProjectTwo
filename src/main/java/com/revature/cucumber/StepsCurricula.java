package com.revature.cucumber;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsCurricula {

    WebDriver driver;

    @Given("^Open the Chrome and launch the application$")
    public void open_the_Chrome_and_launch_the_application() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://dev.assignforce.revaturelabs.com");
    }

    @Then("^Open Chrome Browser and Login Assignforce$")
    public void open_Chrome_Browser_and_Login_Assignforce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Login using User credentials$")
    public void login_using_User_credentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Login is successful and tests Curricula$")
    public void login_is_successful_and_tests_Curricula() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Logout of Assignforce$")
    public void logout_of_Assignforce() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
