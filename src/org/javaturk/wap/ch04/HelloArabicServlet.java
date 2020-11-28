/*
 * HelloJapan.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloArabicServlet extends HttpServlet {
	private String helloInArabic = "\u0633\u0644\u0627\u0645";
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html; charset=iso-8859-6");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloArabicServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> HelloArabicServlet via GET<br></h1>");
        out.println("<h2>");
        out.println("In Arabic:");
        out.println("<br><p>");
        out.println(helloInArabic);  // Hello in Arabic
        out.println("<br>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.HelloArabicServlet\">For Source Code</h4></a>");
    }
    
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("iso-8859-6");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>HelloArabicServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">HelloArabicServlet via POST<br></h1>");
        out.println("<H2>In Arabic:</H2>");
        out.println("<H2>\u4eca\u65e5\u306f\u4e16\u754c</H2>"); // Hello World
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.HelloArabicServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
}
