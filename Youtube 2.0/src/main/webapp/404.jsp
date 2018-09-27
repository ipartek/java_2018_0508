<%@ include file="include/header.jsp"%>

<div class="404 container align-center bg-warning">
    <div class="row">
        <div class="col-md-12 color-primary">
            <div class="error-template">
                <h1>404 No Encontrado</h1>
                <h2>Ooops!</h2>
                
                <div class="error-details">
                   <p>Lo sentimos, ha ocurrido un error inesperado. 
                   La página <%=request.getAttribute("javax.servlet.forward.request_uri") %> no está disponible.</p>
                </div>
                
                <div class="error-actions">
                    <a href="inicio" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>Inicio </a>
                    <a href="mailto:example@email.com" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contáctanos </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp"%>