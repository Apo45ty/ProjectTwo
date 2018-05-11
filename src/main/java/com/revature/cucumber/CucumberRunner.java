package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/cucumberFeature.feature")
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
