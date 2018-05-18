package com.revature.test;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//@Listeners(SafeForceResultListener.class)
public class Trainer_Settings_Good {
	WebDriver chrome;

	@Test(priority = 1)
	public void trainer_opens_browser_and_logs_in() {
		// Get path to Chrome's user profile directory and add it to the ChromeOptions
		// object so that the Chrome Driver uses the User profile
		String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("user-data-dir=" + path);
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		chrome = new ChromeDriver(options);
		chrome.get("https://dev.assignforce.revaturelabs.com");
		chrome.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		chrome.findElement(By.id("password")).sendKeys("trainer123");
		chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 2)
	public void trainer_clicks_SETTINGS() {
		try {
			TimeUnit.SECONDS.sleep(5);
			// Find the Settings button and click it
			// Get list of all items in the navbar, then click Settings
			List<WebElement> list;
			list = chrome.findElements(By.cssSelector(".md-nav-item.ng-scope.ng-isolate-scope.layout-align-end-end"));
			for (WebElement we : list) {
				// For some reason I need to click the button to the right of the want I want
				// clicked
				if (we.getAttribute("name").equals("settings")) {
					System.out.println("Bet I clicked Settings");
					we.click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void trainer_tests_settings_dropdowns() {
		try {
			// Click Default Batch Location dropdown
			TimeUnit.SECONDS.sleep(2);
			chrome.findElement(By.cssSelector("md-select[ng-change=\"sCtrl.getBuildings()\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			// Click an item in the drop down list
			List<WebElement> list;
			list = chrome.findElements(By.cssSelector(".ng-scope.md-ink-ripple"));
			for (WebElement we : list) {
				try {
					if (we.getAttribute("ng-selected").equals("location.id == sCtrl.settings.defaultLocation")) {
						we.click();
						break;
					}
				} catch (ElementNotVisibleException e) {
					System.out.println("Element is not visible man");
					continue;
				} catch (NullPointerException e1) {
					System.out.println("Null pointer my man");
					continue;
				}

			}

			// Click Default Batch Building dropdown
			// TimeUnit.SECONDS.sleep(1);
			// chrome.findElement(By.cssSelector("md-select[ng-model=\"sCtrl.settings.defaultBuilding\"]")).click();
			// Click an item on the dropdown
			// try {
			// chrome.findElement(
			// By.cssSelector("md-option[ng-selected=\"building.id ==
			// sCtrl.settings.defaultBuilding\"]"))
			// .click();
			// } catch (NoSuchElementException e2) {
			// chrome.findElement(By.cssSelector("md-toolbar[ng-click=\"sCtrl.viewContent()\"]")).click();
			// }
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void trainer_tests_settings_textfields() {
		try {
			// Fill all the text fields with information
			TimeUnit.SECONDS.sleep(2);
			chrome.findElement(By.id("input_3")).clear();
			chrome.findElement(By.id("input_3")).sendKeys("1337");
			chrome.findElement(By.id("input_4")).clear();
			chrome.findElement(By.id("input_4")).sendKeys("1337");
			chrome.findElement(By.id("input_5")).clear();
			chrome.findElement(By.id("input_5")).sendKeys("1337");
			chrome.findElement(By.id("input_10")).clear();
			chrome.findElement(By.id("input_10")).sendKeys("1337");
			chrome.findElement(By.id("input_11")).clear();
			chrome.findElement(By.id("input_11")).sendKeys("1337");
			chrome.findElement(By.id("input_12")).clear();
			chrome.findElement(By.id("input_12")).sendKeys("1337");
			chrome.findElement(By.id("input_13")).clear();
			chrome.findElement(By.id("input_13")).sendKeys("1337");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void trainer_logs_out_after_testing_SETTINGS() {
		// Wait 3 seconds and click the logout button, then close the browser window.
		try {
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(
					By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button"))
					.click();
			TimeUnit.SECONDS.sleep(3);
			chrome.quit();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}