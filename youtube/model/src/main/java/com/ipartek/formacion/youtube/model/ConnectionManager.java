package com.ipartek.formacion.youtube.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectionManager {

	private static Connection conn;
	
	private static final Logger LOG = Logger.getLogger(ConnectionManager.class);

	public static Connection getConnection() throws Exception {

		conn = null;

		try {
			// Cargar properties de la BBDD
			Properties prop = new Properties();
	
			InputStream input = ConnectionManager.class
					.getClassLoader()
					.getResourceAsStream("database.properties");
			
			prop.load(input);
			
			LOG.debug("Cargado fichero de propiedades database.properties.");
	
			// comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("Encontrado Driver jdbc:mysql");
	
			// crear conexion
			conn = DriverManager.getConnection(
					prop.getProperty("ddbb.url"), 
					prop.getProperty("ddbb.user"),
					prop.getProperty("ddbb.pass"));
			
			LOG.debug("Conexión establecida.");
		
		} catch (Exception e) {
			
			LOG.error("Error fatal. No conexión a la BBDD.");
		}

		return conn;

	}

}
