package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.revature.pom.BatchesPOM;
import com.revature.pom.LoginPage;
import com.revature.pom.NavbarPOM;

@Listeners(SafeForceResultListener.class)
public class Test_Runner {

	static WebDriver wd;

	Thread thread;

	/**
	 * 
	 */
	// @Test(priority = 0)
	// public void VerifyValidLogin() {
	// openApplication();
	// LoginPage.user(wd).sendKeys("test.trainer@revature.com.int1");
	// LoginPage.pass(wd).sendKeys("trainer123");
	// LoginPage.loginButton(wd).click();
	// wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
	// navbar.logout(wd).click();
	// wd.manage().timeouts().implicitlyWait(33, TimeUnit.SECONDS);
	//
	// }

	// @Test(groups = { "include-test-one" })
	//
	// public void LoginAsVP() {
	//
	// try {
	// loginAsVPofTech();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("To Login in");
	// } finally {
	// wd.quit();
	// }
	// }
	// @Test(groups = { "include-test-one" })
	// public void VPclicksOverview() {
	// try {
	// loginAsVPofTech();
	//
	// clickCurricula();
	// TimeUnit.SECONDS.sleep(5);
	// wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksBatches() {
	// try {
	// loginAsVPofTech();
	// clickBatches();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksCurricula() {
	// try {
	// loginAsVPofTech();
	// clickCurricula();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksLocation() {
	// try {
	// loginAsVPofTech();
	// clickLocations();
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksTraniner() {
	// try {
	// loginAsVPofTech();
	// clickTrainers();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksProfile() {
	// try {
	// loginAsVPofTech();
	// clickProfile();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksSettings() {
	// try {
	// loginAsVPofTech();
	// clickSettings();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }
	//
	// @Test(groups = { "include-test-one" })
	// public void VPclicksLogout() {
	// try {
	// loginAsVPofTech();
	// clickLogout();
	// TimeUnit.SECONDS.sleep(5);
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// org.testng.Assert.fail("Failed to Click");
	// } finally {
	// wd.quit();
	// }
	//
	// }

	public void waitASecound() {

	}

	public void clickOverview() {
		WebDriverWait wait = new WebDriverWait(wd, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.overview(wd)));
		element.click();

	}

	public void clickBatches() {
		WebDriverWait wait = new WebDriverWait(wd, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.batches(wd)));
		element.click();
	}

	public void clickLocations() {
		WebDriverWait wait = new WebDriverWait(wd, 3);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NavbarPOM.locations(wd)));
		element.click();
	}

	public void clickCurricula() {
		NavbarPOM.curricula(wd).click();
	}

	public void clickTrainers() {
		NavbarPOM.trainers(wd).click();
	}

	public void clickProfile() {
		NavbarPOM.profile(wd).click();
	}

	public void clickSettings() {
		NavbarPOM.settings(wd).click();
	}

	public void clickLogout() {
		NavbarPOM.logout(wd).click();
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
