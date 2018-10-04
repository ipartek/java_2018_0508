<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.examen.model.pojo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<div class="contenido">
		<nav aria-label="Page navigation example">
		  
		<div class="producto">
			<c:if test="${ not empty usuario }">
				<div>
					<!-- Buscador por paginas -->
					<div class="row justify-content-md-center">	
					 	<form action="buscadorControler" for="buscarElemto">
							<button class="btn btn-primary btn-lg" type="submit" href="buscadorControler?" >Buscar por pagina</button>
							<input type="text" name="buscarPagina" plasceholder="Introduce el numero de pagina">
												
						</form>
					</div>  
					<div>
						Paginas encontradas
						<ul>
							<c:forEach items="${paginasCoincidencia}" var="p">
								<li><a href="">${p.paginas }</a></li>
							</c:forEach>
							
						</ul>
					
					</div> 
				</div>
				<!-- Buscador de contenido -->
				<div class="row justify-content-md-center">	
				 	<form action="comentariosController" for="buscarElemto">
						<label>Busca texto</label>
						<input type="text" name="buscarElemento">
						<button class="btn btn-primary btn-lg" type="submit" >Buscar texto</button>					
					</form>
				</div>
			</c:if>
			<div class="row justify-content-md-center">			 
	   				<!-- Paginacion -->
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    
				    <%
				    	ArrayList<Paginas> paginas = (ArrayList<Paginas>) request.getAttribute("paginas");
				    	//int nPaginas = Integer.parseInt((String)request.getAttribute("nPaginas"));
				    	if (paginas != null){
				    		for(Paginas p : paginas){
			    			
			    		
				    %>
				    		<li class="page-item"><a class="page-link" href="comentariosController?pagina=<%=p.getPaginas()%>"><%=p.getPaginas() %></a></li>
				    <%
				    		}
				    	}else{
				    %>
				    		<li class="page-item"><a class="page-link" href="comentariosController?pagina=1">1</a></li>
				    <%
				    	}
				    %>
					 
					   
					  </ul>
					</nav>			
			</div>
			<!-- Muestra de contenido de las paginas -->
			<div class="row justify-content-md-center">		 
				   <div class="col col-lg-4 texto-principal texto-principal-fondo">
				   <%
			    	Paginas paginaInicio = (Paginas) request.getAttribute("paginaInicio");
			    	if (paginaInicio != null){	
				    %>
				    	<div><%= paginaInicio.getTexto() %></div>
				    <%
				    	}
				    %>
				    <hr>
					    <div class="texto-principal-pie">
					    	<div class="row">
					    		<div class="col-6 nombreAutor">Texto autor : <%= paginaInicio.getAutor() %> </div>
					    		<div class="col-6 contadorPaginas">Paginas : <%= paginaInicio.getPaginas() %>/<%=paginas.size() %></div>
					    	</div>	
					    </div>
				   </div>
			 </div>
			 <div class="row justify-content-md-center">			 
	   				<!-- Paginacion -->
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item"><a class="page-link" href="comentariosController?paginaAnterior=<%= paginaInicio.getPaginas() %>">Pagina anterior</a></li>

					    <li class="page-item"><a class="page-link" href="comentariosController?paginaSiguiente=<%= paginaInicio.getPaginas() %>">pagina siguiente</a></li>
					  </ul>
					</nav>			
			</div>
			<c:if test="${ not empty usuario }">
				 <div class="row justify-content-md-center text-autor">
	  				<form action="comentariosController">
					   	<div class="col col-lg-4 comentario">
						    <textarea id="textoAutor" placeholder="Añade tu pagina" name="textoAutor" rows="" cols="44"></textarea>			
					   	</div>
					   	<button class="btn btn-primary btn-lg btn-block" type="submit">Añadir texto</button>
				   	</form>
			 	</div>
		 	</c:if>
		 	
			 
		</div>
</div>


<%@ include file="includes/footer.jsp" %>