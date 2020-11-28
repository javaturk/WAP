<%@page contentType="text/html"%>
<html>
<head><title>JSP Page</title></head>
<body>

<html><title>detectingLocales</title>
<head>
     <%@ page import='java.util.Enumeration' %>
     <%@ page import='java.util.Locale' %>
     <%@ page import='java.util.Vector' %>
</head>
<body>

<font size='4'>Locales:</font>
<p>
<% Enumeration en = request.getLocales();

   while(en.hasMoreElements()) {
      Locale locale = (Locale)en.nextElement(); %>
      <%= locale.getDisplayName() %><br>
<%   } %>
</p>


</body>
</html>
