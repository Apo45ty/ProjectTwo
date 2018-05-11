package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/UserEntersTheLandingPage.feature", glue={"com.revature.cucumber"})
public class RunnerUserEntersTheLandingPage extends AbstractTestNGCucumberTests
{

}
