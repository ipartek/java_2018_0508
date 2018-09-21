package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VideoDAO implements CrudAble<Video> {
	
	
	private static VideoDAO INSTANCE = null;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();
		try {
			//obtener conexion bbdd
			Connection con = ConnectionManager.getConnection();
			
			//ejecutar SQL
			String sql = "select id, codigo, nombre from video order by id desc;";
			PreparedStatement ps = con.prepareStatement(sql);
						
			//obtener resultados ResultSet
			ResultSet rs = ps.executeQuery();
			
			//mapear ResultSet a ArrayList<Video>
			Video v = null;
			while( rs.next() ) {				
				v = new Video();
				v.setId( rs.getString("codigo")  );
				v.setNombre( rs.getString("nombre"));
				videos.add(v);				
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return videos;
	}

	@Override
	public Video getById(String id) {
		Video video = new Video();
		try {
			//obtener conexion bbdd
			Connection con = ConnectionManager.getConnection();
			
			//ejecutar SQL
			String sql = "select id, codigo, nombre from video where codigo = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
						
			//obtener resultados ResultSet
			ResultSet rs = ps.executeQuery();
			
			//mapear ResultSet a ArrayList<Video>
			
			while( rs.next() ) {				
				
				video.setId( rs.getString("codigo")  );
				video.setNombre( rs.getString("nombre"));							
			}			
			
		}catch (Exception e) {
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

}