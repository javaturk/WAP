/*
 * BasicServlet.java
 */

package org.javaturk.wap.ch02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BasicServlet extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);   
    }
    
    public void destroy() {}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {  
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BasicServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> BasicServlet <br></h1>");
        printRequest(out, request);
        out.println("</body>");
        out.println("</html>");
        printResponse(out, response);
        out.close();
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BasicServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> BasicServlet <br></h1>");
        printRequest(out, request);
        out.println("</body>");
        out.println("</html>");
        printResponse(out, response);
        out.println("<P><h4><a href=\"SourceCodeServlet?name=wap.ch02.BasicServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    protected void doHead(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BasicServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> BasicServlet <br></h1>");
        printRequest(out, request);
        printResponse(out, response);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    public String getServletInfo() {
        return "Short description";
    }
    
    public void printRequest(PrintWriter out, HttpServletRequest request){
        out.println("<h2> Request Object <br></h2>");
        out.println("<h3>");
        out.println("Protocol: " + request.getProtocol() + "<br>");
        out.println("Scheme: " + request.getScheme() + "<br>");
        out.println("URI: " + request.getRequestURI() + "<br>");
        out.println("URL: " + request.getRequestURL() + "<br>");
        out.println("Server Name: " + request.getServerName() + "<br>");
        out.println("Server Port: " + request.getServerPort() + "<br>");
        out.println("Method: " + request.getMethod()+ "<br>");
        printRequestParameters(out, request);
        printRequestHeader(out, request);
    }
    
    public void printRequestParameters(PrintWriter out, HttpServletRequest request){
        Map map = request.getParameterMap();
        if(map.isEmpty())
            out.println("<br>Parameters: No parameters" + "<br>");
        else{
            out.println("<br>Parameters: " + "<br></h3><h4>");
            Set set = map.keySet();
            int size = map.size();
            out.println("Total " + size + " Parameters<br>");
            Iterator i = set.iterator();
            while(i.hasNext()){
                String parameter = (String) i.next();
                String[] value =  (String[]) map.get(parameter);
                out.println(parameter + ": " + value[0] + "<br>");
            }
            out.println("</h4>");
        /* Another solution
        out.println("Parameters: " + "<br></h3><h4>");
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements()){
            String parameter = (String) e.nextElement();
            String[] value = (String[])request.getParameterValues(parameter);
            out.println(parameter + ": " + value[0] + "<br>");
        }*/
        }
    }
    
    public void printRequestHeader(PrintWriter out, HttpServletRequest request){
        out.println("<br><h3>Header: " + "<br></h3><h4>");
        Enumeration e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String headerName = (String) e.nextElement();
            String value = request.getHeader(headerName);
            out.println(headerName + ": " + value + "<br>");
        }
        out.println("</h4>");
    }
    
    public void printResponse(PrintWriter out, HttpServletResponse response){
        out.println("<h2> Response Object <br></h2>");
        out.println(response);
    }
}
