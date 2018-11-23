<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty juego}">

	<h2>Video Juego Creado !!!</h2>
	id: ${juego.id}
	<br>
	titulo: ${juego.titulo}
	<br>
	Fecha Lanzamiento: ${juego.fechaLanzamiento}
	
</c:if>

