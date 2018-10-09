package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Rol;
import com.ipartek.formacion.youtube.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT u.id as `id_usuario`, u.nombre as `nombre_usuario`, password, id_rol , r.nombre as `nombre_rol`" + ""
			+ "FROM youtube.usuario as u, youtube.rol as r "+" "
				+ "WHERE u.id_rol = r.id"+" "
						+ "ORDER BY u.id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT u.id as `id_usuario`, u.nombre as `nombre_usuario`, password, id_rol , r.nombre as `nombre_rol` " + ""
			+ "FROM youtube.usuario as u, youtube.rol as r "
			+ "WHERE  u.id_rol = r.id AND u.id = ?;";
	private static final String SQL_UPDATE = "UPDATE `youtube`.`usuario`" + 
			"SET `nombre` = ?, `password` = ?, `id_rol` = ? " 
			+ "WHERE `id` = ?;";
	private static final String SQL_DELETE = "DELETE FROM `youtube`.`usuario` "
			+ "WHERE id = ?;";
	private static final String SQL_LOGIN = "SELECT u.id as `id_usuario`, u.nombre as `nombre_usuario`, password, id_rol , r.nombre as `nombre_rol` "
			+ "FROM youtube.usuario as u, youtube.rol as r "
			+ "WHERE u.id_rol = r.id AND u.nombre = ? "
			+ "AND password = ?;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`, `password`, `id_rol` ) VALUES (?,?,?);";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	/**
	 * Comprueba que exista el nombre y password del usuario, case sensitive
	 * 
	 * @param pojo usuario a comprobar
	 * @return true si existe en ddbb, false en caso contrario
	 */

	public Usuario login(Usuario pojo) throws Exception {
		Usuario resul = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LOGIN)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());

			try (ResultSet rs = ps.executeQuery()) {

				if (rs != null && rs.next()) {
					resul = rowMapper(rs, pojo);

				}
			}

		}

		return resul;

	}

	@Override
	public boolean insert(Usuario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());
			ps.setLong(3, pojo.getRol().getId());

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
	public List<Usuario> getAll() throws Exception {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				usuarios.add(rowMapper(rs, null));
			}

		}

		return usuarios;
	}

	@Override
	public Usuario getById(String idtem) throws Exception {
		long id = 0;
		if (idtem != null) {
			id = Long.parseLong(idtem);
		}

		Usuario usuario = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);

		) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					usuario = rowMapper(rs, usuario);

				}
			}

		}

		return usuario;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());
			ps.setLong(3, pojo.getRol().getId());
			ps.setLong(4, pojo.getId());

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

		}
		return resul;
	}

	private Usuario rowMapper(ResultSet rs, Usuario u) throws SQLException {

		if (u == null) {
			u = new Usuario();
		}

		if (rs != null) {
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			u.setPassword(rs.getString("password"));
			Rol rol = new Rol();
			rol.setId(rs.getLong("id_rol"));
			rol.setNombre(rs.getString("nombre_rol"));

			u.setRol(rol);
		}
		return u;
	}

}
