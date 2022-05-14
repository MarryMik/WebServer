package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServer.*;

@WebServlet("/request_by_status")
public class request_by_status extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		QueueDesk queueDesk = QueueDesk.getInstance();
		String param = request.getParameter("status");
		try {
			
			Request.Status status = Request.Status.valueOf(param);
			result = queueDesk.requests(status).toString();
		} catch (Exception e) {
			result = "Invalid status ID: " + param;
		}
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
