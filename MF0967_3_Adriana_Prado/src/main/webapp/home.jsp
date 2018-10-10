<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<h1 class="text-center mb-4">
	ONG Apadrina un perro
</h1>

<div class="main-content">
	<%@include file="includes/buscador.jsp"%>

	<div class="cartas">

		<!-- Lista de todos los perros cuando no se ha usado el buscador -->
		<c:if test="${empty palabra}">
			<c:forEach items="${perros}" var="p">
				<section class="card">
			        <div class="top-box">
			            <img class="img-card" src="${p.imagen}" alt="Imagen">
				        <c:if test="${p.apadrinado}">
				        	<span class="icon">
				        		<i title="¡Apadrinado!" class="fas fa-hand-holding-heart"></i>
			            	</span>
						</c:if>
						<div class="">
							<h2 class="titulo-card">${p.nombre}</h2>
						</div>
			            
			        </div>
			        <div class="bottom-box">
			        	<c:if test="${p.apadrinado}">
			        		<p class="apadrinado"><b>¡Apadrinado!</b></p>
			        	</c:if>
			        	<span class="description">
			                    Raza: ${p.raza}
			            </span>
			            <span class="description">
			                    Edad: ${p.edad}
			            </span>
			            <p class="description">
			                    Peso: ${p.peso} Kg
			            </p>
			            <p class="description">
			                   Código chip: ${p.chip.codigo}
			            </p>
			            <p class="description">
			                    ${p.descripcion}
			            </p>
			        </div>
			    </section>
			    <!-- /.card -->
			</c:forEach>
		</c:if>
		
		<!-- Cuando se ha usado el buscador se muestra esto -->
		<c:if test="${not empty palabra}">			
			<c:forEach items="${perrosEncontrados}" var="p">
				<section class="card">
			        <div class="top-box">
			            <img class="img-card" src="${p.imagen}" alt="Imagen">
				        <c:if test="${p.apadrinado}">
				        	<span class="icon">
				        		<i title="¡Apadrinado!" class="fas fa-hand-holding-heart"></i>
			            	</span>
						</c:if>
						<div class="">
							<h2 class="titulo-card">${p.nombre}</h2>
						</div>
			            
			        </div>
			        <div class="bottom-box">
			        	<span class="description">
			                    Raza: ${p.raza}
			            </span>
			            <span class="description">
			                    Edad: ${p.edad}
			            </span>
			            <p class="description">
			                    Peso: ${p.peso} Kg
			            </p>
			            <p class="description">
			                   Código chip: ${p.chip.codigo}
			            </p>
			            <p class="description">
			                    ${p.descripcion}
			            </p>
			        </div>
			    </section>
			    <!-- /.card -->
			</c:forEach>
		</c:if>
	
	</div>
</div>

<%@include file="includes/footer.jsp"%>