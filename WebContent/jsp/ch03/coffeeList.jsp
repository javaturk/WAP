<%@page contentType="text/html"%>
<%@ page session="false"%>
<%@ page import="java.sql.*"%>

<%!//     String driver = "oracle.jdbc.driver.OracleDriver";
	//         String url = "jdbc:oracle:thin:@localhost:1521:XE";

	String driver = "org.apache.derby.jdbc.ClientDriver";
	String url = "jdbc:derby://localhost:1527/JPA";
	// 	String url = "jdbc:derby://localhost:1527/COFFEES;create=true";
	//String sql = "SELECT No, FirstName, LastName, UserName, Password FROM Users";
	String sql = "Select * from Coffees";
%>

<%
// 	try {
				Class.forName(driver);
// 		Driver driver = (Driver) Class.forName(driver).newInstance();
// 			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
// 		Driver driver = (Driver)Class.forName(driver).newInstance();
// 		Driver driver = (Driver) Class.forName(driver).newInstance();
// 		DriverManager.registerDriver(driver);
// 	} catch (ClassNotFoundException e) {
// 		System.out.println("Driver is not found: " + e.toString());
// 	}
%>
<html>
<head>
<title>Coffee List</title>
</head>
<body>
	<%="<h1 align=\"center\">Coffee List</h1>"%>
	<%="<h3>"%>
	<center>
		<br>
		<H2>Coffees</H2>
		<br> <br>
		<table align=center border=1 cellspacing=1 cellpadding=5>
			<tr>
				<th>Name</th>
				<th>Supplier ID</th>
				<th>Price</th>
				<th>Sales</th>
				<th>Total</th>
			</tr>
			<%
				try {
					Connection con = DriverManager.getConnection(url, "app", "password");
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(sql);
					while (rs.next()) {
						out.println("<tr>");
						out.println("<TD>" + rs.getString(1) + "</TD>");
						out.println("<TD>" + rs.getString(2) + "</TD>");
						out.println("<TD>" + rs.getString(3) + "</TD>");
						out.println("<TD>" + rs.getString(4) + "</TD>");
						out.println("<TD>" + rs.getString(5) + "</TD>");
						out.println("</tr>");
					}
					rs.close();
					s.close();
					con.close();
				} catch (SQLException e) {
					out.println("Problem with db");
				} catch (Exception e) {
					out.println("Problem!");
				}
			%>
		</table>
	</center>
	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch03&name=coffeeList\">For Source Code</h4></a>"%>
</body>
</html>

