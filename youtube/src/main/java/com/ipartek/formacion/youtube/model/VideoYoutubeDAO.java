package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.VideoYoutube;

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
		
		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, pojo.getCod());
			ps.setString(1, pojo.getNombre());
			
			try (ResultSet rs = ps.executeQuery();) {	
				
				int affectedRows = ps.executeUpdate();
				
				if (affectedRows > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<VideoYoutube> getAll() {

		ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				videos.add(rowMapper(rs)); // Mapear ResultSet
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public VideoYoutube getById(int id) {

		VideoYoutube video = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				video = rowMapper(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return video;
	}

	@Override
	public boolean update(VideoYoutube pojo) {
		
		try  {

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		
		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private VideoYoutube rowMapper(ResultSet rs) throws Exception {

		VideoYoutube video = new VideoYoutube();

		if (rs != null) {
			video.setId(Integer.parseInt(rs.getString("id")));
			video.setCod(rs.getString("cod"));
			video.setNombre(rs.getString("nombre"));
		}

		return video;
	}

}
