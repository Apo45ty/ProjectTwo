package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.revature.pom.LoginPage;
import com.revature.pom.NavbarPOM;
import com.revature.test.util.FileUtil;

@Listeners(SafeForceResultListener.class)
public class VP_Overview_Suite {
	static WebDriver wd;
	private int howLongtoWaitInSeconds = 3;
	private static String downloadPath = "C:\\Users\\kaiser\\Downloads";
//	@Test(groups = { "VP_Login" })
//	public void LoginAsVP() {
//
//		try {
//			loginAsVPofTech();
//			TimeUnit.SECONDS.sleep(2);
//		} catch (Exception e) {
//			System.out.println("I am guessing the log in failed");
//			org.testng.Assert.fail("Failed to Login");
//		} finally {
//			wd.quit();
//		}
//	}
//
//	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
//	public void VPclicksOverview() {
//		try {
//			loginAsVPofTech();
//			clickOverview();
//			TimeUnit.SECONDS.sleep(2);
//			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		} catch (Exception e) {
//			System.out.println("I am guessing the log in failed");
//			org.testng.Assert.fail("Failed to Click");
//		} finally {
//			wd.quit();
//		}
//	}

	// commented out for quicker testig and study
	//TODO replace hard waits for soft one
	@Test(groups = { "VP_Login", "Click", "Overview", "Happy" })
	//, dependsOnMethods = { "LoginAsVP", "VPclicksOverview" })
	public void VPOverviewClickExportCSV() {
		String expectedFileNameToBeDL = "batches.csv";
		
		try {
			FileUtil.DeleteFile(downloadPath, expectedFileNameToBeDL);// Deletes The File expected to be downloaded if it is already there
			loginAsVPofTech();// login 
			TimeUnit.SECONDS.sleep(5); // Wait for page to load
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //really making sure the page has loaded
			try {
				TimeUnit.SECONDS.sleep(2); // Wait for page to load
				WebElement overview_getCSV = wd.findElement(By.cssSelector("button[filename='batches.csv']"));
				System.out.println(overview_getCSV.toString());
				overview_getCSV.click(); // click on the found element I hope
				TimeUnit.SECONDS.sleep(3);// Apperantly you need to wait for the download	
				Assert.assertTrue(FileUtil.isFileThere(downloadPath, expectedFileNameToBeDL), "no filename matches anything in the given dierctory");
			} catch (NullPointerException e) {
				org.testng.Assert.fail("Get CSV for Overview has Failed to appear in Document");
				System.out.println("Failed to find Eelement \'overview_getCSV\'");
				
			}
			
			TimeUnit.SECONDS.sleep(4);
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	public void clickOverview() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.overview(wd)));
		element.click();

	}

	public void loginAsVPofTech() {
		openApplication();
		LoginPage.user(wd).sendKeys("test.vpoftech@revature.com.int1");
		LoginPage.pass(wd).sendKeys("yuvi1712");
		LoginPage.loginButton(wd).click();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void openApplication() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("https://dev.assignforce.revaturelabs.com");

	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
		wd.quit();
	}

}
