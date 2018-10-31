package com.ipartek.formacion.libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;

public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;

	private LibroDAO() {
		super();
	}

	public static synchronized LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		return INSTANCE;
	}

	/* GETTERS */

	@Override
	public List<Libro> getAll() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL libroGetAll}");) {

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					libros.add(rowMapper(rs));
				}
			}
		} 
		return libros;
	}

	@Override
	public Libro getById(long id) throws Exception {
		Libro l = null;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL libroGetById(?)}");) {

			

			// se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					l = rowMapper(rs);

				}
			}
		}
		return l;
	}
	
	public List<Libro> getAllDisponibles() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL libroGetAllDisponible}");) {

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					libros.add(rowMapper(rs));
				}
			}
		} 

		return libros;
	}
	
	/* SETTERS */

	@Override
	public boolean insert(Libro pojo) throws Exception {
		return false;
	}

	public boolean loopInsertLibro(Libro pojo, int n_ejemplares) throws Exception {
		boolean resul = false;
		for (int i = 0; i < n_ejemplares; i++) {

			try (Connection con = ConnectionManager.getConnection();
					CallableStatement sp = con.prepareCall("{CALL libroInsert(?,?,?,?)}");) {

				

				// se cargan los parametros de entrada
				sp.setString("p_titulo", pojo.getTitulo());
				sp.setString("p_isbn", pojo.getIsbn());
				sp.setLong("p_id_editorial", pojo.getEditorial().getId());

				// parametros de salida
				sp.registerOutParameter("o_id", Types.INTEGER);

				// Se ejecuta el procedimiento almacenado
				int resultado = sp.executeUpdate();

				//int id = sp.getInt("o_id");

				if (resultado == 1) {

					resul = true;

				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Libro pojo) throws Exception {
		boolean resul;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL libroUpdate(?,?,?,?)}");) {

			// se cargan los parametros de entrada
			sp.setLong("p_id", pojo.getId());
			sp.setString("p_titulo", pojo.getTitulo());
			sp.setString("p_isbn", pojo.getIsbn());
			sp.setLong("p_editorial", pojo.getEditorial().getId());

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
				CallableStatement sp = con.prepareCall("{CALL libroDelete(?)}");) {

			// Se cargan los parametros de entrada
			sp.setString("p_id", id);

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

	private Libro rowMapper(ResultSet rs) throws SQLException {

		Libro l = new Libro();
		l.setId(rs.getLong("idlibro"));
		l.setTitulo(rs.getString("titulo"));
		l.setIsbn(rs.getString("isbn"));

		Editorial e = new Editorial();
		e.setId(rs.getInt("id_editorial"));
		//e.setNombre(rs.getString("nombre"));
		
		l.setEditorial(e);

		return l;
	}

}
