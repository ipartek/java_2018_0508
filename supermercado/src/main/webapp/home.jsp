<%@ include file="includes/head.jsp" %>
<body>

    <div class="contenedor">

        <header id="top">
			<%@ include file="includes/navbar.jsp" %>
            

        </header>

        <div class="contenido">
			<h2>Numero de productos ${numeroProductos}</h2>
			
			<c:forEach items="${productos}" var="p">
				<div class="producto">
					<c:if test="${p.descuento>0 }">
						<p class="descuento">${p.descuento}%</p>
					</c:if>		                
		
		                <img src="${p.imagen}" alt="imagen-producto" />
		
		                <div class="texto-producto">
							<c:if test="${p.descuento>0 }">
								<p><span class="tachado">${p.precio }&euro;</span><span>${p.calcularDescuento}&euro;</span></p>
							</c:if>		                
							<c:if test="${p.descuento==0 }">
								<p><span>${p.precio}&euro;</span></p>
							</c:if>			                    
		                    <p class="precio-litro">(${ p.precioVolumen} / Litro)</p>
		                    <p>${p.descripcion}</p>
		
		                    <div class="cantidad">
		                        <span>&#45;</span> 1 <span>&#43;</span>
		                    </div>
	
	                	</div>
	
	                <a href="#">AÑADIR AL CARRO</a>

            	</div> <!-- /.producto -->
						
			</c:forEach>
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>

        <footer>

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


    </div> <!-- /.contenedor -->

    
</body>
</html>