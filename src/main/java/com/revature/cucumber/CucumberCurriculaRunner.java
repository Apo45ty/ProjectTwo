package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/resources/CucumberCurricula.feature")
public class CucumberCurriculaRunner extends AbstractTestNGCucumberTests {

}
