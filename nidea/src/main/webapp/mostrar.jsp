<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

	<main  class="container">
		<di id="mostrar-page" class="justify-content-center">
			<div class="col-12 mb-3">
				<h1 class="text-center text-primary font-weight-light">Productos</h1>
				<div class="row d-flex flex-wrap card-deck">
					<%
						for(int i=0; i<8; i++){
					%>
					  <div class="col-3 cards">
					    <img class="card-img-top" src="https://picsum.photos/200/200/?image=<%=i%>" alt="Card image cap">
					    <div class="card-body">
					      <h5 class="card-title">Card title</h5>
					      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
					    </div>
					    <div class="card-footer">
					      <small class="text-muted">Last updated 3 mins ago</small>
					    </div>
					  </div>
	
				
					<%} %>
				</div>
				
			</div>
			
		</div>
	</main>

<%@ include file="includes/footer.jsp" %>