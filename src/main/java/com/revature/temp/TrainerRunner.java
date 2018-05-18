package com.revature.temp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src\\main\\resources\\TrainersTest.feature")
public class TrainerRunner extends AbstractTestNGCucumberTests{
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("================== TRACKFORCE TESTS ==================");
		
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Logging out");
	}
}
