package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServer.*;

@WebServlet("/reset_services")
public class reset_services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueueDesk queueDesk = QueueDesk.getInstance();
		String result;
//		queueDesk.services().clear();
		queueDesk.resetServices();
//		Service s1 = new Service("Загальна консультація");
//		Service s2 = new Service("Публічний договір");
//		Service s3 = new Service("Договір приєднання");
//		Service s4 = new Service("Попередній договір");
//		Service s5 = new Service("Договір на користь третьої особи");

		queueDesk.addService("Загальна консультація");
		queueDesk.addService("Публічний договір");
		queueDesk.addService("Договір приєднання");
		queueDesk.addService("Попередній договір");
		queueDesk.addService("Договір на користь третьої особи");

		
//		queueDesk.services().add(s2);
//		queueDesk.services().add(s3);
//		queueDesk.services().add(s4);
//		queueDesk.services().add(s5);
		result = "service: " + queueDesk.services();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
