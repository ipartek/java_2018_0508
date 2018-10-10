package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;
import com.mysql.jdbc.Statement;

public class VideoDAO implements Crudable<Video> {

	private static VideoDAO INSTANCE = null;
	private final String SQL_GET_ALL = "SELECT v.id as 'id_video',codigo ,v.nombre as 'nombre_video', id_usuario,u.nombre as 'nombre_usuario'"
			+ " FROM youtube.video v,youtube.usuario u" + " WHERE v.id_usuario=u.id"
			+ " ORDER BY v.id DESC LIMIT 1000;";

	private final String SQL_GET_BY_ID = "SELECT v.id as 'id_video',codigo ,v.nombre as 'nombre_video', id_usuario,u.nombre as 'nombre_usuario'"
			+ " FROM youtube.video v,youtube.usuario u" + " WHERE v.id_usuario=u.id AND v.id=?";

	private final String SQL_UPDATE = "UPDATE video SET codigo=?, nombre = ?, id_usuario=? WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo,nombre,id_usuario) VALUES (?, ?,?);";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";

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
	public boolean insert(Video pojo) throws SQLException {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection(); // Obtener conexion bbdd
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) { // Ejecutar
																												// sql

			if (pojo != null) {

//				Connection con =  ConnectionManager.getConnection();

//				PreparedStatement ps = con.prepareStatement(SQL_INSERT);
				ps.setString(1, pojo.getCodigo());
				ps.setString(2, pojo.getTitulo());
				ps.setLong(3, pojo.getUsuario().getId());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					// Conseguir id generado
					try (ResultSet rs = ps.getGeneratedKeys();) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));
							resul = true;
						}
					}
				}
			}
		}
		return resul;
	}

	@Override
	public List<Video> getAll() throws Exception {
		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				videos.add(rowMapper(rs));
			}
		}

		return videos;
	}

	@Override
	public Video getById(String id2) throws Exception {
		Long id = (long) 0;
		if (id2 != null) {
			id = Long.parseLong(id2);
		}
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				// Obtener resultados
//				ResultSet rs = ps.executeQuery();

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					video = rowMapper(rs);
				}
			}

		}

		return video;
	}

	@Override
	public boolean update(Video pojo) throws SQLException {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getTitulo());
			ps.setString(3, Long.toString(pojo.getUsuario().getId()));
			ps.setLong(4, pojo.getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(String id2) throws SQLException {
		boolean resul = false;
		Long id = Long.parseLong(id2);

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id.longValue());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		}

		return resul;
	}

	private Video rowMapper(ResultSet rs) throws Exception {
		Video v = new Video();
		if (rs != null) {
			v.setId(rs.getLong("id_video"));
			v.setCodigo(rs.getString("codigo"));
			v.setTitulo(rs.getString("nombre_video"));

			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));

			v.setUsuario(u);
		}
		return v;
	}
}
