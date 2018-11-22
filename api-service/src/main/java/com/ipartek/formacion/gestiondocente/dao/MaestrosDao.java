package com.ipartek.formacion.gestiondocente.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.gestiondocente.conection.ConnectionManager;
import com.ipartek.formacion.gestiondocente.pojo.Alumno;
import com.ipartek.formacion.gestiondocente.pojo.Profesor;


public class MaestrosDao  {
	

	private static MaestrosDao INSTANCE = null;
	ArrayList<Profesor> maestros = new ArrayList<Profesor>();
	
	private final String SQL_SELECT_BY_ID = "SELECT codigo, NSS, nombre, apellidos, fNacimiento, DNI, direccion, poblacion, codigopostal, email, activo \r\n" + 
			"FROM gestiondocente.profesor\r\n" + 
			"where codigo = ?;";
	



	private MaestrosDao() {

		maestros = new ArrayList<Profesor>();
	}

	public static synchronized MaestrosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaestrosDao();
		}
		return INSTANCE;
	}

	
	

	
	public Profesor getById(long id) throws Exception{
		Profesor p = new Profesor();
		PreparedStatement ps = null;
		try (Connection conexion = ConnectionManager.getConnection();) {
			int index = 1;
			ps = conexion.prepareStatement(SQL_SELECT_BY_ID);
			


			System.out.println("Pasando por checkByNamePass UsuariosDaoJDBC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = (rowMapper(rs));
			}
				
		}
			return p;
		}

	
	

	private Profesor rowMapper(ResultSet rs) throws Exception {
		Profesor profesor = new Profesor();
		
		profesor.setCodigo(rs.getInt("codigo"));
		profesor.setNombre(rs.getString("nombre"));
		profesor.setNss(rs.getInt("nombre"));
		profesor.setNombre(rs.getString("nombre"));
		
		
		
		
		return profesor;
	}

		
}
