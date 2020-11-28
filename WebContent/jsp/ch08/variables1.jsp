<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="courseName" scope="session" value="Web Application Programming with Java"/>
<c:set var="trainer" scope="session" value="Akin Kaldiroglu"/>
<c:set var="year" scope="session">2009</c:set>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Variables I</title>
</head>
<body>
<H2 ALIGN="CENTER">Variables I with JSTL</H2> 

This is <b><c:out value="${courseName}"/></b> given by  <b><c:out value="${trainer}"/></b> in <c:out value="${year}"/>.
<br/><br/>

  Enter a value for x:
  <br/>
  <form action='variables2.jsp' method='POST'>

	x: <input type="text" name="x" />
	<br/><br/>
	<input type="reset" value="Clear" />
	<input type="submit" value="Submit" />

</form>

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=variables1\">For Source Code</h4></a>"%>
</body>
</html>