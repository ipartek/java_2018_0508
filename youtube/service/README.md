# Service: proyecto encargado del acceso a datos, capa Servicio.

Proyecto JAR para conectar con la base de datos, encargado de dar servicio al resto de aplicaciones.
Usamos **DriverManager** en vez de Pool de conexiones del servidor.

## Modelo Base de datos

![Alt text](https://github.com/ipartek/java_2018_0508/blob/ainaraGoitia/youtube/service/screenshot-bbdd.PNG)

##Instalación 
Para poder importar la base de datos usada en este proyecto se adjunta el archivo **youtube.sql**
## Configuración conexión de la base de datos.
Para poder cambiar la conexión a la BBDD, mirar fichero:
	src\main\resources\ **database.properties**


