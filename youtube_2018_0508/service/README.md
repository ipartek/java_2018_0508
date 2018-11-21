# service: Proyecto encargado del acceso a datos.

Proyecto para conectar con la base de datos., encargado de dar servicio al resto de aplicaciones.
Usamos  **DriverManager** en vez de Pool de conexión del servidor.

## Diagrama de la base de datos:
![alt text](https://github.com/ipartek/java_2018_0508/blob/andreaPerez/youtube_2018_0508/service/src/imagen/diagramaYoutube.png)


## Configuracion conexión base de datos:

Para poder cambiar la conexión a la bbd,mirar fichero:
\src\main\resources\database.properties

## Para poder importar la base de datos con sus tablas e información, mirar script **youtube.sql**