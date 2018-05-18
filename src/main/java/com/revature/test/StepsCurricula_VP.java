package com.revature.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class StepsCurricula_VP {

	WebDriver driver;

	@Test(priority = 1)
	public void launches_Chrome_Browser_and_initiates_login() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=");
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver(options);
		driver.get("https://dev.assignforce.revaturelabs.com");

	}

	@Test(priority = 2)
	public void enters_login_credentials() {
		driver.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("yuvi1712");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}


	@Test(priority = 3)
	public void delete_curriculum() {
		try {
			TimeUnit.SECONDS.sleep(4);
			driver.findElement(By.xpath("//li[@name='curricula']")).click(); // Clicks Curricula Tab
			TimeUnit.SECONDS.sleep(2);
			TimeUnit.SECONDS.sleep(3);

			WebElement element = driver.findElement(By.cssSelector("button[ng-click=\"cCtrl.removeCurriculum($event,curr)\"]"));
			Actions actions = new Actions(driver); //Actions class to click same name button
			actions.moveToElement(element).click().build().perform();


			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]")).click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (NoSuchElementException e2) {

		}

	}


	@Test(priority = 4)
	public void clicks_on_curricula_tabs_and_navigates() {

		try {
			TimeUnit.SECONDS.sleep(4);
			driver.findElement(By.xpath("//li[@name='curricula']")).click(); // Clicks Curricula Tab
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"))
					.click(); // clicks plus sign button


			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).click(); // selects input texbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).clear(); // clears input textbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]"))
					.sendKeys("New Core Curricula Test2"); // Adds new curriculum name
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("md-select[aria-label=\"curriculumSkills\"]")).click(); // clicks skills
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.id("select_option_32")).click(); // chooses skill
			driver.findElement(By.id("select_option_31")).click(); // chooses skill
			driver.findElement(By.id("select_option_13")).click(); // chooses skill
			driver.findElement(By.id("select_option_12")).click(); // chooses skill
			driver.findElement(By.id("select_option_22")).click(); // chooses skill
			driver.findElement(By.id("select_option_29")).click(); // chooses skill
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.id("select_option_32")).sendKeys(Keys.ESCAPE);
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("button[ng-click=\"saveCurriculum()\"]")).click(); // clicks save button
		} catch (InterruptedException e) {
		}

	}

	@Test(priority = 5)
	public void create_new_skills() {
		// Create Skill

		try {
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[ng-model=\"cCtrl.skillName\"]")).sendKeys("Prueba 1");
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"skill\"]/form/div/div/div")).click(); // Clicks CREATE Skill button
		} catch (InterruptedException e) {
		}

	}

	@Test(priority = 6)
	public void curricula_with_all_skills() {


		try {
			TimeUnit.SECONDS.sleep(4);
			driver.findElement(By.xpath("//li[@name='curricula']")).click(); // Clicks Curricula Tab
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"))
					.click(); // clicks plus sign button
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).click(); // selects input texbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).clear(); // clears input textbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]"))
					.sendKeys("New Core Curricula Test6"); // Adds new curriculum name
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("md-select[aria-label=\"curriculumSkills\"]")).click(); // clicks skills
			TimeUnit.SECONDS.sleep(1);

			
		} catch (InterruptedException e) {
		}

		List<WebElement> list = driver.findElements(By.cssSelector("md-option[ng-repeat=\"x in skills| orderBy:'name'\"]"));
		for (WebElement skills : list) {
			try {
				TimeUnit.MILLISECONDS.sleep(40);
				skills.click();

			} catch (ElementNotVisibleException e) {
				e.printStackTrace();
			}catch(NullPointerException e1) {
				e1.printStackTrace();
			}catch(InterruptedException e2) {
				
			}
		}
		try {
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("select_option_209")).sendKeys(Keys.ESCAPE);
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector("button[ng-click=\"saveCurriculum()\"]")).click(); // clicks save button
		} catch (InterruptedException e) {
			}
			
		}
		
		
	@Test(priority = 7)
	public void create_new_focus() {

		try {
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[2]/md-toolbar/div/button[1]"))
					.click(); // clicks plus sign button


			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).click(); // selects input texbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]")).clear(); // clears input textbox
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("input[aria-label=\"curriculumName\"]"))
					.sendKeys("New Focus Test2"); // Adds new curriculum name
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("md-select[aria-label=\"curriculumSkills\"]")).click(); // clicks skills
			TimeUnit.SECONDS.sleep(2);

			driver.findElement(By.id("select_option_226")).click(); // chooses skill

			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.id("select_option_226")).sendKeys(Keys.ESCAPE);
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("button[ng-click=\"saveCurriculum()\"]")).click(); // clicks save button
		} catch (InterruptedException e) {
		}

	}

	@Test(priority = 8)
	public void delete_focus() {
		try {
			TimeUnit.SECONDS.sleep(3);
			driver.findElement(By.xpath("//*[@id=\"focus\"]/md-list/md-list-item[1]/button[2]")).click();
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]")).click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (NoSuchElementException e2) {

		}

	}

	@Test(priority = 9)
	public void quits_session_right_after_testing_curricula() {
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(9);
			driver.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"))
					.click();
			TimeUnit.SECONDS.sleep(5);
			driver.quit();
		} catch (InterruptedException e) {
		}

	}
}
