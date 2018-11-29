package com.formaciion.ipartek.gestor.conection;

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
		try {
			LOG.debug("DENTRO DE CONNECTION MANNAGER");
			// cargar properties
			Properties prop = new Properties();

			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(input);
			LOG.debug("cargado fichero .properties");

			// comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("existe driver mysql");
			// crear conexion
			conn = DriverManager.getConnection(prop.getProperty("ddbb.url"), prop.getProperty("ddbb.user"),
					prop.getProperty("ddbb.pass"));
			LOG.debug("Conexion establecida");
		} catch (Exception e) {
			LOG.error("Fallo en la conexion de la base de datos: " + e);
		}

		return conn;

	}

}