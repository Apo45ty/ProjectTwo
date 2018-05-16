package com.revature.temp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.revature.test.SafeForceResultListener;
@Listeners(SafeForceResultListener.class)
public class Vpoftech_Settings_Steps{
    WebDriver chrome;

    @Test (priority = 1)
    public void trainer_opens_browser_and_goes_to_salesforce_page_to_test_SETTINGS() throws Throwable {
        String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + path);
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        chrome = new ChromeDriver(options);
        chrome.get("https://dev.assignforce.revaturelabs.com");
        chrome.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		chrome.findElement(By.id("password")).sendKeys("yuvi1712");
		chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);
    }

    @Test (priority = 2)
    public void trainer_clicks_SETTINGS(){

    }

    @Test (priority = 3)
    public void trainer_logs_out_after_testing_SETTINGS() throws Throwable {
        TimeUnit.SECONDS.sleep(3);
        try {
            chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button")).click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        chrome.quit();
    }
}