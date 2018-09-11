<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main class="container" role="main">
	
		<h1><i class="fas fa-clipboard-list"></i> Listado backend</h1>
		
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Código</th>
					<th scope="col">Descripción</th>
					<th scope="col">Oferta</th>
					<th scope="col">Precio</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td scope="row">Armario de roble</td>
					<td>AR-109</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </td>
					<td>10%</td>
					<td>39.99&euro;</td>
				</tr>
				
				<tr>
					<td scope="row">Mesa de comedor</td>
					<td>ME-43</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
					<td>NO</td>
					<td>9.99&euro;</td>
				</tr>
				
				<tr>
					<td scope="row">Escritorio profesional</td>
					<td>ES-08</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
					<td>20%</td>
					<td>69.99&euro;</td>
				</tr>
				
				<tr>
					<td scope="row">Nevera 3x15</td>
					<td>NEV-56</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </td>
					<td>20%</td>
					<td>59.99&euro;</td>
				</tr>
				
				<tr>
					<td scope="row">Bañera grande</td>
					<td>BA-12</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
					<td>NO</td>
					<td>79.99&euro;</td>
				</tr>
				
				<tr>
					<td scope="row">Cama de matrimonio</td>
					<td>CA-20</td>
					<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
					<td>50%</td>
					<td>84.99&euro;</td>
				</tr>
				
			</tbody>
			
		</table>
	
	</main>


<%@include file="includes/footer.jsp" %>