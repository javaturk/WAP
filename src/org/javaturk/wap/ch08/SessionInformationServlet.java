/*
 * SessionInformationServlet.java
 */

package org.javaturk.wap.ch08;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SessionInformationServlet extends HttpServlet {
    
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
        out.println("<title>SessionInformationServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">SessionInformationServlet</h1>");
        out.println("<h2>");
        printSessionInformation(out, session);
        out.println("<form method=POST action=SessionInformationServlet>");
        out.println("<p align=center><input type=submit value=\"Please click me!\">");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.SessionInformationServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
        out.println("<title>SessionInformationServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">SessionInformationServlet</h1>");
        out.println("<h2>");
        out.println(count);
        printSessionInformation(out, session);
        out.println("<form method=POST action=SessionInformationServlet>");
        out.println("<p align=center><input type=submit value=\"Please click me!\">");
                        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.SessionInformationServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void printSessionInformation(PrintWriter out, HttpSession session){
        out.println("<table align=center border=1 cellspacing=1 cellpadding=5>");
        out.println("<th colspan=8 align=center><h3>Session Information</h3></th>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center><b>ID</b></td>");
        out.println("<td align=center><b>Is New</b></td>");
        out.println("<td align=center><b>Creation Time</b></td>");
        out.println("<td align=center><b>Last Accessed Time</b></td>");
        out.println("<td align=center><b>Max Inactive Interval</b></td>");
        out.println("</tr>");
        out.println("<tr valign=top>");
        out.println("<td align=center>"+ session.getId() + "</td>");
        out.println("<td align=center>"+ session.isNew() + "</td>");
        out.println("<td align=center>"+ session.getCreationTime() + "</td>");
        out.println("<td align=center>"+ session.getLastAccessedTime() + "</td>");
        out.println("<td align=center>"+ session.getMaxInactiveInterval() + "</td>");
        out.println("</tr>");
        
        out.println("</tr></table>");
    }
}