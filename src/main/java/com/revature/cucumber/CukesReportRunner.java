package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/resources/cukesReport.feature")
public class CukesReportRunner extends AbstractTestNGCucumberTests {

}
