<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/taglibs.jsp"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main" >

	<%@include file="includes/alert.jsp"%>

	<h1 class="text-center mb-3 ">Listado de perros</h1>
	
	<table id="lista" class="display">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Raza</th>
                <th>Peso (Kg)</th>
                <th>Apadrinado</th>
                <th>Chip</th>
            </tr>
        </thead>
        <!-- /thead -->
        <tbody>
			<c:forEach items="${perros}" var="p">
				<tr>
	                <td>${p.nombre}</td>
	                <td>${p.edad}</td>
	                <td>${p.raza}</td>
	                <td>${p.peso}</td>
					<td>${(p.apadrinado)?'Si':'No'}</td>
	                <td>${p.chip.codigo}</td>
	            </tr> 
			</c:forEach>    
        </tbody>
        <!-- /tbody -->
        <tfoot>
	        <tr>
	            <th>Nombre</th>
	            <th>Edad</th>
	            <th>Raza</th>
	            <th>Peso (Kg)</th>
	            <th>Apadrinado</th>
	            <th>Chip</th>
	        </tr>
       </tfoot>
       <!-- /tfoot -->
    </table>
	<!-- /table -->
</main>
<!-- /main -->

<%@include file="includes/footer.jsp"%>