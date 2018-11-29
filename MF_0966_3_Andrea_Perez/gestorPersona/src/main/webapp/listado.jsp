<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
   
<div class="container">   
	<div class="container">
		<h1 class="text-center">Listado de Registros de Personas</h1>
		
		<c:if test="${alert.texto!=null}">
			<div class="alert ${alert.tipo} alert-dismissible show" role="alert">
				<p>${alert.texto}</p>
			 	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			 		<span aria-hidden="true">&times;</span>
			 	</button>
			</div>		
		</c:if>
		
		<div class="row justify-content-end mt-2 mb-5">
			<div class="col col-2 mb-2">
				<a href="home?id=-1&op=4" class="btn btn-success">Crear Registro de Persona</a>
			</div>
			<form action="home?op=3" class="navbar-form navbar-left" method="POST">
				<label>Buscador:</label>
				<div class="form-group">
					<input type="text" class="form-control" name="cadena" placeholder="Inserte dato a buscar" value="" autofocus required>
				</div>
				<input type="submit" class="btn btn-default" value="Buscar ">
			</form>	
		</div>
		<table id="example" class="display" style="width:100%">
	        <thead>
	            <tr>
	            <th>ID</th>			             	
	                <th>Nombre</th>
	                <th>Primer Apellido</th>
	                <th>Segundo Apellido</th> 
	                <th>Email</th> 
	                <th>DNI</th>			                              
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${personas}" var="p">
	        		<tr>
	        		<td><a href="home?id=${p.id}&op=4">${p.id}</a></td>
					
					<td>${p.nombre}</td>
	                <td>${p.apellido1}</td>
	                <td>${p.apellido2}</td>	
	                <td>${p.email}</td>
		            <td>${p.dni}</td>   			                
		            </tr> 			        	
	        	</c:forEach>
	        </tbody>
	        <tfoot>
	            <tr>
	            	<th>ID</th>			             	
	                <th>Nombre</th>
	                <th>Primer Apellido</th>
	                <th>Segundo Apellido</th> 
	                <th>Email</th> 
	                <th>DNI</th>			                
	            </tr>
	        </tfoot>
	    </table>
		    </div>
</div>

    
<%@include file="includes/footer.jsp"%>