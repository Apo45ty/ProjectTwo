package com.revature.http;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Test {

	public static void main(String[] args) {
		// create <suite name="AllTests">
		XmlSuite suite = new XmlSuite();
		suite.setName("SuiteOfAllTests");
		// create <test name="LoginTest">
		XmlTest test = new XmlTest(suite);
		test.setName("AllTests");
		// create <classes>
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.revature.temp.TrainerRunner"));
		test.setXmlClasses(classes);
		// testNG instance
	    TestNG testng = new TestNG();
	    // create list of suites to run
	    List<XmlSuite> suites = new ArrayList<XmlSuite>();
	    suites.add(suite);
	    // add suites to testNG
	    testng.setXmlSuites(suites);
	    // create and add test listener which will generate response object
//	    ITestNGListener listener = new ListenerTest();
//	    testng.addListener(listener);
	    testng.setUseDefaultListeners(false);
	    // programmatically run testNG!!
	    System.out.println("About to run TestNG");
	    testng.run();
//		TestListenerAdapter adapter = new TestListenerAdapter();
//		TestNG testng = new TestNG();
//		// testng.setTestClasses(new Class[] {
//		// com.revature.test.Trainer_Settings_Steps.class
//		// });
//		java.util.List<String> suites = Lists.newArrayList();
//		System.out.println((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
//		suites.add((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
//		testng.setTestSuites(suites);
//		testng.addListener((ITestNGListener) adapter);
//		testng.setVerbose(-1);
//		testng.setUseDefaultListeners(false);
//		testng.setPreserveOrder(true);
//		testng.run();
	}

}
