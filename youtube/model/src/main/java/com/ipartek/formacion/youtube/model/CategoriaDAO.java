package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Categoria;
import com.mysql.jdbc.Statement;

public class CategoriaDAO implements CrudAble<Categoria> {

	private static CategoriaDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT idcategoria, nombre FROM categoria ORDER BY idcategoria ASC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT idcategoria, nombre FROM categoria WHERE idrol = ?;";
	private final String SQL_GET_BY_NAME = "SELECT idcategoria, nombre FROM categoria WHERE nombre = ?;";

	private final String SQL_INSERT = "INSERT INTO categoria (nombre) VALUES (?);";
	private final String SQL_UPDATE = "UPDATE categoria SET nombre = ? WHERE idcategoria = ?;";
	private final String SQL_DELETE = "DELETE FROM categoria WHERE idcategoria = ?;";

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	// ------------ GETTERS ---------------//
	// -----------------------------------//
	@Override
	public List<Categoria> getAll() throws Exception {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				categorias.add(rowMapper(rs)); // Mapear ResultSet
			}
		}

		return categorias;
	}

	@Override
	public Categoria getById(long l) throws Exception {
		Categoria categoria = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, l);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					categoria = rowMapper(rs);
				}

			}
		}

		return categoria;
	}

	public Categoria getByName(String categNombre) throws Exception {
		Categoria categoria = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_NAME);) {

			ps.setString(1, categNombre);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					categoria = rowMapper(rs);
				}

			}
		}
		return categoria;
	}

	// ------------ SETTERS ---------------//
	// -----------------------------------//
	@Override
	public boolean insert(Categoria pojo) throws Exception {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {

				// Conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {

					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						result = true;
					}
				}
			}
		}

		return result;
	}

	@Override
	public boolean update(Categoria pojo) throws Exception {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getNombre());
			ps.setLong(2, pojo.getId());

			if (ps.executeUpdate() == 1) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public boolean delete(long l) throws Exception {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, l);

			if (ps.executeUpdate() == 1) {
				result = true;
			}
		}

		return result;
	}

	// --------- PRIVATE FUNCTIONS --------//
	// -----------------------------------//
	private Categoria rowMapper(ResultSet rs) throws SQLException {

		Categoria categoria = new Categoria();

		if (rs != null) {

			categoria.setId(rs.getLong("idcategoria"));
			categoria.setNombre(rs.getString("nombre"));

		}

		return categoria;
	}

}
