package com.revature.http;

import java.io.File;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class SystemTestNG {

	public static void main(String[] args) {
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//path to xml
		File f =new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testng.xml");
		suites.add(f.getAbsolutePath()); 
		testng.setTestSuites(suites);
		testng.run();
	}

}
