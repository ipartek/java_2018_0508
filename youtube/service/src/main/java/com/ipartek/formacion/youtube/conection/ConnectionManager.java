package com.ipartek.formacion.youtube.conection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;




public class ConnectionManager {

	private static Connection conn;
	private final static Logger LOG = Logger.getLogger(Connection.class);


	public static Connection getConnection() {
		try {
			conn = null;
		
		//cargar properties
		Properties prop = new Properties();
		
		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
		prop.load(input);
		LOG.debug("Cargado fichero properties");
		
		//comprobar que exista .jar para mysql
		Class.forName(prop.getProperty("ddbb.driver")).newInstance();
		LOG.debug("Existe driver MYSQL");
		
		//crear conexion
		conn = DriverManager.getConnection(
							prop.getProperty("ddbb.url"), 
							prop.getProperty("ddbb.user"),
							prop.getProperty("ddbb.pass"));	
		LOG.debug("Conexión establecida");
		
		}catch(Exception e) {
			LOG.fatal(e);
		}
			
		return conn;

	}

}