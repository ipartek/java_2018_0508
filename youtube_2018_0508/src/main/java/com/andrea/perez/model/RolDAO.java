package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.andrea.perez.pojo.Rol;
import com.mysql.jdbc.Statement;

public class RolDAO implements Crudable<Rol> {
	private static RolDAO INSTANCE = null;
	private static final String SQL_GET_ALL = "SELECT id,nombre FROM rol ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT id,nombre FROM rol WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE rol SET nombre= ? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";
	private static final String SQL_DELETE = "DELETE FROM rol WHERE id = ?;";

	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Rol pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {
				
				ps.setString(1, pojo.getNombre().trim());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));// devuelve el valor de la primera columna "id" de la bbdd
							resul = true;
						}
					}

				}
			}
		}
		return resul;
	}

	@Override
	public List<Rol> getAll() throws Exception {
		List<Rol> roles = new ArrayList<Rol>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				roles.add(rowMapper(rs));
			}

		}

		return roles;
	}

	@Override
	public Rol getById(String idtem) throws Exception {
		long id = 0;
		if (idtem != null) {
			id = Long.parseLong(idtem);
		}
		Rol r = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					r = rowMapper(rs);
				}
			}

		}

		return r;
	}

	@Override
	public boolean update(Rol pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			
			ps.setString(1, pojo.getNombre());
			ps.setLong(2, pojo.getId());
			

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, Long.parseLong(id));

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}

		return resul;
	}

	private Rol rowMapper(ResultSet rs) throws Exception {
		Rol r = new Rol();
		if (rs != null) {
			r.setId(rs.getLong("id"));
			r.setNombre(rs.getString("nombre"));
		}
		return r;
	}

}
