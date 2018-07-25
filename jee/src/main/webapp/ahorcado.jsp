<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/navbar.jsp" %>

	<h1>Juego del ahorcado</h1>
	
	<%
		//Esto es Java
		
		
	
	%>
	
	<div class="container">
	
		<p>${msg}</p>
		
		<label>${palabraMostrar}</label>
		
		<form action="ahorcado" method="post">
		
			<input type="text" name="letra" placeholder="Escribe una letra" />
			<input type="submit" value="Comprobar"/>
		
		</form>
		
		<div class="ahorcado fallo${fallos}"></div>
		
		<p class="text-danger">${eliminado}</p>
		
		<a href="ahorcado?otraPartida=1">Jugar otra partida</a>
	
	</div>
	
<%@ include file="includes/footer.jsp" %>