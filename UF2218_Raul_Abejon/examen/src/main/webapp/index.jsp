<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.examen.model.pojo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<div class="contenido">	
  
		<div class="producto">
		
			<!-- Muestra de contenido de las paginas -->
			<div class="row justify-content-md-center">	
			
					<!-- BUSCAR TEXTO -->
					<div class="col-3 m-auto align-self-end">
						<form action="ebookController" for="buscarElemto">								
							<input type="text" name="buscarElemento" placeholder="Buscar texto">
							<input type="hidden" name="accionRequerida" value="1">
							<button class="btn btn-primary btn-lg" type="submit" >Buscar por texto</button>					
						</form>
						
						<!-- POSIBLES PAGINAS DE COINCIDENCIA -->
						<div class="row justify-content-md-center">
						
							<c:if test="${not empty paginasCoincidencia }">						
								<div class="mr-auto">								
									<ul>
										<c:forEach items="${paginasCoincidencia}" var="p">
											<li>Paginas <a href="">${p.paginas }</a></li>
										</c:forEach>									
									</ul>							
								</div> 
							</c:if>
						</div>
					</div>	 
						
					<!-- EBOOK -->
				   <div class="col col-lg-4 texto-principal texto-principal-fondo">
				    	<div>${paginaInicio.texto }</div>
				    <hr>
					    <div class="texto-principal-pie">
					    	<div class="row">
					    		<div class="col-6 nombreAutor">Texto autor :${paginaInicio.autor }  </div>
					    		<div class="col-6 contadorPaginas">Paginas :${paginaInicio.paginas } / ${paginas.size() }</div>
					    	</div>	
					    </div>
				   </div>
				   
				   <!-- BUSCAR PAGINA -->
				   <div class="col-3 m-auto align-self-end ">
							<form class="buscador-centrado" action="ebookController" for="buscarPagina">						
							<input class="buscador-centrado" type="text" name="buscarPagina" placeholder="Buscar por pagina">
							<input type="hidden" name="accionRequerida" value="2">
							<button  class="btn btn-primary btn-lg" type="submit"  >Buscar por pagina</button>
												
						</form>							
					</div>
			 </div>
			 
			 <!-- PAGINACION -->
			 <div class="row justify-content-md-center">			 
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item"><a class="page-link" href="ebookController?paginaAnterior=${paginaInicio.paginas }&accionRequerida=4">Pagina anterior</a></li>
					    <li class="page-item"><a class="page-link" href="ebookController?paginaSiguiente=${paginaInicio.paginas }&accionRequerida=5">pagina siguiente</a></li>
					  </ul>
					</nav>			
			</div>
			
			<!-- ENTRADA DE TEXTO -->
			<c:if test="${ not empty usuario }">
				<div>					
					<div class="row justify-content-md-center">
						
						<div class="col-3">
							<c:if test="${ not empty usuario }">
								 <div class="row justify-content-md-center text-autor">
					  				<form action="ebookController">
									   	<div class="col col-lg-4 comentario">
										    <textarea id="textoAutor" placeholder="Añade tu pagina" name="textoAutor" rows="" cols="44"></textarea>
										    <input type="hidden" name="accionRequerida" value="3">			
									   	</div>
									   	<button class="btn btn-primary btn-lg btn-block" type="submit">Añadir texto</button>
								   	</form>
							 	</div>
						 	</c:if>
						</div>
					</div> 
			</c:if>
		</div>
</div>


<%@ include file="includes/footer.jsp" %>