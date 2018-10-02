package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ipartek.formacion.youtube.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	// private final String SQL_GET_ALL = "SELECT id, nombre, password FROM usuario
	// ORDER BY id DESC LIMIT 1000;";
	// private final String SQL_GET_BY_ID = "SELECT id, nombre, password FROM
	// usuario WHERE id = ?;";
	// private final String SQL_UPDATE = "UPDATE usuario SET nombre= ? , password= ?
	// WHERE id = ?;";
	// private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private static final String SQL_LOGIN = "SELECT `id`, `nombre`, `password`, `rol` FROM youtube.usuario WHERE nombre = ? AND password = ?;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`, `password`) VALUES (?,?);";

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

	public Usuario login(Usuario pojo) {
		Usuario resul = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LOGIN)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());

			try (ResultSet rs = ps.executeQuery()) {
				
				if (rs != null && rs.next()) {
					resul = RowMapper(rs, pojo);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;

	}

	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return resul;
	}

	@Override
	public List<Usuario> getAll() {

		return null;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario getByNombre(String usuarioNombre) {
		// TODO Auto-generated method stub
		return null;
	}

	private Usuario RowMapper(ResultSet rs, Usuario u) throws SQLException {

		if (u == null) {
			u = new Usuario();
		}

		if (rs != null) {
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("nombre"));
			u.setPassword(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}

}
