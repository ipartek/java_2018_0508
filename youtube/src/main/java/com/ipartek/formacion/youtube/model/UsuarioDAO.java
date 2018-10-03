package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements CrudAble<Usuario>{
	
	private static final String SQL_LOGIN = "SELECT `id`, `nombre`, `password`, `rol` FROM youtube.usuario WHERE nombre = ? AND password = ?;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`, `password`) VALUES (?,?);";
	private static final String SQL_GET_ALL = "SELECT id, nombre, password, rol FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT  id, nombre, password, rol FROM video WHERE id = ?;";
	private static final String SQL_GET_UPDATE = "UPDATE usuario SET nombre= ?, password= ? WHERE id = ?;";
	private static final String SQL_GET_DELETE = "DELETE FROM usuario WHERE id = ?;";
	
	private static UsuarioDAO INSTANCE = null;
	
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
	 * @param pojo Usuario a comprobar
	 * @return null si no encuentra
	 */
	public Usuario login(Usuario pojo) {
		Usuario resul = null;
		try ( Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LOGIN) ) {
			
			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPass());
			
			try ( ResultSet rs = ps.executeQuery() ){
				
				if ( rs != null && rs.next() ) {
					resul = rowMapper(rs, pojo);
				}
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	@Override
	public boolean insert(Usuario pojo) {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			
			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPass().trim());
			
			int affectedRows = ps.executeUpdate();
			if ( affectedRows == 1 ) {				
				try ( ResultSet rs = ps.getGeneratedKeys() ){
					while( rs.next() ) {
						pojo.setId( rs.getLong(1) );
						resul = true;						
					}
				}				
			}//affectedRows == 1 
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	private Usuario rowMapper(ResultSet rs, Usuario u ) throws Exception {
		
		if ( u == null ) {
			u = new Usuario();
		}
		
		if( rs != null) {
			u.setId(rs.getLong("id"));			
			u.setNombre(rs.getString("nombre"));
			u.setPass(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}

}