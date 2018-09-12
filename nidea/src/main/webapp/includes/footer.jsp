		

				
		<script src="vendors/jquery/3.3.1/jquery.js"></script>
   		<script src="vendors/datatable/1.10.19/js/jquery.dataTables.min.js"></script>
  		<script src="vendors/datatable/2.2.3/js/responsive.js"></script>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		 crossorigin="anonymous"></script-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		 crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		 crossorigin="anonymous"></script>
		 
		 <!--

		//-->

		 
				 
		<script>
				function validate(){
					console.log("holi!!");
					var pass = document.querySelector("#registro-page form input[name='password']");
					var passrep = document.querySelector("#registro-page form input[name='passwordrep']");
					if(	(pass.value != "") && (passrep.value != "")){
						if(pass.value == passrep.value){
							pass.classList.remove( "error" );
							passrep.classList.remove( "error" );
							
						}else{
							pass.classList.add("error");
							passrep.classList.add("error");
						}
					}else{
						if(pass.textContent == ""){
							pass.classList.remove( "error" );
						}else{
							passrep.classList.remove( "error" );
						}
					}
				
				}
				/* JQUERY
				$(document).ready(function(){
					//Esperamos a que todo el HTML este cargado
					$('#tabla-dashboard').DataTable({
		                "responsive": true,
		                "language": {
		                    "url": "vendors/datatable/1.10.19/languages/spanish.json"
		                }
		            });
					$("#registro-page form input[name='password']").keyup(validate);
					$("#registro-page form input[name='passwordrep']").keyup(validate);
					
				});
				
				function validate(){
					var $pass=$("#registro-page form input[name='password']");
					var $passrep = $("#registro-page form input[name='passwordrep']");
					if(	($pass.val() != "") && ($passrep.val() != "")){
						if($pass.val() == $passrep.val()){
							$pass.removeClass( "error" );
							$passrep.removeClass( "error" );
							
						}else{
							$pass.addClass( "error" );
							$passrep.addClass( "error" );
						}
					}else{
						if($pass.val() == ""){
							$pass.removeClass( "error" );
						}else{
							$passrep.removeClass( "error" );
						}
					}
				}*/
			
		</script>
	</body>

	</html>