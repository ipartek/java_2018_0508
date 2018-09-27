<footer class="">
 	<hr>
 	
	 <div class="row justify-content-end m-0 mb-2">
	 	<span>Escrito por: ${pagina.nombreUsuario}</span> 
	 </div>
	
	<c:if test="${pagina.id > 0}"> 
		 <div class="row justify-content-center">
		 	<p>Página ${pagina.id} de ${totalPaginas - 1}</p>
		 </div>
	 </c:if>
	 
	 <c:if test="${pagina.id <= 0}"> 
		 <div class="row justify-content-center">
		 	<p>Portada</p>
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