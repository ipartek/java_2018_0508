<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<!-- EMPIEZA NUEVO BOOTSTRAP -->

<main class="container">
		<%@include file="includes/alert.jsp"%>
		
		<c:if test="${empty sessionScope.usuario }">
		<h3>Debes iniciar sesion para poder escribir en el libro</h3>	
		
		</c:if>
		<div class="buscar">
			<form action="inicio" method="post" >
			<input type="number" name="buscarPag" placeholder="Nº pag" required value="${buscarPag}">
			<input type="submit" value="Buscar pagina">
		</form>
		</div>
		
		
		<div class="nav_pag">
			<a type="button" class="btn btn-info izq" href="inicio?op=retrocede"><i class="fas fa-backward"></i></a>
			<a type="button" class="btn btn-info dech" href="inicio?op=avanza"><i class="fas fa-forward"></i></a>			
		</div>
		
		
		
		<div class="paginacion">
			<h4 class="h4 nav-pagina">${pagActual.numPag } / ${numPaginas} Pag</h4>
			<hr class="my-4">
			<p class="text_autor"><strong>${pagActual.autor}</strong></p>
			<hr class="my-4">
			<p class="text-justify texto "> ${pagActual.texto}</p>
		</div>
		
		<div class="nav_pag">
			<a type="button" class="btn btn-info izq" href="inicio?op=retrocede"><i class="fas fa-backward"></i></a>
			<a type="button" class="btn btn-info dech" href="inicio?op=avanza"><i class="fas fa-forward"></i></a>			
		</div>
		
		<div class="buscar">
			<form action="inicio" method="post" >
				<input type="text" name="buscarPalabra" placeholder="Texto a buscar" required value="${buscarPalabra}">
				<input type="submit" value="Buscar texto">
			</form>
		</div>	
		
		<h3>Paginas encontradas:</h3>
		<ul>			
			<c:forEach items="${pagsEncontradas}" var="p">
				<li><a href="#">Pagina ${p.numPag}</a></li>	
			</c:forEach>			
		</ul>
		
</main>



<%@include file="includes/footer.jsp"%>
