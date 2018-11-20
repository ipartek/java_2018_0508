<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>
</div>
    <!-- /#wrapper -->
	<footer class="navbar navbar-inverse">
      <div class="container">
      
	       <% 
	     	String fecha = "";
	     	Cookie[] cookies = request.getCookies();
	     	for( Cookie c : cookies ){
	     		if ( "cVisita".equals(c.getName())){
	     			//ultima visita
	     			fecha = URLDecoder.decode( c.getValue(), "UTF-8" );
	     			
	     			//guardar visita actual
	     			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");		
	     			Cookie cVisita = new Cookie("cVisita", URLEncoder.encode( dateFormat.format(new Date()),"UTF-8") );
	     			cVisita.setMaxAge(60*60*24*365); //1año
	     			response.addCookie(cVisita);
	     			
	     			break;
	     		}	
	     	}     	
	     %>
	     <span class="text-warning">Ultima visita <%=fecha%></span>
     	
      
      	
      	<c:set var="anyo" value="<%= new java.util.Date()%>" />      	  
        <p class="m-0 text-center text-white">Copyright &copy; 
           Your Website <fmt:formatDate type="both" pattern="yyyy" value="${anyo}" />
           <!-- @see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html -->
        </p>
        
      </div>
      <!-- /.container -->
    </footer>
      <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Datatable js -->
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		    $('#userDataTable').DataTable();
		    /* "order": [[ 3, "desc" ]] */
		    var readURL = function(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	
	            reader.onload = function (e) {
	                $('.avatar').attr('src', e.target.result);
	            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
		} );
		
		function showPass(event,elementId){
			console.log("nos llega :"+ elementId);
			 var el = document.getElementById(elementId);
			if(el.type == 'password'){
				console.log('password');
				el.type ="text";
			}else{
				console.log('texto');
				el.type ="password";
			}
			if(event.target.classList.contains("fa-eye")){
				event.target.classList.remove("fa-eye");
				event.target.classList.add("fa-eye-slash");
			}else{
				event.target.classList.remove("fa-eye-slash");
				event.target.classList.add("fa-eye");
				
				
			}
		}
		function showModal(texto){
			
			console.log(texto);
			document.getElementById('modalBody').innerHTML = texto;

			$('#myModal').modal('show');
			
		}
	</script>
	
</body>

</html>