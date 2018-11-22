package com.ipartek.formacion.repaso.conection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionManager {
	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static Connection conn;

	public static Connection getConnection() {

		try {
			conn = null;

			// cargar properties
			Properties prop = new Properties();

			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("bbdd.properties");
			prop.load(input);
			LOG.debug("Cargado fichero properties");

			// comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("bbdd.driver")).newInstance();
			LOG.debug("Existe driver mySQL");

			// crear conexion
			conn = DriverManager.getConnection(prop.getProperty("bbdd.url"), prop.getProperty("bbdd.user"),
					prop.getProperty("bbdd.password"));
			LOG.debug("Conexión establecida con la base de datos");

		} catch (Exception e) {
			LOG.fatal("Error estableciendo la conexión con base de datos", e);
		}

		return conn;

	}

}