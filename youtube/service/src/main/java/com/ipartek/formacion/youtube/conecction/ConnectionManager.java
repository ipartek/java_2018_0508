package com.ipartek.formacion.youtube.conecction;

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

		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("bbdd.properties");
		prop.load(input);

		// comprobar que exista .jar para mysql
		Class.forName(prop.getProperty("bbdd.driver")).newInstance();

		// crear conexion
		conn = DriverManager.getConnection(prop.getProperty("bbdd.url"), prop.getProperty("bbdd.user"),
				prop.getProperty("bbdd.password"));

		return conn;

	}

}