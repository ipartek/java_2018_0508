<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty juego}">
	<h2>Videojuego Creado</h2>
	<p>ID: ${juego.id}</p>
	<p>Titulo: ${juego.titulo}</p>
	<p>Fecha de Lanzamiento: ${juego.fechaLanzamiento}</p>
</c:if>