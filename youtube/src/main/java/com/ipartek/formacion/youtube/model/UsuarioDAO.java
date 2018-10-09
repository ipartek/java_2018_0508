package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT u.idUsuario, u.nombre as usuario_nombre, u.password, u.id_rol, "
			+ "r.idRol, r.nombre as rol_nombre " + "FROM usuario as u, rol as r " + "WHERE u.id_rol = r.idRol "
			+ "ORDER BY r.idRol DESC LIMIT 1000;";

	private final String SQL_GET_BY_ID = "SELECT u.idUsuario, u.nombre as 'usuario_nombre', u.password, u.id_rol, r.idRol, r.nombre as 'rol_nombre'"
			+ " FROM usuario as u, rol as r" 
			+ " WHERE u.id_rol = r.idRol AND idUsuario=?;";
	
	private final String SQL_GET_BY_NAME = "SELECT idUsuario, nombre, password, id_rol FROM usuario WHERE nombre = ?;";

	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password, id_rol) VALUES (?, ?, ?);";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ? WHERE idUsuario = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?;";

	private final String SQL_LOGIN = "SELECT u.idUsuario, u.nombre as 'usuario_nombre', u.password, u.id_rol, r.idRol, r.nombre as 'rol_nombre'"
			+ " FROM usuario as u, rol as r" 
			+ " WHERE u.id_rol = r.idRol AND u.nombre=? AND u.password=?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	// ------------ GETTERS ---------------//
	// -----------------------------------//
	@Override
	public List<Usuario> getAll() throws SQLException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				usuarios.add(rowMapper(rs, usuario)); // Mapear ResultSet
			}
		}

		return usuarios;
	}

	@Override
	public Usuario getById(long l) throws SQLException {
		Usuario usuario = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, l);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					usuario = rowMapper(rs, usuario);
				}
			}
		}

		return usuario;
	}

	public Usuario getByName(String usuarioNombre) throws SQLException {
		Usuario usuario = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_NAME);) {

			ps.setString(1, usuarioNombre);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					usuario = rowMapper(rs, usuario);
				}

			}
		}
		return usuario;
	}

	public Usuario login(Usuario pojo) throws SQLException {
		Usuario usuario = null;

		Connection cnx = ConnectionManager.getConnection();
		PreparedStatement ps = cnx.prepareStatement(SQL_LOGIN);

		ps.setString(1, pojo.getNombre());
		ps.setString(2, pojo.getPassword());

		try (ResultSet rs = ps.executeQuery()) {

			if (rs != null && rs.next()) {
				usuario = rowMapper(rs, pojo);
			}

		}

		return usuario;
	}

	// ------------ SETTERS ---------------//
	// -----------------------------------//
	@Override
	public boolean insert(Usuario pojo) throws SQLException {
		boolean result = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());
			ps.setLong(3, pojo.getRol().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				
				
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						result = true;
					}
				}
			}

		}
		return result;
	}

	@Override
	public boolean update(Usuario pojo) throws SQLException {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());
			ps.setLong(3, pojo.getId());

			if (ps.executeUpdate() == 1) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public boolean delete(long l) throws SQLException {
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

	// --------- PRIVATE FUNCITONS --------//
	// -----------------------------------//
	private Usuario rowMapper(ResultSet rs, Usuario usuario) throws SQLException {

		if (usuario == null) {

			usuario = new Usuario();
		}

		if (rs != null) {

			usuario.setId(rs.getLong("idUsuario"));
			usuario.setNombre(rs.getString("usuario_nombre"));
			usuario.setPass(rs.getString("password"));

			// Detectamos el Rol
			Rol rol = new Rol();
			rol.setId(rs.getLong("idRol"));
			rol.setNombre(rs.getString("rol_nombre"));

			usuario.setRol(rol);
		}

		return usuario;
	}

}
