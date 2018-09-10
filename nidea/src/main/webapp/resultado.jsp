<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


	<main role="main" class="container">
		<h1>Resultado</h1>
		<hr>
		<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="images/imagen.png" alt="Card image cap">
  			<span class="badge badge-light">
  			<%
				out.print(request.getParameter("oferta"));
			%>
			</span>
  			<div class="card-body">
  			<div class="row">
	    		<div class="col">
		    		<h5 class="card-title">
					<%
					out.print(request.getParameter("nombre"));
					%>
					</h5>
	    		</div>
	    		<div class="col">
		    		<p class="card-text">
			    		<small class="text-muted">
						<%
						out.print(request.getParameter("precio")+"€");
						%>
						</small>
					</p>
	    		</div>
    		</div>
  			<p class="card-text">
    			<%
				out.print(request.getParameter("descripcion"));
				%>
			</p>
    			<a href="#" class="btn btn-primary">Ver articulo</a>
  			</div>
		</div>
		
	</main>


<%@include file="includes/footer.jsp" %>