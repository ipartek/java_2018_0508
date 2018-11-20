<div class="card card-outline-secondary my-4">
   <div class="card-header">
     Comentarios
   </div>
   <div class="card-body">
   
   	 <div class="form-comentario">
   	 
   	 	<c:if test="${not empty sessionScope.usuario}">
   	 		<p><b class="text-warning">${sessionScope.usuario.nombre}</b> Queremos saber que opìnas de este video</p>   	 	
   	 	</c:if>
   	 	<c:if test="${empty sessionScope.usuario}">
   	 		<p><i class="text-danger">*Para poder escribir tu opinión, por favor incia sessión.</i></p>
   	 	</c:if>	
   	 	
   	  	<form action="publicar" method="post" class="form-inline d-flex align-items-stretch">
   	 		<textarea class="form-control" name="texto" rows="5" placeholder="Danos tu opinión..." required ${(empty sessionScope.usuario)?'disabled':''}></textarea>
   	 		<input type="hidden" name="id_video" value="${videoInicio.id}">   	 		
   	 		<input type="submit" value="Comentar" class="form-control ml-auto btn btn-outline-info " ${(empty sessionScope.usuario)?'disabled':''}>
   	 	</form>
   	 </div>
   	 		
   	 <hr>
   	 
   	 <c:forEach items="${comentarios}" var="c">
     	<p class="modal-body">${c.texto}</p>
     	<small class="text-muted"><b>${c.usuario.nombre}</b>  <fmt:formatDate value="${c.fecha}" pattern="dd/MM/yyyy HH:mm"/></small>
     	<hr>
     </c:forEach>
          
   </div>
 </div>
 <!-- /.card -->