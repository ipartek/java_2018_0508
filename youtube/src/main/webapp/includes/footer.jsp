<!-- Directivas para usar Tags el prefijo es  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%-- <%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.pojo.Comentarios"%>
<%@page import="com.ipartek.formacion.pojo.Alerts"%>
<%@page import="com.ipartek.formacion.pojo.Video"%> --%>

<%@page import="com.ipartek.formacion.youtube.controller.VideoYoutubeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

 <footer class="py-5 bg-dark">
      <div class="container">
             
      	<c:if test="${not empty usuario}"> 
        	<span class="text-warning">Ultima visita <%=fecha %></span><!-- cookie.cVisita.value -->
        </c:if> --%>

      </div>
      
      <!-- /.container -->
    </footer>

   

  </body>

</html>