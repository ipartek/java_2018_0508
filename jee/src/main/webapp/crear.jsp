	<%@ include file="includes/header.jsp" %>
	
	<h1>CMS Crear Libro Nuevo</h1>
	

		<div>
		<form action="crear" method="POST">
			<table>
				<tr>
					<th>	<label for="titulo">Titulo</label>			</th>
					<th>	<input type="text" name="titulo" value="" required pattern="^[a-zA-Z0-9]{3,25}$"> 	</th>
				</tr>
				<tr>
					<th>	<label for="isbn">ISBN</label>			</th>
					<th>	<input type="text" name="isbn" value="" required pattern="^[0-9]{10,10}$"> 	</th>
				</tr>
				<tr>
					<th>	<label for="editorial">Editorial</label>			</th>
					<th>	<input type="text" name="edxitorial" value="" required pattern="^[a-zA-Z0-9]{3,25}$"> 	</th>
				</tr>

				<tr>			
					<th>	<label for="prestado">Prestado?</label>			</th>
					
					<th>
					    <input type="radio" id="prestado" name="estado" value="prestado">
					    <label for="contactChoice1">Prestado</label>
					    <input type="radio" id="noPrestado" name="estado" value="noPrestado">
					    <label for="contactChoice2">No prestado</label>
   					</th>
			
				</tr>

			</table>
		</form>
	</div>



</body>

</html>