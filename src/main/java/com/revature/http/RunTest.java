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
    
    
    public static final int  RUNALLTEST=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		//try to parse the suite info
		int suite = RUNALLTEST;
		try {
			suite = Integer.parseInt(request.getParameter("suite"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    System.out.println((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
	    switch(suite) {
	    case RUNALLTEST:
	    default:
	    	suites.add((new File("C:\\selenium\\testng.xml")).getAbsolutePath());
		    break;
	    }
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
