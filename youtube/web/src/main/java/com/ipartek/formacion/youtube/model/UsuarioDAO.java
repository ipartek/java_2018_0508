package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAO implements CrudAble<Usuario> {


	private static UsuarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol'" +
	                                   " FROM usuario as u, rol as r" +
	                                   " WHERE u.id_rol = r.id" +
	                                   " ORDER BY u.id DESC LIMIT 500;";
	
	private final String SQL_GET_BY_ID = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol'" +
            " FROM usuario as u, rol as r" +
            " WHERE u.id_rol = r.id AND u.id = ?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre= ? ,password= ?, id_rol=? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, password, id_rol ) VALUES (?,?,?);";
	private final String SQL_INSERT_ALTA = "INSERT INTO usuario (nombre, password ) VALUES (?,?);";
	private final String SQL_LOGIN = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', password, id_rol as 'id_rol', r.nombre as 'nombre_rol' " +
									 " FROM usuario as u, rol as r " + 
									 " WHERE u.id_rol = r.id AND u.nombre=? AND password=?;";
	
	private final String SQL_NOMBRE="SELECT nombre FROM usuario WHERE nombre LIKE '?';";
	
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
			ps.setString(2, pojo.getPassword().trim());
			ps.setLong(3, pojo.getRol().getId());
					
			

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try ( ResultSet rs = ps.getGeneratedKeys() ){
					while( rs.next() ) {
						pojo.setId( rs.getLong(1) );
						resul = true;						
					}
				}			

			}

		} 
		return resul;
	}
	
	public boolean insertAlta(Usuario pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_ALTA, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try ( ResultSet rs = ps.getGeneratedKeys() ){
					while( rs.next() ) {
						pojo.setId( rs.getLong(1) );
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
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				usuarios.add(rowMapper(rs, usuario));
			}

		} 

		return usuarios;
	}

	@Override
	public Usuario getById(long id) throws Exception{
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

	public Usuario login(Usuario pojo)  throws Exception  {
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

	public boolean update(Usuario pojo)  throws Exception {
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
	
	public boolean buscar(String nombre) {
		boolean resul = false;
		Usuario u = null;
		try (Connection con = ConnectionManager.getConnection();

				) {
					try (PreparedStatement ps = con.prepareStatement(SQL_NOMBRE);) {
						ps.setString(1, nombre);
						
						try(ResultSet rs = ps.executeQuery()){
							while (rs.next()) {
								
								u = rowMapperBuscar(rs);

							}
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
	

	private Usuario rowMapper(ResultSet rs, Usuario u) throws Exception {
		if (u == null) {
			u = new Usuario();
		} else {

		}

		if (rs != null) {

			u.setNombre(rs.getString("nombre_usuario"));
			u.setPassword(rs.getString("password"));			
			u.setId(rs.getLong("id_usuario"));
			try {
				Rol rol = new Rol();
				rol.setId(rs.getLong("id_rol"));
				rol.setNombre(rs.getString("nombre_rol"));
				u.setRol(rol);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		return u;
	}
	private Usuario rowMapperBuscar(ResultSet rs) throws Exception {
		Usuario u = new Usuario();
		if (u == null) {
			u = new Usuario();
		} else {

		}

		if (rs != null) {

			u.setNombre(rs.getString("nombre_usuario"));
			u.setPassword(rs.getString("password"));			
			u.setId(rs.getLong("id_usuario"));
			try {
				Rol rol = new Rol();
				rol.setId(rs.getLong("id_rol"));
				rol.setNombre(rs.getString("nombre_rol"));
				u.setRol(rol);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		return u;
	}


}