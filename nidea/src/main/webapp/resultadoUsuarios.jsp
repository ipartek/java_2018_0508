<%@page import="com.ipartek.formacion.nidea.pojo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


<%
	ArrayList<Usuario> usersArray = (ArrayList<Usuario>)request.getAttribute("usuarios");

%>
<div class="container">
	
		<h1>Resultado</h1>
		<div class="row">
			
			<%
				for( Usuario u :usersArray){
							
			%>
			<div class="col-sm-4">
				<div class="card" >
				  <img class="card-img-top" src="https://image.flaticon.com/icons/svg/17/17004.svg" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">Usuario: <%=u.getNombre()%></h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>		
			</div>
			<%
				}
			%>
		</div>	
		
		
		
	</div>
	
	


<%@include file="includes/footer.jsp" %>