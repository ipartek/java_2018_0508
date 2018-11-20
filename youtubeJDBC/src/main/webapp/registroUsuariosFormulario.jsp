<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.youtube.controller.pojo.Alert"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Video"%>
<%@page import="com.ipartek.formacion.youtube.controller.RegistroUsuarioController"%>
<%@ include file="includes/header.jsp"  %>	
<%@ include file="includes/nav.jsp"  %>

    <!-- Page Content -->
    <div class="container"><!-- align-self-center -->
	    <div class="formularioAlta row" >
		    <div class="col " >
				<form action="RegistroUsuarioControler" method="post">
					  <div class="form-row">
					  <div class="form-group col-md-12">
					      <label for="nombreUsuario">Usuario</label>
					      <input type="text" class="form-control " id="nombre" onblur="checkNombre()" name="nombreUsuario" autofocus required="required" placeholder="5 caracteres minimo" pattern="[A-Za-z]{5,45}">
					     <!--  <small id="noDisponilbe" class="form-text  text-danger" >Nombre no disponible</small> -->
					      <small id="nombreHelp" class="form-text" ></small>
					    </div>
					    <!-- <div class="form-group col-md-6">
					      <label for="emailUsuario">Email</label>
					      <input type="email" class="form-control" name="emailUsuario" required="required" placeholder="ejemplo@correo.com" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,45}">
					    </div> -->
					    <div class="form-group col-md-6">
					      <label for="passUsuario">Password</label>
					      <input type="password" class="form-control" required="required" name="passUsuario" placeholder="*******">
					    </div>
					    <div class="form-group col-md-6">
					      <label for="replyPassUsuario">Repita el password</label>
					      <input type="password" class="form-control" required="required" name="replyPassUsuario" placeholder="*******">
					    </div>
					  </div>
					  <div class="center-button">
					  	<button  type="submit" class="btn btn-primary">Date de alta</button>
					  </div>
				</form>
			</div>
	    </div>	    
    </div>
    <!-- /.container -->

          <%@ include file="includes/footer.jsp"  %>
