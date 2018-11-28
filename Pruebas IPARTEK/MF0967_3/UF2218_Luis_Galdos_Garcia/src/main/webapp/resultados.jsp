<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<div class="row align-center">
        <div class="col color-primary">
			<!-- Gestión de alertas -->
			<%@include file="include/alert.jsp" %>
		</div>
	</div>
	
	<c:forEach items="${pagsEncontradas}" var="pag">
		<div class="row align-center">
	        <div class="col-md-12 color-primary">
	           <div class="card" style="width: 18rem;">
				 
				  <div class="card-body">
				    <h2 class="card-title">${pag.titulo}</h2>
				    <h3 class="card-title">${pag.autor}</h3>
				    <p class="card-text">${pag.contenidoCorto} ...</p>
				    <a href="#" class="btn btn-primary">Leer más</a>
				  </div>
				</div>
	           
	        </div>
	    </div>
    </c:forEach>
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>