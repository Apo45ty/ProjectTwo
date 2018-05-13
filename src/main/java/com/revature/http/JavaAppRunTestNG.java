package com.revature.http;

import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;

import com.revature.test.SafeForceResultListener;
@Listeners(SafeForceResultListener.class)
public class JavaAppRunTestNG {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ResultListener adapter = new ResultListener();
		TestNG testng = new TestNG();
//		List<String> suites = Lists.newArrayList();
//		File f =new File("src\\main\\resources\\testng.xml");
//		suites.add(f.getAbsolutePath()); 
//		testng.setTestSuites(suites);
		testng.setTestClasses(new Class[] { com.revature.cucumber.CucumberRunner.class });
		testng.addListener(adapter);
		testng.run();
	}



}
