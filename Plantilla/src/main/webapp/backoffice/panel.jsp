<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "../include/header.jsp" %>

<%@ include file = "../include/navbar.jsp" %>

<main class="container mt-5" role="main">

	<c:if test="alert != null">
		<!-- Gestión de alertas -->
		<div class="row align-center">
	        <div class="col color-primary">
				<%@include file="/include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	

</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="/include/footer.jsp" %>
	</div>
</div>
