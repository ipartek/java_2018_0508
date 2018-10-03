<%@include file="includes/taglibs.jsp"%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.adriana.prado.pojo.Usuario"%>
<%@page import="com.adriana.prado.pojo.Alert"%>
<%@page import="com.adriana.prado.controller.HomeController"%>
<%@page import="com.adriana.prado.pojo.Video"%>
<%@page import="java.util.ArrayList"%>


<%@include file="includes/header.jsp"%>

	<%
//		Usuario bean =new Usuario();
// 		bean.setNombre("Soy un Bean");
// 		out.print("<p>" + bean.getNombre() + "</p>");
	%>
	
<%-- 	<jsp:useBean id="bean2" scope="page" class="com.adriana.prado.pojo.Usuario"></jsp:useBean> --%>
<%-- 	<jsp:setProperty property="nombre" name="bean2" value="Marianiko el Corto"/> --%>
<%-- 	<jsp:getProperty property="nombre" name="bean2"/> --%>

	<%@include file="includes/navbar.jsp"%>

	<!-- Page Content -->
	<div class="container mt-4">
<%-- 	<p><fmt:message key="msj.video.por.visualizar"> --%>
<%-- 		<fmt:param value="1" /> --%>
<%-- 	</fmt:message></p> --%>

		<%@include file="includes/alert.jsp"%>

		<div class="row">
			
			<%@include file="includes/listaVideos.jsp"%>	

			<div class="col-lg-9">

				<div class="card mt-4">

					<!-- https://tutorialzine.com/2015/08/how-to-control-youtubes-video-player-with-javascript -->

					<div id="video-placeholder"></div>
					
<%-- 					<iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${videoInicio.codigo }?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe> --%>
           
					<div class="card-body">
						<h3 class="card-title">
							${videoInicio.titulo }
						</h3>
						<p class="card-text">${videoInicio.descripcion}</p>
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header"><fmt:message key="titulo.comentarios"/></div>
					<div class="card-body">
						<c:forEach items="${videos}" var="v">
<%-- 							<p>${v.comentarios.contenido }</p> --%>
<%-- 							<small class="text-muted">Posted by ${v.comentarios.nombreUsuario} on ${ v.comentarios.fecha}</small> --%>
							<hr>
						</c:forEach>
						
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						
						<!-- Si hay usuario loggeado -->
						<c:if test="${not empty usuario }">
							<form action="comentar" method="post" id="cmtform">
								<textarea rows="4" cols="105" name="comentario" form="cmtform" 
								placeholder="Escribe aquí tu comentario..."></textarea>
								<input type="hidden" name="fecha" value="${LocalDateTime.now() }">
								<input type="hidden" name="user" value="${usuario}">
								
								<div>
									<button type="submit" class="btn btn-success"><fmt:message key="boton.comentar"/></button>
								</div>
							</form>
						</c:if>
						
						<!-- Si no hay usuario loggeado -->
						<c:if test="${empty usuario }">
							<p>****Por favor inicia sesión para comentar en el vídeo****</p>
						</c:if>
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

<%@include file="includes/footer.jsp"%>
