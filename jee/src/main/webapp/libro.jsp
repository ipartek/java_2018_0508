

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<br>
<form action="libro" method="post" class="loginform">
	<i class="fas fa-book-open"></i>
	<div class="container">
		<label for="isbn"><b>ISBN</b></label> 
		<input type="text" placeholder="Isbn" name="isbn" class="logininput"> <br> 
		<label for="titulo"> <b>Título</b></label> 
		<input type="text" placeholder="Título" name="titulo" class="logininput">
		<label for="editorial"> <b>Editorial</b></label> 
		<input type="text" placeholder="Editorial" name="editorial" class="logininput">
		<label> <input type="checkbox" name="prestado"> Prestado</label>
		<button type="submit">Crear</button>	
	</div>
	<p style="color: red">${msg }</p>
</form>
