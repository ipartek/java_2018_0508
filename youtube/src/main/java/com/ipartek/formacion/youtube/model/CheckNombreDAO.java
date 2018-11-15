package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckNombreDAO {

	private static CheckNombreDAO INSTANCE = null;
	
	private final String SQL = "SELECT COUNT(id) FROM usuario WHERE nombre = ?;";
	
	private CheckNombreDAO() {
		super();
	}
	
	public static synchronized CheckNombreDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CheckNombreDAO();
		}
		return INSTANCE;
	}
	
	public boolean comprobarNombre(String nombre) throws SQLException {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL);) {
			
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();
			
			
		}
		
		return resul;
	}
	
	
}
