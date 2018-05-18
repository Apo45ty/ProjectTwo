package com.revature.temp;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrainersTestSteps {

	{
		System.out.println("Started tts");
	}
	WebDriver driver;
	private String randomFirstName = "test";
	private String randomSecondName = "test";
	private String tempName = "test";
	private WebElement nameElement;

	@Given("^Launches Chrome Browser and login$")
	public void launches_Chrome_Browser_and_login() throws Throwable {
		String path = System.getProperty("user.home") + File.separator + "AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + path);
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://dev.assignforce.revaturelabs.com");
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 10_000)).until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("test.vpoftech@revature.com.int1");
		driver.findElement(By.id("password")).sendKeys("yuvi1712");
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	}

	@When("^Clicks on the trainers tab$")
	public void clicks_on_the_trainers_tab() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='trainers']")));
		driver.findElement(By.xpath("//a[@href='trainers']")).click();
		//// a[@href='mercurywelcome.php']
	}

	@Then("^Clicks on first trainer$")
	public void clicks_on_first_trainer() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 40_000)).until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(".md-no-style.md-button.md-ink-ripple")));
		List<WebElement> list = driver.findElements(By.cssSelector(".md-no-style.md-button.md-ink-ripple"));
		// System.out.println("number of elements found: " + list.size());
		list.get(0).click();
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// *[@id="view"]/md-card/md-content[1]/md-list/md-list-item[1]/div/button
	}

	@Then("^Verifies that the profile page loaded$")
	public void verifies_that_the_profile_page_loaded() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// System.out.println(driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains("profile"));

	}

	@Then("^Clicks on the create new trainer button$")
	public void clicks_on_the_create_new_trainer_button() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		List<WebElement> list = driver.findElements(By.cssSelector(".md-icon-button.md-button.md-ink-ripple"));
		// System.out.println("number of elements found: " + list.size());
		list.get(0).click();

	}// div[@classs='md-toolbar-tools'] .md-icon-button.md-button.md-ink-ripple/

	@Then("^Enters a new firstname and lastname$")
	public void enters_a_new_firstname_and_lastname() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000)).until(ExpectedConditions.presenceOfElementLocated(By.id("input_1")));
		getRandomName();
		driver.findElement(By.id("input_1")).sendKeys(randomFirstName);
		driver.findElement(By.id("input_2")).sendKeys(randomSecondName);
	}

	public void getRandomName() {
		int size = (int) (Math.random() * 100);
		randomFirstName = "";
		randomSecondName = "";
		for (int i = 0; i < size; i++) {
			randomFirstName += "" + (char) (Math.random() * (double) Short.MAX_VALUE);
			randomSecondName += "" + (char) (Math.random() * (double) Short.MAX_VALUE);
		}
		System.out.println("First Name: " + randomFirstName);
		System.out.println("Second Name: " + randomFirstName);
	}

	@Then("^Clicks on the save button$")
	public void clicks_on_the_save_button() throws Throwable {
		driver.findElement(By.id("input_2")).sendKeys(Keys.RETURN);
	}// md-primary md-button md-ink-ripple

	@Then("^Verifies that the trainr is created$")
	public void verifies_that_the_trainr_is_created() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='ng-binding']")));
		List<WebElement> list = driver.findElements(By.xpath("//h3[@class='ng-binding']"));
		System.out.println("number of elements found: " + list.size());
		boolean hasElement = false;
		for (WebElement we : list) {
			if (we.getText().equals(randomFirstName + " " + randomSecondName)) {
				hasElement = true;
				break;
			}
		}
		System.out.println(""+hasElement);
	}

	@Then("^Selects the first unactivated trainer and activates the trainer$")
	public void selects_the_first_unactivated_trainer_and_activates_the_trainer() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000)).until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(".material-icons.revOrange.ng-scope")));
		List<WebElement> list = driver.findElements(By.cssSelector(".material-icons.revOrange.ng-scope"));
		System.out.println("number of elements found: " + list.size());
		int count = 0;
		for (WebElement we : list) {
			if (we.getText().equals("add_circle")) {
				// Store the webelement
				System.out.println(we);
				nameElement = we.findElement(By.xpath(".."));
				System.out.println(nameElement);
				nameElement = nameElement.findElement(By.xpath(".."));
				System.out.println(nameElement);
				nameElement = nameElement.findElement(By.xpath("//h3[@class='ng-binding']"));
				System.out.println(nameElement);
				// Click to activate it
				we.click();
				break;
			}
			count++;
		}
	}

	@Then("^Verifies that the selected trainer is activated$")
	public void verifies_that_the_selected_trainer_is_activated() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000)).until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(".material-icons.revOrange.ng-scope")));
		List<WebElement> list = driver.findElements(By.cssSelector(".material-icons.revOrange.ng-scope"));
		System.out.println("number of elements found: " + list.size());
		boolean isActivated = false;
		for (WebElement we : list) {
			if (we.getText().equals("remove_circle")) {
				// Store the webelement
				WebElement temp = we.findElement(By.xpath(".."));
				temp = temp.findElement(By.xpath(".."));
				temp = temp.findElement(By.xpath("//h3[@class='ng-binding']"));
				if (temp.getText().equals(nameElement.getText())) {
					isActivated = true;
					break;
				}
			}
		}
		assertTrue(isActivated);
	}

	@Then("^Selects the first activated trainer and unactivates the trainer$")
	public void selects_the_first_activated_trainer_and_unactivates_the_trainer() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 20_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".material-icons.revOrange.ng-scope")));
		List<WebElement> list = driver.findElements(By.cssSelector(".material-icons.revOrange.ng-scope"));
		System.out.println("number of elements found: " + list.size());
		int count = 0;
		for (WebElement we : list) {
			if (we.getText().equals("remove_circle")) {
				// Store the webelement
				System.out.println(we);
				nameElement = we.findElement(By.xpath(".."));
				System.out.println(nameElement);
				nameElement = nameElement.findElement(By.xpath(".."));
				System.out.println(nameElement);
				nameElement = nameElement.findElement(By.xpath("//h3[@class='ng-binding']"));
				System.out.println(nameElement);
				tempName = nameElement.getText();
				// Click to activate it
				we.click();
				break;
			}
			count++;
		}
	}

	@Then("^Verifies that the selected trainer is unactivated$")
	public void verifies_that_the_selected_trainer_is_unactivated() throws Throwable {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		(new WebDriverWait(driver, 1_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='curriculum']")));
		driver.findElement(By.xpath("//a[@href='curriculum']")).click();
		(new WebDriverWait(driver, 1_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='trainers']")));
		driver.findElement(By.xpath("//a[@href='trainers']")).click();
		(new WebDriverWait(driver, 20_000))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".material-icons.revOrange.ng-scope")));
		List<WebElement> list = driver.findElements(By.cssSelector(".material-icons.revOrange.ng-scope"));
		System.out.println("number of elements found: " + list.size());
		boolean isUnactivated = false;
		for (WebElement we : list) {
			if (we.getText().equals("add_circle")) {
				// Store the webelement
				WebElement temp = we.findElement(By.xpath(".."));
				temp = temp.findElement(By.xpath(".."));
				temp = temp.findElement(By.xpath("//h3[@class='ng-binding']"));
//				System.out.println(temp.getText());
				if (temp.getText().equals(tempName)) {
					isUnactivated = true;
					break;
				}
			}
		}
		System.out.println("Found on deactivated "+isUnactivated);
	}

	@Then("^Logs Out$")
	public void logs_Out() throws Throwable {
		try {
			List<WebElement> list = driver.findElements(
					By.cssSelector("._md-nav-button.md-accent.md-button.ng-scope.md-ink-ripple.md-unselected"));
			list.get(7).click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
