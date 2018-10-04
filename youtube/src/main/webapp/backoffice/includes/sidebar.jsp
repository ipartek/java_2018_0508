<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Navigation -->
 <div class="navbar-default sidebar" role="navigation">
     <div class="sidebar-nav navbar-collapse">
         <ul class="nav" id="side-menu">
             <li>
                 <a href="backoffice/index.jsp"><i class="fas fa-tachometer-alt"></i> Inicio</a>
             </li>
             <li>
                 <a href="backoffice/usuario?op=<%= BackofficeUsuarioController.OP_LISTAR%>"><i class="fas fa-users"></i> Usuarios</a>
             </li>
             <li>
                 <a href="backoffice/index.jsp"><i class="fab fa-youtube"></i> Videos</a>
             </li>
         </ul>
     </div>
     <!-- /.sidebar-collapse -->
 </div>
 <!-- /.navbar-static-side -->
