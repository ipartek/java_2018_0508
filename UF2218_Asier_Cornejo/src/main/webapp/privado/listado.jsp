<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>	

        <main class="container" role="main">
	<c:if test="${not empty alert}">
			<div class="container">
				<div class="alert ${alert.tipo} alert-dismissible fade show"
					role="alert">
					<p>${alert.texto}</p>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
	
				${alert=null}
	
		</c:if>
		
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Descuento</th>
                        <th>Precio Final</th>
                        <th>Precio / Litro</th>
                        <th>Descripción</th>
                        <th>Imagen (URL)</th>
                    </tr>
                </thead>

                <tbody>
                
                <c:forEach items="${productos}" var="p"> 
                
                	<tr>
                        <td>${p.nombre}</td>
                        <td>${p.precio}&euro;</td>
                        <td>${p.descuento}&#37</td>
                        <td>${p.calcularDescuento}&euro;</td>
                        <td>${p.precioCantidad}&euro;/litro;</td>
                       
                        <td>${p.descripcion}</td>
                        <td><img src="${p.imagen}" alt="" /></td>
                    </tr>
                
                
                
                </c:forEach>
                        
                </tbody>

            </table>
            
        </main>

        <footer id="listado-footer">

            <div>
                <p>&copy; 2018</p>
            </div>
                
            <nav>
                <a href="#">Politica de privacidad</a>
                <a href="#">Contacto</a>
                <a href="#">Localización</a>
            </nav>
                
            <div class="social">
                <a href="https://es-es.facebook.com/" id="facebook" target="_blank"><i class="fab fa-facebook-square fa-3x"></i></a>
                <a href="https://twitter.com/?lang=es" id="twitter" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
            </div>
                
        </footer>

   

    <!-- Scripts para plugin datatable -->

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
    <script>
            
        $(document).ready(function() {
            $('#listado-productos').DataTable( {
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
                }
            } );
        } );
    
    </script>
    
</body>
</html>