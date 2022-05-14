package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webServer.Operator;
import webServer.QueueDesk;
//import webServer.*;

@WebServlet("/operatorById")
public class operatorById extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueueDesk queueDesk = QueueDesk.getInstance();
		String result = "";
		String param = request.getParameter("handler");
		try {
			int operatorId= Integer.valueOf(param);
			Operator operator = queueDesk.operators().stream().filter(x -> x.getId()==operatorId).findAny()
					.orElse(null);
			result = operator.toString();
		} catch (Exception e) {
			result = "Invalid operator ID: " + param;
		}
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
