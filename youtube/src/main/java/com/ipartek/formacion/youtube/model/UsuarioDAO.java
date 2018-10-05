package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements CrudAble<Usuario>{
	
	private static final String SQL_LOGIN = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario WHERE nombre = ? AND password = ?;";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`, `password`) VALUES (?,?);";
	private static final String SQL_GETALL = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `nombre`, `password`, `rol` FROM usuario WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ?, rol = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	
	
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
	 * @return true si existe en bbdd, false en caso contrario
	 * @throws Exception 
	 */
	public boolean login(Usuario pojo) throws Exception {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_LOGIN)){
			
			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());
			
			try (ResultSet rs = ps.executeQuery();){
			
				if(rs != null && rs.next()) {
					pojo = rowMapper(rs, pojo);
					resul = true;
				}
				
			}
			
		}
		
		return resul;
	}
	
	@Override
	public boolean insert(Usuario pojo) throws Exception {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			
			ps.setString(1, pojo.getNombre().trim());
			ps.setString(2, pojo.getPassword().trim());
			
			int affectedRows = ps.executeUpdate();
			if ( affectedRows == 1 ) {				
				try ( ResultSet rs = ps.getGeneratedKeys() ){
					while( rs.next() ) {
						pojo.setId( rs.getLong(1) );
						resul = true;						
					}
				}				
			}//affectedRows == 1 
			
			
		}
		return resul;
	}

	@Override
	public List<Usuario> getAll() throws Exception {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GETALL);
				ResultSet rs = ps.executeQuery();){			
				
				while(rs.next()) {
					usuarios.add(rowMapper(rs, null));
				}
				
			}
		
		return usuarios;
	}

	@Override
	public Usuario getById(String id) throws Exception {
		Usuario usuario = null;
		
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);){
			usuario =	new Usuario();
				ps.setString(1, id);
				try (ResultSet rs = ps.executeQuery();){
					//mapear ResultSet a ArrayList<Video>
					while( rs.next() ) {
						usuario = rowMapper(rs, usuario);							
					}
				}
			}	
		
		return usuario;
	}

	@Override
	public boolean update(Usuario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getPassword());
			ps.setInt(3, pojo.getRol());
			ps.setLong(4, pojo.getId());
			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
				
			ps.setString(1, id);
			if(ps.executeUpdate() == 1) {
				resul = true;
			}
					
		}
		
		return resul;
	}
	
	private Usuario rowMapper(ResultSet rs, Usuario u) throws Exception {
		
		if(u == null) {
			u = new Usuario();
		}
		
		if(rs != null) {
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("nombre"));
			u.setPassword(rs.getString("password"));
			u.setRol(rs.getInt("rol"));
		}
		return u;
	}

}
