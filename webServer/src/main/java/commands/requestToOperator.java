package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServer.*;

/**
 * Servlet implementation class requestToOperator
 */
@WebServlet("/requestToOperator")
public class requestToOperator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		QueueDesk queueDesk = QueueDesk.getInstance();

		String param = request.getParameter("operatorId");
		if(param!=null) {
		try {
			int handlerId = Integer.valueOf(param);
			Operator handler = queueDesk.operators().stream().filter(x -> x.getId() == handlerId).findAny()
					.orElse(null);
			handler = queueDesk.operator(handler);
			if (handler != null) {
				result = "operator: " + handler;
			} else {
				result = "Unknown operator: " + param + " or queue is empty";
			}
		} catch (Exception e) {
			result = "Invalid operator ID: " + param;
		}
		}else {
			String phone = request.getParameter("phone");
			System.out.println("queueDesk.dbOperatorByPhone(phone)="+phone);
			try {
				Operator handler = queueDesk.dbOperatorByPhone(phone);
				handler = queueDesk.operator(handler);
				if (handler != null) {
					result = "operator: " + handler;
				} else {
					result = "Unknown operator: " + phone + " or queue is empty";
				}
			} catch (Exception e) {
				result = "Invalid operator ID: " + phone;
			}
			
		}
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
