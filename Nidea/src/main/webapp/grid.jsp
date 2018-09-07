<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>NIDEA</title>
        
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles.css">
        
    </head>

    <body>
            <%@include file="includes/navbar.jsp"%>
<div class="container">
	    
    <!-- Header -->
    <div class="row">
        <div class="col-12">
            <header>
                <h1>NIDEA</h1>
                <h5>12 columnas</h5>
            </header>
        </div>
    </div>
    <!-- /Header -->
    
    <!-- Main -->
    <div class="main row">
        <div class="col-sm-12 col-md-8 col-xl-6">
            <section>
            <!-- No es necesario englobar los titulos en div para que funcione Bootstrap -->
            <div class="d-none d-xl-block"><h5>6 Columnas</h5></div>
            <div class="d-none d-md-block d-xl-none"><h5>8 Columnas</h5></div>
            <div class="d-block d-md-none"><h5>12 Columnas</h5></div>
                <p>
                Extra small &lt; 576px <br>
                Small ≥ 576px <br>
                Medium ≥ 768px <br>
                Large ≥ 992px <br>
                Extra large ≥ 1200px
                </p>
            </section>
        </div>
        <div class="col-sm-12 col-md-4 col-xl-6">
            <aside>
            <!-- En el mismo h5 se puede -->
                <h5 class="d-none d-xl-block">6 Columnas</h5>
                  <h5 class="d-none d-md-block d-xl-none">4 Columnas</h5>
                  <h5 class="d-block d-md-none">12 Columnas</h5>
            </aside>
        </div>
    </div>
    <!-- /Main -->
    
    <!-- Destacados -->
    <div class="destacados row justify-content-center">
        <div class="col-3">
            <section>
                <h5>3 Columnas</h5>
            </section>
        </div>
        <div class="col-3 offset-xl-1">
            <section>
                <h5>3 Columnas</h5>
            </section>
        </div>
        <div class="col-3 offset-xl-1">
            <section>
                <h5>3 Columnas</h5>
            </section>
        </div>
    </div>
    <!-- /Destacados -->
    
     <!-- Footer -->
     <div class="row">
         <div class="col">
            <footer>
                <h5>12 Columnas</h5>
            </footer>
        </div>
    </div>
     <!-- /Footer -->
    
    </div>


    <!-- Place at the end of the page to load it faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        
</body>
</html>

<!-- Offset en main 4cols
copiar breakpoints x
extra large al ser grande van a ser 6 y 6 x
de md hacia arriba 8 y 4 x
small cambia a 12 x
que aparezcan el numero de columnas en funcion del tamaÃ±os x
cambiar algun color de los textos -->