<%@include file="includes/taglibs.jsp"%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.controller.pojo.Alert"%>
<%@page import="com.ipartek.formacion.controller.HomeController"%>
<%@page import="com.ipartek.formacion.pojo.Video"%>
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
				
				<%@include file="includes/comentarios.jsp"%>

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

<%@include file="includes/footer.jsp"%>
