package com.revature.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

	@Test(groups = { "include-test-one" })
	public void LoginAsVP() {
		try {
			loginAsVPofTech();
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
		} finally {
			wd.quit();
		}
	}
	// @Test(groups = { "include-test-one" })
	// public void VPclicksOverview() {
	// try {
	// loginAsVPofTech();
	// clickCurricula();
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
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
	// } catch (Exception e) {
	// System.out.println("I am guessing the log in failed");
	// } finally {
	// wd.quit();
	// }
	//
	// }

	public void waitASecound() {

	}

	public void clickOverview() {
		NavbarPOM.overview(wd).click();
	}

	public void clickBatches() {
		NavbarPOM.batches(wd).click();
	}

	public void clickLocations() {
		NavbarPOM.locations(wd).click();
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
		wd.manage().timeouts().implicitlyWait(29, TimeUnit.SECONDS);
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
