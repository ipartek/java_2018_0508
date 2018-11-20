<!-- SET JAVA LANGUAGE AND UTF-8 CODIFICATION -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- IMPORTS OF JAVA CLASSES -->

<!-- INCLUDE HEADER -->
<%@ include file="include/header.jsp"%>
    
<!-- HOME CONTENT -->
<div class="container">
    
    <!-- INCLUDE HEADER-NAV -->
	<%@ include file="include/header-nav.jsp"%>
	
	<!-- INCLUDE ALERTS -->
	<%@ include file="include/alert.jsp"%>
	
	<!-- INCLUDE CONFIRMATION ALERTS -->
	<%@ include file="include/modal-alerts.jsp"%>
	
	<div class="row">
		
		<div class="col-lg-3">
			
			<h2 class="mb-0 text-center">Categorías</h2>
			<div class="list-group">
			<c:forEach items="${ categorias }" var="categoria">
			
			<a href="#" class="list-group-item list-group-item-action list-group-item-primary">${ categoria.nombre }</a>
			
			</c:forEach>
			</div>
		</div>	<!-- /.col -->
		
	</div> <!-- /.row -->
	
	
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
