<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Rol"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
    	
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${(rol.id == -1)?'Crear Registro': rol.nombre }</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
      		      		
      		<form action="roles" method="post">
      			
      			<div class="form-group">
				   <label for="id">Id</label>
				   <input type="text" class="form-control" name="id" id="id" value="${rol.id}" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${rol.nombre}" autofocus>
				</div>
				
				      		      		
      			<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>">
      			<input type="submit" value="${(rol.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
      			<c:if test="${rol.id > 0}">
      				<a href="roles?id=${rol.id}&op=<%=CrudControllable.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>
      			</c:if>	
      		</form>
      		
      		<script>
      			function confirmar( e ) {					
      				if ( confirm('¿Estas seguro que quieres ELIMINAR ?') ){
      					console.log('confirmado eliminar');
      				}else{
      					//prevenir el evento por defecto de <a href=''>
      					e.preventDefault();
      				}      				
				}
      		</script>
      		
      </div>      
     
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

