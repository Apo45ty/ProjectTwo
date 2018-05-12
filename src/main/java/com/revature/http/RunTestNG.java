/**
 * 
 */
package com.revature.http;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.db.UpdatedDBSingletonDAOImpl;
import com.revature.model.UpdatedTest;

/**
 * @author Ed M
 * @date May 12, 2018
 * @time time 3:05:03 PM
 */
public class RunTestNG extends HttpServlet {

	/**
	 * 
	 */
	public RunTestNG() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
		String commandType = request.getParameter("type");
		if (ajax) {
			List<UpdatedTest> result = UpdatedDBSingletonDAOImpl.getInstance().getAllTest(0);
			if (commandType.equals("getallTest")) {
				String json = new Gson().toJson(result);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				try {
					response.getWriter().write(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (commandType.equals("startTestNGtest")) {
				response.setContentType("text/html");

				String url = request.getParameter("url");

				// add the parameters to be passed to the main method of the selenium test into
				// a string array

				String[] urls = new String[1];

				urls[0] = url;

				// pass the string array as an argument to the main method

				com.revature.test.Test_Runner.openApplication();
			}
		}
	}
}
