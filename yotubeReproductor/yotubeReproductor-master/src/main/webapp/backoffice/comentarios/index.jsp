
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<div id="page-wrapper">

<%@ include file="../includes/alert.jsp" %>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Comentarios <span class="badge">${comentarios.size()}</span></h1> 
	
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row 
	<div class="row">
		<div class="col">
			<a href="comentarios?id=-1&op=4" class="btn btn-success">Aprobar</a>
		</div>
	</div>-->

	<div class="row">
	${comentarios}

		
	</div>

</div>

<%@ include file="../includes/footer.jsp" %>  