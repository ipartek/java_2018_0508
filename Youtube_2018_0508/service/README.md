# Service: Proyecto encargado del acceso a datos, capa Servicio (Model)

## Montar la Base de Datos

Para realizar la conexión a la Base de Datos, lo primero que tenemos que hacer es coger el archivo [Youtube.sql](https://github.com/ipartek/java_2018_0508/blob/adrianaprado/Youtube_2018_0508/service/Youtube.sql) 
donde se encuentra toda la jerarquia de tablas. Este archivo lo podemos encontrar en la carpeta raiz de Youtube_Service.

Copiamos el contenido del archivo **.sql** y lo pegamos en nuestra base de datos para que cree todas las tablas y sus datos.

El diagrama de la base de datos tiene que quedar de la siguiente forma para que esté correcto:

### Diagrama de entidad-relacion del proyecto web Youtube
![alt text](https://github.com/ipartek/java_2018_0508/blob/adrianaprado/Youtube_2018_0508/service/src/main/images/youtube-diagrama.PNG "Diagrama youtube")

## Conectar el proyecto Youtube con nuestra Base de Datos

Una vez montada la BBDD, debemos realizar varios cambios desde Eclipse para que al ejecutar el proyecto, podamos conectarnos a la BBDD.

Lo primero que se tiene que hacer es actualizar el pom.xml con la dependencia de MySQL:

```xml
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.47</version>
	</dependency>
```

A continuación, creamos un fichero llamado, por ejemplo, **database.properties** donde guardaremos el driver, la url y las credenciales de nuestra BBDD.

Ejemplo:

ddbb.driver=com.mysql.jdbc.Driver
ddbb.url=jdbc:mysql://127.0.0.1:3306/youtube?useSSL=false
ddbb.user=root
ddbb.pass=root

Por último, creamos una nueva clase java **ConnectionManager.java** donde se realiza la conexión a la BBDD, clase a la cual habrá que llamar cada vez que se quiera realizar alguna alta, baja,
modificación o consulta.

```java
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {

	private static Connection conn;

	public static Connection getConnection() throws Exception {

		conn = null;

		// cargar properties
		Properties prop = new Properties();

		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
		prop.load(input);

		// comprobar que exista .jar para mysql
		Class.forName(prop.getProperty("ddbb.driver")).newInstance();

		// crear conexion
		conn = DriverManager.getConnection(prop.getProperty("ddbb.url"), prop.getProperty("ddbb.user"),
				prop.getProperty("ddbb.pass"));

		return conn;
	}

}
```