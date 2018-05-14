package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BatchesPOM {
	private static WebElement element;
	
	public static WebElement core_curriculum(WebDriver wd) {
		element = wd.findElement(By.id("select_value_label_1"));
		return element;
	}
	public static WebElement focus(WebDriver wd) {
		element = wd.findElement(By.id("select_value_label_2"));
		return element;
	}
	public static WebElement skills(WebDriver wd) {
		element = wd.findElement(By.id("select_value_label_3"));
		return element;
	}
}
