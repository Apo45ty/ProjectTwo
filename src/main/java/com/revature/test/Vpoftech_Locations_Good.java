package com.revature.test;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//@Listeners(SafeForceResultListener.class)
public class Vpoftech_Locations_Good {
	WebDriver chrome;
	String name = "The City of Evil";
	String city = "A7x";
	String building = "Diamonds in the Rough";
	// VA state is hardcoded as option with id select_option_52

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
	public void vpoftech_clicks_locations() {
		try {
			// Wait 7 seconds for the page to load before clicking any elements
			TimeUnit.SECONDS.sleep(5);
			// Find and click the LOCATIONS button
			chrome.findElement(
					By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
					.click();
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void vpoftech_clicks_every_item() {
		try {
			// Find and click every item on the list
			List<WebElement> list;
			list = chrome.findElements(By.cssSelector("button[ng-click=\"lCtrl.openLocation(location)\"]"));
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

	// @Test(priority = 4)
	public void vpoftech_tests_deleting_a_row() {
		try {
			// Test deleting a row
			TimeUnit.SECONDS.sleep(3);
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

	@Test(priority = 5)
	public void vpoftech_tests_to_add_a_location() {
		try {
			// Test to add a location
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.xpath("//*[@id=\"locAdd\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.name\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.name\"]")).sendKeys(name);
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.city\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.city\"]")).sendKeys(city);
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("md-select[ng-model=\"ldCtrl.location.state\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.id("select_option_52")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void vpoftech_tests_to_add_a_building() {
		JavascriptExecutor jse = (JavascriptExecutor) chrome;
		try {
			// Test to add building
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(location)\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			jse.executeScript("window.scrollBy(0,-1000)", "");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("//*[@id=\"bldgAdd\"]/md-icon")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"bldgCtrl.building.name\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"bldgCtrl.building.name\"]")).sendKeys(building);
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(location)\"]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void vpoftech_tests_to_add_a_room() {
		JavascriptExecutor jse = (JavascriptExecutor) chrome;
		try {
			jse.executeScript("window.scrollBy(0,-1000)", "");
			// Test to add room
			TimeUnit.SECONDS.sleep(3);
			List<WebElement> list;
			// Get list of building checkboxes
			list = chrome.findElements(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(building)\"]"));
			System.out.println("List has: " + list.size());
			for (WebElement we : list) {
				we.click();
				break;
			}

			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.cssSelector("button[ng-click=\"lCtrl.addRoom()\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).clear();
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).sendKeys("007");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	// @Test(priority = 8)
	public void vpoftech_tests_to_edit_a_selected_item() {
		try {
			// Test to edit selected
			List<WebElement> list;
			// Get list of building entries
			TimeUnit.SECONDS.sleep(3);
			list = chrome.findElements(By.cssSelector("button[ng-click=\"lCtrl.openBuilding(building)\"]"));
			System.out.println("List has: " + list.size());
			for (WebElement we : list) {
				we.click();
				break;
			}

			// Get list of room checkboxes
			TimeUnit.SECONDS.sleep(1);
			list = chrome.findElements(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(room)\"]"));
			System.out.println("List has: " + list.size());
			for (WebElement we : list) {
				we.click();
				break;
			}

			// Click edit button to edit room
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.cssSelector("button[ng-click=\"lCtrl.editSelected()\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).clear();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"rdCtrl.room.roomName\"]")).sendKeys("Edited");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
			;
			TimeUnit.SECONDS.sleep(3);

			// Get list of building checkboxes
			list = chrome.findElements(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(building)\"]"));
			System.out.println("List has: " + list.size());
			for (WebElement we : list) {
				we.click();
				break;
			}

			// Click edit button to edit room
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.cssSelector("button[ng-click=\"lCtrl.editSelected()\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"bldgCtrl.building.name\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"bldgCtrl.building.name\"]")).clear();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"bldgCtrl.building.name\"]")).sendKeys("Edited");
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
			;
			TimeUnit.SECONDS.sleep(3);

			// Get list of location checkboxes
			list = chrome.findElements(By.cssSelector("md-checkbox[ng-click=\"lCtrl.toggle(location)\"]"));
			String att = "A7x";
			System.out.println("List has: " + list.size());
			for (WebElement we : list) {
				we.click();
				break;
			}

			// Click edit button to edit location
			TimeUnit.SECONDS.sleep(3);
			chrome.findElement(By.cssSelector("button[ng-click=\"lCtrl.editSelected()\"]")).click();

			// Location name
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.name\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.name\"]")).clear();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.name\"]")).sendKeys("Edited");
			TimeUnit.SECONDS.sleep(1);

			// Location city
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.city\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.city\"]")).clear();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.cssSelector("input[ng-model=\"ldCtrl.location.city\"]")).sendKeys("Edited");
			TimeUnit.SECONDS.sleep(1);

			// Location state
			chrome.findElement(By.cssSelector("md-select[ng-model=\"ldCtrl.location.state\"]")).click();
			TimeUnit.SECONDS.sleep(1);
			chrome.findElement(By.id("select_option_99")).click();
			TimeUnit.SECONDS.sleep(1);
			// chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/md-dialog-actions/button[1]")).click();
			TimeUnit.SECONDS.sleep(3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}

	@Test(priority = 9)
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