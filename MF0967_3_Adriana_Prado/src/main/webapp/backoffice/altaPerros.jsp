<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<!-- Main -->
<main class="container" role="main" >
	<div class="row justify-content-center align-items-end">
		<h1 class="text-center">Registrar un nuevo perro</h1>
	</div>
    <div class="row justify-content-center align-items-center">
	<div class="col">
	
		<form class="altaperro" action="altaperro" method="post">
           <p class="text-center">Los campos con <b class="required"></b> son obligatorios.</p>
            <div class="form-row justify-content-center">
            	<div class="col col-md-8">
            		<div class="form-row">
	                    <div class="col">
	                        <div class="form-group">
	                            <label class="required" for="nombre">Nombre: </label>
	                            <input class="form-control" type="text" name="nombre" placeholder="Mínimo 3 caracteres y máximo 20" minlength="3" maxlength="20" required autofocus>
	                        </div>
	                    </div>
                	</div>
                	<!-- /.form-row -->
                
	                <div class="form-row">
	                    <div class="col">
	                        <div class="form-group">
	                                <label class="required" for="edad">Edad: </label>
	                                <input class="form-control" type="number" name="edad" step="1" placeholder="Ejemplo: 10 años" required>
	                        </div>
	                    </div>
	                    
	                    <div class="col">
	                        <div class="form-group">
	                                <label class="required" for="peso">Peso (Kg): </label>
	                                <input class="form-control" type="number" name="peso" step="0.01" placeholder="Ejemplo: 15,20 Kg" required>
	                        </div>
	                    </div>
	                </div>
	                <!-- /.form-row -->
	                
	                <div class="form-row">
	                    <div class="col">
	                        <div class="form-group">
	                                <label class="required" for="raza">Raza: </label>
	                                <input class="form-control" type="text" name="raza" placeholder="Ejemplo: Beagle" required>
	                        </div>
	                    </div>
	                    
	                    <div class="col">
	                        <div class="form-group">
	                                <label class="required" for="chip">Nº Chip: </label>
	                                <input class="form-control" type="text" name="chip" placeholder="Formato: DD-DDDD-AAAA" required>
	                        </div>
	                    </div>
	                </div>
	                <!-- /.form-row -->
	                
	                <div class="form-row">
	                    <div class="col">
	                        <div class="form-group">
                                <label class="required" for="latitud">Latitud: </label>
                                <input class="form-control" type="number" step="1" name="latitud" placeholder="Ejemplo: 90º" required>
	                        </div>
	                    </div>
	                    
	                    <div class="col">
	                        <div class="form-group">
                                <label class="required" for="longitud">Longitud: </label>
                                <input class="form-control" type="number" step="1" name="longitud" placeholder="Ejemplo: 90º" required>
	                        </div>
	                    </div>
	                </div>
	                <!-- /.form-row -->
	                
	                <div class="form-row">
	                    <div class="col">
	                        <div class="form-group">
	                            <label class="required" for="imagen">Dirección web de la imagen: </label>
	                            <input class="form-control" type="url" name="imagen" placeholder="http://example/image.png" required>
	                        </div>
	                    </div>
	                    
	                    <div class="col">
	                        <div class="form-check">
	                            <label class="d-block text-center" for="apadrinado">Apadrinado:</label>
	                            <input class="form-control" type="checkbox" name="apadrinado" value="apadrinado">
	                        </div>
	                    </div>
               		</div>
               		<!-- /.form-row -->
               		
              		<div class="form-group">
					    <label for="descripcion">Descripción:</label>
					    <textarea class="form-control" id ="descripcion" name="descripcion" rows="3"></textarea>
					</div>
					<!-- /.form-group -->
					
	                <input class="form-control btn btn-outline-primary" type="submit" value="Dar de Alta">
            	</div>
			</div>
           </form>
          <!-- /form -->
		</div>
	</div>
</main>
<!-- /Main -->

<%@include file="includes/footer.jsp"%>