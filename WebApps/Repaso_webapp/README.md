# Proyecto WEB Java 3.0 y JSP (Último Repaso)

Proyecto Maven-izado que abarca todas las fases de la creación de una aplicación web con conexión a base de datos, utilizando el patrón de diseño 
Modelo-Vista-Controlador e implementado con tecnologías (Server-side) de Java Web 3.0, JSTL y JSP's.

Se han usado las siguientes tecnologías:

	- Java Servlet's 		-> Para la capa del CONTROLADOR, con gestion de sessiones de usuario.
	- Java Filter's			-> Filtro de Seguridad y para la codificación UTF-8.
	- JSP + JSTL			-> Java Server Pages y JSP Standard Tag Libraries, para la VISTA.
	- JDBC/Connection-J		-> Driver encargado de la comunicación entre PL/SQL y JEE. DriverManager, ConnectionManager, PreparedStatement y 							   CallableStatement.
	- PL/SQL				-> Para la creación y gestión de la BBDD (Parte del Modelo).
	- Validations (javax)	-> Capa del Modelo en el Modelo-Vista-Controlador.
	- Bootstrap 4			-> Maquetación UI (User Interface).

Para la configuración se incluyen:

	- ConnectionManager 	-> Encargada de realizar la conexión con la BBDD.
	
