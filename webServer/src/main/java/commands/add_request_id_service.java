package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServer.*;

@WebServlet("/add_request_id_service")
public class add_request_id_service extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		QueueDesk queueDesk = QueueDesk.getInstance();
		String clientName=request.getParameter("client_name");
		String clientPhone=request.getParameter("client_phone");
		String serviceId=request.getParameter("service_id");
		Client client = queueDesk.addClient(clientName, clientPhone);
		Service service = queueDesk.checkService(Integer.valueOf(serviceId));
		Request reques = queueDesk.addRequest(client, service);
		result = "request: " + reques;
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
