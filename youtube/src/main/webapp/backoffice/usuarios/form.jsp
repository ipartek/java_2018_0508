<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${(usuario.id == -1)?'Crear Usuario': usuario.nombre }</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
      		      		
      		<form action="usuarios" method="post">
      			
      			<div class="form-group">
				   <label for="id">Id</label>
				   <input type="text" class="form-control" name="id" id="id" value="${usuario.id}" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${usuario.nombre}" autofocus>
				</div>
				
				<div class="form-group">
				   <label for="password">Contraseña</label>
				   <div class="input-group">
      					<div class="input-group-addon"><i class="fas fa-eye" onclick="showpass(event,'password')"></i></div>
				   		<input type="password" class="form-control" name="password" id="password" value="${usuario.password}">
				   	</div>	
				</div>
				
				<div class="form-group">				
				   <label for="rol">Rol</label>
				   <select name="rol" class="form-control">
				   		<c:forEach items="${roles}" var="rol">
				   			<option value="${rol.id}"  ${(rol.id==usuario.rol.id)?'selected':''} >${rol.nombre}</option>
				   		</c:forEach>
				   </select>
				</div>
      		      		
      			<input type="hidden" name="op" value="<%=BackofficeUsuarioController.OP_GUARDAR%>">
      			<input type="submit" value="${(usuario.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
      			<c:if test="${usuario.id > 0}">
      				<a href="usuarios?id=${usuario.id}&op=<%=BackofficeUsuarioController.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>
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

