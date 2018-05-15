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

public class Trainer_Locations_Steps {
    WebDriver chrome;

    @Test(priority = 1)
    public void trainer_opens_browser_and_goes_to_salesforce_page_to_test_LOCATIONS() throws Throwable {
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
    public void trainer_tests_the_LOCATIONS_page_by_clicking_all_elements() {
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        chrome.findElement(
                By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
                .click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
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
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }

        }

    }

    @Test(priority = 3)
    public void trainer_logs_out_after_testing_LOCATIONS() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            chrome.findElement(
                    By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button"))
                    .click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        chrome.quit();
    }
}