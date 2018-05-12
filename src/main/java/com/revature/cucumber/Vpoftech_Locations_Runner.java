package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/vpoftech_locations.feature")
public class Vpoftech_Locations_Runner extends AbstractTestNGCucumberTests{

}