<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty juego}">

	<h2>Video Juego Creado !!!</h2>
	id: ${juego.id}
	<br>
	titulo: ${juego.titulo}
	<br>
	Fecha Lanzamiento: ${juego.fechaLanzamiento}
	
</c:if>


<c:if test="${empty juegos}">
	*Lo sentimos pero no existen juegos todavia
</c:if>

<ol>
<c:forEach items="${juegos}" var="j">
	<li>${j}</li>	
</c:forEach>
</ol>

