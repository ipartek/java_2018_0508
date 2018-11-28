package com.ipartek.formacion.game.connection;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ConnectionManager {

	private static Connection conn;
	private static final Logger LOG = Logger.getLogger(ConnectionManager.class);

	public static Connection getConnection() {

		conn = null;

		try {

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");

			if (ds == null) {
				throw new Exception("Data source no encontrado!");
			}

			conn = ds.getConnection();
			LOG.debug("Conexión realizada.");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}