package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Editorial;

public class EditorialDAO implements CrudAble<Editorial> {

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
		String sql = "{CALL editorialInsert(?,?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, pojo.getNombre());
			
			cs.registerOutParameter(2, Types.INTEGER);
			
			int affectedRows = cs.executeUpdate();
			
			if (affectedRows == 1) {
				pojo.setId(cs.getInt(2));
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public List<Editorial> getAll() throws Exception {

		ArrayList<Editorial> editorial = new ArrayList<Editorial>();
		String sql = "{CALL editorialGetAll}";

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
	public Editorial getById(long id) throws Exception {
		Editorial resul = null;
		String sql = "{CALL editorialGetById(?)}";
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
	public boolean update(Editorial pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL editorialUpdate(?,?)}";
		try (Connection con = ConnectionManager.getConnection(); 
				CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, pojo.getId());
			cs.setString(2, pojo.getNombre());
			
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
		String sql = "{CALL editorialDelete(?)}";
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

	private Editorial rowMapper(ResultSet rs) throws Exception {
		Editorial editorial = new Editorial();
		if (rs != null) {
			editorial.setId(rs.getLong("id"));
			editorial.setNombre(rs.getString("nombre"));
		}
		return editorial;
	}

}
