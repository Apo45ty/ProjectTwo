package com.revature.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(SafeForceResultListener.class)
public class Trainer_Locations_Steps {
    WebDriver chrome;

    @Test
    public void trainer_opens_browser_and_goes_to_salesforce_page_to_test_LOCATIONS() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://dev.assignforce.revaturelabs.com");
        chrome.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
        chrome.findElement(By.id("password")).sendKeys("trainer123");
        chrome.findElement(By.id("password")).sendKeys(Keys.RETURN);

    }

    @Test
    public void trainer_tests_the_LOCATIONS_page_by_clicking_all_elements() throws Throwable {
        TimeUnit.SECONDS.sleep(8);

        chrome.findElement(
                By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]/a/span/span"))
                .click();
        TimeUnit.SECONDS.sleep(3);
        List<WebElement> list;
        list = chrome.findElements(By.cssSelector(".md-no-style.md-button.md-ink-ripple"));
        System.out.println("number of elements found: " + list.size());
        for (WebElement element : list) {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                element.click();
                TimeUnit.MILLISECONDS.sleep(300);
                element.click();
            } catch (ElementNotVisibleException e) {
                continue;
            }

        }

    }

    @Test
    public void trainer_logs_out_after_testing_LOCATIONS() throws Throwable {
        TimeUnit.SECONDS.sleep(3);
        chrome.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]/button/span")).click();
        chrome.quit();

    }
}