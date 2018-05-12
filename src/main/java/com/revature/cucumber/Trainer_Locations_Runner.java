package com.revature.cucumber;

import org.testng.annotations.Listeners;

import com.revature.test.SafeForceResultListener;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/trainer_locations.feature")
public class Trainer_Locations_Runner extends AbstractTestNGCucumberTests{

}