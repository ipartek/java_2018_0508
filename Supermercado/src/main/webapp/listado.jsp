<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado</title>
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <div class="contenedor">

        <%@include file="includes/navbar.jsp"%>

        <main class="container" role="main">
	
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Descuento</th>
                        <th>Precio / Litro</th>
                        <th>Descripción</th>
                        <th>Imagen (URL)</th>
                    </tr>
                </thead>

                <tbody>
                    
                    <tr>
                        <td>Beefeater</td>
                        <td>12.95&euro;</td>
                        <td>25</td>
                        <td>20&#37;</td>
                        <td>18.50&euro; / L</td>
                        <td>BEEFEATER ginebra inglesa botella 70cl.</td>
                        <td><img src="images/beefeater.jpg" alt="imagen-ginebra-beefeater" /></td>
                    </tr>
                        
                    <tr>
                        <td>Don Simón</td>
                        <td>1.75&euro;</td>
                        <td>176</td>
                        <td>5&#37;</td>
                        <td>2.15&euro; / L</td>
                        <td>Vino tinto 12 % vol alcohol. Clarificado y estabilizado. Franco y limpio. Microbiológicamente estable.</td>
                        <td><img src="images/donsimon.jpg" alt="imagen-vino-don-simon" /></td>
                    </tr>
                        
                    <tr>
                        <td>Absolut Vodka</td>
                        <td>15.75&euro;</td>
                        <td>17</td>
                        <td>0&#37;</td>
                        <td>19.95&euro; / L</td>
                        <td>Absolut Vodka es la marca líder de vodka Premium, con el auténtico sabor del vodka original o tus sabores favoritos elaborados con ingredientes naturales.</td>
                        <td><img src="images/absolut-vodka.png" alt="imagen-absolute-vodka" /></td>
                    </tr>
                        
                    <tr>
                        <td>Johnnie Walker (Blue Label)</td>
                        <td>22.95&euro;</td>
                        <td>34</td>
                        <td>33&#37;</td>
                        <td>27.50&euro; / L</td>
                        <td>Johnnie Walker​ es una marca de whisky escocés producida por Diageo en Kilmarnock, Escocia.</td>
                        <td><img src="images/johnnie-walker-blue-label.jpg" alt="imagen-whisky-johnny-walker" /></td>
                    </tr>
                        
                    <tr>
                        <td>Santa Teresa</td>
                        <td>17.95&euro;</td>
                        <td>76</td>
                        <td>0&#37;</td>
                        <td>20.50&euro; / L</td>
                        <td>Con una mezcla de rones Premium y hasta cinco años en barriles y barricas de roble, Santa Teresa Gran Reserva es la joya de la corona de los rones.</td>
                        <td><img src="images/santateresa.jpg" alt="imagen-ron-santa-teresa" /></td>
                    </tr>
                        
                    <tr>
                        <td>Paulaner</td>
                        <td>2.95&euro;</td>
                        <td>92</td>
                        <td>10&#37;</td>
                        <td>5.35&euro; / L</td>
                        <td>Como marca líder de cerveza de trigo, la Cervecería Paulaner asume responsabilidad y aboga por un consumo responsable de bebidas alcohólicas.</td>
                        <td><img src="images/paulaner.jpg" alt="imagen-cerveza-paulaner" /></td>
                    </tr>
                        
                </tbody>

            </table>
            
        </main>

        <footer id="listado-footer">

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

    </div> <!-- /.contenedor -->

    <!-- Scripts para plugin datatable -->

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
    <script>
            
        $(document).ready(function() {
            $('#listado-productos').DataTable( {
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
                }
            } );
        } );
    
    </script>
    
</body>
</html>