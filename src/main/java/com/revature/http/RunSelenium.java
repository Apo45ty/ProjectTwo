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
	WebDriver driver;
	DatabaseSingletonDao db;
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
		// Set response headers to allow cross origin request
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		
		openBrowser();
		navigateToURL();
		login();
		driver.close();
	}

	/**
	 * Settup webdriver and open new chrome browser window
	 */
	private void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	/**
	 * Navigate the browser to the test page url and measure page load time
	 */
	private void navigateToURL() {

		//Get time before loading the web page
		long startTime = System.currentTimeMillis();
		
		//Set the browser url
		driver.get("https://dev.assignforce.revaturelabs.com");

		//Force a timeout to wait for page to load a given html element
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Login")));

		//Get the current time and measure how long the page loading took
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		// Create a database dao instance and store run time as a Test object
		db = DatabaseSingletonDaoImpl.getInstance();
		Test t = new Test(1, "Java Time measured Running", "" + totalTime, false, db.readTT(10), db.readS(10));
		db.create(t);
		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
		
		//Use Javascript to measure the page load time using Performance Timing variables
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
		//Store the javascript time in the database
		t = new Test(2, "Javascript Time measured", "" + loadtime, false, db.readTT(10), db.readS(10));
		db.create(t);
	}

	/**
	 * Automate the entering login credentials and login into web page
	 */
	public void login() {
		
		//enter the username for the web page
		driver.findElement(By.id("username")).sendKeys("test.trainer@revature.com.int1");
		//enter the password for the web page
		driver.findElement(By.id("password")).sendKeys("trainer123");
		//click the login button
		driver.findElement(By.id("Login")).click();

		//Cast Web Driver to a javascript
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//execute a page scroll
		jse.executeScript("scroll(0,800)");

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
