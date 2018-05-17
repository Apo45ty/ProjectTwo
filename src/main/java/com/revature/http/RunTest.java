package com.revature.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Servlet implementation class RunTest
 */
public class RunTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MyThread t;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunTest() {
        super();
        t = new MyThread();
        Thread thread = new Thread(t);
        thread.start();
    }
    /**
     * My thread class
     * @author Elton-John
     */
    class MyThread implements Runnable{
		private boolean hasRequest = false;
		private boolean done = false;
    	@Override
		public void run() {
			while(!done){
				if(hasRequest) {
					TestListenerAdapter adapter = new TestListenerAdapter();
					TestNG testng = new TestNG();
					testng.setTestClasses(new Class[] { 
							com.revature.test.Trainer_Locations.class,
							com.revature.test.StepsCurricula_VP.class
					});
					testng.addListener((ITestNGListener) adapter);
					testng.setVerbose(-1);
					testng.setUseDefaultListeners(false);
					testng.run();
					hasRequest=false;
				}
			}
		}
    	public boolean getHasRequest() {
    		return hasRequest;
    	}
    	public synchronized void setHasRequest(boolean hasrequest) {
    		hasRequest = hasrequest;
    	}
    	public boolean isDone() {
    		return done;
    	}
    	public void setDone(boolean pdone) {
    		done = pdone;
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		t.setHasRequest(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
