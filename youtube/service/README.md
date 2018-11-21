# Proyecto encargado del acceso a datos, capa Servicio.

## Instalación BBDD
	-Para instalar la base de datos ejecutar el script youtube.sql
	
## Conexión a BBDD
	-Se utiliza un DriverManager para establecer la conexión.
	-La cofiguración se encuentra en el fichero src/main/resources/ **database.properties**.
	-Para comprobar si establece conexión, ejecute el test src/main/java/ **ConnectionManagerTest**.

## Diagrama BBDD
	
![Diagrama base de datos](https://github.com/ipartek/java_2018_0508/blob/adrianGarcia/youtube/service/youtube_diagrama.PNG)