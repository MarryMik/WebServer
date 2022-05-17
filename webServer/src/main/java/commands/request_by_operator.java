package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import webServer.*;


@WebServlet("/request_by_operator")
public class request_by_operator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QueueDesk queueDesk = QueueDesk.getInstance();
		String param = request.getParameter("operator_phone");

		String json;
		if(param!=null) {
			json = new Gson().toJson(queueDesk.dbRequestsOperatorByPhone(param));

		}else {
			param = request.getParameter("user_phone");
			json = new Gson().toJson(queueDesk.dbRequestsOperatorByPhone(param));

		}
		
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
