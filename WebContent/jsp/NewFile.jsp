<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New File</title>
</head>
<body>
<H1>Naber abi :)</H1>

<%= "Nasılsın?" %>

<%
	if( Math.random() < 0.5){

%>
	<H1>:) :) :)</H1>
	
	<%
	}else{

%>
	<H1>:( :( :(</H1>
	
	<%
	}

%>
	
</body>
</html>