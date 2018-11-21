package com.andrea.perez.youtube.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectionManager {

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static Connection conn;

	public static Connection getConnection() throws Exception {

		conn = null;

		//cargar properties
				Properties prop = new Properties();
				
				InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
				prop.load(input);
				
				
				//comprobar que exista .jar para mysql
				Class.forName(prop.getProperty("ddbb.driver")).newInstance();

				//crear conexion
				conn = DriverManager.getConnection(
									prop.getProperty("ddbb.url"), 
									prop.getProperty("ddbb.user"),
									prop.getProperty("ddbb.pass"));		

		return conn;

	}

}