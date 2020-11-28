package org.javaturk.wap.ch07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DefaultValuesFormServlet extends HttpServlet {
	String defaultName = "Your name";

    public DefaultValuesFormServlet() {
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>DefaultValuesFormServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">DefaultValuesFormServlet</h1>");
        out.println("<h3>");
        out.println("Please fill out the following form. Thank you.");
        printForm(out);
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch07.DefaultValuesFormServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">DefaultValuesFormServlet</h1>");
        out.println("<h3 align=\"center\">");
        printParameters(out, request);
        
        out.println("<p><h4><a href=\"SourceCodeServlet?name=wap.ch07.DefaultValuesFormServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void printForm(PrintWriter out){
        out.println("<form method=POST action=DefaultValuesFormServlet>");
        out.println("<table border=0>");
        
        out.println("<tr valign=top>");
        out.println("<td align=right><b>Name:</b></td>");
        out.println("<td align=left><input type=text name=name value=\"" + defaultName + "\"size=32 maxlength=80></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=right><b>Sex:</b></td>");
        out.println("<td align=left>");
        out.println("<input type=radio name=sex value=\"M\"> Male <br>");
        out.println("<input type=radio name=sex value=\"F\" CHECKED > Female</td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=right><b>Income:</b></td>");
        out.println("<td align=left>");
        out.println("<select name=income size=1>");
        out.println("<option>Under $25,000");
        out.println("<option>$25,001 to $50,000");
        out.println("<option>$50,001 to $75000");
        out.println("<option>$75,001 and higher");
        out.println("</select></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=right><b>Team You Support:</b></td>");
        out.println("<td align=left>");
        out.println("<select name=team size=1>");
        out.println("<option>Besiktas");
        out.println("<option>Fenerbahce");
        out.println("<option>Galatasaray");
        out.println("<option>Genclerbirligi");
        out.println("<option>Trabzonspor");
        out.println("</select></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td colspan=2 align=center>");
        out.println("<input type=submit value=\"Submit Query\">");
        out.println("<input type=reset value=\"Clear\"></td>");
        out.println("</tr></table>");
        out.println("</form>");
    }
    
    private void printParameters(PrintWriter out, HttpServletRequest request){
        out.println("Here is your information<p>");
        out.println("<table align=center border=1 cellspacing=1 cellpadding=5>");
       
        out.println("<th colspan=2 align=center>Parameters</th>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center><b>Name</b></td>");
        out.println("<td align=center><b>Value</b></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>Name</td>");
        out.println("<td align=center>" + request.getParameter("name") + "</td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>Sex</td>");
        out.println("<td align=center>" + request.getParameter("sex") + "</td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>Income</td>");
        out.println("<td align=center>" + request.getParameter("income") + "</td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>Team</td>");
        out.println("<td align=center>" + request.getParameter("team") + "</td>");
        out.println("</tr>");
        
        out.println("</tr></table>");
    }
}
