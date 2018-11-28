<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
   
<div class="container">   
	<div class="container">
		<div class="row justify-content-end mt-2 mb-5">
			<div class="col col-2 mb-2">
				<a href="home?id=-1&op=4" class="btn btn-success">Crear Registro de Persona</a>
			</div>
			<form action="home?op=3" class="navbar-form navbar-left" role="search">
				<label>Buscar por DNI:</label>
				<div class="form-group">
					<input type="text" class="form-control" name="buscadni" placeholder="DNI a buscar" value="">
				</div>
				<input type="submit" class="btn btn-default" value="Buscar por DNI ">
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