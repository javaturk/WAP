/*
 * CheckCookie.java
 */

package org.javaturk.wap.ch08;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckCookieServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookie = new Cookie("mycookie", "yourcookie");
        response.addCookie(cookie);
       
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CheckCookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CheckCookieServlet</h1>");
        out.println("<h2>");
        out.println("<form method=POST action=CheckCookieServlet>");
        out.println("I have sent you a piece of cookie. Now I'll see if you have accepted it.<br>");
        out.println("<p><input type=submit value=\"Please click here!\">");
        out.println("</form>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CheckCookieServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
    }
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        boolean flag = checkCookie(request);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CheckCookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CheckCookieServlet</h1>");
        out.println("<h2>");
        if(flag)    out.println("You love cookies. Isn't it?<br>");
        else        out.println("You don't love cookies. Isn't it?<br>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CheckCookieServlet\">For Source Code</h4></a>");
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
                if (cookie.getName().equals("mycookie") && cookie.getValue().equals("yourcookie")) {
                    cookieFound = true;
                    break;
                }
            }
        }
        return cookieFound;
    }
}
