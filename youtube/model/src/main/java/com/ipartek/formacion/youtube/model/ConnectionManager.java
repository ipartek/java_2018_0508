package com.ipartek.formacion.youtube.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.jboss.logging.Logger;

public class ConnectionManager {

	private static Connection conn;
	
	private static final Logger LOG = Logger.getLogger(ConnectionManager.class);

	public static Connection getConnection() throws Exception {

		conn = null;

		// cargar properties
		Properties prop = new Properties();

		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
		prop.load(input);
		
		LOG.debug("Cargado fichero de propiedades database.properties.");

		// comprobar que exista .jar para mysql
		Class.forName(prop.getProperty("ddbb.driver")).newInstance();

		// crear conexion
		conn = DriverManager.getConnection(prop.getProperty("ddbb.url"), prop.getProperty("ddbb.user"),
				prop.getProperty("ddbb.pass"));
		
		LOG.debug("Conexión establecida.");

		return conn;

	}

}
