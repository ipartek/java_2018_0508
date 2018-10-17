<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

        <div class="contenido">
        <div class="perros-principal">
             <c:forEach items="${perros}" var="p">
             
             	<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="${p.img }" alt="Imagen del perro ">
					  <c:if test="${p.apadrinado != false}">
					  		<span class="badge badge-pill badge-warning apadrinado">Apadrinado</span>
					  </c:if>
					  <div class="card-body">
					    <h5 class="card-title">Nombre: ${p.nombre }</h5>
					  </div>
					  <ul class="list-group list-group-flush">
					    <li class="list-group-item">Raza: ${p.raza }</li>
					    <li class="list-group-item">Edad: ${p.edad }</li>
					    <li class="list-group-item">Peso: ${p.peso }</li>
					    <li class="list-group-item">Chip: ${p.chipPerro.nIdentificacion }</li>
					    <li class="list-group-item">Apadrinado:: ${p.apadrinado == false ? "No" :"Si" } <c:if test="${p.apadrinado == 'true'}">
					    	
					   </c:if></li>
					  </ul>
					  <%-- <div class="card-body">
					  	<c:if test="${p.apadrinado == 'true'}">
					    	<span class="badge badge-pill badge-info">Apadrinado</span>
					   </c:if>
					  </div> --%>
					</div>
				
             </c:forEach>
             </div>
        </div> <!-- /.contenido -->

       

<%@ include file="includes/footer.jsp" %>