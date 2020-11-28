/*
 * HelloJapan.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloJapanServlet extends HttpServlet {
	private String helloInJapanese = "\u4eca\u65e5\u306f\u4e16\u754c";
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloJapanServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> HelloJapanServlet via GET<br></h1>");
        out.println("<h2>");
        out.println("In Japanese:");
        out.println("<br><p>");
        out.println(helloInJapanese);  // Hello World in Japanese
        out.println("<br>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.HelloJapanServlet\">For Source Code</h4></a>");
    }
    
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("Shift_JIS");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>HelloJapanServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">HelloJapanServlet via POST<br></h1>");
        out.println("<H2>In Japanese:</H2>");
        out.println("<H2>\u4eca\u65e5\u306f\u4e16\u754c</H2>"); // Hello World
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.HelloJapanServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
}
