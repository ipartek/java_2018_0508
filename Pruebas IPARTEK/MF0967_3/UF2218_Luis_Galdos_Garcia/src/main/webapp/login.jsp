<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${not empty sessionScope.alert}">
		<div class="row align-middle">
	        <div class="col color-primary">	
				<%@include file="../include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<div class="row align-middle">
        <div class="col-md-12 color-primary">
        <form action="login" method="post">
		  
		  <div class="form-group">
		    <label for="usuario">Usuario</label>
		    <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Mínimo 5 caracteres" value="${cookie.cNombre.value}">
		  </div>
		  
		  <div class="form-group">
		    <label for="psw">Contraseña</label>
		    <input type="password" class="form-control" id="psw" name="password" placeholder="Mínimo 5 caracteres" min="5">
		  </div>
		  
		  <div class="form-check">
		    <input type="checkbox" class="form-check-input" id="recordar">
		    <label class="form-check-label" for="recordar" ${(not empty cookie.cNombre.value)?"checked":""}>Recordar usuario</label>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Acceder</button>
		  
		</form>
        </div> <!--  ./col -->
    </div> <!--  ./row -->
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>