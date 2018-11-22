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
	
	private final String SQL_SELECT_BY_ID = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password, id_rol as 'id_rol',r.nombre as 'nombre_rol'"+
	"  FROM usuario as u , rol as r"+
	"  WHERE u.id_rol = r.id"+
	"  order by u.id ASC limit 1000;";
	



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
				a = (rowMapper(rs));
			}
				
		}
			return a;
		}

	
	

	private Alumno rowMapper(ResultSet rs) throws Exception {
		Alumno alumno = new Alumno();
		
		return alumno;
	}

		
}
