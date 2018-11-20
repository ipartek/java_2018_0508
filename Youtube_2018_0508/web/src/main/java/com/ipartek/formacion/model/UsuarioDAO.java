package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Rol;
import com.ipartek.formacion.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Crudable<Usuario>{
	private static UsuarioDAO INSTANCE = null;
	
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password, id_rol) VALUES (?, ?, ?);";
	private static final String SQL_GET_ALL = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.password, id_rol as 'id_rol', r.nombre as 'rol_nombre'"
												+" FROM youtube.usuario as u, youtube.rol as r"
												+" WHERE u.id_rol = r.id"
												+" ORDER BY u.id DESC LIMIT 500";
	private static final String SQL_GET_BY_ID = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.password, id_rol as 'id_rol', r.nombre as 'rol_nombre'"
												+ " FROM youtube.usuario as u, youtube.rol as r"
												+ " WHERE u.id_rol = r.id AND u.id = ?;";
	private static final String SQL_GET_BY_NOMBRE = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.password, id_rol as 'id_rol', r.nombre as 'rol_nombre'"
													+ " FROM youtube.usuario as u, youtube.rol as r"
													+ " WHERE u.nombre = ? AND u.password = ?;";
private static final String SQL_GET_NOMBRE = "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.password, id_rol as 'id_rol', r.nombre as 'rol_nombre'"
													+ " FROM youtube.usuario as u, youtube.rol as r"
													+ " WHERE u.id_rol = r.id AND u.nombre = ?;";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ?, id_rol = ? WHERE id = ?;";
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
	public boolean insert(Usuario pojo) throws Exception{
		boolean resul = false;
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			if(pojo != null) {
				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getContrasena().trim());
				ps.setLong(3, pojo.getRol().getId());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					//Conseguir id generado
					ResultSet rs = ps.getGeneratedKeys();
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
	public List<Usuario> getAll()  throws Exception{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);){
		ResultSet rs = ps.executeQuery();

		//Mapear ResultSet a ArrayList
		while(rs.next()) {
			usuarios.add(rowMapper(rs));
		}
		}
		return usuarios;
	}

	@Override
	public Usuario getById(String id2)  throws Exception{
		Long id = (long) 0;
		if(id2 != null) {
			id = Long.parseLong(id2);
		}
		Usuario u = null;
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);){

			
		ps.setLong(1, id);
		
		try (ResultSet rs = ps.executeQuery();){
			//Obtener resultados
//				ResultSet rs = ps.executeQuery();
			
			//Mapear ResultSet al objeto o array objetos
			while( rs.next() ) {
				u = rowMapper(rs);					
			}	
		}
		
		}
		return u;
	}
	
	public boolean getByNombre(String nombre) throws Exception {
		boolean resul = false;
		@SuppressWarnings("unused")
		Usuario u = null;
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_GET_NOMBRE);){
			
			ps.setString(1, nombre);
			
			//Obtener resultados
			ResultSet rs = ps.executeQuery();
			
			//Mapear ResultSet al objeto o array objetos
			while( rs.next() ) {
				u = rowMapper(rs);
				resul = true;
			}
		}
		return resul;
	}

	/**
	 * Funcion que comprueba el nombre y la contraseña de un usuario y si existe devuelve el objeto Usuario de la bbdd
	 * @param Nombre de usuario a comprobar.
	 * @param Password del usuario a comprobar.
	 * @return El usuario de la bbdd que coincida con los parametros. Si no existe, devuelve null.
	 */
	//Metodo extra para encontrar un usuario registrado por su nombre, ya que es UK
	public Usuario getByNombreAndPswd(String nombre, String pswd)  throws Exception{
		Usuario u = null;
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_GET_BY_NOMBRE);){
			
			ps.setString(1, nombre);
			ps.setString(2, pswd);
			
			ResultSet rs = ps.executeQuery();
			//Obtener resultados
	//				ResultSet rs = ps.executeQuery();
			
			//Mapear ResultSet al objeto o array objetos
			while( rs.next() ) {
				u = rowMapper(rs);					
			}
		}
		return u;
	}

	@Override
	public boolean update(Usuario pojo)  throws Exception{
		boolean resul = false;
		try(Connection con =  ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
		
		ps.setString(1, pojo.getNombre());
		ps.setString(2, pojo.getContrasena());
		ps.setLong(3, pojo.getRol().getId());
		ps.setLong(4, pojo.getId());
		
		
		int affectedRows = ps.executeUpdate();
		
		if(affectedRows == 1) {
			resul = true;
		}	
		}
		return resul;
	}

	@Override
	public boolean delete(String id2)  throws Exception{
		boolean resul = false;
		Long id = Long.parseLong(id2);
		
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
				
			ps.setLong(1, id.longValue());
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}	
		}
		return resul;
	}

	private Usuario rowMapper(ResultSet rs) throws Exception{
		Usuario u = new Usuario();
		if(rs != null) {
			u.setId(rs.getLong("id_usuario"));
			u.setNombre( rs.getString("nombre_usuario"));
			u.setContrasena(rs.getString("password"));
			
			Rol rol = new Rol();
			rol.setId(rs.getLong("id_rol"));
			rol.setNombre(rs.getString("rol_nombre"));
			
			u.setRol(rol);
		}
		return u;
	}

	
}
