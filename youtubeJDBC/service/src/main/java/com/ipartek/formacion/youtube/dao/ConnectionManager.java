package com.ipartek.formacion.youtube.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {

	private static Connection conn;

	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		conn = null;

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		return conn;

	}

}