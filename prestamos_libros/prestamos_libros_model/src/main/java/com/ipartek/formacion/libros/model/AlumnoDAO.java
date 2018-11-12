package com.ipartek.formacion.libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;

public class AlumnoDAO implements CrudAble<Alumno> {

	private static AlumnoDAO INSTANCE = null;

	private AlumnoDAO() {
		super();
	}

	public static synchronized AlumnoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnoDAO();
		}
		return INSTANCE;
	}

	/* GETTERS */

	@Override
	public List<Alumno> getAll() throws Exception {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoGetAll}");) {

			
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					alumnos.add(rowMapper(rs));
				}
			}
		}

		return alumnos;
	}

	@Override
	public Alumno getById(long id) throws Exception {
		Alumno a = null;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoGetById(?)}");) {

			

			// se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);

				}
			}
		}
		return a;

	}
	
	public List<Alumno> getAllDisponible() throws Exception {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoGetAllDisponible}");) {

			
			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					alumnos.add(rowMapper(rs));
				}
			}
		}
		
		return alumnos;
	}

	/* SETTERS */

	@Override
	public boolean insert(Alumno pojo) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoInsert(?, ?)}");) {

			// Se cargan los parametros de entrada
			sp.setString("p_nombre", pojo.getNombre());

			// parametros de salida
			sp.registerOutParameter("o_id", Types.INTEGER);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			int id = sp.getInt("o_id");
			pojo.setId(id);

			if (resultado == 1) {

				resul = true;

			} else {

				resul = false;
			}
			
		}
		return resul;
	}

	@Override
	public boolean update(Alumno pojo) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoUpdate(?,?)}");) {

			// se cargan los parametros de entrada
			sp.setString("p_nombre", pojo.getNombre());
			sp.setLong("p_id", pojo.getId());

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			if (resultado == 1) {
				resul = true;

			} else {
				resul = false;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL alumnoDelete(?)}");) {

			// se cargan los parametros de entrada

			sp.setInt("p_id", Integer.parseInt(id));

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			if (resultado == 1) {
				
				resul = true;

			} else {
				resul = false;
			}
		}
		return resul;

	}

	private Alumno rowMapper(ResultSet rs) throws SQLException {
		Alumno a = new Alumno();
		a.setId(rs.getLong("idalumno"));
		a.setNombre(rs.getString("nombre"));
		return a;

	}

}
