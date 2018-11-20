package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.conecction.ConnectionManager;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.mysql.jdbc.Statement;

public class RolDAO implements CrudAble<Rol> {

	private static RolDAO INSTANCE = null;
	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT  id, nombre FROM rol WHERE id = ?;";
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

	@Override
	public boolean insert(Rol rol) throws Exception {
		boolean result = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, rol.getNombre().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						rol.setId(rs.getLong(1));
						result = true;
					}
				}

			}

		}

		return result;
	}

	@Override
	public Rol getById(long id) throws Exception {
		Rol rol = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					rol = rowMapper(rs, rol);
				}
			}

		}
		return rol;
	}

	@Override
	public boolean update(Rol rol) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, rol.getNombre());
			ps.setLong(2, rol.getId());

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	private Rol rowMapper(ResultSet rs, Rol rol) throws Exception {
		if (rol == null) {
			rol = new Rol();
		}

		if (rs != null) {

			rol.setId(rs.getLong("id"));
			rol.setNombre(rs.getString("nombre"));

		}

		return rol;
	}

}
