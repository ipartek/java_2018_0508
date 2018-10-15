<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Comentarios</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<c:forEach items="${comentarios}" var="c">
            	<form action="">
            		<div class="row">
	            			<div class="col">
	            				<input class="form-check-input" type="checkbox" name="" id="" value="${c.id}">
	            			</div>
	            			<div class="col">
								<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${c.usuario.nombre}">
	            			</div>
	            			<div class="col">
	            				<textarea readonly class="form-control-plaintext" id="exampleFormControlTextarea1" rows="3">${c.texto}</textarea>
	            			</div>
            		</div>
            	</form>
            	</c:forEach>
            </div>
</div>
<!-- /#page-wrapper -->

<%@include file="../includes/footer.jsp" %>