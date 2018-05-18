package com.revature.http;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

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

	public static final int RUNALLTEST = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		// try to parse the suite info
		int suiteNum = RUNALLTEST;
		try {
			suiteNum = Integer.parseInt(request.getParameter("suite"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

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
		// ITestNGListener listener = new ListenerTest();
		// testng.addListener(listener);
		testng.setUseDefaultListeners(false);
		// programmatically run testNG!!
		System.out.println("About to run TestNG");
		testng.run();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
