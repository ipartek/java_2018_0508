package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public class VideoDAO implements CrudAble<Video>{

	private static VideoDAO INSTANCE = null;
	
	private static List<Video> videos = null;
	
	private VideoDAO() {
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			//Conexion a bbdd
			Connection con = ConnectionManager.getConnection();
			//Ejecutar SQL
			String sql = "select id, codigo, nombre from video order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			//Obtener resultados
			ResultSet rs = ps.executeQuery();
			//Mapear ResultSet a ArrayList<videos>
			Video v = null;
			while(rs.next()) {
				
				v = new Video();
				v.setId(rs.getString("codigo"));
				v.setNombre(rs.getString("nombre"));
				videos.add(v);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
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
