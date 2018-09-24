package com.ipartek.formacion.youtube.model;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {

	private static Connection con;

	public static Connection getConnection() {

		con = null;

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");

			if (ds == null) {
				throw new Exception("Data source no encontrado!");
			}

			con = ds.getConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;

	}

}
