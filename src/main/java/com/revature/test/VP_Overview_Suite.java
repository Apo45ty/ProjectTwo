package com.revature.test;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
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
import com.revature.test.model.MockBatch;
import com.revature.test.util.FileUtil;
import com.revature.test.util.TableUtil;

@Listeners(SafeForceResultListener.class)
public class VP_Overview_Suite {
	static WebDriver wd;
	private int howLongtoWaitInSeconds = 3;
	private static String downloadPath = "C:\\Users\\kaiser\\Downloads";

	@Test(groups = { "VP_Login", "Login", "Happy" })
	public void LoginAsVP() {

		try {
			loginAsVPofTech();
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Login");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Navbar" }, dependsOnMethods = { "LoginAsVP" }, enabled =  true)
	
	public void VPclicksOverview() {
		try {
			loginAsVPofTech();
			VPclicksOverview();
			TimeUnit.SECONDS.sleep(3);
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("I am guessing the log in failed");
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	// commented out for quicker testig and study
	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Download" }, dependsOnMethods = { "LoginAsVP" },enabled =  true)
	public void VPOverviewClickExportCSV() {
		String expectedFileNameToBeDL = "batches.csv";

		try {
			FileUtil.DeleteFile(downloadPath, expectedFileNameToBeDL);// Deletes The File expected to be downloaded if
																		// // it is already there
			loginAsVPofTech();// login
			TimeUnit.SECONDS.sleep(5); // Wait for page to load
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // really making

			try {
				TimeUnit.SECONDS.sleep(2); // Wait for page to load
				WebElement overview_getCSV = wd.findElement(By.cssSelector("button[filename='batches.csv']"));
				System.out.println(overview_getCSV.toString());
				overview_getCSV.click(); // click on the found element I hope
				TimeUnit.SECONDS.sleep(3);// Apperantly you need to wait for the download
				Assert.assertTrue(FileUtil.isFileThere(downloadPath, expectedFileNameToBeDL),
						"no filename matches anything in the given dierctory");
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

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "DropDown" }, dependsOnMethods = { "LoginAsVP" },enabled =  true)
	public void VPOverviewClickFilterAndClickAllDropOptions() {

		try {
			loginAsVPofTech();// login
			TimeUnit.SECONDS.sleep(3); // Wait for page to load
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // really making sure the page has loaded
			TimeUnit.SECONDS.sleep(2); // Wait for page to load
			// Finds the Filter Button I hope
			WebElement overview_element_filter_btn = wd
					.findElement(By.cssSelector("button[aria-label=\"Filter\"]"));
			try {
								
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_btn.click(); // click on the found element I hope
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				// Progress DropDown Option
				WebElement overview_element_filter_Drop_Active = wd
						.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter = 'Active'\"]"));
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(overview_element_filter_Drop_Active.getTagName().toString());
				overview_element_filter_Drop_Active.click();
				TimeUnit.MILLISECONDS.sleep(350);

				/****
				 * NOTE TO FUTURE ED REMEBER TO CLICK THE DROP (filter) DOWN AGAIN TO BE ABLE TO
				 * CLICK THINGS IN IT(think about it you wasted 30mins on this)vvv
				 ****/
				// Re Clicks the Filter Button for the dropdown
				overview_element_filter_btn.click();
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Beginning in two Weeks DropDown Option
			WebElement overview_element_filter_Drop_Upcoming = wd.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter = 'Upcoming'\"]"));
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(overview_element_filter_btn.getTagName().toString());
			overview_element_filter_Drop_Upcoming.click();
			TimeUnit.MILLISECONDS.sleep(256);// Time is given fro elements to load
			try {
				// Re Clicks the Filter Button for the dropdown
				overview_element_filter_btn.click();
				TimeUnit.MILLISECONDS.sleep(200);

				// All DropDown Option
				WebElement overview_element_filter_Drop_All = wd.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter = 'All'\"]"));
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_Drop_All.click();
				TimeUnit.MILLISECONDS.sleep(300);

			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to find DropDown Item");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "DropDown" }, dependsOnMethods = { "LoginAsVP" }, enabled =  true)
	public void VPOverviewClickFilterDropDownItemAll() {

		try {
			loginAsVPofTech();// login
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // really making sure the page has loaded
			TimeUnit.SECONDS.sleep(2); // Wait for page to load
			try {
				TimeUnit.SECONDS.sleep(2); // Wait for page to load
				// Finds the Filter Button I hope
				WebElement overview_element_filter_btn = wd.findElement(By.cssSelector("button[aria-label='Filter']"));
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_btn.click(); // click on the found element I hope
				TimeUnit.MILLISECONDS.sleep(200);

				// All DropDown Option
				WebElement overview_element_filter_Drop_All = wd
						.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter = 'All'\"]"));
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_Drop_All.click();
				TimeUnit.MILLISECONDS.sleep(300);

				/**
				 * I Can't think of a way to test if getAll batches is really of the batchs -
				 * Maybe compare it to the other two filter options,and see if there are any in
				 * their, but not in all, but... eh
				 */

			} catch (NullPointerException e) {
				System.out.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to find DropDown Item");
			}

		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "FilterDropDown" }, dependsOnMethods = { "LoginAsVP" }, enabled =  true)

	public void VPOverviewClickFilterDropDownItemActive() {

		try {
			loginAsVPofTech();// login
			TimeUnit.SECONDS.sleep(3); // Wait for page to load
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // really making sure the page has loaded
			try {
				TimeUnit.SECONDS.sleep(2); // Wait for page to load
				// Finds the Filter Button I hope
				WebElement overview_element_filter_btn = wd.findElement(By.cssSelector("button[aria-label='Filter']"));
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_btn.click(); // click on the found element I hope
				TimeUnit.MILLISECONDS.sleep(200);

				// Progress DropDown Option
				WebElement overview_element_filter_Drop_Active = wd
						.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter =	 'Active'\"]"));
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(overview_element_filter_Drop_Active.getTagName().toString());
				overview_element_filter_Drop_Active.click();
				TimeUnit.MILLISECONDS.sleep(350);

				/****
				 * NOTE TO FUTURE ED REMEBER TO CLICK THE DROP (filter) DOWN AGAIN TO BE ABLE TO
				 * CLICK THINGS IN IT(think about it you wasted 30mins on this)vvv
				 ****/

			} catch (NullPointerException e) {
				System.out.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to find DropDown Item");

			}

		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "FilterDropDown" }, dependsOnMethods = { "LoginAsVP" },enabled =  true)
	 
	public void VPOverviewClickFilterDropDownItemUpcoming() {

		try {
			loginAsVPofTech();// login
			TimeUnit.SECONDS.sleep(3); // Wait for page to load
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // really making sure the page has loaded
			try {
				TimeUnit.SECONDS.sleep(2); // Wait for page to load
				// Finds the Filter Button I hope
				WebElement overview_element_filter_btn = wd.findElement(By.cssSelector("button[aria-label='Filter']"));
				System.out.println(overview_element_filter_btn.getTagName().toString());
				overview_element_filter_btn.click(); // click on the found element I hope
				TimeUnit.MILLISECONDS.sleep(200);

				// Progress DropDown Option
				WebElement overview_element_filter_Drop_Active = wd
						.findElement(By.cssSelector("button[ng-click=\"hCtrl.batchFilter = 'Upcoming'\"]"));
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(overview_element_filter_Drop_Active.getTagName().toString());
				overview_element_filter_Drop_Active.click();
				TimeUnit.MILLISECONDS.sleep(350);

				/****
				 * NOTE TO FUTURE ED REMEBER TO CLICK THE DROP (filter) DOWN AGAIN TO BE ABLE TO
				 * CLICK THINGS IN IT(think about it you wasted 30mins on this)vvv
				 ****/

			} catch (NullPointerException e) {
				System.out.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to find DropDown Item");

			}

		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  true)
	 
	public void VPOverviewTableSortByNameAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					Collections.sort(expectedSort, new MockBatch.SortByName());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out
								.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
						if (!(clickedOnce.get(index).getName().equals(expectedSort.get(index).getName()))) {
							org.testng.Assert.fail("Sort by Name is not in Ascending Order");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  true)
	 
	public void VPOverviewTableSortByNameDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled = true)

	public void VPOverviewTableSortByCurrAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortCurrDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	public void VPOverviewTableSortByTrainerAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}
	
	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortBDesceyTrainernding() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	public void VPOverviewTableSortByLocationAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortByLocationDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	public void VPOverviewTableSortByBuildingAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortByBuildingDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	public void VPOverviewTableSortByRoomAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortByRoomDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	public void VPOverviewTableSortBystartDateAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortByEndDateDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
	}
	
	public void VPOverviewTableSortByEndDateAscending() {
		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"curriculum.name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows);// Pre-AnySorting
			
			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"curriculum.name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click();
				try {
					// Ascending Test
					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedOnce = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSort = Notclicked;
					
					System.out.println("=========");
					for(MockBatch temp : Notclicked)
						System.out.println("Sorted:  " + temp.getCurriculum());
					
					/////////////////////
					Collections.sort(expectedSort, new MockBatch.SortByCurriculum());
					for(MockBatch temp : expectedSort)
						System.out.println("UnSorted:  " + temp.getCurriculum());
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(clickedOnce.get(index).getName() + " | " + expectedSort.get(index).getName());
////						if (!(clickedOnce.get(index).getCurriculum().equals(expectedSort.get(index).getCurriculum()))) {
////							org.testng.Assert.fail("Sort by Curriculum is not in Ascending Order");
//						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Ascending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println(e.getLocalizedMessage());
				org.testng.Assert.fail("Failed to Find the Element");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed during Click");
		} finally {
			wd.quit();
		}
	}

	@Test(groups = { "VP_Login", "Click", "Overview", "Happy", "Sort", "Table" }, dependsOnMethods = { "LoginAsVP" },enabled =  false)
	 
	public void VPOverviewTableSortBystartDateDescending() {

		try {
			loginAsVPofTech();// login
			WebDriverWait wait = new WebDriverWait(wd, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[md-order-by=\"name\"]")));

			List<WebElement> UnSortedRows = wd.findElements(
					By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
			List<MockBatch> Notclicked = com.revature.test.util.TableUtil.getMockBatch(UnSortedRows); // Pre-AnySorting

			try {
				WebElement overview_element_sort_table_by_name = wd
						.findElement(By.cssSelector("th[md-order-by=\"name\"]"));
				System.out.println("overview_element_sort_name: " + overview_element_sort_table_by_name.getText());
				overview_element_sort_table_by_name.click(); // Click sort
				TimeUnit.MILLISECONDS.sleep(350);
				overview_element_sort_table_by_name.click(); // Click sort
				try {
					// Descending Test

					List<WebElement> tableRows = wd.findElements(
							By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
					List<MockBatch> clickedTwice = com.revature.test.util.TableUtil.getMockBatch(tableRows);
					List<MockBatch> expectedSortReverse = Notclicked;
					Collections.sort(expectedSortReverse, new MockBatch.SortByName());
					Collections.reverse(expectedSortReverse);
					for (int index = 0; index < Notclicked.size(); index++) {
						System.out.println(
								clickedTwice.get(index).getName() + " | " + expectedSortReverse.get(index).getName());
						if (!(clickedTwice.get(index).getName().equals(expectedSortReverse.get(index).getName())))
							org.testng.Assert.fail("Sort by Name is not in Descending Order");
					}

				} catch (Exception e) {
					e.printStackTrace();
					org.testng.Assert.fail("Decending Table Error");
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				org.testng.Assert.fail("Failed to Find the Element");
				System.out.println("Failed to find Eelement \'overview_element_sort_name\'");
			}
		} catch (Exception e) {
			System.out.println("Failure due to: " + e.getLocalizedMessage());
			org.testng.Assert.fail("Failed to Click");
		} finally {
			wd.quit();
		}
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
