package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements CrudAble<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario',password,id_rol as 'id_rol', r.nombre as 'nombre_rol'" + 
										" FROM usuario as u, rol as r" +
										" WHERE u.id_rol = r.id" + 
										" ORDER BY u.id DESC LIMIT 1000;";
	
	private final String SQL_GET_BY_ID = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol'" +
										 " FROM usuario as u, rol as r" + 
										 " WHERE u.id_rol = r.id AND u.id = ?;";
	
	private final String SQL_GET_BY_NOMBRE = "select u.id as 'id_usuario', u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol'" + 
											 " from usuario as u, rol as r" + 
											 " where u.nombre = ?;";
	
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?,password= ?, id_rol = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre,password,id_rol) VALUES (?,?,?);";
	
	private final String SQL_LOGIN = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario',password,id_rol as 'id_rol', r.nombre as 'nombre_rol'" +
									 " FROM usuario as u, rol as r" +
									 " WHERE u.id_rol = r.id AND u.nombre = ? AND password = ?";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	public boolean insert(Usuario pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());			
			ps.setString(2, pojo.getPass().trim());
			ps.setLong(3, pojo.getRol().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try(ResultSet rs = ps.getGeneratedKeys()){
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
		Usuario usuario = null;

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
			){
			
			try(ResultSet rs = ps.executeQuery()){

				while (rs.next()) {
					usuarios.add(rowMapper(rs, usuario));
				}
			
			}

		} 

		return usuarios;
	}

	@Override
	public Usuario getById(long id) throws Exception {
		Usuario usuario = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					usuario = rowMapper(rs, usuario);
				}
			}

		} 

		return usuario;
	}
	
	public Usuario getByNombre(String nombre) throws Exception {
		Usuario usuario = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_NOMBRE);) {

			ps.setString(1, nombre);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					usuario = rowMapper(rs, usuario);
				}
			}

		} 

		return usuario;
	}

	public Usuario login(Usuario pojo) throws Exception {
		Usuario resul = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LOGIN)) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPass());

			try (ResultSet rs = ps.executeQuery()) {

				if (rs != null && rs.next()) {
					resul = rowMapper(rs, pojo);
				}

			}

		} 
		return resul;
	}

	public boolean update(Usuario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPass());
			ps.setLong(3, pojo.getRol().getId());
			ps.setLong(4, pojo.getId());

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

	private Usuario rowMapper(ResultSet rs, Usuario u) throws Exception {
		if (u == null) {
			u = new Usuario();
		} 

		if (rs != null) {

			u.setNombre(rs.getString("nombre_usuario"));
			u.setPass(rs.getString("password"));
			u.setId(rs.getLong("id_usuario"));
			
			Rol rol = new Rol();
			rol.setId(rs.getLong("id_rol"));
			rol.setNombre(rs.getString("nombre_rol"));
			
			u.setRol(rol);
			
		}
		return u;
	}

}