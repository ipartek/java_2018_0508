<div class="card card-outline-secondary my-4">
   <div class="card-header">
     Comentarios
   </div>
   <div class="card-body">
   
   	 <div class="form-comentario">
   	 
   	 	<p><b class="text-warning">USUARIO</b> Queremos saber que opìnas de este video</p>
   	 	<p><i class="text-danger">*Para poder escribir tu opinión, por favor incia sessión.</i></p>
   	 	
   	  	<form action="publicar" method="post" class="form-inline d-flex align-items-stretch">
   	 		<textarea class="form-control" name="texto" rows="5" placeholder="Danos tu opinión..." required></textarea>
   	 		<input type="hidden" name="id_video" value="${videoInicio.id}">
   	 		<input type="hidden" name="id_usuario" value="${usuario.id}">
   	 		<%-- <input type="submit"  value="Comentar" ${(sessionScope.usuario.id  != null?'crear Usuario' : usuarioSeleccionado.nombre } class="form-control ml-auto btn btn-outline-info "> --%>
   	 	</form>
   	 </div>
   	 	
   	 <hr>
   	 <c:forEach items="${comentarios}" var="c">
     <small class="text-muted">Posted by Anonymous on 3/1/17</small>	     	<p>${c.texto}</p>
     <hr>	     	<small class="text-muted"><b>${c.usuario.nombre}</b>  <fmt:formatDate value="${c.fecha}" pattern="dd/MM/yyyy HH:mm"/></small>
     	<hr>
     </c:forEach>   
   </div>
 </div>
 <!-- /.card --> 