package com.revature.http;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.revature.db.DatabaseSingletonDaoImpl;
import com.revature.model.Test;
import com.revature.model.TestSystem;

/**
 * Servlet implementation class GetAllSystems
 */
public class GetAllSystems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllSystems() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response headers to allow cross origin request
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		// Try to execute jaxb marsheling
		try {
			// Set the context factory without the jaxb.properties file
			System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

			// JAXB JSON CONFIGURATION
			JAXBContext jaxbContext = JAXBContext.newInstance(TestSystem.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Try to parse the page parameter
			int page = 0;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			// Fetch the results from the web page and convert them to an array
			List<TestSystem> emp = DatabaseSingletonDaoImpl.getInstance().getAllSystem(page);
			TestSystem[] result = new TestSystem[emp.size()];
			result = emp.toArray(result);

			// Print out the jaxb json string
			jaxbMarshaller.marshal(result, System.out);
			jaxbMarshaller.marshal(result, response.getWriter());
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
