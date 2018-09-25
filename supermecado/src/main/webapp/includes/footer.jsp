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