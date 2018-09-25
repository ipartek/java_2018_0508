<%@ include file="../includes/head.jsp" %>
<body>

        <div class="contenedor">

            <header>
        
                <%@ include file="../includes/navbar.jsp" %>
                
            </header>

            <main role="main" class="container">

                <h1><i class="fas fa-archive"></i> Alta de producto</h1>
                <small>Los campos con * son obligatorios</small>
            
                <form method="post" class="form-alta-producto" action="altaProducto">

                    <div class="form-row">
                            
                        <div class="form-group col">
                            <label for="nom" class="required">Nombre del producto:</label>
                            <input type="text" class="form-control" id="nom" name="nombre" minlength="5" maxlength="20" required autofocus placeholder="De 5 a 20 caracteres" />
                        </div>
                    
                        <div class="form-group col">
                            <label for="precio" class="required">Precio del producto:</label>
                            <input type="number" class="form-control" id="precio" name="precio" required min="0" step="0.1" placeholder="0.0&euro;"/>
                        </div>
                               
                    </div> <!-- /.form-row -->
                            
                    <div class="form-row">
                            
                        <div class="form-group col">
                            <label for="cant-descuento">Descuento(&#37;):</label>
                            <input type="number" class="form-control" id="cant-descuento" name="cant-descuento" placeholder="Si no hay descuento, no rellene este campo" />
                        </div>
                                    
                        <div class="form-group col">
                            <label for="litro" class="required">Precio por Litro:</label>
                            <input type="number" class="form-control" id="litro" name="litro" min="0" step="0.1" required placeholder="0.0&euro; / Litro" />
                        </div>
                                   
                    </div> <!-- /.form-row -->
                            
                    <div class="form-group">
                        <label for="desc">Descripción:</label>
                        <textarea id="desc" class="form-control" name="descripcion" placeholder="Informe a sus clientes sobre los detalles del producto" rows="3" /></textarea>
                    </div>

                    <div class="form-group">
                        <label for="img" class="required">Imagen(URL):</label>
                        <input type="text" class="form-control" id="img" name="imagen" required placeholder="http://ejemplo-de-imagen.com" />
                    </div>

                    <button type="submit" class="btn btn-outline-primary btn-block">Dar de alta producto</button>

                </form>
                
            </main>

            <footer>

                <div>
                    <p>&copy; 2018</p>
                </div>
            
                <nav>
                    <a href="#">Politica de privacidad</a>
                    <a href="#">Contacto</a>
                    <a href="#">Localización</a>
                </nav>
            
                <div class="social">
                    <a href="https://es-es.facebook.com/" id="facebook" target="_blank"><i class="fab fa-facebook-square fa-3x"></i></a>
                    <a href="https://twitter.com/?lang=es" id="twitter" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
                </div>
            
            </footer>

        </div> <!-- ./contenedor -->
    
</body>
</html>