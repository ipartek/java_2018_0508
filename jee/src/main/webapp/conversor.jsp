<%@ page import="com.ipartek.formacion.gestor.libros.controller.ConversorController" %>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

	<h1>Conversor metros-pies</h1>
	
	<div class="grid">
	
		<form class="formConversor" action="conversor" method="get">
			<fieldset>
				<legend>Metros:</legend>
				<input type="text" name="metros" placeholder="Metros" value="${unidadM}" />
				<input type="hidden" name="form" value="<%=ConversorController.FORM1 %>" />
				<label>${piesCalculados} pies</label>
				<p class="text-danger">${msgMetros}</p>
				<input type="submit" value="Convertir" />
			</fieldset>
		</form>
		
		<form class="formConversor" action="conversor" method="post">
			<fieldset>
				<legend>Pies:</legend>
				<input type="text" name="pies" placeholder="Pies" value="${unidadP}" />
				<input type="hidden" name="form" value="<%=ConversorController.FORM2 %>" />
				<label>${metrosCalculados} metros</label>
				<p class="text-danger">${msgPies}</p>
				<input type="submit" value="Convertir" />
			</fieldset>
		</form>
	
	</div>
	
<%@ include file="includes/footer.jsp" %>