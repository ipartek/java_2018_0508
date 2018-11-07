package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Editorial;

public class EditorialDAO implements Crudable<Editorial> {
	private static EditorialDAO INSTANCE = null;

	private EditorialDAO() {
		super();
	}

	public static synchronized EditorialDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EditorialDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Editorial pojo) throws Exception {
		boolean resul = false;
//		Editorial editorial = new Editorial();
		String sql = "{call `editorialInsert`(?,?)}";
//		int id = 0;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setString(1, pojo.getNombre().trim());
			cs.registerOutParameter("pid", Types.INTEGER);

			int affectedRows = cs.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}
//			id = cs.getInt("pid");
//			editorial.setId(id);

		} 
		return resul;
	}

	@Override
	public List<Editorial> getAll() throws Exception {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		String sql = "{call `editorialgetAll` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Editorial e = new Editorial();
				e.setId(rs.getLong("id"));
				e.setNombre(rs.getString("nombre"));
				editoriales.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return editoriales;
	}

	@Override
	public Editorial getById(String id) throws Exception {

		Editorial editorial = new Editorial();
		String sql = "{call `editorialgetById` (?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, Long.parseLong(id));

			try (ResultSet rs = cs.executeQuery();) {

				while (rs.next()) {
					editorial.setId(rs.getLong("id"));
					editorial.setNombre(rs.getString("nombre"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editorial;
	}

	@Override
	public boolean update(Editorial pojo) throws Exception {

		boolean resul = false;
//		Editorial editorial = new Editorial();
		String sql = "{call `editorialUpdate`(?,?)}";
//		int id = 0;
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
//		Editorial editorial = new Editorial();
		String sql = "{call `editorialDelete`(?)}";
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
