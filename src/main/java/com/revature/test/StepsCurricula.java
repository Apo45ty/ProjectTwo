package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SafeForceResultListener.class)
public class StepsCurricula {

	WebDriver driver;

	@Test(priority = 1)
	public void launches_Chrome_Browser_and_initiates_login(){
		String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + path);
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://dev.assignforce.revaturelabs.com");
		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("trainer123");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 2)
	public void clicks_on_curricula_tabs_and_navigates(){
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a/span/span"))
				.click();
		driver.findElement(By.id("coreArrow")).click();
		driver.findElement(By.id("coreArrow")).click();
		driver.findElement(By.id("focusArrow")).click();
		driver.findElement(By.id("focusArrow")).click();

	}

	@Test(priority = 3)
	public void quits_session_right_after_testing_curricula() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
				.click();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
