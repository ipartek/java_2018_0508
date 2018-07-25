<%@ include file="includes/header.jsp" %>		
<%@ include file="includes/navbar.jsp" %>
	
		<h1>Conversor</h1>
		
		<div id="content">
			<div class="caja">
				<h2>Metros > Pies </h2>
				<form action="conversor" method="post">
					<input name="metros" type="text" placeholder="Metros">
					<input name="formulario" type="hidden" value="1">
					<p>Metros: ${metros}</p>
					<p>Pies: ${piesCv}</p>
					<input class="enviar" type="submit" value="Convierte" />
					<p class="msgError">${mensaje}</p>
					<p class="msgError">${mensaje1}</p>
				</form>
			</div>
			
			<div class="caja">
				<h2>Pies > Metros</h2>
				<form action="conversor" method="post">
					<input name="pies" type="text" placeholder="Pies">
					<input name="formulario" type="hidden" value="2">
					<p>Pies: ${pies}</p>
					<p>Metros: ${metrosCv}</p>
					<input class="enviar" type="submit" value="Convierte" />
					<p class="msgError">${mensaje}</p>
					<p class="msgError">${mensaje2}</p>
				</form>
			</div>
	
			<a id ="reset" href="conversor?rst=1">Reset</a>
		</div>
		
<%@ include file="includes/footer.jsp" %>