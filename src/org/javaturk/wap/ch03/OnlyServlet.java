/*
 * ServletRequestServlet.java
 */

package org.javaturk.wap.ch03;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OnlyServlet implements Servlet {
    
    public void init(ServletConfig config) throws ServletException {
//        System.out.println("init() in OnlyServlet");
    }
    
    public void destroy(){
//    	System.out.println("destroy() in OnlyServlet");
    }
    
    public String getServletInfo() {
        return "Short description";
    }
    
    public ServletConfig getServletConfig() {
        return null;
    }
    
    public void service(ServletRequest request, ServletResponse response)
    throws ServletException, IOException {
    	
    	response.setContentType("text/html");
    	ServletOutputStream out = response.getOutputStream();
    	
    	StringBuffer sb = new StringBuffer();
    	
    	String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    	sb.append(docType);
    	sb.append("<HTML>");
    	sb.append("<HEAD><TITLE>OnlyServlet</TITLE></HEAD>");
    	
        sb.append("<BODY>");
        sb.append("<h1 align=\"center\">OnlyServlet</h1>");
        
        sb.append("<H2><P>\n");
        sb.append("Info on ServletRequest:<P>");
        sb.append("<P>Server Port: " + request.getServerPort());
        sb.append("<P>Server Name: " + request.getServerName());
        sb.append("<P>Protocol: " + request.getProtocol());
        sb.append("<P>Character Encoding: " + request.getCharacterEncoding());
        sb.append("<P>Content Type: " + request.getContentType());
        sb.append("<P>Content Length: " + request.getContentLength());
        sb.append("<P>Remote Address: " + request.getRemoteAddr());
        sb.append("<P>Remote Host: " + request.getRemoteHost());
        sb.append("<P>Local Address: " + request.getLocalAddr());
        sb.append("<P>Local Name: " + request.getLocalName());
        sb.append("<P>Local Port: " + request.getLocalPort());
        sb.append("<P>Scheme: " + request.getScheme());
        sb.append("<P>Method: " + ((HttpServletRequest) request).getMethod());
        
        sb.append("<P>Parameters: ");
        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            sb.append("<P>Parameter Name: " + parameterName);
            sb.append("\tParameter Value: " +
            request.getParameter(parameterName));
        }
        sb.append("<P>Attributes: ");
        Enumeration attributes = request.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            sb.append("<P>Attribute name: " + attribute);
            sb.append("\tAttribute value: " +
            request.getAttribute(attribute));
        }
        sb.append("<P></H2>");
        sb.append("<P><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch03.OnlyServlet\">For Source Code</h4></a>");
        sb.append("</BODY>");
        sb.append("</HTML>");
        
        out.write(sb.toString().getBytes());
        out.close();
    }
}
