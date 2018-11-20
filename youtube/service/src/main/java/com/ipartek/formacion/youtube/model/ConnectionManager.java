package com.ipartek.formacion.youtube.model;

import java.sql.Connection;

public class ConnectionManager {

	private static Connection conn;

	public static Connection getConnection() {

		conn = null;

		

		

		return conn;

	}

}