package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Alumno;

public class AlumnoDAO implements Crudable<Alumno> {
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
	public boolean insert(Alumno pojo) throws Exception {
		boolean resul = false;
		String sql = "{call `alumnoInsert`(?,?)}";
		int id = -1;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setString(1, pojo.getNombre().trim());
			cs.registerOutParameter("pid", Types.INTEGER);

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				id = cs.getInt("pid");
				pojo.setId(id);
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public List<Alumno> getAll() throws Exception {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		String sql = "{call `alumnogetAll` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Alumno a = new Alumno();
				a.setId(rs.getLong("id"));
				a.setNombre(rs.getString("nombre_apellidos"));
				alumnos.add(a);
			}

		}
		return alumnos;
	}

	@Override
	public Alumno getById(String id) throws Exception {

		Alumno alumno = new Alumno();
		String sql = "{call `alumnogetById` (?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, Long.parseLong(id));

			try (ResultSet rs = cs.executeQuery();) {

				while (rs.next()) {
					alumno.setId(rs.getLong("id"));
					alumno.setNombre(rs.getString("nombre_apellidos"));
				}

			}
		}
		return alumno;
	}

	@Override
	public boolean update(Alumno pojo) throws Exception {

		boolean resul = false;

		String sql = "{call `alumnoUpdate`(?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setString(1, pojo.getNombre().trim());
			cs.setLong(2, pojo.getId());

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {

		boolean resul = false;

		String sql = "{call `alumnoDelete`(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, Long.parseLong(id));

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}

		return resul;
	}
}
