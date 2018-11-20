package com.ipartek.formacion.youtube.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT v.id, v.codigo, v.nombre,v.id_usuario,u.nombre nombre_usuario FROM video as v,usuario as u WHERE v.id_usuario= u.id ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT v.id, v.codigo,v.nombre,v.id_usuario,u.nombre as nombre_usuario"
			+ " FROM video as v, usuario as u" + " WHERE v.id=? AND v.id_usuario=u.id;";
	private final String SQL_UPDATE = "UPDATE video SET codigo= ? , nombre= ?,id_usuario=? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre,id_usuario) VALUES (?,?,?);";
	private final String SQL_GET_ALL_VIDEOS_BY_USER_ID = "SELECT v.id, v.codigo, v.nombre,v.id_usuario,u.nombre as nombre_usuario FROM video as v,usuario as u WHERE v.id_usuario= ? And v.id_usuario=u.id order BY u.id DESC LIMIT 1000;";

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
	public boolean insert(Video video) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, video.getCodigo());
			ps.setString(2, video.getNombre());
			ps.setLong(3, video.getUsuario().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						video.setId(rs.getLong(1));
						resul = true;
					}
				}

			}

		} catch (Exception e) {
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
				videos.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	public List<Video> getAllByUserId(long id) {

		ArrayList<Video> videos = new ArrayList<Video>();
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_VIDEOS_BY_USER_ID);) {
			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					video = rowMapper(rs);
					videos.add(video);
					video = null;
				}
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
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
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
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId());
			ps.setLong(4, pojo.getId());

			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id);
			if (ps.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Video rowMapper(ResultSet rs) throws Exception {
		Video video = new Video();
		Usuario usuario = new Usuario();
		if (rs != null) {
			video.setId(rs.getLong("id"));
			video.setCodigo(rs.getString("codigo"));
			video.setNombre(rs.getString("nombre"));
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("nombre_usuario"));
			video.setUsuario(usuario);

		}
		return video;
	}

	public String ejemploPA(long idVideo) {
		String result = "PETA FIJO";
		String sql = "{CALL `ejemplo`(?)}";
		try (Connection con = ConnectionManager.getConnection(); CallableStatement cs = con.prepareCall(sql);) {

			cs.setLong(1, idVideo);
			
			try 
				(ResultSet rs=cs.executeQuery()){
				while(rs.next()) {
				result=rs.getString("nombre");
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result += " causa:" + e.getCause();
		}

		return result;

	}

}
