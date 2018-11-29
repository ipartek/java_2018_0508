<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      
      <a class="navbar-brand" href="#">IPARTEK</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
          </li>
        </ul>
        
        <!--  BUSCADOR  -->
          <input class="form-control mr-sm-2" id = "busqueda" type="text" placeholder="Introduce DNI, Nombre o email." aria-label="Buscador" oninput="search()">
        </form>
      </div>
    </nav>