package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Usuario;

public class ComentarioDAO implements CrudAble<Comentario> {
	public static ComentarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre"
			+ "FROM youtube.comentario as c, youtube.usuario as u" + "WHERE c.id_usuario = u.id"
			+ "ORDER BY u.id DESC LIMIT 1000;";

	private static final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre "+ 
			  " FROM comentario as c , usuario as u " +
              " WHERE c.id_usuario = u.id AND "+
			  " c.id_video = ? " +
			  " ORDER BY c.id DESC LIMIT 500;";

	private static final String SQL_GET_BY_ID = "SSELECT c.id as `id_comentario`, c.fecha, c.texto, c.aprobado, c.id_usuario, c.id_video, u.nombre as nombre_usuario"
			+ "FROM youtube.comentario as c, youtube.usuario as u" + "WHERE c.id_usuario = u.id AND c.id_video = ?;";

	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	// añadir la columna de id_usuario
	private final String SQL_INSERT = "INSERT INTO comentario (texto, id_usuario, id_video) VALUES (?,?,?);";

	public static synchronized ComentarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getTexto().trim());
			ps.setLong(2, pojo.getUsuario().getId());
			ps.setLong(3, pojo.getVideo().getId());
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;

					}
				}
			}//(affectedRows == 1)

		}

		return resul;
	}

	@Override
	public List<Comentario> getAll() throws Exception {

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				comentarios.add(rowMapper(rs, null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	public List<Comentario> getAllByVideo(long videoId) throws Exception {

		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID);) {

			ps.setLong(1, videoId);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentarios.add(rowMapper(rs, comentario));
				}
			}

		}
		return comentarios;
	}

	@Override
	public Comentario getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Comentario pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	private Comentario rowMapper(ResultSet rs, Comentario c) throws Exception {
		if (c == null) {
			c = new Comentario();
		}

		if (rs != null) {
			c.setId(rs.getLong("id_comentario"));
			c.setAprobado(rs.getBoolean("aprobado"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
		

			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("nombre"));
			c.setUsuario(usuario);

		}

		return c;
	}

}
