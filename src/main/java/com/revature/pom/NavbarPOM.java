/**
 * 
 */
package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ed M
 * @date May 10, 2018
 * @time time 1:58:47 PM
 */
public class NavbarPOM {

	public static WebElement element;

	public static WebElement nav_bar(WebDriver wd) {
		element = wd.findElement(By.className("md-nav-bar"));
		return element;
	}

	public static WebElement overview(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]"));
		return element;
	}

	public static WebElement batches(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[2]"));
		return element;
	}

	public static WebElement locations(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[3]"));
		return element;
	}

	public static WebElement curricula(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]"));
		return element;
	}

	public static WebElement trainers(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]"));
		return element;
	}

	public static WebElement profile(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[6]"));
		return element;
	}

	public static WebElement reports(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[7]"));
		return element;
	}

	public static WebElement settings(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]"));
		return element;
	}

	public static WebElement logout(WebDriver wd) {
		element = wd
				.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[9]"));
		return element;
	}

	///-------------------- END NAV BAR --------------------///
	public static WebElement view(WebDriver wd) {
		element = wd.findElement(By.id("view"));
		return element;
	}
}
