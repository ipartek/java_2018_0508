package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.andrea.perez.pojo.Comentario;
import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements Crudable<Comentario> {

	private static ComentarioDAO INSTANCE = null;

	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre,id_video "
			+ " FROM comentario as c , usuario as u " + " WHERE c.id_usuario = u.id AND " + " c.id_video = ? "
			+ " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM comentario WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE comentario SET aprobado= ? WHERE id = ?;";
	private final String SQL_APROBAR = "UPDATE comentario SET aprobado = 1 WHERE id IN "; // IN (1,3);
	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO `youtube`.`comentario` (`texto`, `id_video`, `id_usuario`) VALUES (?, ?, ?);";
	private final String SQL_GET_APROBAR = " SELECT c.id as 'id_comentario', u.id as 'id_usuario',fecha,texto,aprobado,u.nombre,id_video,v.nombre as 'nombre_video'"
			+ " FROM comentario as c , usuario as u,video v " + " WHERE c.id_usuario = u.id AND c.id_video=v.id AND c.aprobado=0"
			+ " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_UPDATE_APROBAR = "UPDATE comentario SET aprobado=? WHERE id=?;";

	public static synchronized ComentarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) throws SQLException {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {

				ps.setString(1, pojo.getTexto().trim());
				ps.setLong(2, pojo.getVideo().getId());
				ps.setLong(3, pojo.getUsuario().getId());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));// devuelve el valor de la primera columna "id" de la bbdd
							resul = true;
						}
					}

				}
			}
		}
		return resul;
	}

	@Override
	public List<Comentario> getAll() throws SQLException {
		return null;
//		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
//		try (Connection con = ConnectionManager.getConnection();
//				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);) {
//
//			try (ResultSet rs = ps.executeQuery()) {
//				while (rs.next()) {
//					comentarios.add(rowMapper(rs));
//				}
//			}
//
//		}
//		return comentarios;

	}

	public List<Comentario> getAllByVideo(long video_id) throws Exception {
		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID);) {

			ps.setLong(1, video_id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentarios.add(rowMapper(rs));
				}
			}

		}
		return comentarios;
	}

	@Override
	public Comentario getById(String id) {
		return null;
//		Comentario resul = null;
//		if (id != null) {
//			for (Comentario comentarioIteracion : lista) {
//				if (id.equals(comentarioIteracion.getId())) {
//					resul = comentarioIteracion;
//					break;
//				}
//			}
//		}
//		return resul;
	}

	@Override
	public boolean update(Comentario pojo) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setBoolean(1, pojo.isAprobado());
			ps.setLong(2, pojo.getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	public boolean aprobar(String[] ids) throws Exception {

		boolean resul = false;

		String in = "(";
		for (int i = 0; i < ids.length; i++) {			
			if ( i == (ids.length-1)) {
				in += ids[i];
			}else {
				in += ids[i] + ",";	
			}			
		}
		in += ");";
		String sql = SQL_APROBAR + in;

		try (Connection con = ConnectionManager.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql); ) {

			int affectedRows = ps.executeUpdate();
			if (affectedRows == ids.length) {
				resul = true;
			}

		}
		return resul;
	}

	@Override
	public boolean delete(String id) {
		return false;
//		boolean resul = false;
//		Comentario vIteracion = null;
//		if (id != null) {
//			// buscar comentario a eliminar
//			for (int i = 0; i < lista.size(); i++) {
//				vIteracion = lista.get(i);
//				if (id.equals(vIteracion.getId())) {
//					resul = lista.remove(vIteracion);
//					break;
//				}
//			}
//		}
//		return resul;
	}

	public ArrayList<Comentario> getAllAprobarComentario() throws Exception {

		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_APROBAR);) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					comentarios.add(rowMapper(rs));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comentarios;

	}

	public boolean updateAprobar(String[] idComent) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE_APROBAR);) {

			for (int i = 0; i < idComent.length; i++) {
				ps.setLong(1, 1);
				ps.setLong(2, Long.parseLong(idComent[i]));

				int affectedRows = ps.executeUpdate();

				if (affectedRows == idComent.length) {
					resul = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Comentario rowMapper(ResultSet rs) throws Exception {
		Comentario c = new Comentario();

		if (rs != null) {
			c.setId(rs.getLong("id_comentario"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
			c.setAprobado(rs.getBoolean("aprobado"));

			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setNombre(rs.getString("nombre"));

			c.setUsuario(usuario);

			try {
				Video video = new Video();
				video.setId(rs.getLong("id_video"));
				video.setTitulo(rs.getString("nombre_video"));
				c.setVideo(video);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		}
		return c;
	}
}
