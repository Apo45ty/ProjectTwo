package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.revature.pom.LoginPage;
import com.revature.pom.NavbarPOM;

@Listeners(SafeForceResultListener.class)
public class VP_Nav_Sutie {

	static WebDriver wd;

	Thread thread;
	private int howLongtoWaitInSeconds = 3;
	@Test(groups = { "VP_Login" })
	public void LoginAsVP() {

		try {
			loginAsVPofTech();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Login");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksOverview() {
		try {
			loginAsVPofTech();

			clickOverview();
			TimeUnit.SECONDS.sleep(5);
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksBatches() {
		try {
			loginAsVPofTech();
			clickBatches();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01"}, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksCurricula() {
		try {
			loginAsVPofTech();
			clickCurricula();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksLocation() {
		try {
			loginAsVPofTech();
			clickLocations();
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksTraniner() {
		try {
			loginAsVPofTech();
			clickTrainers();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksProfile() {
		try {
			loginAsVPofTech();
			clickProfile();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksSettings() {
		try {
			loginAsVPofTech();
			clickSettings();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	@Test(groups = { "VP_Login", "Click", "Lvl=01" }, dependsOnMethods = { "LoginAsVP" })
	public void VPclicksLogout() {
		try {
			loginAsVPofTech();
			clickLogout();
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}

	}

	public void waitASecound() {

	}

	public void clickOverview() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.overview(wd)));
		element.click();

	}

	public void clickBatches() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.batches(wd)));
		element.click();
	}

	public void clickLocations() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.locations(wd)));
		element.click();
	}

	public void clickCurricula() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.curricula(wd)));
		
		
	}

	public void clickTrainers() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.trainers(wd)));
		element.click();
	}

	public void clickProfile() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.profile(wd)));
		element.click();
		
	}

	public void clickSettings() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.settings(wd)));
		element.click();
		
	}

	public void clickLogout() {
		WebDriverWait wait = new WebDriverWait(wd, howLongtoWaitInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.settings(wd)));
		element.click();
		
	}

	// Actions builder = new Actions(wd);
	// builder.moveToElement(BatchesPOM.core_curriculum(wd),10,
	// 2).click().perform();
	// //dropdown.selectByIndex(1);
	//
	// wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
	// NavbarPOM.logout(wd).click();
	//
	// }
	public void loginAsVPofTech() {
		openApplication();
		LoginPage.user(wd).sendKeys("test.vpoftech@revature.com.int1");
		LoginPage.pass(wd).sendKeys("yuvi1712");
		LoginPage.loginButton(wd).click();
		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void loginAsTrainer() {
		openApplication();
		LoginPage.user(wd).sendKeys("test.trainer@revature.com.int1");
		LoginPage.pass(wd).sendKeys("trainer123");
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
		wd.close();
	}

}
