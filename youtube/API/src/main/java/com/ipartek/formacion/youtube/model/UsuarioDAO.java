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

	private final String SQL_GET_ALL = "SELECT u.*, r.nombre FROM usuario as u,"
			+ " INNER JOIN rol as r ON u.id_rol = r.idrol" 
			+ " ORDER BY r.idrol DESC LIMIT 1000;";

	private final String SQL_GET_BY_ID = "SELECT u.*, r.nombre FROM usuario as u,"
			+ " INNER JOIN rol as r ON u.id_rol = r.idrol" 
			+ " WHERE u.idusuario = ?;";
	
	private final String SQL_GET_BY_NAME = "SELECT u.*, r.nombre as 'rol_nombre'"
			+ " FROM usuario as u INNER JOIN rol as r ON u.id_rol = r.idrol" 
			+ " WHERE u.alias = ?;";

	private final String SQL_INSERT = "INSERT INTO usuario (nombre, apellido_1, apellido_2, descripcion, imagen, alias, password, email, status, id_rol)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, apellido_1 = ?, , apellido_2 = ?,"
			+ " descripcion = ?, imagen = ?, alias = ?, password = ?, email = ?, status = ?, id_rol = ?"
			+ " WHERE idusuario = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?;";

	private final String SQL_LOGIN = "SELECT u.*, r.nombre as 'rol_nombre'"
			+ " FROM usuario as u INNER JOIN rol as r ON u.id_rol = r.idrol" 
			+ " WHERE u.alias = ? AND u.password = ?;";

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

		ps.setString(1, pojo.getAlias());
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
			
			ps.setLong(3, pojo.getRol().getId()); // FK id_Rol

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
			
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido1(rs.getString("apellido_1"));
			usuario.setApellido2(rs.getString("apellido_2"));
			usuario.setEmail(rs.getString("email"));
			usuario.setImagen(rs.getString("imagen"));
			usuario.setAlias(rs.getString("alias"));
			usuario.setPassword(rs.getString("password"));
			usuario.setDireccion(rs.getString("direccion"));
			usuario.setDescripcion(rs.getString("descripcion"));
			
			usuario.setFecha_alta(rs.getDate("fecha_alta"));
			usuario.setStatus(rs.getInt("status"));

			// Detectamos el Rol
			Rol rol = new Rol();
			rol.setId(rs.getLong("id_rol"));
			rol.setNombre(rs.getString("rol_nombre"));

			usuario.setRol(rol);
		}

		return usuario;
	}

}
