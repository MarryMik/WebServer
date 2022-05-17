package commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import webServer.*;

@WebServlet("/CommandOperators")
public class CommandOperators extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueueDesk queueDesk = QueueDesk.getInstance();
//		String result = queueDesk.operators().toString();

		String json = new Gson().toJson(queueDesk.operators());
		
		response.setContentType("text/plain;charset=UTF-8");
//		response.getWriter().write(result);
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
