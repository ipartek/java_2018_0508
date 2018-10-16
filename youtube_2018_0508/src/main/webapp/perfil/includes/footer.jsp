<%@include file="taglibs.jsp"%>
	<!-- Footer -->
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLDecoder"%>

<footer class="py-5 bg-dark">
		<div class="container">
		<%
				String user ="";
				String fecha = "";
				Cookie[] cookies = request.getCookies();
				for(Cookie c: cookies){
					if(c.getName().equals("cVisita")){
						fecha = URLDecoder.decode(c.getValue(), "UTF-8");
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Cookie cVisita = new Cookie("cVisita", URLEncoder.encode(dateFormat.format(new Date()), "UTF-8"));
					}
				}
				%>
<%-- 			<span class="text-warning mr-5"> Última visita <%=fecha %></span> --%>
			<!-- https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html -->
			<c:set var="now" value="<%= new java.util.Date() %>"/>
			<span class="text-warning">Última visita el </span>
			<span class="text-warning"> <fmt:formatDate type="both" pattern="dd MM yyyy HH:mm" timeStyle="medium" value="${now }"/></span>
			<p class="m-0 text-center text-white">Copyright &copy; Youtube 2018</p>
		</div>
		<!-- /.container -->
	</footer>
<!-- jQuery -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/jquery/jquery.min.js"></script>
		
		 <!-- Bootstrap Core JavaScript -->
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- DataTables JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables/js/jquery.dataTables.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/vendor/datatables-responsive/dataTables.responsive.js"></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src="https://blackrockdigital.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	    <script>
		    $(document).ready(function() {
		        $('#dataTable-ordenable').DataTable({
		        	responsive: true,
		        	"language": {
		        		"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		       		}		            
		        });
		        $('[data-toggle="tooltip"]').tooltip(); 
		    });
		    
		    //funcion para el confirm de eliminar 
		    function confirmar(e){
        		if(confirm('¿Estás seguro de que quieres eliminar?')){
        			console.log('Pulsado eliminar');
        		}else{
        			//Prevenir el evento por defecto del enlace
        			e.preventDefault();
        		}
        	}		    
		    		    
		  //Ocultar y mostrar password
		  function showpass(event,contrasenna){
			  
			  var el=document.getElementById(contrasenna);
			  
			  if(el.type=="password"){				  
				  el.type="text";
				 
			  }else{
				  el.type="password";
			  }
			  
			  
			  if(event.target.classList.contains("fa-eye")){
				  event.target.classList.remove("fa-eye");
				  event.target.classList.add("fa-eye-slash");
			  }else{
				  event.target.classList.remove("fa-eye-slash");
				  event.target.classList.add("fa-eye");
			  }
			  
		  }
		  
		  //Mostrar comentario completo del usuario por aprobar
		  function showModalComentario(idComentario, texto){
				$('#modalVerComentario').modal('show');
				var comentario = document.getElementById('comentarioCompleto');
				comentario.innerHTML = texto;
			}
		  
		  
		  
		 
		    
	    </script>
		
	</body>
</html>