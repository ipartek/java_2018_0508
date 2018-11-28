<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
   
<main class="container">
    
    <!-- Tratamiento de las alertas get POST-->
	    <c:if test="${empty alerta}">
	    	${alerta=null}
	    </c:if>
	    
		<c:if test="${not empty alerta}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
  				<span >${alerta}</span>
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
			</div>
		</c:if>	
		    <div class="container">
		   <div class="row justify-content-end mt-2 mb-5">
				<div class="col col-2 mb-2">
					<a href="home?id=-1&op=4"" class="btn btn-success">Nuevo Registro de Persona</a>
				</div>
				<form action="home?op=3" class="navbar-form navbar-left" role="search">
				<label>Buscar por DNI:</label>
					<div class="form-group">
						<input type="text" class="form-control" name="buscadni" placeholder="DNI a buscar" value="">
					</div>
					<input type="submit" class="btn btn-default" value="Buscar por DNI ">
				</form>
				
				<form action="home?op=5" class="navbar-form navbar-left" role="search">
				<label>Buscar por Email:</label>
					<div class="form-group">
						<input type="text" class="form-control" name="buscaemail" placeholder="Email a buscar" value="">
					</div>
					<input type="submit" class="btn btn-default" value="Buscar por Email">
				</form>
				
				<form action="home?op=6" class="navbar-form navbar-left" role="search">
				<label>Buscador que coincidan con nombre o apellido1 o pellido2:</label>
					<div class="form-group">
						<input type="text" class="form-control" name="buscaNombre" placeholder="Nombre a buscar" value="">
					</div>
					<input type="submit" class="btn btn-default" value="Buscar">
				</form>
			</div>
		    	<table id="example" class="display" style="width:100%">
			        <thead>
			            <tr>
			            <th>ID</th>
			             	
			                <th>Nombre</th>
			                <th>Apellido1</th>
			                <th>Apellido2</th> 
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
				            <td>${p.dni}</a></td>   			                
				            </tr> 			        	
			        	</c:forEach>
			        </tbody>
			        <tfoot>
			            <tr>
			            	<th>ID</th>			             	
			                <th>Nombre</th>
			                <th>Apellido1</th>
			                <th>Apellido2</th> 
			                <th>Email</th> 
			                <th>DNI</th>			                
			            </tr>
			        </tfoot>
			    </table>
		    </div>
	  </main>

    
<%@include file="includes/footer.jsp"%>