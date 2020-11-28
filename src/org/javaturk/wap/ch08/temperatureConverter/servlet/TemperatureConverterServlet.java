package org.javaturk.wap.ch08.temperatureConverter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.ch08.temperatureConverter.dao.TemperatureConverterDao;
import org.javaturk.wap.ch08.temperatureConverter.dao.TemperatureConverterQuery;
import org.javaturk.wap.ch08.temperatureConverter.domain.InvalidArgumentException;
import org.javaturk.wap.ch08.temperatureConverter.domain.Temperature;
import org.javaturk.wap.ch08.temperatureConverter.domain.TemperatureConverter;
import org.javaturk.wap.ch08.temperatureConverter.domain.TripleTemperatureConverter;

@WebServlet("/TemperatureConverterServlet")
public class TemperatureConverterServlet extends HttpServlet {
	private TemperatureConverter converter;
	private TemperatureConverterDao converterDao;

	public void init(ServletConfig config) {
		converter = new TripleTemperatureConverter();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		printHeader(out);
		printForm(out, null, null);
		printFooter(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String degreeString = request.getParameter("degree");
		String sourceString = request.getParameter("source");
		String targetString = request.getParameter("target");
		
		TemperatureConverterQuery query = TemperatureConverterQuery.createTemperatureConverterQuery(sourceString, targetString, degreeString);
	
		Temperature temperature = null;
		
		try {
			temperature = converter.convert(query);
		} catch (InvalidArgumentException e) {
		}
		
		HttpSession session = request.getSession();
		Map<TemperatureConverterQuery, Temperature> queryMap = (TreeMap<TemperatureConverterQuery, Temperature>) session.getAttribute("queryMap");
		if(queryMap == null){
			queryMap = new TreeMap<TemperatureConverterQuery, Temperature>();
			session.setAttribute("queryMap", queryMap);
		}
		queryMap.put(query, temperature);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		printHeader(out);
		printForm(out, query, temperature);
		printFooter(out);
		
	}

	private void printForm(PrintWriter out, TemperatureConverterQuery query, Temperature temperature) {
		out.println("Please choose:");
		out.print("&nbsp");
		out.println("<form method=POST action=TemperatureConverterServlet>");
		out.println("<h5>");
		out.println("Convert from:");
		out.print("&nbsp");
		out.println("Degree:");
		out.print("&nbsp");
		out.println("<input type = \"text\" name = \"degree\" size=4>");
		out.print("&nbsp");
		out.println("in");
		out.println("<select name=\"source\">");
		out.print("&nbsp");
		out.println(
				"<option value=\"celsius\">Celsius</option> <option value=\"fahrenheit\">Fahrenheit</option> <option value=\"kelvin\">Kelvin</option> </select>");
		out.print("&nbsp");
		out.println("to:");
		out.println("<select name=\"target\">");
		out.print("&nbsp");
		out.println(
				"<option value=\"celsius\">Celsius</option> <option value=\"fahrenheit\">Fahrenheit</option> <option value=\"kelvin\">Kelvin</option> </select>");
		out.print("&nbsp");
		
		if(temperature != null){
			out.print("<p>");
			out.println(query.getDegree() + "  " + query.getSource().getName() + "   is   " + temperature.getDegree() + "  " + temperature.getType().getName());
			out.print("</p>");
		}
		
		out.println("</h5>");
		out.println("<input type=submit value=\"Submit\">");
		out.println("<input type=reset value=\"Clear\"></td>");
		out.println("</form>");
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TemperatureConverterServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> TemperatureConverterServlet <br></h1>");
		out.println("<h2>");
	}

	private void printFooter(PrintWriter out) {
		out.print("&nbsp");
		out.println(
				"<p><h4><a href=\"TemperatureConverterListServlet\">To see the list of all queries you made so far</h4></a>");
		out.println(
				"<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.temperatureConverter.servlet.TemperatureConverterServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
