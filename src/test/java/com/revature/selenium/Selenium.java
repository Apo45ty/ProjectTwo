package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.db.DatabaseSingletonDao;
import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;

public class Selenium {
	DatabaseSingletonDao db = DatabaseSingletonDaoImpl.getInstance();
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
		
		long startTime = System.currentTimeMillis();

		driver.get("https://dev.assignforce.revaturelabs.com");

		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Login")));
		
		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;
		
		Test t = new Test(1, "Java Time measured Running", ""+totalTime, false,db.readTT(10),db.readS(10));
		db.create(t);
		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
		t = new Test(2, "Javascript Time measured", ""+loadtime, false,db.readTT(10),db.readS(10));
		db.create(t);
		login();
		
	}
	
	public void login() {
		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");;
		driver.findElement(By.id("password")).sendKeys("trainer123");
		driver.findElement(By.id("Login")).click();;
		
		jse = (JavascriptExecutor) driver;
		
		jse.executeScript("scroll(0,800)");
		driver.close();
	}
	
	public static void main(String[] args) {
		Selenium s = new Selenium();
		s.invokeBrowser();
		
	}
}
