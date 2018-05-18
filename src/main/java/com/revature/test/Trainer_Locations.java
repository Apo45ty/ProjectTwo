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
import org.testng.annotations.Listeners;

//@Listeners(SafeForceResultListener.class)
public class Trainer_Locations {
    WebDriver chrome;

    @Test(priority = 1)
    public void trainer_opens_browser_and_logs_in() throws Throwable {
        // Get path to Chrome's user profile directory and add it to the ChromeOptions
        // object so that the Chrome Driver uses the User profile
        String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + path);
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chrome = new ChromeDriver(options);
        chrome.get("https://dev.assignforce.revaturelabs.com");
        chrome.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
        chrome.findElement(By.id("password")).sendKeys("trainer123");
        chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);

    }

    @Test(priority = 2)
    public void trainer_clicks_locations_tab_then_clicks_all_items() {
        try {
            // Wait 7 seconds for the page to load before clicking any elements
            TimeUnit.SECONDS.sleep(7);
            chrome.findElement(
                    By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
                    .click();

            // Find and click the LOCATIONS button
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
                    System.out.println("woopsi");
                    continue;
                }
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }

    @Test(priority = 3)
    public void trainer_logs_out_after_testing_LOCATIONS() {
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