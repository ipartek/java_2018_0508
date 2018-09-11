<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>


<main role="main" class="container"> 

	<div class="row centered-form justify-content-center ">
        <div class="col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default p-3">
        		
        		<div class="panel-heading">
			    	<h3 class="panel-title">Bienvenido <small>It's free!</small></h3>
			 	</div>
			 			
			 	<div class="panel-body">
			    	<form role="form">
			    		<div class="row">	
			    			<div class="col-xs-6 col-sm-6 col-md-6">
			    				<div class="form-group">
			                		<input type="text" name="nombre" class="form-control input-sm" placeholder="Nombre">
			    				</div>
			    			</div>
			    				
			    			<div class="col-xs-6 col-sm-6 col-md-6">
			    				<div class="form-group">
			    					<input type="text" name="apellido" class="form-control input-sm" placeholder="Apellido">
			    				</div>
			    			</div>		
			    		</div>
						<!-- END FORM-ROW -->
							
			    		<div class="form-group">
			    			<input type="email" name="email" class="form-control input-sm" placeholder="E-mail">
			    		</div>

			    		<div class="row">
			    			<div class="col-xs-6 col-sm-6 col-md-6">
			    				<div class="form-group">
			    					<input type="password" name="password" class="form-control input-sm" placeholder="Contraseña">
			    				</div>
			    			</div>
			    			
			    			<div class="col-xs-6 col-sm-6 col-md-6">
			    				<div class="form-group">
			    					<input type="password" name="confirmacion" class="form-control input-sm" placeholder="Repite la contraseña">
			    				</div>
			    			</div>
			    			
			    		</div>
			    		<!-- END FORM-ROW -->
			    			
			    		<input type="submit" value="Register" class="btn btn-info btn-block">
			    	</form>
			    </div>
			    <!-- END PANEL-BODY -->
	    	</div>
	    	<!-- END PANEL -->
    	</div>
    	<!-- END COL -->
    </div>
    <!-- END ROW -->	
</main>

<%@include file="includes/footer.jsp"%>

