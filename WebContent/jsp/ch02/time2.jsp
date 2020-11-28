<%@page contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<title>time</title>
</head>
<body>
<h1 align="center">Time</h1>

	<% int i = 0; %>

	Printing time by including a file through <\jsp:include page="timeIncluded.jsp"/>. A request is made to ""timeIncluded.jsp" and its response is copied right here.
	<p>

		<jsp:include page="timeIncluded.jsp"/>
		<b>i =  <%= i++%></b>

	</p>
	
	Printing right in this page.
	

	Printing time by including a file through <\%@ include file="timeIncluded.jsp"%>. "timeIncluded.jsp" is just copied right here.
	<p>

	<!-- That's duplicated local variable! -->
<%-- 		<%@ include file="timeIncluded.jsp"%> --%>
		<b>i =  <%= i++%></b>

	</p>

<%-- 	Including a file through <c:out value="${null}"> <jsp:include page="timeIncluded.jsp"/> </c:out>.  That prints whole file!--%>

	Printing time by including a file through <\jsp:include page="timeIncluded.jsp"/>. A request is made to ""timeIncluded.jsp" and its response is copied right here.
	<p>

		<jsp:include page="timeIncluded.jsp"/>
		<b>i =  <%= i++%></b>

	</p>
	
	Printing right in this page.
	
	<p>

		<%= new java.util.Date()%>   <%= (new java.util.Date()).getTime()%>
		
	</p>
	<p>
		<%="\n"%>
		<b>i =  <%= i++%></b>
	</p>

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=time\">For Source Code</h4></a>"%>
</body>
</html>
