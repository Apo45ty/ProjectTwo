package com.revature.http;

import java.io.IOException;

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

/**
 * Servlet implementation class GetAllRequest
 */
public class GetAllRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// Set the Marshaller media type to JSON or XML
			jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

			// Set it to true if you need to include the JSON root element in the JSON
			// output
			jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
			// Set it to true if you need the JSON output to formatted
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			int page = 0;
			try {
				page=Integer.parseInt(request.getParameter("page"));
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			Test[] result = DatabaseSingletonDaoImpl.getInstance().getAllTest();
			jaxbMarshaller.marshal(result, System.out);
			jaxbMarshaller.marshal(result, response.getWriter());
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
