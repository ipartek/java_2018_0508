<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	 <div class="container">
	 	<%@include file="includes/alerts.jsp" %>
        <section class="row justify-content-center mt-2">
        	<h2 class="text-center col-12 text-info">¡Registrate!</h2>
            <form action="registrarse" method="post" class="col-6 shadow p-3 mb-5 bg-white rounded">
            	<div class="form-group">
                	<label for="usuario">Usuario:</label>
                    <input name="usuario" type="text" class="form-control" id="usuario" placeholder="Nombre (max. 50 car)" required autofocus>
                </div>
                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input name="password" type="password" class="form-control" id="contraseña" placeholder="Contraseña (max. 20 car)" required>
                </div>
                <div class="form-group">
                    <label for="contraseña2">Vuelve a introducir la contraseña:</label>
                    <input name="password" type="password" class="form-control" id="contraseña2" placeholder="Contraseña (max. 20 car)" required>
                </div>
                <button type="submit" class="btn btn-outline-primary btn-block">Registrarse</button>
            </form>
     	</section>
     </div>

<%@include file="includes/footer.jsp" %>