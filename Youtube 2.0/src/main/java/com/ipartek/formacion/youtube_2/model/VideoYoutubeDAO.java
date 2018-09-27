package com.ipartek.formacion.youtube_2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube_2.pojo.VideoYoutube;

public class VideoYoutubeDAO implements CrudAble<VideoYoutube> {

	private static VideoYoutubeDAO INSTANCE = null;
	
	private final String SQL_GET_ALL = "SELECT id, cod, nombre FROM video ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT id, cod, nombre FROM video WHERE ID = ?;";
	private final String SQL_INSERT = "INSERT INTO video (cod, nombre) VALUES (?, ?);";
	private final String SQL_UPDATE = "UPDATE video SET cod = ?, nombre = ?, WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	

	private VideoYoutubeDAO() {
		super();
	}

	public static synchronized VideoYoutubeDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(VideoYoutube pojo) {
		boolean result = false;
		
		try {
			// Obtener conexion bbdd
			Connection con = ConnectionManager.getConnection();

			// ejecutar SQL
			String sql = "INSERT INTO video (cod, nombre) VALUES (?, ?); ";
			PreparedStatement ps = con.prepareStatement(sql);

			// obtener resultados ResultSet
			ResultSet rs = executeSQL(sql,);

			// mapear ResultSet a ArrayList<Video>
			VideoYoutube v = null;

			while (rs.next()) {
				v = new VideoYoutube();
				v.setId(rs.getString("id"));
				v.setCod(rs.getString("cod"));
				v.setNombre(rs.getString("nombre"));
				videos.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<VideoYoutube> getAll() {

		ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();
		
		try {
			// Obtener conexion BBDD
			Connection cnx = ConnectionManager.getConnection();

			// Ejecutar SQL
			PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);

			// Obtener resultados ResultSet
			ResultSet rs = ps.executeQuery();

			// Mapear ResultSet a ArrayList<Video>
			VideoYoutube v;

			while (rs.next()) {
				v = new VideoYoutube();

				v.setId(Integer.parseInt(rs.getString("id")));
				v.setCod(rs.getString("cod"));
				v.setNombre(rs.getString("nombre"));

				videos.add(v);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public VideoYoutube getById(String id) {
		VideoYoutube video = new VideoYoutube();
		try {

			String sql = "select cod. nombre from video where cod = ?;";

			ResultSet rs;
			// Mapear ResultSet a ArrayList<Video>

			while (rs.next()) {

				video.setCod(rs.getString("codigo"));
				video.setNombre(rs.getString("nombre"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return video;
	}

	@Override
	public boolean update(VideoYoutube pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
