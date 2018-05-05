package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	
	WebDriver driver;
	JavascriptExecutor jse;
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://dev.assignforce.revaturelabs.com");
		
		login();
	}
	
	public void login() {
		driver.findElement(By.id("username")).sendKeys("");;
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("Login")).click();;
		
		jse = (JavascriptExecutor) driver;
		
		jse.executeScript("scroll(0,800)");
	}
	
	public static void main(String[] args) {
		Selenium s = new Selenium();
		s.invokeBrowser();
		
	}
}
