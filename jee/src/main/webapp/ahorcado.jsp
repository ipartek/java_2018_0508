<%@ include file="includes/header.jsp" %>		
<%@ include file="includes/navbar.jsp" %>

		<h1>Juego del Ahorcado</h1>
		
		<div class="ahorcado fallo${fallos}"></div><br>
		
		<span class="intentos">Intentos: ${intentos}</span>
		<span class="aciertos">Aciertos: ${aciertos}</span>
		<span class="fallos">Fallos: ${fallos}</span><br>
		
		<span class="palabraMostrar">${mostrar}</span><br><br>
			                                                                                       
		<form action="juega" method="post">	
			<input name="letra" type="text" placeholder="Introduce una letra">
			<p>${mensaje}</p>
						
			<input type="submit" value="¡Comprueba!" />
		</form><br>
		
		<a href="juega?jdn=1">Jugar de Nuevo</a>
		
<%@ include file="includes/footer.jsp" %>