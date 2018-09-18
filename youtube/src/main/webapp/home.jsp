<!-- Include the header -->
<%@ include file="include/header.jsp"%>

<!-- Include the navbar -->
<%@ include file="include/navbar.jsp"%>
    
<!-- Page Content -->
<div class="container">
    
	<!-- Include the alert -->
	<%@ include file="include/alert.jsp"%>
    
    <div class="row">

        <div class="col-lg-3">        	
        	<h4 class="my-4">Lista Reproduccion</h4>
          	<ul class="list-group">
          	<%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          		if ( videos == null ){
          			videos = new ArrayList<Video>();
          		}
          		
          		Video videoInicio = (Video)request.getAttribute("videoInicio");
          		if ( videoInicio == null){
          			videoInicio = new Video();
          		}
    			
          		for( Video v : videos ){
          	%>
	        	<li class="list-group-item d-flex justify-content-between align-items-center">     
	          		<a href="inicio?id=<%=v.getId()%>"><%=v.getNombre()%></a>
	          		<a href="inicio?id=<%=v.getId()%>&op=<%=HomeController.OP_ELIMINAR%>"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
	            </li>
            <%
          		} //end for
            %>
            </ul>  
            
            <hr>   
            
            <h4 class="my-4">Videos Reproducidos</h4>
	        	<ul class="list-group">
	          	<%
	          		ArrayList<Video> reproducidos = (ArrayList<Video>) session.getAttribute("reproducidos");
	          		if ( reproducidos != null ){
		          		for( Video r : reproducidos ){
		        %>
			   		<li class="list-group-item d-flex justify-content-between align-items-center">     
			        	<a href="?id=<%=r.getId()%>"><%=r.getNombre()%></a>	          	  	
			       	</li>
		       	<%
	          			} //End FOR
	          		}else{
	          	%>
	          		<li class="list-group-item d-flex justify-content-between align-items-center">
	          			<p>Por favor, accede para guardar tus reproducciones.</p>
	          		</li>
	          	<%		
	          		}
	            %>
	            </ul>     
        	</div>        
        	<!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          
            <iframe id="iframe" width="820" height="415" src="https://www.youtube.com/embed/<%=videoInicio.getId()%>?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 class="card-title"><%=videoInicio.getNombre()%></h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->
          <div class="card card-info">
                <div class="card-block">
                    <textarea placeholder="Escribe aquí tu comentario..." class="pb-cmnt-textarea"></textarea>
                    <form class="form-inline"> 
                        <button class="btn" type="button"><span class="fas fa-file-upload"></span></button>
                        <button class="btn btn-primary ml-auto" type="button">Comparte!</button>
                    </form>
                	</div>
            	</div>
        		</div>
    		</div>
        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->
  

       
    
    <!-- Include the footer -->
    <%@ include file="include/footer.jsp"%>
    
   
