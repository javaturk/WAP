/*
 * InformationServlet.java
 *
 * Created on 01 Ocak 2003 �ar�amba, 15:44
 */

package org.javaturk.wap.ch05;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ClientInformationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
        String remoteAddress = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        
        String encoding = request.getCharacterEncoding();
        int length = request.getContentLength();
        String type = request.getContentType();
        
        String protocol = request.getProtocol();
        String scheme = request.getScheme();
        boolean isSecure = request.isSecure();

        String requestURL = (request.getRequestURL()).toString();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String servletName = getServletConfig().getServletName();
        String contextPath= request.getContextPath();
        String pathInfo = request.getPathInfo();
        String translatedPath = request.getPathTranslated();
        
        String method = request.getMethod();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>InformationServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1 align=\"center\">InformationServlet</H1>");
        
        out.println("<H2>Client Information</H2>");
        out.println("<b>Remote Address: </b>" + remoteAddress + "<br>");
        out.println("<b>Remote Host: </b>" + remoteHost + "<br>");
        
        out.println("<H2>Server Information</H2>");
        out.println("<b>Server Name: </b>" + serverName + "<br>");
        out.println("<b>Server Port: </b>" + serverPort + "<br>");
        
        out.println("<H2>Content Information</H2>");
        out.println("<b>Content Character Encoding: </b>" + encoding + "<br>");
        out.println("<b>Content Length in byte: </b>" + length + "<br>");
        out.println("<b>Content MIME Type: </b>" + type + "<br>");
        
        out.println("<H2>Access Information</H2>");
        out.println("<b>Access Protocol: </b>" + protocol + "<br>");
        out.println("<b>Access Scheme: </b>" + scheme + "<br>");
        out.println("<b>Is Access Secure? </b>" + isSecure + "<br>");
        
        out.println("<H2>Path Information</H2>");
        out.println("<b>URL: </b>" + requestURL + "<br>");
        out.println("<b>URI: </b>" + requestURI + "<br>");
        out.println("<b>Servlet Path: </b>" + servletPath + "<br>");
        out.println("<b>Servlet Name: </b>" + servletName + "<br>");
        out.println("<b>Context Path: </b>" + contextPath + "<br>");
        out.println("<b>Extra Path Information: </b>" + pathInfo + "<br>");
        out.println("<b>Translated Path Information: </b>" + translatedPath + "<br>");
        
        out.println("<H2>Request Information</H2>");
        out.println("<b>HTTP Method: </b>" + method + "<br>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.ClientInformationServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
}
