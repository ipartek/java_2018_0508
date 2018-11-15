package com.ipartek.formacion.prestamos_libros.model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {

	private static Connection conn;

	public static Connection getConnection() {

		conn = null;

		try {

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");

			if (ds == null) {
				throw new Exception("Data source no encontrado!");
			}
			conn = ds.getConnection();

			
			/*
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prestamos_libros?user=root&password=root&useSSL=false");
			*/

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}