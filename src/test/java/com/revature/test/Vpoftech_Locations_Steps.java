package com.revature.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Vpoftech_Locations_Steps {
	WebDriver chrome;

	@Test (priority=1)
	public void vp_of_tech_opens_browser_and_goes_to_salesforce_page_to_test_LOCATIONS() throws Throwable {
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

	@Test (priority = 2)
	public void vp_of_Tech_tests_the_LOCATIONS_page_by_clicking_all_elements() throws Throwable {
		TimeUnit.SECONDS.sleep(8);

		chrome.findElement(
				By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
				.click();
		//Press every item on the list
		TimeUnit.SECONDS.sleep(3);
		List<WebElement> list;
		list = chrome.findElements(By.cssSelector(".md-no-style.md-button.md-ink-ripple"));
		System.out.println("number of elements found: " + list.size());
		for (WebElement element : list) {
			try {
				TimeUnit.MILLISECONDS.sleep(800);
				element.click();
				TimeUnit.MILLISECONDS.sleep(800);
				element.click();
			} catch (ElementNotVisibleException e) {
				continue;
			}

		}

		//Test deleting a row
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar/button[5]/md-icon")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"dialogContent_1\"]/div/md-dialog-actions/button[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		//Test to add a location
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
		TimeUnit.SECONDS.sleep(1);
		//Test to add building
		chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"bldgAdd\"]/md-icon")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"input_165\"]")).sendKeys("Building #1");
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		//Test to add room
		chrome.findElement(By.xpath("//*[@id=\"loc391\"]/md-list-item/div/div[1]/md-checkbox/div[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"roomAdd\"]/md-icon")).click();
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("//*[@id=\"input_169\"]")).sendKeys("107");
		TimeUnit.SECONDS.sleep(1);
		chrome.findElement(By.xpath("/html/body/div[3]/md-dialog/form/div/md-dialog-actions/button[1]")).click();
		TimeUnit.SECONDS.sleep(1);
		//Test to edit selected
		chrome.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/md-list-item[1]/div[1]/div[1]/md-checkbox/div[1]")).click();
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
		TimeUnit.SECONDS.sleep(1);
	}

	@Test (priority = 3)
	public void vp_of_Tech_logs_out_after_testing_LOCATIONS() throws Throwable {
		TimeUnit.SECONDS.sleep(3);
        try {
            chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        chrome.quit();
	}
}