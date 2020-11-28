package org.javaturk.wap.jsp.ch05;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ScopeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
        MyBean myBean = (MyBean) sc.getAttribute("myBean");
        int i = myBean.getI();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ScopeServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> ScopeServlet <br></h1>");
        out.println("<h3>");
        out.println(i);
        out.println("<br><p>");
        out.println("<br>");
        out.println("<p><h4><a href=\"/wap/servlet/wap.util.SourceCodeServlet?name=wap.jsp.ch05.ScopeServlet\">For Source Code</h4></a>");

    }
}
