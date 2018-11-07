package com.ipartek.formacion.prestamolibros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;

public class AlumnoDAO implements CrudAble<Alumno>{
	
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

	@Override
	public boolean insert(Alumno alumno) throws Exception {
		
		boolean resul = false;
		String sql = "{CALL `alumnoInsert`(?, ?, ?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, alumno.getNombre());
			cs.setString(2, alumno.getApellidos());
			cs.registerOutParameter("o_id", Types.INTEGER);

			cs.execute();
			
			resul = true;

		} 
		return resul;
		
	}

	@Override
	public List<Alumno> getAll() throws Exception {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno = null;
		String sql = "{CALL `alumnoGetAll`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					alumno = new Alumno();
					alumno.setId(rs.getLong("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));
					alumnos.add(alumno);

				}
			} 
		} catch (Exception e) {
			e.printStackTrace();

		}

		return alumnos;
	}

	@Override
	public Alumno getById(long id) throws Exception {
		Alumno alumno = null;
		String sql = "{CALL `alumnoGetById`(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					alumno = new Alumno();
					alumno.setId(rs.getLong("id"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return alumno;
	}

	@Override
	public boolean update(Alumno alumno) throws Exception {
		
		boolean resul = false;
		String sql = "{CALL alumnoUpdate (?, ?, ?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, alumno.getId());
			cs.setString(2, alumno.getNombre());
			cs.setString(3, alumno.getApellidos());

			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		
		boolean resul = false;
		String sql = "{CALL alumnoDelete (?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, id);
			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

}
