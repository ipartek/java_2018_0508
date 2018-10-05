package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Rol;

public class RolDAO implements CrudAble<Rol> {
	private static RolDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE `youtube`.`rol` SET `nombre` = ? WHERE `id` = ?;";
	private static final String SQL_DELETE = "DELETE FROM `youtube`.`rol` WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO `rol` (`nombre`) VALUES (?);";

	public RolDAO() {
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

				// use youtube;
				// select MAX(id) as id from usuario;
				// conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;

					}
				}
			}

		}

		return resul;
	}

	@Override
	public List<Rol> getAll() throws Exception {

		ArrayList<Rol> roles = new ArrayList<Rol>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				roles.add(rowMapper(rs, null));
			}

		}

		return roles;
	}

	@Override
	public Rol getById(String id) throws Exception {

		Rol rol = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);

		) {

			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					rol = rowMapper(rs, rol);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	public boolean delete(String id) throws Exception {

		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Rol rowMapper(ResultSet rs, Object object) throws SQLException {
		Rol rol = new Rol();
		if (rs != null) {
			rol.setId(rs.getLong("id"));
			rol.setNombre(rs.getString("nombre"));
		}

		return rol;
	}

}
