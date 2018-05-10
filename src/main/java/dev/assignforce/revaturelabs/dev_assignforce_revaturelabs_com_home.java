/**
 * 
 */
package dev.assignforce.revaturelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ed M
 * @date May 10, 2018
 * @time time 1:58:47 PM
 */
public class dev_assignforce_revaturelabs_com_home {

	/**
	 * 
	 */
	private static WebElement element;

	public dev_assignforce_revaturelabs_com_home() {
		// TODO Auto-generated constructor stub
	}

	public static WebElement nav_bar(WebDriver wd) {
		element = wd.findElement(By.className("md-nav-bar"));
		return element;
	}

	public static WebElement overview(WebDriver wd) {
		element = wd.findElement(By.linkText("Overview"));
		return element;
	}

	public static WebElement batches(WebDriver wd) {
		element = wd.findElement(By.linkText("Batches"));
		return element;
	}

	public static WebElement locations(WebDriver wd) {
		element = wd.findElement(By.linkText("Locations"));
		return element;
	}

	public static WebElement curricula(WebDriver wd) {
		element = wd.findElement(By.linkText("Curricula"));
		return element;
	}

	public static WebElement trainers(WebDriver wd) {
		element = wd.findElement(By.linkText("Trainers"));
		return element;
	}

	public static WebElement profile(WebDriver wd) {
		element = wd.findElement(By.linkText("Profile"));
		return element;
	}

	public static WebElement reports(WebDriver wd) {
		element = wd.findElement(By.linkText("Reports"));
		return element;
	}

	public static WebElement settings(WebDriver wd) {
		element = wd.findElement(By.linkText("Settings"));
		return element;
	}

	public static WebElement logout (WebDriver wd) {
		element = wd.findElement(By.linkText("Logout"));
		return element;
	}
///------------------- END NAV BAR -----------------------------------///
}
