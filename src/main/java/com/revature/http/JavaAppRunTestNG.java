package com.revature.http;

import java.util.List;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.revature.db.UpdatedDBSingletonDAO;
import com.revature.db.UpdatedDBSingletonDAOImpl;
import com.revature.model.UpdatedTest;

public class JavaAppRunTestNG {
	public static void main(String[] args) {
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
//		List<String> suites = Lists.newArrayList();
//		File f =new File("src\\main\\resources\\testng.xml");
//		suites.add(f.getAbsolutePath()); 
//		testng.setTestSuites(suites);
		testng.setTestClasses(new Class[] { com.revature.test.StepsCurricula_VP.class });
		testng.addListener((ITestNGListener) adapter);
		testng.run();
	}



}
