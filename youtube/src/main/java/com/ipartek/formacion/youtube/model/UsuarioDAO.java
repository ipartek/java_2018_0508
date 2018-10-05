package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static List<Usuario> usuarios = null;

	private final String SQL_GET_ALL = "SELECT id, nombre, password, rol FROM usuario ORDER BY id DESC LIMIT 50;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre, password, rol FROM usuario WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ?, rol = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?,?);";
	
	private final String SQL_NOMBRE_LIBRE = "SELECT id, nombre, password, rol FROM youtube.usuario  WHERE nombre LIKE ?;";
	private final String SQL_USUARIO = "SELECT id, nombre, password, rol FROM youtube.usuario  WHERE nombre LIKE ? AND password LIKE ?;";

	private UsuarioDAO() {
		usuarios = new ArrayList<Usuario>();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getContrasenya().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				
				// conseguir id generado
				try (ResultSet rs = ps.getGeneratedKeys()){
					while(rs.next()) {
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
				usuarios.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(String id) throws Exception{
		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();

		) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {

					u = rowMapper(rs);

				}
			}

		} 
		return u;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getContrasenya());
			ps.setInt(3, pojo.getRol());
			ps.setLong(4, pojo.getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} 
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} 
		return resul;
	}
	/**
	 * Funcion que comprueba si el nombre esta en la BBDD
	 * @param nombre
	 * @return devuelve true si el nombre esta en la BBDD
	 */
	public boolean mirarNombre(String nombre) {
		boolean resul = false;
		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();

				) {
					try (PreparedStatement ps = con.prepareStatement(SQL_NOMBRE_LIBRE);) {
						ps.setString(1, nombre);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							
							u = rowMapper(rs);

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		if (u != null) {
			resul = true;
		}
		return resul;
	}

	public Usuario comprobarUsuario(String nombre,String contrasenya) {
		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();

				) {
					try (PreparedStatement ps = con.prepareStatement(SQL_USUARIO);) {
						ps.setString(1, nombre);
						ps.setString(2, contrasenya);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							
							u = rowMapper(rs);

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return u;
	}
	
	private Usuario rowMapper(ResultSet rs) throws Exception {
		Usuario u = new Usuario();
		if (rs != null) {
			u = new Usuario();
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("nombre"));
			u.setContrasenya(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}
}
