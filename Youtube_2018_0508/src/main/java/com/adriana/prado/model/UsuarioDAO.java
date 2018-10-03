package com.adriana.prado.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adriana.prado.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Crudable<Usuario>{
	private static UsuarioDAO INSTANCE = null;
	
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?, ?);";
	private static final String SQL_GET_ALL = "SELECT id, nombre, password, rol FROM usuario ORDER BY id DESC LIMIT 1000";
	private static final String SQL_GET_BY_ID = "SELECT nombre, password FROM usuario WHERE id = ?;";
	private static final String SQL_GET_BY_NOMBRE = "SELECT id, nombre, password, rol FROM usuario WHERE nombre = ? AND password = ?;";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ? WHERE id = ?;";
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
	public boolean insert(Usuario pojo) {
		boolean resul = false;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				){
			if(pojo != null) {
				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getContrasena().trim());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					//Conseguir id generado
					try (ResultSet rs = ps.getGeneratedKeys();) {
						while(rs.next()) {
							pojo.setId(rs.getLong(1));
							resul = true;
						}
					}
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();
				){
			
			//Mapear ResultSet a ArrayList
			while(rs.next()) {
				usuarios.add(rowMapper(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}

	@Override
	public Usuario getById(String id2) {
		Long id = (long) 0;
		if(id2 != null) {
			id = Long.parseLong(id2);
		}
		Usuario u = null;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);
				){
			
			ps.setLong(1, id);
			
			try (ResultSet rs = ps.executeQuery();){
				//Obtener resultados
//				ResultSet rs = ps.executeQuery();
				
				//Mapear ResultSet al objeto o array objetos
				while( rs.next() ) {
					u = rowMapper(rs);					
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	/**
	 * Funcion que comprueba el nombre y la contraseña de un usuario y si existe devuelve el objeto Usuario de la bbdd
	 * @param Nombre de usuario a comprobar.
	 * @param Password del usuario a comprobar.
	 * @return El usuario de la bbdd que coincida con los parametros. Si no existe, devuelve null.
	 */
	//Metodo extra para encontrar un usuario registrado por su nombre, ya que es UK
	public Usuario getByNombre(String nombre, String pswd) {
		Usuario u = null;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_NOMBRE);
				){
			
			ps.setString(1, nombre);
			ps.setString(2, pswd);
			
			try (ResultSet rs = ps.executeQuery();){
				//Obtener resultados
//				ResultSet rs = ps.executeQuery();
				
				//Mapear ResultSet al objeto o array objetos
				while( rs.next() ) {
					u = rowMapper(rs);					
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean update(Usuario pojo) {
		boolean resul = false;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
				
				ps.setString(1, pojo.getNombre());
				ps.setString(2, pojo.getContrasena());
				ps.setLong(3, pojo.getId());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					resul = true;
				}	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return resul;
	}

	@Override
	public boolean delete(String id2) {
		boolean resul = false;
		Long id = Long.parseLong(id2);
		
		try (Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
			
			ps.setLong(1, id.longValue());
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}

	private Usuario rowMapper(ResultSet rs) throws Exception{
		Usuario u = new Usuario();
		if(rs != null) {
			u.setId(rs.getLong("id"));
			u.setNombre( rs.getString("nombre"));
			u.setContrasena(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}
}
