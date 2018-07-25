
	<h1>CMS Prestamos de libros</h1>


		
		<%@ include file="includes/header.jsp" %>
		<%@ include file="includes/navbar.jsp" %>
		
	<div id="content">
		<form action="saludo" method="post">
			<div class="container">
				<label for="Nombre"><b>Username*</b></label> 
				<input type="text" placeholder="Dime tu nombre" name="nombre">
				<p id="msg">${mensaje}</p>
	
				<button type="submit">Login</button>
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>