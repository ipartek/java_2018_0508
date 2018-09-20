<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page isErrorPage="true" %> <!--  Es necesaria esta directiva para manejar la variable implícita Exception -->


500
<br>
CAUSA 		<%= exception.getCause() %> <br>
MENSAJE		<%= exception.getMessage() %><br>
TOSTRING	<%= exception.toString() %><br>

<textarea cols=20 rows = 20>

	<%=exception.printStackTrace(new PrintWriter(out))%>

</textarea>
