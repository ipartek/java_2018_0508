package com.andrea.perez.youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.andrea.perez.pojo.Rol;
import com.andrea.perez.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Crudable<Usuario> {
	private static UsuarioDAO INSTANCE = null;
	private static final String SQL_GET_ALL = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password,id_rol,r.nombre as 'nombre_rol'"
			+ " FROM youtube.usuario as u,youtube.rol as r" + " WHERE u.id_rol=r.id"
			+ " ORDER BY u.id DESC LIMIT 1000;";

	private static final String SQL_GET_BY_ID = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password,id_rol,r.nombre as 'nombre_rol'"
			+ " FROM youtube.usuario as u,youtube.rol as r" + " WHERE u.id_rol=r.id AND u.id = ?;";

	private static final String SQL_GET_BY_NOMBRE = "SELECT u.id as 'id_usuario',u.nombre as 'nombre_usuario', password,id_rol,r.nombre as 'nombre_rol'"
			+ " FROM youtube.usuario as u,youtube.rol as r" + " WHERE u.id_rol=r.id AND u.nombre=? AND password=?";
	private static final String SQL_GET_BY_NOMBRE_RETIDO = "SELECT nombre" + " FROM youtube.usuario "
			+ " WHERE nombre=? ";

	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ? ,password= ?,id_rol=? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password,id_rol) VALUES (?, ?,?);";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {

				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getContrasena().trim());
				ps.setLong(3, pojo.getRol());

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
	public List<Usuario> getAll() throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				usuarios.add(rowMapper(rs));
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
		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					u = rowMapper(rs);
				}
			}

		}

		return u;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getContrasena());
			ps.setLong(3, pojo.getRol());
			ps.setLong(4, pojo.getId());

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

	public Usuario getByNombre(String nombre, String password) throws Exception {
		String nom = "";
		if (nombre != null) {
			nom = nombre;
		}

		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_NOMBRE)) {

			ps.setString(1, nom);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					u = rowMapper(rs);
				}
			}

		}

		return u;
	}

	public boolean getByNombreRepetido(String nombre) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_NOMBRE_RETIDO)) {

			ps.setString(1, nombre);

			try (ResultSet rs = ps.executeQuery()) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					resul = true;
				}
			}

		}

		return resul;

	}

	private Usuario rowMapper(ResultSet rs) throws Exception {
		Usuario u = new Usuario();

		if (rs != null) {
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			u.setContrasena(rs.getString("password"));

			Rol rol = new Rol();
			rol.setId(rs.getLong("id_rol"));
			rol.setNombre(rs.getString("nombre_rol"));

			u.setRol((int) rol.getId());
		}
		return u;
	}

}
