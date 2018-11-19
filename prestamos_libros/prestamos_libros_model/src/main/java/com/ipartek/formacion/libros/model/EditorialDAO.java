package com.ipartek.formacion.libros.model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;



import com.ipartek.formacion.libros.pojo.Editorial;

import com.ipartek.formacion.libros.model.CrudAble;


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

	// GETTERS //
	// ---------------------------------------------------------//
	@Override
	public List<Editorial> getAll() throws Exception {
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL editorialGetAll}");) {
			
			try (ResultSet rs = sp.executeQuery();) {
				
				while (rs.next()) {
					
					editoriales.add(rowMapper(rs));
				}
			}
		}

		return editoriales;
	}

	@Override
	public Editorial getById(long id) throws Exception {
		
		Editorial e = null;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall(" CALL editorialGetById(?)");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					
					e = rowMapper(rs);

				}
			}
		}
		return e;
	}

	// SETTERS //
	// ---------------------------------------------------//
	@Override
	public boolean insert(Editorial pojo) throws Exception {
		
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall(" CALL editorialInsert(?, ?)");) {

			// Se cargan los parametros de entrada
			sp.setString("p_nombre", pojo.getNombre());
			
			// Se recogen los parametros de salida
			sp.registerOutParameter("o_id", Types.INTEGER);
			
			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			
			int id = sp.getInt("o_id");
			pojo.setId(id);
			
			if (resultado == 1) {
				
				resul = true;
			
			} 
		}
		return resul;
	}

	@Override
	public boolean update(Editorial pojo) throws Exception {
		
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("CALL editorialUpdate(?, ?)");) {

			// Se cargan los parametros de entrada
			sp.setString("p_nombre", pojo.getNombre());
			sp.setLong("p_id", pojo.getId());

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			
			if (resultado == 1) {
				
				resul = true;

			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall(" CALL editorialDelete(?)");) {

			// Se cargan los parametros de entrada
			sp.setString("p_id", id);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();
			
			if (resultado == 1) {
				
				resul = true;

			}
		}
		return resul;
	}

	private Editorial rowMapper(ResultSet rs) throws SQLException {
		Editorial e = new Editorial();
		
		e.setId(rs.getLong("ideditorial"));
		e.setNombre(rs.getString("nombre"));
		
		return e;
	}

}
