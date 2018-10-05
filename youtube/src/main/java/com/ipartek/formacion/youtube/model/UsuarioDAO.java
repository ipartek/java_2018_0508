package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT idUsuario, nombre, password, id_rol FROM usuario ORDER BY idUsuario DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT idUsuario, nombre, password, id_rol FROM usuario WHERE idUsuario = ?;";
	private final String SQL_GET_BY_NAME = "SELECT idUsuario, nombre, password, id_rol FROM usuario WHERE nombre = ?;";
	
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?, ?);";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ? WHERE idUsuario = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	//------------ GETTERS ---------------//
	//-----------------------------------//
	@Override
	public List<Usuario> getAll() throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				usuarios.add(rowMapper(rs)); // Mapear ResultSet
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
					usuario = rowMapper(rs);
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
					usuario = rowMapper(rs);
				}

			}
		} 
		return usuario;
	}
	
	//------------ SETTERS ---------------//
	//-----------------------------------//
	@Override
	public boolean insert(Usuario pojo) throws SQLException {
		boolean result = false;

		Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPass());

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

		return result;
	}

	@Override
	public boolean update(Usuario pojo) throws SQLException {
		boolean result = false;
		
		try (Connection cnx = ConnectionManager.getConnection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPass());
			ps.setLong  (3, pojo.getId());
			
			if (ps.executeUpdate() == 1 ) {
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
			
			if ( ps.executeUpdate() == 1 ) {
				result = true;
			}
		}

		return result;
	}
	
	
	//--------- PRIVATE FUNCITONS --------//
	//-----------------------------------//
	private Usuario rowMapper(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		if (rs != null) {

			usuario.setId(rs.getLong("idUsuario"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPass(rs.getString("password"));	
			
			int rol = Integer.parseInt(rs.getString("id_rol"));
			
			switch (rol) {
			case 0:
				usuario.setRol(Usuario.ROL_ADMIN);
				break;
			default:
				usuario.setRol(Usuario.ROL_USER);
				break;
			}
		}

		return usuario;
	}

}
