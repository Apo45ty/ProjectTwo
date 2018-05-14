package com.revature.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;

	@Given("^Open the Chrome and launch the application$")
	public void open_the_Chrome_and_launch_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://dev.assignforce.revaturelabs.com");
	}


	@When("^Enter the User(\\d+) and password(\\d+)$")
	public void enter_the_User_and_password(String arg1, String arg2) throws Throwable {
		
		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		//enter the password for the web page
		driver.findElement(By.id("password")).sendKeys("trainer123");
		driver.findElement(By.id("Login")).click();

//		driver.findElement(By.id("uid")).sendKeys(arg1);
//		driver.findElement(By.id("password")).sendKeys(arg2);
	}

	@Then("^Press Logout button$")
	public void Press_Logout_Button() throws Throwable {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(8);
			driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]")).click();
			TimeUnit.SECONDS.sleep(5);
			driver.quit();
	}
}