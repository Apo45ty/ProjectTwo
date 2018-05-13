package com.revature.http;

import java.util.List;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
<<<<<<< HEAD

import com.revature.db.UpdatedDBSingletonDAO;
import com.revature.db.UpdatedDBSingletonDAOImpl;
import com.revature.model.UpdatedTest;
=======
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;
>>>>>>> ff9f581fc93d7fd934cd366decb6fb458d63ecc1

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
<<<<<<< HEAD
		testng.setTestClasses(new Class[] { com.revature.test.StepsCurricula_VP.class });
		testng.addListener((ITestNGListener) adapter);
=======
		testng.setTestClasses(new Class[] { com.revature.cucumber.CucumberRunner.class });
		testng.addListener(adapter);
>>>>>>> ff9f581fc93d7fd934cd366decb6fb458d63ecc1
		testng.run();
	}



}
