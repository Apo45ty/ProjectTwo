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

public class Trainer_Settings_Steps {
    WebDriver chrome;

    @Test(priority = 1)
    public void trainer_opens_browser_and_goes_to_salesforce_page_to_test_SETTINGS() throws Throwable {
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
    public void trainer_clicks_SETTINGS() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chrome.findElement(
                By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a/span/span"))
                .click();
        chrome.findElement(By.id("input_3")).sendKeys("1337");
        chrome.findElement(By.id("input_4")).sendKeys("1337");
        chrome.findElement(By.id("input_5")).sendKeys("1337");
        chrome.findElement(By.id("input_10")).sendKeys("1337");
        chrome.findElement(By.id("input_11")).sendKeys("1337");
        chrome.findElement(By.id("input_12")).sendKeys("1337");
        chrome.findElement(By.id("input_13")).sendKeys("1337");
        chrome.findElement(By.xpath("//*[@id=\"select_value_label_1\"]/span[1]/div")).click();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chrome.findElement(By.xpath("//*[@id=\"select_option_17\"]"));

    }

    @Test(priority = 3)
    public void trainer_logs_out_after_testing_SETTINGS() throws Throwable {
        TimeUnit.SECONDS.sleep(3);
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