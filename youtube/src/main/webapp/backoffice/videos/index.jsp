<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   

	<div id="page-wrapper" class="contenedor">   
	<%@include file="../includes/alert.jsp" %> 
  
	    <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header titulo">Videos <span class="badge nVideos">${fn:length(videos)}</span></h1>
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
  				<a href="videos?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="btn btn-danger">Crear nuevo</a>  			
  			</div>
  		
  		</div>
	    
		<table id="tablaOrdenable" class="display">
			<thead>
			    <tr>
			        <th>Id</th>
			        <th>Imagen</th>
			        <th>Nombre</th>
			        <th>Usuario</th>
			    </tr>
			</thead>
			<tbody>
			    <c:forEach items="${videos}" var="v">
				    <tr>
				        <td>${v.id}</td>
				        <td><img src="https://img.youtube.com/vi/${v.codigo}/0.jpg" class="thumbnail" alt="Miniatura de ${v.nombre}" title="Miniatura de ${v.nombre}" /></td>
				        <td><a href="videos?id=${v.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="text-danger">${v.nombre}</a></td>
				        <td><a href="usuarios?id=${v.usuario.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${v.usuario.nombre}</a></td>
				    </tr>
			    </c:forEach>
			</tbody>
			<tfoot>
			    <tr>
			        <th>Id</th>
			        <th>Nombre</th>
			        <th>Usuario</th>
			        <th>Imagen</th>
			    </tr>
			</tfoot>
		</table>
	</div>
    
<%@include file="../includes/footer.jsp"%>