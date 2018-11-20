package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT v.id as id_video, v.codigo, v.nombre as nombre_video, u.id as id_usuario, u.nombre as nombre_usuario "+
										" FROM video as v, usuario as u "+
										" WHERE u.id = v.id_usuario "+
										" ORDER BY v.id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT v.id as id_video, v.codigo, v.nombre as nombre_video, u.id as id_usuario, u.nombre as nombre_usuario "+
										" FROM video as v, usuario as u "+
										" WHERE v.id = ? AND  u.id = v.id_usuario;";
	
	private final String SQL_UPDATE = "UPDATE youtube, video SET nombre= ?, codigo= ?, id_usuario= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	//añadir la columna de id_usuario
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre, id_usuario) VALUES (?,?,?);";

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
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId());
			//añadir un nuevo setInt para el id del usuario

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
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
				videos.add(rowMapper(rs, null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public Video getById(String id) throws Exception  {
		
		
		Video video = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);

		) {

			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					video = rowMapper(rs, video);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return video;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Video rowMapper(ResultSet rs, Video video) throws Exception {
		
			video = new Video();
			Usuario usuario = new Usuario();
		
		if (rs != null) {
			video.setId(rs.getLong("id_video"));
			video.setCodigo(rs.getString("codigo"));
			video.setNombre(rs.getString("nombre_video"));
			
			
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("nombre_usuario"));

			video.setUsuario(usuario);
		}

		return video;
	}

	public boolean update(Video pojo) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getCodigo());
			ps.setLong(3, pojo.getUsuario().getId());
			ps.setLong(4, pojo.getId());

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

}