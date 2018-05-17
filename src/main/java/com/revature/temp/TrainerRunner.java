package com.revature.temp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="C:\\selenium\\TrainersTest.feature",glue={"com.revature.temp"})
public class TrainerRunner extends AbstractTestNGCucumberTests{

}
