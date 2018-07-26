<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
		<h1>Juego del Ahorcado</h1>
		
		<span class="intentos">Intentos: ${intentos}</span>
		<span class="fallos">Fallos: ${fallos}</span>
		<span class="aciertos">Aciertos: ${aciertos}</span>
		
		<div class="ahorcado fallo${fallos}"></div>
		
		<span class="palabraMostrar">${palabraMostrar}</span>
			                                                                                       
		<form action="ahorcado" method="post">
				
			<input name="letra" type="text" placeholder="Dime Una Letra">
			<p class="text-danger">${msg}</p>
						
			<input type="submit" value="Probar Suerte" />
		
		</form>
		
		<%
			boolean isTerminado = (boolean)request.getAttribute("isTerminado");
			if ( isTerminado ){
				%>
					<a href="ahorcado?jdn=1">Jugar de Nuevo</a>
				<%
			}
		%>
		
<%@ include file="includes/footer.jsp"%>