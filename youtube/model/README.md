# Lista de Reproducción de Youtube 

## Service

### Descripción

Capa de servicios del proyecto Lista de Reproducción de Youtube que permite crear listas de reproducción personalizadas, así como crear usuarios con diferentes y roles y publicar comentarios.

Esta capa se encarga de gestionar la conexión con los diferentes modelos así como de implementar la lógica mayoritaria de la aplicación.

### Documentos de configuración

Se incluyen los siguientes archivos:

	-	**BBDD_Youtube.sql** -> Script para la creación de la base de datos, incluye datos de prueba.
	-	**Diagrama_BBDDYoutube.png** -> Diagrama de entidad-relación de la base de datos.

Otros archivos a destacar:

	- **src/main/resources/database.properties** -> resources/database.properties. Inlcuye las variables necesarias para realizar la conexión a la BBDD a través de la Clase **ConnectionManager**, que es la encargada de manejar la conexión.
	
### Diagrama de Entidad relación de la Base de Datos
![alt Modelo de la Base de Datos](https://github.com/ipartek/java_2018_0508/blob/luisgaldos/youtube/model/Diagrama_BBDDYoutube.png)