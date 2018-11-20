package com.ipartek.formacion.model;

import java.sql.Connection;

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

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}