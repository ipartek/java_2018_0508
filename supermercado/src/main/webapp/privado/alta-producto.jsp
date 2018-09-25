<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/navbar.jsp" %>

            <main role="main" class="container">
            
            <c:if test="${empty alert }">
      		${alert = null }
      		
	      	</c:if>
	      	
	      	<c:if test="${not empty alert }">
	      	
	      		<div class="alert ${alert.tipo } alert-dismissible fade show" role="alert">
				  <p>${alert.texto }</p>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
	      	</c:if>	

                <h1><i class="fas fa-archive"></i> Alta de producto</h1>
                <small>Los campos con * son obligatorios</small>
            
                <form action="alta" method="post" class="form-alta-producto">

                    <div class="form-row">
                            
                        <div class="form-group col">
                            <label for="nom" class="required">Nombre del producto:</label>
                            <input type="text" class="form-control" id="nom" name="nombre" value="${producto.nombre }" minlength="5" maxlength="20" required autofocus placeholder="De 5 a 20 caracteres" />
                        </div>
                    
                        <div class="form-group col">
                            <label for="precio" class="required">Precio del producto:</label>
                            <input type="number" class="form-control" id="precio" name="precio" value="${producto.precio }" required min="0" step="0.01" placeholder="0.0&euro;"/>
                        </div>
                               
                    </div> <!-- /.form-row -->
                            
                    <div class="form-row">

                        <div class="form-group col">
                            <label for="cant">Cantidad de productos a ingresar:</label>
                            <input type="number" class="form-control" id="cant" name="cantidad" min="1" max="20" placeholder="Mínimo 1 y máximo 20" >
                        </div> 
                            
                        <div class="form-group col">
                            <label for="cant-descuento" class="required">Descuento(&#37;):</label>
                            <input type="number" class="form-control" id="cant-descuento" name="descuento" value="${producto.descuento }" required placeholder="Si no hay descuento, no rellene este campo" />
                        </div>
                                    
                        <div class="form-group col">
                            <label for="litro" class="required">Precio por Litro:</label>
                            <input type="number" class="form-control" id="litro" name="precioUnidad" value="${producto.precioUnidad }" min="0" step="0.01" required placeholder="0.0&euro; / Litro" />
                        </div>
                                   
                    </div> <!-- /.form-row -->
                            
                    <div class="form-group">
                        <label for="desc" class="required">Descripción:</label>
                        <textarea id="desc" class="form-control" name="descripcion" required placeholder="Informe a sus clientes sobre los detalles del producto" rows="3" />${producto.descripcion }</textarea>
                    </div>

                    <div class="form-group">
                        <label for="img" class="required">Imagen(URL):</label>
                        <input type="text" class="form-control" id="img" name="imagen" value="${producto.imagen }" required placeholder="http://ejemplo-de-imagen.com" />
                    </div>

                    <button type="submit" class="btn btn-outline-primary btn-block">Dar de alta producto</button>

                </form>
                
            </main>
            
            
<%@ include file="../includes/footer.jsp" %>