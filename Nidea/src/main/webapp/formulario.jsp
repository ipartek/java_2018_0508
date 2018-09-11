<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main role="main" class="container">
	<h1>Formulario Alta Producto</h1>
	<p>Los campos con * son obligatorios.</p>
	
	<form action="formulario" method="post">
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				   <label class="required" for="nombre">Nombre: </label>
				   <input class="form-control" type="text" name="nombre" placeholder="Nombre del producto" required autofocus tabindex="1">
				   <div class="invalid-feedback">
		          		Please choose a username.
		        	</div>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<label class="required" for="categoria">Categoría: </label>
					<select name="categoria" class="custom-select">
						<option selected value="${categoria[0].id}">${categoria[0].nombre}</option>
						<%
							ArrayList<Categoria> categoria = (ArrayList<Categoria>)request.getAttribute("categoria");
							for(int i=1;i<categoria.size();i++){
								
						%>	
							<option value="<%=categoria.get(i).getId()%>"><%=categoria.get(i).getNombre()%></option>
						<%
							}
						%>
					  
					  
					</select>
				</div>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col">
				<div class="form-group">
				    <label class="required" for="codigo">Código: </label>
				    <input class="form-control" type="text" name="codigo" placeholder="Código del producto" tabindex="3">
				</div>
			</div>
			
			<div class="col">
				<div class="form-group">
			   		<label class="required" for="precio">Precio: </label>
			   		<input class="form-control" type="number" name="precio" step="0.1" placeholder="Precio" tabindex="4">
				</div>
			</div>
			
			<div class="col">
				<div class="form-group form-check">
					<label class="d-block text-center" for="oferta">Oferta</label>
				    <input class="form-control" type="checkbox" name="oferta" tabindex="2">
				</div>
			</div>

		</div>
		
		<div class="form-group">
			<label class="required" for="descripcion">Descripción: </label>
			<textarea class="form-control" type="text" name="descripcion" rows="5"  placeholder="Descripción del producto" tabindex="5"></textarea>
		</div>
		
		<input class="form-control btn btn-outline-primary" type="submit" value="Dar de Alta">
	</form>
</main>

<%@include file="includes/footer.jsp"%>