<footer class="">
 	<hr>
 	
	 <div class="row justify-content-end m-0 mb-2">
	 	<span>Escrito por: ${pagina.nombreUsuario}</span> 
	 </div>
	
	<c:if test="${pagina.id > 0}"> 
		 <div class="row justify-content-center">
		 	<p><strong>Página ${pagina.id} de ${totalPaginas - 1}</strong></p>
		 </div>
	 </c:if>
	 
	 <c:if test="${pagina.id <= 0}"> 
		 <div class="row justify-content-center">
		 	<p><strong>Portada</strong></p>
		 </div>
	 </c:if>
	 
 	<div class="row justify-content-${(pagina.id <= 0)?'end':'between'} m-0">
 		<c:if test="${pagina.id > 0}">
 			<a class="btn btn-dark" href="pagina?id=${pagina.id-1}" role="button">Anterior</a>
 		</c:if>
 		
 		<c:if test="${!esUltimo}">
 			<a class="btn btn-dark justify-content-end" href="pagina?id=${pagina.id+1}" role="button">Siguiente</a>
 		</c:if>
 	</div>
</footer>

<div class="input-group mt-3 mb-3 ">
  <input type="text" class="form-control" placeholder="Buscar página..." aria-describedby="basic-addon2">
  <div class="input-group-append">
    <button class="btn btn-outline-secondary" type="submit">Buscar</button>
  </div>
</div>