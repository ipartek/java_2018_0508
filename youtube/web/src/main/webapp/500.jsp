<%@ page isErrorPage="true" %>  

<p>Si marcamos la JSP como pagina de error, podemos acceder a la variable implicita <b>exception</b> </p>

500
<br>
CAUSA <%=exception.getCause()%><br>
MENSAJE <%=exception.getMessage()%><br>
TOSTRING <%=exception.toString()%><br>


<textarea cols="20" rows="10">
	<%
		//pinta por pantalla la traza de la excepcion
		exception.printStackTrace(new java.io.PrintWriter(out));
	%>
</textarea>