
<%@ page isErrorPage="true" %>  

<p>Si marcamos la JSP como pagina de error, podemos acceder a la variable implicita <b>exception</b> </p>

500
<br>
CAUSA <%=exception.getCause()%><br>
MENSAJE <%=exception.getMessage()%><br>
TOSTRING <%=exception.toString()%><br>


<textarea cols="100" rows="20">
	<%
		//pinta por pantalla la traza de la excepcion
		exception.printStackTrace(new java.io.PrintWriter(out));
	%>
</textarea>

<!--  
<!DOCTYPE html>
<html lang=es>
     <head>
		
		<link rel="stylesheet" href="css/stylesError.css" >
    </head>
    <body>
        <div class=container>
            <h2><span>500</span><br/>Error Interno del Servidor</h2>
            <p>¡Vaya! Algo salió mal.<br /><br />Por favor prueba con la  siguiente pagina o no dudes en contactar con nosotros si el problema persiste.</p>
            <a href="inicio"><button>Ir a la pagina</button></a>
 
        </div>
    </body>
</html>
-->