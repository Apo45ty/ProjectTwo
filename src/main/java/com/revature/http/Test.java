package com.revature.http;

import java.io.File;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Test {

	public static void main(String[] args) {
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
//		testng.setTestClasses(new Class[] { 
//				com.revature.test.Trainer_Settings_Steps.class
//		});	
	    java.util.List<String> suites = Lists.newArrayList();
	    System.out.println((new File("src/main/resources/testng.xml")).getAbsolutePath());
	    suites.add((new File("./src/main/resources/testng.xml")).getAbsolutePath());
	    testng.setTestSuites(suites);
		testng.addListener((ITestNGListener) adapter);
		testng.setVerbose(-1);
		testng.setUseDefaultListeners(false);
		testng.setPreserveOrder(true);
		testng.run();
	}

}
