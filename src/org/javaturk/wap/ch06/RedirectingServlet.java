/*
 * RedirectingServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RedirectingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("TargetServlet");
    }
}
