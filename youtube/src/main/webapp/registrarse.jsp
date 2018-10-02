<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	 <div class="container">
	 	<%@include file="includes/alerts.jsp" %>
        <section class="row justify-content-center mt-2">
        	<h1 class="text-center col-12 text-info">¡Registrate!</h1>
            <form action="registrarse" method="post" class="col-6 shadow p-3 mb-5 bg-white rounded">
            	<div class="form-group">
                	<label for="usuario">Usuario:</label>
                    <input name=nombre type="text" class="form-control" id="usuario" placeholder="Nombre (min. 3 max. 50 car)" required autofocus pattern="{3,50}">
                </div>
                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input name="password" type="password" class="form-control" id="contraseña" placeholder="Contraseña (min. 8 max. 20 car)" required pattern="{8,20}">
                </div>
                <div class="form-group">
                    <label for="contraseña2">Vuelve a introducir la contraseña:</label>
                    <input name="repassword" type="password" class="form-control" id="contraseña2" placeholder="Contraseña (min. 8 max. 20 car)" required pattern="{8,20}">
                </div>
                <button type="submit" class="btn btn-outline-primary btn-block">Registrarse</button>
            </form>
     	</section>
     </div>

<%@include file="includes/footer.jsp" %>