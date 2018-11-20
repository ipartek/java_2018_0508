package com.andrea.perez.model;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {

	private static Connection conn;

	public static Connection getConnection() throws Exception {

		conn = null;

		 Class.forName("com.mysql.jdbc.Driver").newInstance();

		return conn;

	}

}