package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Alumno;

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

	@Override
	public boolean insert(Alumno pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL alumnoInsert(?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, pojo.getNombre());
			cs.setString(2, pojo.getApellidos());
			
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			
			int affectedRows = cs.executeUpdate();
			pojo.setId(cs.getInt(3));
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public List<Alumno> getAll() throws Exception {

		ArrayList<Alumno> editorial = new ArrayList<Alumno>();
		String sql = "{CALL alumnoGetAll}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				editorial.add(rowMapper(rs));
			}

		}
		return editorial;
	}

	@Override
	public Alumno getById(long id) throws Exception {
		Alumno resul = null;
		String sql = "{CALL alumnoGetById(?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, id);

			try (ResultSet rs = cs.executeQuery();) {
				while (rs.next()) {
					resul = rowMapper(rs);
				}

			}

		}
		return resul;
	}

	@Override
	public boolean update(Alumno pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL alumnoUpdate(?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, pojo.getId());
			cs.setString(2, pojo.getNombre());
			cs.setString(3, pojo.getApellidos());
			
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		boolean resul = false;
		String sql = "{CALL alumnoDelete(?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, id);
			
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	private Alumno rowMapper(ResultSet rs) throws Exception {
		Alumno alumno = new Alumno();
		if (rs != null) {
			alumno.setId(rs.getLong("id"));
			alumno.setNombre(rs.getString("nombre"));
			alumno.setApellidos(rs.getString("apellidos"));
		}
		return alumno;
	}

}
