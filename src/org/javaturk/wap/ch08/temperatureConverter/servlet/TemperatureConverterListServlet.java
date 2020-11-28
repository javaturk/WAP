package org.javaturk.wap.ch08.temperatureConverter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.ch08.temperatureConverter.dao.TemperatureConverterQuery;
import org.javaturk.wap.ch08.temperatureConverter.domain.Temperature;

/**
 * Servlet implementation class TemperatureConverterListServlet
 */
@WebServlet("/TemperatureConverterListServlet")
public class TemperatureConverterListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		printHeader(out);
		HttpSession session = request.getSession();
		Map<TemperatureConverterQuery, Temperature> queryMap = (Map<TemperatureConverterQuery, Temperature>) session.getAttribute("queryMap");
		printQueries(queryMap, out);
		printFooter(out);
	}

	private void printQueries(Map<TemperatureConverterQuery, Temperature> queryMap, PrintWriter out) {
		int size = queryMap.size();
		out.println("There are " + size + " entries you queried.");
		Set<TemperatureConverterQuery> queries = queryMap.keySet();
		Iterator<TemperatureConverterQuery> iterator = queries.iterator();

		out.println("<p>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th align = \'center\' width = \'30%\'>Date</th>");
		out.println("<th align = \'center\' width = \'18%\'>Degree</th>");
		out.println("<th align = \'center\' width = \'17%\'>Source</th>");
		out.println("<th align = \'center\' width = \'18%\'>Degree</th>");
		out.println("<th align = \'center\' width = \'17%\'>Target</th>");

		while (iterator.hasNext()) {
			TemperatureConverterQuery query = iterator.next();
			Temperature temperature = queryMap.get(query);
			out.println("<tr>");

			out.println("<td align = \'center\' width = \'30%\'>");
			out.println(query.getQueryTime());
			out.println("</td>");
			out.println("<td align = \'center\' width = \'18%\'>");
			out.println(query.getDegree());
			out.println("</td>");
			out.println("<td align = \'center\' width = \'17%\'>");
			out.println(query.getSource());
			out.println("</td>");
			out.println("<td align = \'center\' width = \'18%\'>");
			out.println(temperature.getDegree());
			out.println("</td>");
			out.println("<td align = \'center\' width = \'17%\'>");
			out.println(temperature.getType());
			out.println("</td>");
			out.println("</tr>");
		}
		out.print("</table>");
		out.print("&nbsp");
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TemperatureConverterListServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> TemperatureConverterListServlet <br></h1>");
		out.println("<h2>");
	}

	private void printFooter(PrintWriter out) {
		out.print("&nbsp");
		out.println(
				"<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch08.temperatureConverter.servlet.TemperatureConverterListServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
