package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;

public class RolDAO implements CrudAble<Rol> {

	private static RolDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE rol SET nombre= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM rol WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";

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

			ps.setString(1, pojo.getNombre().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
					}
				}
			} // affectedRows == 1

		}
		return resul;
	}

	@Override
	public List<Rol> getAll() throws Exception {
		Rol rol = null;

		ArrayList<Rol> roles = new ArrayList<Rol>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				roles.add(rowMapper(rs, rol));
			}

		}
		return roles;
	}

	@Override
	public Rol getById(long id) throws Exception {
		Rol rol = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					rol = rowMapper(rs, rol);
				}
			}

		}
		return rol;
	}

	@Override
	public boolean update(Rol pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setLong(2, pojo.getId());
			if (ps.executeUpdate() == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {
			ps.setLong(1, id);
			if (ps.executeUpdate() == 1) {
				resul = true;
			}
		}
		return resul;
	}

	private Rol rowMapper(ResultSet rs, Rol r) throws Exception {
		if (r == null) {
			r = new Rol();
		}
		if (rs != null) {
			r.setNombre(rs.getString("nombre"));
			r.setId(rs.getLong("id"));
		}
		return r;
	}


}