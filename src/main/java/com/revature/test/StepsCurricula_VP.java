package com.revature.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class StepsCurricula_VP {

	WebDriver driver;

	@Test(priority = 1)
	public void launches_Chrome_Browser_and_initiates_login() throws Throwable {
		// String path = System.getProperty("user.home") + File.separator +
		// "AppData\\Local\\Google\\Chrome\\User Data";
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("user-data-dir=");
		 options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev.assignforce.revaturelabs.com");
		driver.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("yuvi1712");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 2)
	public void clicks_on_curricula_tabs_and_navigates() throws Throwable {
		TimeUnit.SECONDS.sleep(8);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//li[@name='curricula']")).click();
		driver.findElement(
		By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"))
		.click();
		driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).click();
		driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).sendKeys("New Core Currila"); 
		
//		driver.findElement(By.id("coreArrow")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(9);
		driver.findElement(By.id("select_value_label_2")).click();
		driver.findElement(By.xpath("//*[@id=\"select_295\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"select_option_330\"]/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/md-dialog")).click();
		driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]/span")).click();
		driver.findElement(By.id("//*[@id=\"core\"]/md-list/md-list-item[1]/button[1]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"select_295\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"select_option_330\"]/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/md-dialog")).click();
		driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"input_1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"input_1\"]")).sendKeys("New Skillz");
		
		driver.findElement(By.xpath("//*[@id=\"skill\"]/form/div/div/div/span")).click();
		driver.findElement(By.id("coreArrow")).click();
		driver.findElement(By.id("coreArrow")).click();
	}

	// @Test(priority = 3)
	// public void clicks_on_plus() throws Throwable {
	// 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// 	driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"))
	// 	.click();

		// driver.findElement(By.xpath("//*[@id=\"core\"]/md-list/md-list-item[1]/button[1]/i"))
		// 		.click(); // Curricula plus button
	//}

	@Test(priority = 3)
	public void quits_session_right_after_testing_curricula() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(9);
		driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
				.click();
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
	}
}
