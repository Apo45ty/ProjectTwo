package com.revature.http;

<<<<<<< HEAD
import java.io.IOException;
=======
import java.io.File;
import java.io.IOException;
import java.util.List;

>>>>>>> 61cc6993e95a493d512cff12e42a32aa3dc55192
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
<<<<<<< HEAD
=======
import org.testng.collections.Lists;

>>>>>>> 61cc6993e95a493d512cff12e42a32aa3dc55192

/**
 * Servlet implementation class RunCucumber
 */
public class RunCucumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunCucumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestListenerAdapter adapter = new TestListenerAdapter();
		TestNG testng = new TestNG();
<<<<<<< HEAD
=======
//		List<String> suites = Lists.newArrayList();
//		File f =new File("src\\main\\resources\\testng.xml");
//		suites.add(f.getAbsolutePath()); 
//		testng.setTestSuites(suites);
>>>>>>> 61cc6993e95a493d512cff12e42a32aa3dc55192
		testng.setTestClasses(new Class[] { com.revature.cucumber.CucumberRunner.class });
		testng.addListener((ITestNGListener) adapter);
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
