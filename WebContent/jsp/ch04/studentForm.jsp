<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.javaturk.wap.jsp.ch03.*" %>

<%! Student student = new Student();
	int no;
	String firstName;
	String lastName;
	String department;
	%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>

<H2 ALIGN="CENTER">Student Info</H2>

<% String noString = request.getParameter("no");
   no = Integer.parseInt(noString);
   firstName = request.getParameter("firstName");
   lastName = request.getParameter("lastName");
   department = request.getParameter("department");
	
   student.setFirstName(firstName);
   student.setLastName(lastName);
   student.setDepartment(department);
   
   session.setAttribute("student", student);
   out.print(student);
%>
<p>

<%= student %>

<H2 ALIGN="CENTER">Request Parameters</H2>
<p>
${param.no}
<p>
${param.firstName}
<p>
${param.lastName}
<p>
${param.department}

<p>
<H2 ALIGN="CENTER">Forward me :)</H2>
<FORM ACTION="forwarded.jsp" METHOD="POST">
		<CENTER>
				<INPUT TYPE="SUBMIT">
		</CENTER>
	</FORM>

  <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch04&name=studentForm\">For Source Code</h4></a>" %>
</body>
</html>