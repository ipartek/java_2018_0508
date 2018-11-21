# Proyecto encargado del acceso a datos, capa Servicio.

## Instalación de la base de datos:

	-Abrir el archivo **youtube.sql** de la carpeta raíz con un gestor de BBDD.
	
	
## Esquema de la base de datos
![Esquema de la BBDD](https://github.com/ipartek/java_2018_0508/blob/asierCornejo/youtube/service/Esquema.JPG)

## Configuración de la Base de datos
	-El archivo que de configuración es el src/main/resources/**bbdd.properties** en caso de querer cambiarla.
	-La clase **ConnectionManagerTest** realiza un test con Junit para comprobar que la conexión a la BBDD es correcta.
	-Para realizar la conexión a la BBDD se utiliza la clase **DriverManager** en lugar de un pool de conexiones..