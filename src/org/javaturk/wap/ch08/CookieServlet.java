/*
 * CookieServlet.java
 */

package org.javaturk.wap.ch08;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookie1 = new Cookie("id", "kslr6632829");
        cookie1.setMaxAge(86400);
        cookie1.setComment("From WAP");
        response.addCookie(cookie1);
        
        Cookie cookie2 = new Cookie("userNo", "1234567890");
        cookie2.setMaxAge(3600);
        cookie2.setComment("From WAP");
        response.addCookie(cookie2);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CookieServlet</h1>");
        out.println("<h2>");
        out.println("<form method=POST action=CookieServlet>");
        out.println("I have sent you a piece of cookie.<br>");
        out.println("<p><input type=submit value=\"Click here to see it!\">");
        out.println("</form>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CookieServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        int count = 0;
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if(cookies != null) count = cookies.length;
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CookieServlet</h1>");
        out.println("<h2>");
        out.println("There are");
        out.println(count);
        out.println("cookies associated with this site.<br>");
        if(count > 0){
            out.println("Here they are:<br></h2>");
            for(int i = 0; i < count; i++){
                out.println("<p><b>Cookie name: </b>" + cookies[i].getName());
                out.println("<b>Cookie value: </b>" + cookies[i].getValue());
//                out.println("<b>Cookie max age: </b>" + cookies[i].getMaxAge());
//                out.println("<b>Cookie domain: </b>" + cookies[i].getDomain());
//                out.println("<b>Cookie path: </b>" + cookies[i].getPath());
//                out.println("<b>Cookie version: </b>" + cookies[i].getVersion());
//                out.println("<b>Cookie comment: </b>" + cookies[i].getComment());
            }
        }
        
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CookieServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
