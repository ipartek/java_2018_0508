package com.ipartek.formacion.repaso.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectionManager {

	private static Connection conn;
	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	
	public static Connection getConnection() {

		conn = null;
		
		try {
			//cargar properties
			Properties prop = new Properties();
			
			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
			prop.load(input);
			LOG.debug("Cargado ficehero properties");
			
			//comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("Existe driver mysql");

			//crear conexion
			conn = DriverManager.getConnection(
								prop.getProperty("ddbb.url"), 
								prop.getProperty("ddbb.user"),
								prop.getProperty("ddbb.pass"));
			LOG.debug("Conexión establecida");
		
		} catch (Exception e) {
			LOG.fatal("Error estableciendo conexión a base de datos", e);
		}		

		return conn;

	}

}