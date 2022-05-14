package commands;
import webServer.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_request
 */
@WebServlet("/add_request")
public class add_request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		QueueDesk queueDesk = QueueDesk.getInstance();
		String clientName=request.getParameter("client_name");
		String clientPhone=request.getParameter("client_phone");
		String serviceName=request.getParameter("selected_option");
		Service service = queueDesk.findByName(serviceName);
		Client client = queueDesk.addClient(clientName, clientPhone);
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
