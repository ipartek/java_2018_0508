<%@ include file="includes/navbar.jsp" %>
<%@ include file="includes/header.jsp" %>

	<h1>Conversor</h1>
	
	<form action="convertir" method="post">
	<div><input type="text" name="valor"></div>
	<div>
		<div><input type="radio" name="tipo" value="m"> Metros -> Pies</div>
		<div><input type="radio" name="tipo" value="p"> Pies -> metros</div>
	</div>
	<button type="submit">Convertir</button>
	</form>

	<p>${resultado}</p>

	
<%@ include file="includes/footer.jsp" %>