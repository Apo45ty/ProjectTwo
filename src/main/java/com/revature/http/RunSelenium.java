package com.revature.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.db.DatabaseSingletonDao;
import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;

/**
 * Servlet implementation class RunSelenium
 */
public class RunSelenium extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RunSelenium() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		DatabaseSingletonDao db = DatabaseSingletonDaoImpl.getInstance();
		WebDriver driver;
		JavascriptExecutor jse;
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		long startTime = System.currentTimeMillis();

		driver.get("https://dev.assignforce.revaturelabs.com");

		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Login")));

		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		Test t = new Test(1, "Java Time measured Running", "" + totalTime, false, db.readTT(10), db.readS(10));
		db.create(t);
		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
		t = new Test(2, "Javascript Time measured", "" + loadtime, false, db.readTT(10), db.readS(10));
		db.create(t);

		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		;
		driver.findElement(By.id("password")).sendKeys("trainer123");
		driver.findElement(By.id("Login")).click();
		;

		jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0,800)");
		driver.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
