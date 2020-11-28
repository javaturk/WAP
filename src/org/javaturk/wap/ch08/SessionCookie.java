package org.javaturk.wap.ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SessionCookie")
public class SessionCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie cookie1 = new Cookie("session", "1234567890");
		cookie1.setMaxAge(-1);
		response.addCookie(cookie1);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>SessionCookie</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">SessionCookie</h1>");
		out.println("<h2>");
		out.println("I have sent you a session cookie. It'll expire in " + cookie1.getMaxAge() + " seconds. <br>");
		out.println("Please click here to see it.<br>");
		out.println("<form method=POST action=SessionCookie>");
		out.println("<p><input type=submit value=\"Click here to see it!\">");
		out.println("</form>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.SessionCookie\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        
		        boolean flag = checkCookie(request);
		        
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>SessionCookie</title>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<h1 align=\"center\">SessionCookie</h1>");
		        out.println("<h2>");
		        if(flag)    out.println("You sent the cookie back. But if you close this browser it'll be deleted.<br>");
		        else        out.println("The cookie has been deleted because it was a session cookie!<br>");
		        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.SessionCookie\">For Source Code</h4></a>");
		        out.println("</body>");
		        out.println("</html>");
		    }
		    
		    private boolean checkCookie(HttpServletRequest request){
		        boolean cookieFound = false;
		        
		        Cookie[] cookies = request.getCookies();
		        if (cookies != null) {
		            int length = cookies.length;
		            for (int i=0; i<length; i++) {
		                Cookie cookie = cookies[i];
		                if (cookie.getName().equals("session") && cookie.getValue().equals("1234567890")) {
		                    cookieFound = true;
		                    break;
		                }
		            }
		        }
		        return cookieFound;
		    }

}
