package com.ipartek.formacion.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Libro;

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
		String sql = "{CALL libroInsert(?,?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setString(1, pojo.getIsbn());
			cs.setString(2, pojo.getTitulo());
			cs.setLong(3, pojo.getEditorial().getId());

			cs.registerOutParameter(4, java.sql.Types.INTEGER);

			int affectedRows = cs.executeUpdate();
			pojo.setId(cs.getInt(4));
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public List<Libro> getAll() throws Exception {

		ArrayList<Libro> libro = new ArrayList<Libro>();
		String sql = "{CALL libroGetAll}";

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				libro.add(rowMapper(rs));
			}

		}
		return libro;
	}

	@Override
	public Libro getById(long id) throws Exception {
		Libro resul = null;
		String sql = "{CALL libroGetById(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
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
	public boolean update(Libro pojo) throws Exception {
		boolean resul = false;
		String sql = "{CALL libroUpdate(?,?,?,?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setLong(1, pojo.getId());
			cs.setString(2, pojo.getIsbn());
			cs.setString(3, pojo.getTitulo());
			cs.setLong(4, pojo.getEditorial().getId());
			

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
		String sql = "{CALL libroDelete(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {
			cs.setLong(1, id);

			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	private Libro rowMapper(ResultSet rs) throws Exception {
		Libro libro = new Libro();
		if (rs != null) {
			libro.setId(rs.getLong("id"));
			libro.setIsbn(rs.getString("isbn"));
			libro.setTitulo(rs.getString("titulo"));
			try {
				Editorial e = new Editorial();
				e.setId(rs.getLong("id_editorial"));
				e.setNombre(rs.getString("nombre"));
				libro.setEditorial(e);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return libro;
	}

}
