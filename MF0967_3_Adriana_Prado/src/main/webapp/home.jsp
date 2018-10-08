<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<h1 class="text-center mb-4">
	ONG Apadrina un perro
</h1>

<div class="main-content">

	<c:forEach items="${perros}" var="p">
		<section class="card">
	        <div class="top-box">
	            <img class="img-card" src="${p.imagen}" alt="Imagen">
		        <c:if test="${p.apadrinado}">
		        	<span class="icon">
	                	<i class="fas fa-hand-holding-heart"></i>
	            	</span>
				</c:if>
	            <h2 class="titulo-card">${p.nombre}</h2>
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
	                    ${p.descripcion}
	            </p>
	        </div>
	    </section>
	    <!-- /.card -->
	</c:forEach>
</div>

<form action="home?op=1" method="post">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="Buscar por nombre o chip..." aria-label="Recipient's username" aria-describedby="button-addon2" name="palabra">
			<div class="input-group-append">
				<input class="form-control btn btn-secondary" type="submit" value="Buscar" id="button-addon2">
			</div>
		</div>
	</form>
	
	<c:if test="${not empty perro}">
       	<section class="card">
	        <div class="top-box">
	            <img class="img-card" src="${perro.imagen}" alt="Imagen">
		        <c:if test="${perro.apadrinado}">
		        	<span class="icon">
	                	<i class="fas fa-hand-holding-heart"></i>
	            	</span>
				</c:if>
	            <h2 class="titulo-card">${perro.nombre}</h2>
	        </div>
	        <div class="bottom-box">
	        	<span class="description">
	                    Raza: ${perro.raza}
	            </span>
	            <span class="description">
	                    Edad: ${perro.edad}
	            </span>
	            <p class="description">
	                    Peso: ${perro.peso} Kg
	            </p>
	            <p class="description">
	                    ${perro.descripcion}
	            </p>
	        </div>
	    </section>
	    <!-- /.card -->
	</c:if>

<%@include file="includes/footer.jsp"%>