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

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT v.idvideo, v.codigo, v.nombre as 'video_nombre' , v.id_usuario"
			+ ", u.idusuario, u.nombre as 'usuario_nombre', u.password" 
			+ " FROM video as v, usuario as u"
			+ " WHERE v.id_Usuario = u.idusuario" 
			+ " ORDER BY idvideo DESC LIMIT 1000;";

	private final String SQL_GET_BY_ID = "SELECT v.idvideo, v.codigo, v.nombre as 'video_nombre' , v.id_usuario"
			+ " , u.idusuario, u.nombre as 'usuario_nombre', u.password" + " FROM video as v, usuario as u"
			+ " WHERE v.idvideo = ? AND v.id_usuario = u.idusuario;";
	
	private final String SQL_GET_ONE_VIDEO_PER_CATEGORY = "SELECT (c.nombre), v.idvideo, v.nombre"
			+ " FROM categoria as c INNER JOIN video as v"
			+ " ON c.idcategoria = v.id_categoria"
			+ " GROUP BY c.nombre;";

	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre, id_usuario) VALUES (?, ?, ?);";
	private final String SQL_UPDATE = "UPDATE video SET codigo = ?, nombre = ?, id_usuario = ? WHERE idvideo = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE idvideo = ?;";

	private VideoDAO() {
		super();
	}

	public static synchronized VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	// ------------ GETTERS ---------------//
	// -----------------------------------//
	@Override
	public List<Video> getAll() throws Exception {

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				videos.add(rowMapper(rs)); // Mapear ResultSet
			}
		}
		return videos;
	}
	
	public List<Video> getOnePerCategory() throws Exception {

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ONE_VIDEO_PER_CATEGORY);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				videos.add(rowMapper(rs)); // Mapear ResultSet
			}
		}
		return videos;
	}

	@Override
	public Video getById(long id) throws Exception {

		Video video = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {

					video = rowMapper(rs); // Mapear ResultSet
				}

			}
		}

		return video;
	}

	// ------------ SETTERS ---------------//
	// -----------------------------------//
	@Override
	public boolean insert (Video pojo) throws SQLException {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getCod());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {

				try (ResultSet rs = ps.getGeneratedKeys()) { // Conseguir ID generado

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
	public boolean update (Video pojo) throws SQLException {

		boolean result = false;
		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getCod());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId()); // FK id_usuario
			ps.setLong(4, pojo.getId());

			if (ps.executeUpdate() == 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete (long id) throws SQLException {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);

			if (ps.executeUpdate() == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// --------- PRIVATE FUNCTIONS --------//
	// -----------------------------------//
	private Video rowMapper(ResultSet rs) throws Exception {

		Video video = new Video();
		Usuario usuario = new Usuario();

		if (rs != null) {

			// Campos de clase Video
			video.setId(rs.getInt("idVideo"));
			video.setCod(rs.getString("codigo"));
			video.setNombre(rs.getString("video_nombre"));

			// Campos de clase Usuario -> (video_has_usuario)
			usuario = new Usuario();
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("usuario_nombre"));
			usuario.setPass(rs.getString("password"));
			
			video.setUsuario(usuario);
		}

		return video;
	}

}
