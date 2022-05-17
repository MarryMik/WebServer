package cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/process2")
public class process2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public process2() {
        super();
    }
    
    String htmText2="<!DOCTYPE html>\r\n"
    		+ "<html lang=\"en\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
    		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
    		+ "    <title>Queue</title>\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 944px) \" href=\"./style/style.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 554px) and (max-width:944px)\" href=\"./style/styles1.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen  and (max-width:554px)\" href=\"./style/styles2.css\">\r\n"
    		+ "\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 944px) \" href=\"./style/queuestyle.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 554px) and (max-width:944px)\" href=\"./style/queuestyle1.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen  and (max-width:554px)\" href=\"./style/queuestyle2.css\">\r\n"
    		+ "    <link href=\"http://fonts.cdnfonts.com/css/roboto\" rel=\"stylesheet\">\r\n"
    		+ "    <script src=\"./js/queuePrint.js\" defer></script>\r\n"
    		+ "</head>\r\n"
    		+ "\r\n"
    		+ "<body onload=\"postName();\">\r\n"
    		+ "    <header class=\"header\">\r\n"
    		+ "        <nav class=\"nav-bar\">\r\n"
    		+ "            <div class =\"nav-bar-wrapper\">\r\n"
    		+ "                <div class=\"nav-logo-wrapper\">\r\n"
    		+ "                    <a class=\"logo-link\" ><i class=\"nav-logo\"></i></a>\r\n"
    		+ "                    <span class=\"nav-title\"><a class=\"title-link\" >Your Contract</a></span>\r\n"
    		+ "                </div>\r\n"
    		+ "            </div>\r\n"
    		+ "\r\n"
    		+ "            <div class=\"nav-menu-wrapper\">\r\n"
    		+ "                <span class=\"nav-menu-item\"><a class=\"nav-menu-item-link\" href=\"queueAcount.html\">Черга</a></span>\r\n"
    		+ "                <span class=\"nav-menu-item\" id=\"last-span-nav-menu-item\"><a class=\"nav-menu-item-link\" href=\"DeleteCookie\">Вихід</a></span>\r\n"
    		+ "                <a href=\"process2\" class=\"icon-link\"><i class=\"nav-menu-item\"></i></a>\r\n"
    		+ "                <div class=\"menu-button\"></div>\r\n"
    		+ "            </div>\r\n"
    		+ "            \r\n"
    		+ "        </nav>\r\n"
    		+ "    </header>\r\n"
    		+ "\r\n"
    		+ "    <div class=\"page-wrapper\">\r\n"
    		+ "        <section class=\"queue-section\">\r\n"
    		+ "            <div class=\"left\"></div>\r\n"
    		+ "            <div class=\"queue-list-wrapper\" id=\"queue-list-wrapper\">                \r\n"
    		+ "                <form id=\"next-form\"><h2 class=\"queue-title\">Твоя черга</h2>\r\n"
    		+ "                	<div class=\"button-wrapper\">\r\n"
    		+ "                	<!-- operator's phone -->\r\n"
    		+ "                	<input id=\"userPhone\" name=\"userPhone\" type=\"hidden\" value=\"$$$\"/>\r\n"
    		+ "                                <button class=\"form-submit-button\" onclick=\"nextTicket(); \" type=\"submit\">Next</button>\r\n"
    		+ "                    <button class=\"form-submit-button\"  onclick=\"closeTicket(); \" type=\"submit\">Close</button></div>\r\n"
    		+ "                </form>\r\n"
    		+ "                <div class=\"applications-title-wrapper\">\r\n"
    		+ "                    <h4 class=\"title-applications\" id=\"title-id\">Клієнт</h4>\r\n"
    		+ "                    <h4 class=\"title-applications\" id=\"title-type\">Послуга</h4>\r\n"
    		+ "                    <h4 class=\"title-applications\" id=\"title-status\">Статус</h4>\r\n"
    		+ "                </div>\r\n"
    		+ "                <div id=\"requests\"></div>\r\n"
    		+ "             </div>\r\n"
    		+ "            <div class=\"right\"></div>\r\n"
    		+ "        </section>\r\n"
    		+ "    </div>\r\n"
    		+ "    \r\n"
    		+ "</body>\r\n"
    		+ "</html>";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie ck[]=request.getCookies();  
	    String phone =ck[0].getValue();      
//		QueueDesk queueDesk = QueueDesk.getInstance();
		
//		queueDesk.operator(queueDesk.operatorByPhone(phone)); 
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(htmText2.replace("$$$", phone));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
