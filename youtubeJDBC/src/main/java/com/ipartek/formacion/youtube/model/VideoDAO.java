package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT id, codigo, nombre FROM video ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT  id, codigo, nombre FROM video WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE video SET codigo= ? , nombre= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre) VALUES (?,?);";

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
	public boolean insert(Video pojo) {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);){
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			
			int affectedRows = ps.executeUpdate();
			if ( affectedRows == 1 ) {
				resul = true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
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
	public Video getById(String id) {
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID); 
			){
						
			ps.setString(1, id);
			
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
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private Video rowMapper(ResultSet rs) throws Exception {
		Video video= new Video();
		if( rs != null) {
			video.setId(rs.getLong("id"));
			video.setCodigo(rs.getString("codigo"));
			video.setNombre(rs.getString("nombre"));
		}
		return video;
	}
	
	

}