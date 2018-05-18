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
public class Vpoftech_Locations_Bad {
	WebDriver chrome;

	@Test(priority = 1)
	public void vpoftech_opens_browser_and_logs_in() {
		// Get path to Chrome's user profile directory and add it to the ChromeOptions
		// object so that the Chrome Driver uses the User profile
		String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + path);
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		chrome = new ChromeDriver(options);
		chrome.get("https://dev.assignforce.revaturelabs.com");
		chrome.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		chrome.findElement(By.id("password")).sendKeys("yuvi1712");
		chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 2)
	public void vpoftech_clicks_locations_and_clicks_every_item() {
		try {
			// Wait 7 seconds for the page to load before clicking any elements
			TimeUnit.SECONDS.sleep(7);

			// Find and click the LOCATIONS button
			chrome.findElement(
					By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
					.click();

			TimeUnit.SECONDS.sleep(3);

			// Find and click every item on the list
			List<WebElement> list;
			list = chrome.findElements(By.cssSelector(".md-no-style.md-button.md-ink-ripple"));
			System.out.println("number of elements found: " + list.size());
			for (WebElement element : list) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
					element.click();
					TimeUnit.MILLISECONDS.sleep(100);
					element.click();
				} catch (ElementNotVisibleException e) {
					continue;
				} catch (NullPointerException e1) {
					continue;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void vpoftech_tests_deleting_a_row() {
		try {
			// Test deleting a row
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath(
					"//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]"))
					.click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar/button[5]/md-icon")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"dialogContent_1\"]/div/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void vpoftech_tests_to_add_a_location() {
		try {
			// Test to add a location
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"locAdd\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_54\"]")).sendKeys("A Building");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_55\"]")).sendKeys("Herndon");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"select_value_label_53\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"select_option_160\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void vpoftech_tests_to_add_a_building() {
		try {
			// Test to add building
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath(
					"//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]"))
					.click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"bldgAdd\"]/md-icon")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_165\"]")).sendKeys("Building #1");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void vpoftech_tests_to_add_a_room() {
		try {
			// Test to add room
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"loc391\"]/md-list-item/div/div[1]/md-checkbox/div[1]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"roomAdd\"]/md-icon")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_169\"]")).sendKeys("107");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void vpoftech_tests_to_edit_a_selected_item() {
		try {
			// Test to edit selected
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath(
					"//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]"))
					.click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"locEdit\"]/md-icon")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_284\"]")).sendKeys("Papa Wonka");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"input_285\"]")).sendKeys("Pizza Townz");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"select_value_label_283\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"select_option_334\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void vp_of_Tech_logs_out_after_testing_LOCATIONS() {
		// Wait 3 seconds and click the logout button, then close the browser window.
		try {
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(
					By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button"))
					.click();
			chrome.quit();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}