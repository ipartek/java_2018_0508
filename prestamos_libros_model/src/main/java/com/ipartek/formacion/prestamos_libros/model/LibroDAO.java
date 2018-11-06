package com.ipartek.formacion.prestamos_libros.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;


public class LibroDAO implements Crudable<Libro>{
	
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
		int aux = 0;
		String sql = "{call `libroInsert`(?,?,?,?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			if (pojo.getCant() > 1) {
				for (int i = 0; i < pojo.getCant(); i++) {

					cs.setString(1, pojo.getTitulo().trim());
					cs.setString(2, pojo.getIsbn().trim());
					cs.setLong(3, pojo.getEditorial().getId());
					cs.registerOutParameter("pid", Types.INTEGER);

					int affectedRows = cs.executeUpdate();
					if (affectedRows == 1) {

						aux += 1;

						if (aux == pojo.getCant()) {
							resul = true;
						}
					}
				}
			} else {
				cs.setString(1, pojo.getTitulo().trim());
				cs.setString(2, pojo.getIsbn().trim());
				cs.setLong(3, pojo.getEditorial().getId());
				cs.registerOutParameter("pid", Types.INTEGER);

				int affectedRows = cs.executeUpdate();
				if (affectedRows == 1) {
					resul = true;
				}
			}

		}
		return resul;

	}

	@Override
	public List<Libro> getAll() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String sql = "{call `librogetAll` ()}";
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {

			while (rs.next()) {
				Libro l = new Libro();
				l.setId(rs.getLong("id_libro"));
				l.setTitulo(rs.getString("titulo"));
				l.setIsbn(rs.getString("isbn"));

				Editorial e = new Editorial();
				e.setId(rs.getLong("editorial_id"));
				e.setNombre(rs.getString("nombre_editorial"));

				l.setEditorial(e);

				libros.add(l);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
	}

	@Override
	public Libro getById(String id) throws Exception {
		Libro libro = new Libro();
		String sql = "{call `libroGetById` (?)}";

		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, Long.parseLong(id));

			try (ResultSet rs = cs.executeQuery();) {

				while (rs.next()) {
					libro.setId(rs.getLong("libro_id"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setIsbn(rs.getString("isbn"));
					Editorial e = new Editorial();
					e.setId(rs.getLong("editorial_id"));
					e.setNombre(rs.getString("nombre_editorial"));
					libro.setEditorial(e);
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
		// Libro libro = new Libro();
		String sql = "{call libroUpdate(?,?,?,?)}";
		// int id = 0;
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setString(1, pojo.getTitulo().trim());
			cs.setString(2, pojo.getIsbn().trim());
			cs.setLong(3, pojo.getEditorial().getId());
			cs.setLong(4, pojo.getId());

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
		// Libro libro = new Libro();
		String sql = "{call `libroDelete`(?)}";
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
