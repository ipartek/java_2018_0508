package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;

public class EditorialDAO implements CrudAble<Editorial> {

	private static EditorialDAO INSTANCE = null;

	public EditorialDAO() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized EditorialDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EditorialDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Editorial pojo) throws Exception {
		String sql = "{ CALL `editorialesInsert` (?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setString(1, pojo.getNombre());
			cs.registerOutParameter(2, Types.INTEGER);
			
			int affectedRows = cs.executeUpdate(); 
			if( affectedRows ==  1 ) {
				
				pojo.setId(cs.getInt(2));
				return true;
			}
			
		}
		return result;
	}

	@Override
	public List<Editorial> getAll() throws Exception {

		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		String sql = "{ CALL `editorialesGetAll` () }";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// preparar parametros
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					Editorial e = new Editorial();
					e.setId(rs.getLong("id"));
					e.setNombre(rs.getString("nombre"));
					editoriales.add(e);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return editoriales;
	}

	@Override
	public Editorial getById(String id) throws Exception {
		Editorial e = new Editorial();
		String sql = "{ CALL `editorialesGetById`(?) }";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setInt(1, Integer.parseInt(id));
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					e.setId(rs.getLong("id"));
					e.setNombre(rs.getString("nombre"));

				}
			}

		}

		return e;
	}

	@Override
	public boolean update(Editorial pojo) throws Exception {
		String sql = "{ CALL `editorialesUpdate` (?,?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// parseInt para convertir de Long a INT
			cs.setInt(1, new Long(pojo.getId()).intValue());
			cs.setString(2, pojo.getNombre());
			
			int affectedRows = cs.executeUpdate();
			if ( affectedRows == 1 ) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(String id) throws Exception {
		String sql = "{ CALL `editorialesDelete` (?) }";
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			// parseInt para convertir de String a INT
			cs.setInt(1, Integer.parseInt(id));
			if ( cs.executeUpdate() == 1 ) {
				result = true;
			}
		}
		return result;
	}
}
