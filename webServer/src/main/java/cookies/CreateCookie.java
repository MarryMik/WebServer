package cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webServer.*;

@WebServlet("/process1")
public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCookie() {
        super();
    }
    private String htmText1="<!DOCTYPE html>\r\n"
    		+ "<html lang=\"en\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
    		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
    		+ "    <title>Sign in</title>\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 944px) \" href=\"./style/style.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 554px) and (max-width:944px)\" href=\"./style/styles1.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (max-width:554px)\" href=\"./style/styles2.css\">\r\n"
    		+ "\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 944px) \" href=\"./style/acoountstyle.css\" >\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (min-width: 554px) and (max-width:944px)\" href=\"./style/acountstyles1.css\">\r\n"
    		+ "    <link rel=\"stylesheet\" media=\"screen and (max-width:554px)\"href=\"./style/accountstyles2.css\">\r\n"
    		+ "    <link href=\"http://fonts.cdnfonts.com/css/roboto\" rel=\"stylesheet\">\r\n"
    		+ "    \r\n"
    		+ "    \r\n"
    		+ "</head>\r\n"
    		+ "<style>\r\n"
    		+ "    html,\r\n"
    		+ "    body{\r\n"
    		+ "        height: 100%;\r\n"
    		+ "        min-width: 470px;\r\n"
    		+ "    }\r\n"
    		+ "</style>\r\n"
    		+ "<body>\r\n"
    		+ "    <header class=\"header\">\r\n"
    		+ "        <nav class=\"nav-bar\">\r\n"
    		+ "            <div class =\"nav-bar-wrapper\">\r\n"
    		+ "                <div class=\"nav-logo-wrapper\">\r\n"
    		+ "                    <a class=\"logo-link\" href=\"index.html\"><i class=\"nav-logo\"></i></a>\r\n"
    		+ "                    <span class=\"nav-title\"><a class=\"title-link\" href=\"index.html\">Your Contract</a></span>\r\n"
    		+ "                </div>\r\n"
    		+ "            </div>\r\n"
    		+ "\r\n"
    		+ "            <div class=\"nav-menu-wrapper\">\r\n"
    		+ "                <span class=\"nav-menu-item\"><a class=\"nav-menu-item-link\" href=\"queue.html\">Черга</a></span>\r\n"
    		+ "                <span class=\"nav-menu-item\" id=\"last-span-nav-menu-item\"><a class=\"nav-menu-item-link\" href=\"index.html\">Подати заявку</a></span>\r\n"
    		+ "                <a href=\"account.html\" class=\"icon-link\"><i class=\"nav-menu-item\"></i></a>\r\n"
    		+ "                <div class=\"menu-button\"></div>\r\n"
    		+ "            </div>\r\n"
    		+ "            \r\n"
    		+ "        </nav>\r\n"
    		+ "    </header>\r\n"
    		+ "    <div class=\"page-wrapper\">\r\n"
    		+ "        <section class=\"login-section\">\r\n"
    		+ "            \r\n"
    		+ "                <div class=\"left\"></div>\r\n"
    		+ "                <div class=\"form-login-card\">\r\n"
    		+ "                    <div class=\"form-login-wrapper\">\r\n"
    		+ "                        <h2 class=\"form-login-title\">Вхід</h2>\r\n"
    		+ "                        <form  action=\"process1\" class=\"login-form\" id=\"login-form\">\r\n"
    		+ "                            <label for=\"login\" class=\"login-form-label\">Логін</label>\r\n"
    		+ "                            <input type=\"text\" class=\"login-form-input\" name=\"login\" id=\"login\" placeholder=\"Введіть логін\" required>\r\n"
    		+ "                            <label for=\"password\" class=\"login-form-label\">Пароль</label>\r\n"
    		+ "                            <input type=\"password\" class=\"login-form-input\" name=\"password\" id=\"password\" placeholder=\"Введіть пароль\" required>\r\n"
    		+ "                            <div class=\"button2-wrapper\">\r\n"
    		+ "                                <button  class=\"form-login-button\" type=\"submit\">Увійти</button>\r\n"
    		+ "                                <div class=\"other-action-link-wrapper\">\r\n"
    		+ "                                    <!--<a href=\"password.html\" class=\"other-action-link\"><p class=\"other-action\">Забули пароль</p></a>-->\r\n"
    		+ "                                    <!--<a href=\"registration.html\" class=\"other-action-link\"><p class=\"other-action\">Зареєструватися</p></a>-->\r\n"
    		+ "                                </div>\r\n"
    		+ "                            </div>\r\n"
    		+ "                        </form>\r\n"
    		+ "                        \r\n"
    		+ "                        <p class=\"message-text\" id=\"sign-in-message-text\">$$$</p>\r\n"
    		+ "                    </div>\r\n"
    		+ "                </div>\r\n"
    		+ "                <div class=\"right\"></div>\r\n"
    		+ "\r\n"
    		+ "            \r\n"
    		+ "        </section>\r\n"
    		+ "    </div>\r\n"
    		+ "    <footer class=\"footer\">\r\n"
    		+ "        <span class=\"footer-credentials\">\r\n"
    		+ "            © 2022 Your Contract. Всі права захищені.\r\n"
    		+ "        </span>\r\n"
    		+ "    </footer>\r\n"
    		+ "</body>\r\n"
    		+ "</html>";
    
    
    private String htmText2="<!DOCTYPE html>\r\n"
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
    		+ "    \r\n"
    		+ "    <!-- <script src=\"./js/queuePrint.js\" defer></script>-->\r\n"
    		+ "</head>\r\n"
    		+ "\r\n"
    		+ "<body>\r\n"
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
    		+ "            <div class=\"queue-list-wrapper\" id=\"queue-list-wrapper\">\r\n"
    		+ "                <h2 class=\"queue-title\">Вітаємо, $$$</h2>\r\n"
    		+ "                <form action=\"process2\"><button type=\"submit\" class=\"form-submit-button\">Start</button></form>\r\n"
    		+ "             </div>\r\n"
    		+ "            <div class=\"right\"></div>\r\n"
    		+ "        </section>\r\n"
    		+ "    </div>\r\n"
    		+ "    \r\n"
    		+ "</body>\r\n"
    		+ "</html>";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueueDesk queueDesk =  QueueDesk.getInstance();
		 String login= request.getParameter("login");
		 String pasw = request.getParameter("password");
		 Operator operator = queueDesk.loginAccount(login, pasw);
		 //String result=null;
		 if (operator ==null) {
			 response.setContentType("text/html;charset=UTF-8");
			 
			response.getWriter().write(htmText1.replace("$$$", "The password or login are not correct!"));
		//	 result="The  password or login are not correct!";
		 }else {
		//	 result="Succesfull!";
			 Cookie ck=new Cookie("user",operator.getPhone());  
			 ck.setMaxAge(60*30);
			response.addCookie(ck);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(htmText2.replace("$$$", operator.getName()));
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
