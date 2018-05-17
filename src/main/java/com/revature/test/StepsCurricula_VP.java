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
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=");
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://dev.assignforce.revaturelabs.com");
		driver.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("yuvi1712");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 2)
	public void clicks_on_curricula_tabs_and_navigates() throws Throwable {
		TimeUnit.SECONDS.sleep(8);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//li[@name='curricula']")).click(); //Clicks Curricula Tab
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(
		By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"))
		.click(); // clicks plus sign button
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).click(); //selects input texbox
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).clear(); //clears input textbox
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).sendKeys("New Core Curricula"); //Adds new curriculum name
		
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("md-select[aria-label=\"curriculumSkills\"]")).click(); //clicks skills
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.id("select_option_32")).click(); //chooses skill
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.id("select_option_32")).sendKeys(Keys.ESCAPE);
//		driver.findElement(By.xpath("//*[@id=\"dialogContent_6\"]/form/div[1]/h3")).click(); //clicks box
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("button[ng-click=\"saveCurriculum()\"]")).click(); //clicks save button


		//Create Skill
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("input[ng-model=\"cCtrl.skillName\"]")).sendKeys("New Test Skill");
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("div[ng-click=\"cCtrl.createSkill(skillForm)\")]")).click();

		// driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]/span")).click();
		// driver.findElement(By.id("//*[@id=\"core\"]/md-list/md-list-item[1]/button[1]/i")).click();
		// driver.findElement(By.xpath("//*[@id=\"select_295\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"select_option_330\"]/div[2]")).click();
		// driver.findElement(By.xpath("/html/body/div[3]/md-dialog")).click();
		// driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]/span")).click();
		// driver.findElement(By.xpath("//*[@id=\"input_1\"]")).click();
		// driver.findElement(By.xpath("//*[@id=\"input_1\"]")).sendKeys("New Skillz");
		
		// driver.findElement(By.xpath("//*[@id=\"skill\"]/form/div/div/div/span")).click();
		// driver.findElement(By.id("coreArrow")).click();
		// driver.findElement(By.id("coreArrow")).click();
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
