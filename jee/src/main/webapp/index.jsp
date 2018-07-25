<%@include file="includes/navbar.jsp"%>
<%@include file="includes/header.jsp"%>

<h1>Listar libro</h1>
<%
	//Esto es java
	out.print("<p>Soy Java</p>");
%>



<form action="saludo" method="post">

	<input name="nom" type="text" placeholder="Dime tu Nombre">
	<p class="text-danger">${msg}</p>

	<input type="submit" value="Enviar">

</form>

<%@include file="includes/footer.jsp"%>



