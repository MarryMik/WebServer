package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webServer.QueueDesk;

/**
 * Servlet implementation class reset_operators
 */
@WebServlet("/reset_operators")
public class reset_operators extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueueDesk queueDesk = QueueDesk.getInstance();
		String result;
//		queueDesk.operators().clear();
		queueDesk.resetOperators();
		queueDesk.addOperator("380967777777", "first", "Марія","1111");
		queueDesk.addOperator("380968888888", "second" , "Олег", "1111");
		queueDesk.addOperator("380965555555", "third", "Петро", "1111");
		queueDesk.addOperator("380964444444", "fourth", "Олена", "1111");
		result = "service: " + queueDesk.operators();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
