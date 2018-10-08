<%@ include file="includes/header.jsp" %>
<body>

    <div class="contenedor">

        <header id="top">
<%@ include file="includes/navbar.jsp" %>
<%@ include file="includes/alert.jsp" %>            

        </header>

        <div class="contenido ">
			
			
			<c:forEach items="${perros}" var="p">
				<div class="producto col-3">
					<c:if test="${p.apadrinado}">
						<p class="descuento">Apadrinado</p>
					</c:if>		                
		
		                <img src="${p.img}" alt="imagen-producto" />
		                 <h5 class="card-title">${p.nombre}</h5>
						
		                <div class="texto-producto">
							<p class="etiquetas"><strong>Raza: </strong>${p.raza}</p>                
							<p class="etiquetas"><strong>peso: </strong>${p.peso}</p>  			                    
										                    
		                    <p class="etiquetas"><strong>Edad(Años): </strong>${ p.edad}</p>
		                    <p class="etiquetas"><strong>Chip: </strong>${ p.chip.numero}</p>
		                    
		
		                   
	
	                	</div>
		
			<a class=" "href="#">Ver mas información</a>
		
	                

            	</div> <!-- /.producto -->
						
			</c:forEach>
			
<!-- 		<!-- Buscador -->	 
<!-- 			<div class="buscar"> -->
<!-- 			<form action="home" method="post" > -->
<%-- 				<input type="text" name="buscarPalabra" placeholder="Texto a buscar" required value="${buscarTexto}"> --%>
<!-- 				<input type="submit" value="Buscar texto"> -->
<!-- 			</form> -->
<!-- 		</div>	 -->
		
<!-- 		<h3>Paginas encontradas:</h3> -->
<!-- 		<ul>			 -->
<%-- 			<c:forEach items="${perrosEncontrados}" var="p"> --%>
<%-- 				<li><a href="#">Nombre: ${p.numPag}</a></li>	 --%>
<%-- 			</c:forEach>			 --%>
<!-- 		</ul> -->
			
			
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>


    </div> <!-- /.contenedor -->

    
<%@ include file="includes/footer.jsp" %> 