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
		
		<div class="row justify-content-end">
			
			<form action="home?op=3" class="navbar-form navbar-left col-12" method="POST">
				<label>Buscador:</label>
				<div class="form-group">
					<div class="col col-6">
						<input type="text" class="form-control" name="cadena" placeholder="Inserte dato a buscar" value="" autofocus required>
					</div>	
					<div class="col col-6">
						<input type="submit" class="btn btn-default " value="Buscar ">
					</div>						
				</div>				
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