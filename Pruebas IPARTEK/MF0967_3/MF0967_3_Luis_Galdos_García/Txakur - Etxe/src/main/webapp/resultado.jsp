<!-- Cabecera -->
<%@ include file="/include/header.jsp" %>

<!-- Navegador -->
<%@ include file="/include/navbar.jsp" %>

<main class="container mt-5" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${alert != null }">
		<div class="row align-center">
	        <div class="col color-primary">
				<%@include file="/include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<!-- Formulario de Acceso -->
	<c:if test="${empty sessionScope.usuario}">
		<div class="row align-center">
	        <div class="col-lg-3 color-primary">
				<%@ include file="/include/modal-login-form.jsp" %>
			</div>
		</div>
	</c:if>

		<!-- MOSTRAR RESULTADOS BÚSQUEDA (INICIO)-->
		<section class="container">
		<p class="h2 text-white">Mostrando resultados para: ${ busqueda }</p> 
			<div class="card-group">
			
				<c:forEach items="${perrosEncontrados}" var="perro" varStatus="loop"> 	
				
					    	<div class="card m-2">
							    <img class="card-img-top" src="${ perro.img }" alt="Imagen del perro">
							    <div class="card-body">
							      <h5 class="card-title text-center">${ perro.nombre }</h5>
										<ul class="list-group">
										  <li class="list-group-item"><b>Raza:</b> ${ perro.raza }.</li>
										  <li class="list-group-item"><b>Edad:</b> ${ perro.edad } años.</li>
										  <li class="list-group-item"><b>Peso:</b> ${ perro.peso } kg.</li>
										  <li class="list-group-item"><b>Chip:</b> ${ perro.chip.numero }</li>
										</ul>
							      <p class="card-text text-center">
							      	<small class="text-info">${not perro.esApadrinado ? "Apadrínalo ya!" : "Ya tiene un hogar" }</small>
							      </p>
					    		</div> <!-- ./ card-body -->
					  		</div> <!-- ./ card -->		
				</c:forEach>
			</div> <!-- ./ card-group -->  
		 <p class="h2 text-white">${numResultados} resultados.</p>  
		</section>
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="/include/footer.jsp" %>
	</div>
</div>