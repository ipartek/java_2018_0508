<%@page import="com.andrea.perez.controller.back.BackofficeRolController"%>
<%@page import="com.andrea.perez.pojo.Rol"%>
<%@include file="../includes/header.jsp"%>    
<%@include file="../includes/aside.jsp"%> 

<div id="page-wrapper">
${(rol.id == -1)?'Crear':'Modificar'}
<%@include file="../includes/alert.jsp"%>
	<div class="row">
		<div class="col-lg-12">
		
		<div class="row justify-content-center align-items-center" style="min-height:470px;">
      
      	<div class="col-6">	
      		<h1>Editar Rol de los usuarios</h1>
      		
      		<form method="post" action="roles?op=${BackofficeRolController.OP_GUARDAR}">
      			<div class="form-group">
      		 		<label for="id">Id</label>
	      			<input type="text" class="form-control" name="id" id="id" value="${(rol.id==-1)?'': rol.id }" readonly>
	      		</div>
	      		
      		 	<div class="form-group">
      		 		<label for="nombre">Nombre</label>
	      			<input type="text" name="nombre" class="form-control" id="nombre" value="${rol.nombre }" autofocus>
	      		</div>	      		
	      		
	      		<input type="submit" value="${(rol.id == -1)?'Crear':'Modificar'}" class="btn btn-primary btn-block">
				<c:if test="${rol.id > 0 }">
					<a href="roles?id=${rol.id}&op=${BackofficeRolController.OP_ELIMINAR}" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar(Modal confirmar)</a>
				</c:if>
      		</form>
      	</div>
      
      </div><!-- .row -->
		
		
		<!-- row -->
		
		</div>
		<!-- /col-lg-12 -->
	</div>
	<!-- /row -->	
</div>






<%@include file="../includes/footer.jsp"%>