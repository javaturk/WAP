/*
 * HitCounter.java
 */

package org.javaturk.wap.ch08;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HitCounterServlet1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("hitCount");
        if(count == null) count = new Integer(1);
        else count = new Integer(count.intValue() + 1);
        session.setAttribute("hitCount", count);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HitCounterServlet1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">HitCounterServlet1</h1>");
        out.println("<h2>");
        out.println("You have visited HitCounterServlet1 pages " + count + " times.");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.HitCounterServlet1\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
         
        out.close();
    }
}
