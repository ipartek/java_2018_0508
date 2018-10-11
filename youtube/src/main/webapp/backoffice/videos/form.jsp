<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
    	
  	  <%@ include file="../includes/alert.jsp" %>
  
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${(video.id == -1)?'Crear Registro': video.nombre }</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
      		      		
      		<form action="videos" method="post">
      			
      			<div class="form-group">
				   <label for="id">Id</label>
				   <input type="text" class="form-control" name="id" id="id" value="${video.id}" readonly>
				</div>
				
				<div class="form-group">
				   <label for="nombre">Nombre</label>
				   <input type="text" class="form-control" name="nombre" id="nombre" value="${video.nombre}" autofocus>
				</div>
				
				<div class="form-group">
				   <label for="codigo">Codigo</label>
				   <input type="text" class="form-control" name="codigo" id="codigo" value="${video.codigo}" maxlength="11" minlength="11" >
				</div>
				
				<div class="form-group">
				   <label for="id_usuario">Usuario</label>
				   <select name="id_usuario" class="form-control">
				   		<c:forEach items="${usuarios}" var="u">
				   			<option value="${u.id}"  ${(u.id==video.usuario.id)?'selected':''}>${u.nombre}</option>
				   		</c:forEach>
				   </select>				   
				</div>
				
				      		      		
      			<input type="hidden" name="op" value="<%=CrudControllable.OP_GUARDAR%>">
      			<input type="submit" value="${(video.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
      			<c:if test="${video.id > 0}">
      				<a href="videos?id=${video.id}&op=<%=CrudControllable.OP_ELIMINAR%>" onclick="confirmar(event)" class="btn btn-danger btn-block">Eliminar</a>
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

