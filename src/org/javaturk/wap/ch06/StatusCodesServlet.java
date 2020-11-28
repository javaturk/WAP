/**
 * StatusCodesServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class StatusCodesServlet extends HttpServlet {
    private int i = 0;
    long retryTime = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String choice = request.getParameter("choice");
        if(choice == null)  printOptions(out);
        else{
            if(choice.equals("0"))               processOK(out, response);
            else if(choice.equals("1"))          processMovedPermanently(out, response);
            else if(choice.equals("2"))          processBadRequest(out, response);
            else if(choice.equals("3"))          processNotFound(out, response);
            else if(choice.equals("4"))          processServiceUnavailable(out, response);
            else if(choice.equals("5"))          processRefresh(out, response);
            else if(choice.equals("6"))          processSendError(out, response);
            else if(choice.equals("7"))          processSendErrorWithMessage(out, response);
            else if(choice.equals("8"))          processManualHandling(out, response);
            else if(choice.equals("9"))          processFound(out, response);
            else if(choice.equals("10"))         processRetryAfter(out, response);
            else processElse(out, response);
        }
    }
    
    private void processOK(PrintWriter out, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        printHeader(out);
        out.println("You have clicked on <b>200 OK</b>");
        printFooter(out);
    }
    
    private void processNotFound(PrintWriter out, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    
    private void processMovedPermanently(PrintWriter out, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "index.html");
    }
    
    private void processFound(PrintWriter out, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", "index.html");
    }
    
    private void processBadRequest(PrintWriter out, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
    
    private void processServiceUnavailable(PrintWriter out, HttpServletResponse response){
        if(i == 0){
            Date now = new Date();
            retryTime = now.getTime() + 5000;
            System.out.println("now: " + now.getTime());
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
//            response.setDateHeader("Retry-After", 5L);
            response.setHeader("Retry-After", "5");
            i++;
            //System.out.println("i: " + i + "retryTime: " + retryTime);
        }
        else{
            printHeader(out);
            out.println("You have waited " + (retryTime/1000) + " second after the click!");
            printFooter(out);
        }
    }
    
    private void processRetryAfter(PrintWriter out, HttpServletResponse response){
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            response.setHeader("Retry-After", "5");
    }
    
    private void processRefresh(PrintWriter out, HttpServletResponse response){
        response.setHeader("Refresh", "5; URL=index.html");
        printHeader(out);
        out.println("You will be redirected to another page in 5 seconds<br>");
        printFooter(out);
    }
    
    private void processSendError(PrintWriter out, HttpServletResponse response){
        try{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        catch (IOException e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    private void processSendErrorWithMessage(PrintWriter out, HttpServletResponse response){
        String message = "Sorry! We can not find the source you have requested.";
        try{
            response.sendError(HttpServletResponse.SC_NOT_FOUND, message);
        }
        catch (IOException e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    private void processManualHandling(PrintWriter out, HttpServletResponse response){
        printHeader(out);
        out.println("You have clicked on <b>Manual Handling</b>.<br>");
        out.println("There is a problem with the response.<br>");
        out.println("But we prefer not to use HTTP status codes.");
        printFooter(out);
    }
    
    private void processElse(PrintWriter out, HttpServletResponse response){
        printHeader(out);
        out.println("How did you do that man!");
        printFooter(out);
    }
    
    private void printOptions(PrintWriter out){
        printHeader(out);
        out.println("<h2>Click any of the links for different responses:</h2>");
        out.println("<h3><ul>");
        out.println("<li><a href=\"StatusCodesServlet?choice=0\">200 OK</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=1\">301 MovedPermanently</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=9\">302 Found (Moved Temporarily)</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=2\">400 BadRequest</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=3\">404 NotFound</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=4\">503 ServiceUnavailable</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=5\">Refresh</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=6\">Send NotFound Error</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=7\">Send NotFound Error with a Brief Message</a>");
        out.println("<li><a href=\"StatusCodesServlet?choice=8\">Manual Handling</a>");
        printFooter(out);
    }
    
    private void printHeader(PrintWriter out){
        out.println("<html>");
        out.println("<head>");
        out.println("<title>StatusCodesServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> StatusCodesServlet <br></h1>");
        out.println("<h2>");
    }
    
    private void printFooter(PrintWriter out){
        out.println("</h2>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.StatusCodesServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
