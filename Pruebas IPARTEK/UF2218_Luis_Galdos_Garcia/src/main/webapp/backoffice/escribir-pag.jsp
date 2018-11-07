<!-- Cabecera -->
<%@ include file="../include/header.jsp" %>

<!-- Navbar -->
<%@ include file="../include/navbar.jsp" %>

<main class="container" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${not empty sessionScope.alert}">
		<div class="row align-middle">
	        <div class="col color-primary">	
				<%@include file="../include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<form action="publicar" method="post">
	  <div class="form-group">
	    <label for="titulo">Título</label>
	    <input type="text" class="form-control" name="titulo" placeholder="De 5 a 120 caracteres." min="5" max="120">
	  </div>
	  
	  <div class="form-group">
	    <label for="contenido">Contenido de la Página</label>
	    <textarea class="form-control" name="contenido" rows="5" placeholder="Mínimo 25 palabras."></textarea>
	  </div>
	  
	  <button type="submit" class="btn btn-primary btn-block">Publicar</button>
	</form>
	
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="../include/footer.jsp" %>
	</div>
</div>