/*
 * SourceCodeServlet.java
 */

package org.javaturk.wap.util;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * This servlet prints out the source code of a given Java or JSP file. Usually
 * Java file is the soruce code of a servlet in this project. Paremeters about
 * the files are passed with a GET request and this servlet using the root
 * directories gets the source code prints to the response. There are two
 * directories for source files, one for .java files and one for .jsp files.
 * They are defined as init parameters (srcDir and jspDir) for this servlet in
 * web.xml. Format of a request to get a Java source file is:
 * http://www.teachmejava
 * .org:8080/WAP3.0/SourceCodeServlet?name=org.javaturk.wap.ch04.SelamServlet
 * Format of a request to get a JSP source file is:
 * http://www.teachmejava.org:8080/WAP3.0/SourceCodeServlet?dir=ch01&name=selam
 * 
 * For a specific case to web.xml its whole path is read as init paramaters from
 * web.xml.
 * 
 * @author akin
 * 
 */
@WebServlet(name = "SourceCodeServlet", urlPatterns = "/SourceCodeServlet", initParams = {
		@WebInitParam(name = "srcDir", value = "/Users/akin/Java/Eclipse/202009/workspace/Web WS/WAP3.4/src"),
		@WebInitParam(name = "jspDir", value = "/Users/akin/Java/Eclipse/202009/workspace/Web WS/WAP3.4/WebContent/jsp"),
		@WebInitParam(name = "web.xml", value = "/Users/akin/Java/Eclipse/202009/workspace/Web WS/WAP3.4/WebContent/WEB-INF/web.xml")})
public class SourceCodeServlet extends HttpServlet {

	private String srcDir;
	private String jspDir;
	private String webXmlFile;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		srcDir = (String) config.getInitParameter("srcDir");
		jspDir = (String) config.getInitParameter("jspDir");
		webXmlFile = (String) config.getInitParameter("web.xml");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(getCode(request));
		out.close();
	}

	private String getCode(HttpServletRequest request) {
		String sourceName = request.getParameter("name");
		String sourceDir = request.getParameter("dir");
		StringBuffer buffer = new StringBuffer();

		File file = null;
		FileReader in = null;
		String path = null;
		String filePath = null;
		String dir = null;
		String fileName = null;
		String separator = File.separator;

		try {
			if (sourceDir == null) {
				if (sourceName.equals("web.xml")) {
					// That's for web.xml
					filePath = webXmlFile;
				} else {

					// That means it's a Java source file
					// Sourcename is smt like wap.ch11.login.nonmvc.LoginServlet
					// So get the last index of . and using that index divide
					// the sourcename into two parts: dir and filename
					int index = sourceName.lastIndexOf(".");
					dir = sourceName.substring(0, index);
					fileName = sourceName.substring(index + 1, sourceName.length());
					int i = 0;
					// Replace all . with separator
					String newDir = dir.replace(".", separator);
					filePath = srcDir + separator + newDir + separator + fileName + ".java";
				}
			} else {
				filePath = jspDir + separator + sourceDir + separator + sourceName + ".jsp";
			}
			file = new File(filePath);
			in = new FileReader(file);
		} catch (FileNotFoundException e) {
			buffer.append("Could not find the file: \n");
			buffer.append(filePath);
			return buffer.toString();
		}
		int c;
		try {
			while ((c = in.read()) != -1)
				buffer.append((char) c);
		} catch (IOException e) {
			buffer.append("IOException is thrown!");
			return buffer.toString();
		}
		return buffer.toString();
	}
}
