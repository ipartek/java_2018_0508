	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>

	<h1>El Ahorcado</h1>
	<h2 class="center">Descubre la palabra</h2>
	
	<section id="tablero">
	
		<div id="juego">
		
			<%
		
			char[] huecos = (char[]) request.getAttribute("huecos");
		
			out.print("<h2 class='center'>");
			for(int i = 0; i<huecos.length;i++){
				out.print(" "+huecos[i]+" ");
			}
			out.print("</h2>");
		
			%>
			
			<div class="ahorcado fallo<%= request.getAttribute("fallos") %>">
			</div>
			
			<!-- <img src="img/ahorcado.jpg" alt="Imagen del juego del ahorcado."> -->
			
			<br>
			
			<form class="center" action="ahorcado" method="POST">
				
				<input name="letra" type="text" placeholder="Dime una letra" maxlength="1" autofocus>
				<br>
				<input class="btn btn-gestion-libros" type="submit" value="Enviar">
				
			</form>
		
			<div class="center">
				<p>${msg}</p>
				
				<%
					if((boolean)request.getAttribute("recarga") == true){
						out.print("<a href='ahorcado' class='btn btn-danger'>Volver a JUGAR</a>");
					}
				%>
			</div>
			
		
		</div>
		
	</section>
	

	<%@ include file = "includes/footer.jsp" %>