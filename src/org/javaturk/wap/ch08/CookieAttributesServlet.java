/*
 * CookieAttributesServlet.java
 */

package org.javaturk.wap.ch08;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieAttributesServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookie1 = new Cookie("id", "kslr6632829");
        cookie1.setVersion(0);
        cookie1.setMaxAge(86400);
        cookie1.setPath("/wap/servlet/");
        cookie1.setSecure(false);
        cookie1.setComment("Holds the unique session id.");
        response.addCookie(cookie1);
        
        Cookie cookie2 = new Cookie("userNo", "1234567890");
        cookie2.setVersion(1);
        cookie2.setMaxAge(86400);
        cookie2.setPath("/wap/servlet/");
        cookie2.setSecure(false);
        cookie2.setComment("This is user no.");
        response.addCookie(cookie2);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieAttributesServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CookieAttributesServlet</h1>");
        out.println("<h2>");
        out.println("<form method=POST action=CookieAttributesServlet>");
        out.println("I have sent you a piece of cookie.<br>");
        out.println("<p><input type=submit value=\"Click here to see it!\">");
        out.println("</form>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CookieAttributesServlet\">For Source Code</h4></a>");
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
        out.println("<title>CookieAttributesServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">CookieAttributesServlet</h1>");
        out.println("<h2>");
        out.println("There are");
        out.println(count);
        out.println("cookies associated with this site.<br>");
        if(count > 0){
            out.println("Here they are:<br></h2>");
            printCookies(out, cookies);
        }
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.CookieAttributesServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void printCookies(PrintWriter out, Cookie[] cookies){
        out.println("<table align=center border=1 cellspacing=1 cellpadding=5>");
        out.println("<th colspan=8 align=center><h3>Cookies</h3></th>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center><b>Name</b></td>");
        out.println("<td align=center><b>Value</b></td>");
        out.println("<td align=center><b>Version</b></td>");
        out.println("<td align=center><b>Domain</b></td>");
        out.println("<td align=center><b>MaxAge</b></td>");
        out.println("<td align=center><b>Path</b></td>");
        out.println("<td align=center><b>Is Secure</b></td>");
        out.println("<td align=center><b>Comment</b></td>");
        out.println("</tr>");
        for(int i = 0; i < cookies.length; i++){
            out.println("<tr valign=top>");
            out.println("<td align=center>"+ cookies[i].getName() + "</td>");
            out.println("<td align=center>"+ cookies[i].getValue() + "</td>");
            out.println("<td align=center>"+ cookies[i].getVersion() + "</td>");
            out.println("<td align=center>"+ cookies[i].getDomain() + "</td>");
            out.println("<td align=center>"+ cookies[i].getMaxAge() + "</td>");
            out.println("<td align=center>"+ cookies[i].getPath() + "</td>");
            out.println("<td align=center>"+ cookies[i].getSecure() + "</td>");
            out.println("<td align=center>"+ cookies[i].getComment() + "</td>");
            out.println("</tr>");
        }
        out.println("</tr></table>");
    }
}
