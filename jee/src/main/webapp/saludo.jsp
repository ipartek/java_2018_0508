<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		// ESto es JAVA	
		out.print(request.getAttribute("nombre"));
		out.print(request.getAttribute("ap1"));
		out.print(request.getAttribute("ap2"));
	%>
</body>
</html>