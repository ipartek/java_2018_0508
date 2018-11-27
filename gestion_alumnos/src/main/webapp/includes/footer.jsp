    <!-- Bootstrap core JavaScript -->
    <script
        src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script
        src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Scripts para plugin datatable -->

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
    <script
        src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script>
    $(document).ready( function () {
        $('#myTable').DataTable( {
            "order": [[ 0, "desc" ]],
            "pageLength": 50
        } );;
    } );
    </script>
    
        </body>
        </html>