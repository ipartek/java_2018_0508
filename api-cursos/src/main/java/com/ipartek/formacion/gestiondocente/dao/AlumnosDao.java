package com.ipartek.formacion.gestiondocente.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.gestiondocente.conection.ConnectionManager;
import com.ipartek.formacion.gestiondocente.pojo.Alumno;



public class AlumnosDao  {
	private static AlumnosDao INSTANCE = null;
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	
	private final String SQL_SELECT_BY_ID = "SELECT codigo ,nombre FROM alumno WHERE codigo = ?;";
	
	



	private AlumnosDao() {

		alumnos = new ArrayList<Alumno>();
	}

	public static synchronized AlumnosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnosDao();
		}
		return INSTANCE;
	}

	
	

	
	public Alumno getById(long id) throws Exception{
		Alumno a = new Alumno();
		PreparedStatement ps = null;
		try (Connection conexion = ConnectionManager.getConnection();) {
			int index = 1;
			ps = conexion.prepareStatement(SQL_SELECT_BY_ID);
			ps.setLong(index, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setCodigo(rs.getInt("codigo"));
				a.setNombre(rs.getString("nombre"));
			}
				
		}
			return a;
		}

	
	

	

		
}
