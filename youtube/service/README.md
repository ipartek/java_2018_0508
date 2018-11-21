# Proyecto encargado del acceso a datos, capa Servicio

Proyecto JAR para conectar con la base de datos, encargado de dar servicio al resto de aplicaciones. Usamos **DriverManager** en vez de Pool de conexiones del servidor.

## Modelo Base Datos

![alt modelo base datos](https://github.com/ipartek/java_2018_0508/blob/master/youtube/service/modelo_base_datos.png)

## Configuración Base Datos

Para poder cambiar la configuracion de la BBDD, mirar fichero:
	src\main\resources\ **database.properties**
	
## Instalación
Para poder importar la base de datos con sus tablas e información, mirar script **youtube.sql**