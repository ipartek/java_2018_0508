<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        
        <a class="navbar-brand" href="inicio">Lista de Reproducción</a>
        
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
          
            <!-- SEARCH BAR -->
            <form class="form-inline text-center ml-auto">
            	<div class="input-group stylish-input-group">
                    <input type="text" class="form-control"  placeholder="Código o título del video" size="40">
                    <span class="input-group-text">
                        <button type="submit">
                            <i class="fas fa-search"></i>
                        </button>  
                    </span>
                </div>
            </form>
            
            <ul class="nav navbar-nav flex-row ml-auto">
                
                <li class="nav-item order-2 order-md-1">
                	<a href="backoffice" class="nav-link" title="Ajustes">
                		<i class="fa fa-cog fa-fw fa-lg"></i>
                	</a>
                </li>
                
                <li class="nav-item order-2 order-md-1">
                	<a href="#" class="nav-link" title="Acerca De">
                		<i class="fas fa-info-circle fa-lg"></i>
                	</a>
                </li>
                
                
                <li class="dropdown order-1" id="loginForm">
                    <button type="button" data-toggle="dropdown" class="btn btn-outline-secondary dropdown-toggle">
                    	${ empty sessionScope.usuario ? 'Acceder' : 'Insertar' } <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right mt-2">
                       <li class="px-3 py-2">
                       		
                       		<%@ include file="modal-forms.jsp"%>
                            
                        </li>
                    </ul> <!-- /. dropdown-menu -->
                
                </li>	<!-- /.dropdown -->
            
            </ul>	<!--/. navbar-nav -->
            
        </div>	<!-- /.navbar-collapse -->
    
    </div>	<!-- /.container -->
</nav>