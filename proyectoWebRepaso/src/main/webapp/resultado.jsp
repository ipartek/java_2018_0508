<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>El resultado de sumar los dos parametros es:</p>

	<h2>Expresion language</h2>
	<p>${suma}</p>

	<hr>

	<h2>Scriplet</h2>
	<p><%=request.getAttribute("suma")%></p>

</body>
</html>