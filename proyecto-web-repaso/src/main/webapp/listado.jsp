<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty juego}">
	<h2>Videojuego Creado</h2>
	<p>ID: ${juego.id}</p>
	<p>Titulo: ${juego.titulo}</p>
	<p>Fecha de Lanzamiento: ${juego.fechaLanzamiento}</p>
</c:if>

<c:if test="${empty juegos}">
<p>${msj}</p>
</c:if>

<h2>Listado de Videojuegos</h2>
<c:forEach items="${juegos}" var="j"> 
<ul>
	<li>ID: ${j.id}</li>
</ul>
	<p>Titulo: ${j.titulo}</p>
	<p>Fecha de Lanzamiento: ${j.fechaLanzamiento}</p>
</c:forEach>
