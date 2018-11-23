<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
       <!-- Comienza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/privado">

	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">

    <title>Proyecto Web Repaso</title>
  </head>
  
  <body>
  
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded shadow-sm">
	<!-- Navbar content -->
	<a class="navbar-brand" href="index.jsp">Web Repaso</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
  	<c:if test="${not empty usuario}">
		<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="logout">Cerrar Sesión <i class="fas fa-sign-out-alt"></i></a>
			</ul>
		</div>
	</c:if>
	
</nav>

<main class="container">
	<%@include file="../includes/alert.jsp"%>
	
	<p>Welcome to darkness e.e</p>
</main>

<%@include file="../includes/footer.jsp"%>