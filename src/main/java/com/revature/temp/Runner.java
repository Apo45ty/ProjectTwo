package com.revature.temp;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\selenium\\CucumberSelenium.feature", glue={"com.revature.cucumber"})
public class Runner extends AbstractTestNGCucumberTests
{
	
}
