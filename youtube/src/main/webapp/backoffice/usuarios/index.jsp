<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper">
 	  
	<%@include file="../includes/alert.jsp" %>   
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Usuarios registrados</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
  		<div class="row">
  		
  			<div class="col-md-8">
  				TODO buscador con lupita  			
  			</div>
  			<div class="col-md-4">
  				<a href="usuarios?id=-1" class="btn btn-primary">Crear nuevo</a>  			
  			</div>
  		
  		</div>
	       
	    
		<table id="tablaOrdenable" class="display">
			<thead>
			    <tr>
			        <th>Id</th>
			        <th>Nombre</th>
			        <th>Password</th>
			        <th>Rol</th>
			    </tr>
			</thead>
			<tbody>
			    
				<c:forEach items="${usuarios}" var="u">
				    	
				    <tr>
				    	<td>${u.id}</td>
				    	<td><a href="usuarios?id=${u.id }">${u.nombre}</a></td>
				    	<td>${u.pass}</td>
				    	<td>${ (u.rol == 1)?'normal' : 'administrador' }</td>			    	
				    </tr>
				    
				</c:forEach>
			        
			</tbody>
		</table>
		
		
	</div>
<%@include file="../includes/footer.jsp"%>