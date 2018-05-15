package com.revature.http;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

/**
 * Servlet implementation class RunTest
 */
public class RunTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunTest() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
//		testng.setTestClasses(new Class[] { 
//				com.revature.test.Trainer_Settings_Steps.class
//		});	
	    List<String> suites = Lists.newArrayList();
	    System.out.println((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
	    suites.add((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
	    testng.setTestSuites(suites);
		testng.addListener((ITestNGListener) adapter);
		testng.setVerbose(2);
//		testng.setUseDefaultListeners(false);
		testng.setPreserveOrder(true);
		testng.run();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
