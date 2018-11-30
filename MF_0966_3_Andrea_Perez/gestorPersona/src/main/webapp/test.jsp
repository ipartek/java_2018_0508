<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

	<link rel="stylesheet" href="css/styles.css">
	
	
    <title>Hello, world!</title>
  </head>
  <body>
  <main class="container">
  	<header>
  		<%@include file="includes/navbar.jsp"%>
  	</header>
  <!-- Tratamiento de alertas -->
	<c:if test="${alert.texto!=null}">
		<div class="alert ${alert.tipo} alert-dismissible show" role="alert">
			<p>${alert.texto}</p>
		 	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 		<span aria-hidden="true">&times;</span>
		 	</button>
		</div>		
	</c:if>
  
   <div class="container"> 
   	<h1><i class="fas fa-archive"></i> Registrar Persona</h1>
    
	   <form novalidate action ="home?op=2" method="post">
		   <div class="col align-items-center justify-content-center m-4">
			   	
			   	<div class="form-row">
		    		
		    		<div class="col">
		    			<label class="col-form-label m-2" for="dni">DNI: </label> 
					</div>
					<div class="col">	
						<input class="form-control ml-2 mr-2 justify-content-end col-6" type="text" name="dni" value="${persona.dni}" placeholder="Ejemplo: 12345678A" min-length="9" max-length="9" required>
					</div>
		       </div>
		       
		       <div class="form-row">
		    		
		    		<div class="col">
		    			<label class="m-2" for="titulo">Nombre: </label>
					</div>
					<div class="col">	
							<input class=" form-control input-sm ml-2 mr-2 justify-content-end" type="text" name="nombre" placeholder="min 2 max 50" value="${persona.nombre}" autofocus required>
					</div>
		       </div>
		       
		       <div class="form-row">
		    		
		    		<div class="col">
							<label class="" for="isbnUpdate">Primer Apellido: </label>
					</div>
					<div class="col">	
							<input class="form-control input-sm ml-2 mr-2" type="text" name="apellido1" placeholder="min 2 max 50 caracteres" value="${persona.apellido1}" maxlength="45" required>
					</div>
					
		       </div>
		       
		       <div class="form-row">
		    		
		    		<div class="col">
							<label class="" for="isbnUpdate">Segundo Apellido: </label>
					</div>
					<div class="col">	
							<input class="form-control input-sm ml-2 mr-2" type="text" name="apellido2" placeholder="min 2 max 50 caracteres" value="${persona.apellido2}" maxlength="45" required>
					</div>
					
		       </div>
		       
		       <div class="form-row">
		    		
		    		<div class="col">
						<input class="form-control input-sm ml-2 mr-2" readonly="readonly" type="hidden" name="id" value="${(persona.id<=0)?'':persona.id}" min-length="2" max-length="45" required>					
					</div>
					
			   </div>
			   
			   <div class="form-row row ">
		    		
		    		<div class="col">
							<label class="col-form-label ml-2" for="email">Correo electrónico: </label> 
					</div>
					<div class="col">	
							<input class="form-control ml-2" type="email" name="email" placeholder="Ejemplo: admin@admin.com" value="${persona.email}" max-length="50">
					</div>
					
		       </div>
			   
		       </div>		       
			
			 <div class="row justify-content-center">
			 	<button type="submit" class="btn btn-primary ">Submit</button>
			 </div>
			 
		</form>
    </div>
    </main> 
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
   </div> <!-- ./contenedor -->
  

</body>
</html>