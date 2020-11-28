package org.javaturk.wap.ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javaturk.wap.util.BaseServlet;

@WebServlet(name="BrowserCheckerServlet", urlPatterns="/BrowserCheckerServlet")
public class BrowserCheckerServlet extends BaseServlet {
	private static String[] browsers = { "Chrome", "IE", "Firefox", "Edge", "Safari", "Torch", "Yandex" };
	private static String[] oss = { "Windows", "Unix", "Linux", "Mac OS" };

	public BrowserCheckerServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agent = request.getHeader("User-Agent");
		String browser = getBrowser(agent);
		String os = getOS(agent);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		printHeader(out);
		
		out.println("<h2 align='center'> Your browser is " + browser + "</h2>");
		out.println("<h2 align='center'> Your OS is " + os + ".</h2>");
		out.println("<h2 align='center'> Your \"User Agent\" info is <i>" + agent + "</i>.</h2>");
		
		printFooter(out);
		
	}

	public String getBrowser(String agent) {
		String browser = "some browser that I don't know of.";
		if (agent == null)
			browser = "No browser info found!";
		else {
			for (String brws : browsers) {
				if (agent.contains(brws)) {
					browser = brws;
					break;
				}
			}
		}

		return browser;
	}
	
	public String getOS(String agent) {
		String OS = "some OS that I don't know of.";
		if (agent == null)
			OS = "No browser info found!";
		else {
			for (String os : oss) {
				if (agent.contains(os)) {
					OS = os;
					break;
				}
			}
		}

		return OS;
	}

}
