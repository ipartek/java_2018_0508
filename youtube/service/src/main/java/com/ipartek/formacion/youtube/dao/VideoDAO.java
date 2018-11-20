package com.ipartek.formacion.youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.conection.ConnectionManager;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT v.id as 'id_video', codigo, v.nombre as 'nombre_video', id_usuario, u.nombre as 'nombre_usuario'" +
	                                    " FROM video as v INNER JOIN usuario as u ON v.id_usuario = u.id " + 
	                                    " ORDER BY v.id DESC LIMIT 1000;";	
	
	private final String SQL_GET_BY_ID = "SELECT v.id as 'id_video', codigo, v.nombre as 'nombre_video', id_usuario, u.nombre as 'nombre_usuario'" +
							            " FROM video as v INNER JOIN usuario as u ON v.id_usuario = u.id " + 
							            " WHERE v.id = ?;";	
	
	
	private final String SQL_UPDATE = "UPDATE video SET codigo= ? , nombre= ?, id_usuario=? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre,id_usuario) VALUES (?,?,?);";

	private VideoDAO() {
		super();
	}

	public static synchronized VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) throws Exception {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId());
			
			int affectedRows = ps.executeUpdate();
			if ( affectedRows == 1 ) {
				
				//conseguir ID generado
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
	public List<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {
			
			while (rs.next()) {				
				videos.add( rowMapper(rs) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public Video getById(long id) {
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID); 
			){
						
			ps.setLong(1, id);
			
			try(ResultSet rs = ps.executeQuery()){			
				while (rs.next()) {
					video = rowMapper(rs);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return video;
	}

	@Override
	public boolean update(Video pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong  (3, pojo.getUsuario().getId() );
			ps.setLong  (4, pojo.getId());
			
			if ( ps.executeUpdate() == 1 ) {
				resul = true;
			}			
			
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
			
			ps.setLong(1, id);			
			if ( ps.executeUpdate() == 1 ) {
				resul = true;
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	
	private Video rowMapper(ResultSet rs) throws Exception {
		Video video= new Video();
		Usuario u = new Usuario();
		if( rs != null) {
			video.setId(rs.getLong("id_video"));
			video.setCodigo(rs.getString("codigo"));
			video.setNombre(rs.getString("nombre_video"));
			
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			
			video.setUsuario(u);
		}
		return video;
	}
	
	

}
