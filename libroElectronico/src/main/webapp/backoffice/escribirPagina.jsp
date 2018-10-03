<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.jsp"%>

<main class="container" role="main">
<%@include file="../includes/alert.jsp"%>	
	
	<form action="paginaControl" method="post">
	  	  
		  <div class="form-group">
		    <label for="contenido">Redactar nueva página</label>
		    <textarea class="form-control" name="texto" rows="5" placeholder="Mínimo 25 palabras." rows="15" required autofocus>${texto}</textarea>
		  </div>
	  
	  <button type="submit" class="btn btn-primary btn-block">Publicar</button>
	</form>
	
</main>
<%@include file="../includes/footer.jsp"%>
