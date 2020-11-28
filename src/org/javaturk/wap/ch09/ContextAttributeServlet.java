package org.javaturk.wap.ch09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContextAttributeServlet extends HttpServlet {

    private ServletContext context;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ContextAttributeServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">ContextAttributeServlet</h1>");
        out.println("<h2> Please Enter A Value : </h2><br>");
        out.println("<FORM METHOD=POST ACTION=ContextAttributeServlet>");
        out.println("Name: <INPUT TYPE=TEXT NAME=ATTRIBUTE SIZE=15>");
        out.println("<INPUT TYPE=SUBMIT NAME=ENTER VALUE=\"Enter\">");
        out.println("</FORM>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch09.ContextAttributeServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	
        String name = request.getParameter("ATTRIBUTE");
        context = getServletContext();
        context.setAttribute("attribute", name);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ContextAttributeServlet</title>");
        out.println("<h2> Thank You.</h2><br>");
        out.println("<h2>The attribute with the value you entered was bound on the context.</h2><br>");
        out.println("</head>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch09.ContextAttributeServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
}
