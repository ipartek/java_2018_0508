package com.ipartek.formacion.prestamolibros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;

public class EditorialDAO implements CrudAble<Editorial>{
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
	public boolean insert(Editorial editorial) throws Exception {
		boolean resul = false;
		String sql = "{CALL `editorialInsert`(?, ?)}";
		
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, editorial.getEditorial());
			cs.registerOutParameter("o_id", Types.INTEGER);

			cs.execute();
			
			resul = true;

		} 
		return resul;
	}

	@Override
	public List<Editorial> getAll() throws Exception {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		Editorial editorial = null;
		String sql = "{CALL `editorialGetAll`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					editorial = new Editorial();
					editorial.setEditorial(rs.getString("editorial"));
					editorial.setId(rs.getLong("id"));
					editoriales.add(editorial);

				}
			} 
		} catch (Exception e) {
			e.printStackTrace();

		}

		return editoriales;
	}

	@Override
	public Editorial getById(long id) throws Exception {
		
		Editorial editorial = null;
		String sql = "{CALL `editorialGetById`(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, id);
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					editorial = new Editorial();
					editorial.setEditorial(rs.getString("editorial"));
					editorial.setId(rs.getLong("id"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return editorial;
	}

	@Override
	public boolean update(Editorial editorial) throws Exception {
		boolean resul = false;
		String sql = "{CALL editorialUpdate (?, ?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {


			cs.setLong(1, editorial.getId());
			cs.setString(2, editorial.getEditorial());


			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		
		boolean resul = false;
		String sql = "{CALL editorialDelete (?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, id);
			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

}
