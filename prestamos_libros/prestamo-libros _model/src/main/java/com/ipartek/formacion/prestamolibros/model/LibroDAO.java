package com.ipartek.formacion.prestamolibros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

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

	@Override
	public boolean insert(Libro pojo) throws Exception {
		boolean resul = false;

		String sql = "{CALL `libroInsert`(?, ?,?,?)}";
		

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, pojo.getTitulo());
			cs.setString(2, pojo.getIsbn());
			cs.setLong(3, pojo.getEditorial().getId());
			cs.registerOutParameter("o_id", Types.INTEGER);

			int affectedRows = cs.executeUpdate();
			
			if(affectedRows == 1) {
				pojo.setId(cs.getInt(4));
				resul = true;
			}
			
		}

		return resul;
	}

	@Override
	public List<Libro> getAll() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		Libro libro = null;
		String sql = "{CALL `libroGetAll`()}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					libro = new Libro();
					libro.setId(rs.getLong("id"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setIsbn(rs.getString("isbn"));

					Editorial editorial = new Editorial();
					editorial.setId(rs.getLong("id_tipo_editorial"));
					editorial.setEditorial(rs.getString("editorial"));

					libro.setEditorial(editorial);

					libros.add(libro);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return libros;
	}

	@Override
	public Libro getById(long id) throws Exception {
		Libro libro = new Libro();
		String sql = "{CALL `libroGetById`(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setLong(1, id);
			
			try (ResultSet rs = cs.executeQuery()) {

				while (rs.next()) {
					libro = new Libro();
					libro.setId(rs.getLong("id"));
					libro.setIsbn(rs.getString("isbn"));
					libro.setTitulo(rs.getString("titulo"));

					Editorial editorial = new Editorial();
					editorial.setId(rs.getLong("id_tipo_editorial"));
					editorial.setEditorial(rs.getString("editorial"));

					libro.setEditorial(editorial);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return libro;
	}

	@Override
	public boolean update(Libro pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL `libroUpdate`(?,?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, pojo.getId());
			cs.setString(2, pojo.getTitulo());
			cs.setString(3, pojo.getIsbn());
			cs.setLong(4, pojo.getEditorial().getId());

			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		boolean resul = false;
		String sql = "{CALL libroDelete (?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, id);
			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}
}
