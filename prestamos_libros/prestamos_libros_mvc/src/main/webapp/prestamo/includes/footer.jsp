<%@include file="taglibs.jsp"%>
		<!-- Footer -->
		<footer class="py-3 bg-light mt-2">
			<div class="row justify-content-center">
				<div class="col col-lg-10">
					<nav id="footer" class="navbar navbar-expand-lg navbar-light bg-light">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav  justify-content-center">
								<li class="nav-item">
									<a class="nav-link" href="#"><span class="sr-only"></span><strong> © IPARTEK Servicios Informáticos</strong></a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
			<!-- /.container -->
		</footer>
		
		<script>
        	function confirmar(e){
        		if(confirm('¿Estás seguro de que quieres eliminar?')){
        			console.log('Pulsado eliminar');
        		}else{
        			//Prevenir el evento por defecto del enlace
        			e.preventDefault();
        		}
        	}
        </script>
        
        <script>
	    	function showModalEditar(idLibro, idAlumno, fechaInicio){
// 	    		console.log('showModalEditar idLibro='+idLibro+' idAlumno='+idAlumno+' fechaInicio='+fechaInicio);
	    		$('#modalEditar').modal('show');
	    		var btn = document.getElementById('libro');
	    		btn.value = idLibro;
	    		var btn2 = document.getElementById('alumno');
	    		btn2.value = idAlumno;
	    		var btn3 = document.getElementById('fechaInicio');
	    		btn3.value = fechaInicio;
	    		
	    		//Poner fecha actual en devolución
	    		var fecha = new Date(); //Fecha actual
	        	  var mes = fecha.getMonth()+1; //obteniendo mes
	        	  var dia = fecha.getDate(); //obteniendo dia
	        	  var ano = fecha.getFullYear(); //obteniendo año
	        	  if(dia<10)
	        	    dia='0'+dia; //agrega cero si el menor de 10
	        	  if(mes<10)
	        	    mes='0'+mes //agrega cero si el menor de 10
				document.getElementById('fechaRetorno').value=ano+"-"+mes+"-"+dia;

					
	        	 
	    	}
	    	
        </script>
	
	</body>

</html>