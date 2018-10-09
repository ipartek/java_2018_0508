<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper" class="contenedor">
 	  
	<%@include file="../includes/alert.jsp" %>   
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header titulo">Roles <span class="badge nRoles">${nRoles }</span></h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
  		<div class="row buscador">
  		
  			<div class="col-md-8">
  				<form action="buscar" method="post">
  					<input type="search" name="buscador" placeholder="Buscar por nombre" />
  					<button type="submit"><i class="fas fa-search"></i></button>
  				</form> 			
  			</div>
  			<div class="col-md-4 btn-crear">
  				<a href="roles?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="btn btn-success">Crear nuevo</a>  			
  			</div>
  		
  		</div>
	       
	    
		<table id="tablaOrdenable" class="display">
			<thead>
			    <tr>
			        <th>Id</th>
			        <th>Nombre</th>
			    </tr>
			</thead>
			<tbody>
			    
				<c:forEach items="${roles}" var="r">
				    	
				    <tr>
				    	<td>${r.id}</td>
				    	<td><a href="roles?id=${r.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="text-success">${r.nombre}</a></td>		    	
				    </tr>
				    
				</c:forEach>
			        
			</tbody>
		</table>
		
		
	</div>
<%@include file="../includes/footer.jsp"%>