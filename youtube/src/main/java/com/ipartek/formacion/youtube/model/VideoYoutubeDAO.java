package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.VideoYoutube;
import com.mysql.jdbc.Statement;

public class VideoYoutubeDAO implements CrudAble<VideoYoutube> {

	private static VideoYoutubeDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT idVideo, cod, nombre FROM video ORDER BY idVideo DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT idVideo, cod, nombre FROM video WHERE idVideo = ?;";
	private final String SQL_INSERT = "INSERT INTO video (cod, nombre) VALUES (?, ?);";
	private final String SQL_UPDATE = "UPDATE video SET cod = ?, nombre = ? WHERE idVideo = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE idVideo = ?;";

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
	public boolean insert(VideoYoutube pojo) throws SQLException {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getCod());
			ps.setString(2, pojo.getNombre());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {

				// Conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {

					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						result = true;
					}
				}
			}

		}

		return result;
	}

	@Override
	public List<VideoYoutube> getAll() throws Exception{

		ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				videos.add(rowMapper(rs)); // Mapear ResultSet
			}
		}
		return videos;
	}

	@Override
	public VideoYoutube getById(long id) throws Exception{

		VideoYoutube video = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					video = rowMapper(rs);
				}

			}
		}

		return video;
	}

	@Override
	public boolean update(VideoYoutube pojo) throws SQLException{
		
		boolean result = false;
		try (Connection cnx = ConnectionManager.getConnection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getCod());
			ps.setString(2, pojo.getNombre());
			ps.setLong  (3, pojo.getId());
			
			if (ps.executeUpdate() == 1 ) {
				result = true;
			}			
		}
		return result;
	}

	@Override
	public boolean delete(long id) throws SQLException{
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);			
			
			if ( ps.executeUpdate() == 1 ) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private VideoYoutube rowMapper(ResultSet rs) throws Exception {

		VideoYoutube video = new VideoYoutube();

		if (rs != null) {

			video.setId(rs.getInt("idVideo"));
			video.setCod(rs.getString("cod"));
			video.setNombre(rs.getString("nombre"));
		}

		return video;
	}

}
