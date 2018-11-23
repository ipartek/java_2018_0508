<%@include file="includes/header.jsp"%>

	<header class="shadow-sm p-3 mb-5 rounded">
	
		<div class="container">
			<h1 class="text-center">Hello, world!</h1>
		</div>

	</header>
	
	<main class="container">
	
		<%@include file="includes/alert.jsp"%>
	
		<p>El resultado de sumar los dos parámetros es: </p>
		
		<h2>Expression Language</h2>
		<p>${suma}</p>
		
		<h2>Scriplet</h2>
		<p><%=request.getAttribute("suma")%></p>
	  	
	</main>
    
<%@include file="includes/footer.jsp"%>