package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements CrudAble<Comentario> {

	private static ComentarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT c.*, u.nombre as 'us_nombre', v.nombre as 'vid_nombre'"
			+ " FROM comentario as c INNER JOIN usuario as u ON c.id_usuario = u.idusuario"
			+ " INNER JOIN video as v ON c.id_video=v.idvideo"
			+ " ORDER BY idcomentario DESC;";

	private final String SQL_GET_BY_ID = "SELECT c.*, u.nombre as 'us_nombre', v.nombre as 'vid_nombre'"
			+ " FROM comentario as c INNER JOIN usuario as u ON c.id_usuario = u.idusuario"
			+ " INNER JOIN video as v ON c.id_video=v.idvideo"
			+ " WHERE idcomentario = ?;";

	private final String SQL_GET_BY_ID_VIDEO = "SELECT c.*, u.nombre as 'us_nombre', v.nombre as 'vid_nombre'"
			+ " FROM comentario as c INNER JOIN usuario as u ON c.id_usuario = u.idusuario"
			+ " INNER JOIN video as v ON c.id_video=v.idvideo"
			+ " WHERE idvideo = ?;";
	
	private final String SQL_GET_BY_ID_USUARIO = "SELECT c.*, u.nombre as 'us_nombre', v.nombre as 'vid_nombre'"
			+ " FROM comentario as c INNER JOIN usuario as u ON c.id_usuario = u.idusuario"
			+ " INNER JOIN video as v ON c.id_video=v.idvideo"
			+ " WHERE idusuario = ?;";
	
	private final String SQL_GET_BY_APROBADOS = "SELECT c.*, u.nombre as 'us_nombre', v.nombre as 'vid_nombre'"
			+ " FROM comentario as c INNER JOIN usuario as u ON c.id_usuario = u.idusuario"
			+ " INNER JOIN video as v ON c.id_video=v.idvideo"
			+ " WHERE aprobado = ?;";

	private final String SQL_INSERT = "INSERT INTO comentario (texto, id_usuario, id_video) VALUES (?, ?, ?);";
	private final String SQL_UPDATE = "UPDATE comentario SET aprobado = ? WHERE idcomentario = ?;";
	private final String SQL_DELETE = "DELETE FROM comentario WHERE idcomentario = ?;";

	private ComentarioDAO() {
		super();
	}

	public static synchronized ComentarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}
		return INSTANCE;
	}

	// ------------ GETTERS ---------------//
	// -----------------------------------//
	@Override
	public List<Comentario> getAll() throws Exception {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				comentarios.add(rowMapper(rs)); // Mapear ResultSet
			}
		}
		return comentarios;
	}

	public List<Comentario> getAllByIdVideo(long id) throws Exception {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID_VIDEO);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {

					comentarios.add(rowMapper(rs)); // Mapear ResultSet
				}
			}
		}
		
		return comentarios;

	}
	
	public List<Comentario> getAllByIdUsuario(long id) throws Exception {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID_USUARIO);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {

					comentarios.add(rowMapper(rs)); // Mapear ResultSet
				}
			}
		}
		
		return comentarios;

	}
	
	public List<Comentario> getAllByAprobado(int aprobado) throws Exception {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_APROBADOS);) {

			ps.setLong(1, aprobado);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {

					comentarios.add(rowMapper(rs)); // Mapear ResultSet
				}
			}
		}
		
		return comentarios;

	}

	@Override
	public Comentario getById(long id) throws Exception {

		Comentario comentario = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {

					comentario = rowMapper(rs); // Mapear ResultSet
				}

			}
		}

		return comentario;
	}

	// ------------ SETTERS ---------------//
	// -----------------------------------//
	@Override
	public boolean insert(Comentario pojo) throws Exception {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getTexto().trim());
			ps.setLong(2, pojo.getUsuario().getId()); // FK id_usuario
			ps.setLong(3, pojo.getVideo().getId()); // FK id_video

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
	public boolean update(Comentario pojo) throws Exception {

		boolean result = false;
		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setBoolean(1, pojo.isAprobado());
			ps.setLong(2, pojo.getId());
			
			
			if (ps.executeUpdate() == 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) throws SQLException {
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
	private Comentario rowMapper(ResultSet rs) throws Exception {

		Comentario comentario = new Comentario();
		
		Usuario usuario = new Usuario();
		
		Video video = new Video();

		if (rs != null) {

			// Campos de clase Comentario
			comentario.setId(rs.getInt("idcomentario"));
			comentario.setTexto(rs.getString("texto"));
			comentario.setAprobado(rs.getBoolean("aprobado"));
			comentario.setFecha(rs.getTimestamp("fecha"));
			
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("us_nombre"));
			
			video.setId(rs.getLong("id_video"));
			video.setNombre(rs.getString("vid_nombre"));
			
			comentario.setUsuario(usuario);
			comentario.setVideo(video);

		}

		return comentario;
	}

}
