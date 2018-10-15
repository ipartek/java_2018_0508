package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.andrea.perez.pojo.Comentario;
import com.andrea.perez.pojo.Rol;
import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements Crudable<Comentario> {

	private static ComentarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre,id_video "+ 
												  " FROM comentario as c , usuario as u " +
			                                      " WHERE c.id_usuario = u.id AND "+
												  " c.id_video = ? " +
												  " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE rol SET nombre= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM rol WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO `youtube`.`comentario` (`texto`, `id_video`, `id_usuario`) VALUES (?, ?, ?);";
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
		
//		List<Comentario> comentarios = new ArrayList<Comentario>();
//		try (Connection con = ConnectionManager.getConnection();
//				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
//				ResultSet rs = ps.executeQuery();) {
//
//			// Mapear ResultSet a ArrayList
//			while (rs.next()) {
//				try {
//					comentarios.add(rowMapper(rs));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
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
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID);
				) {

				ps.setLong(1, video_id);
				
				try(ResultSet rs = ps.executeQuery()){			
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
	public boolean update(Comentario comentarioUpdate) {
		return false;
//		boolean resul = false;
//		Comentario comentarioIteracion = null;
//		int i = 0;
//		if (comentarioUpdate != null) {
//			// Iterator
//			Iterator<Comentario> it = lista.iterator();
//			while (it.hasNext()) {
//				comentarioIteracion = it.next();
//				if (comentarioIteracion.getId() == comentarioUpdate.getId()) {
//					lista.set(i, comentarioUpdate);
//					resul = true;
//					break;
//				}
//				i++;
//			}
//		}
//		return resul;
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

	private Comentario rowMapper(ResultSet rs) throws Exception {
		Comentario c = new Comentario();

		if (rs != null) {
			c.setId(rs.getLong("id_comentario"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
			c.setAprobado(rs.getBoolean("aprobado"));

			Usuario usuario=new Usuario();
			usuario.setId(rs.getLong("id_usuario"));			
			usuario.setNombre(rs.getString("nombre"));

			c.setUsuario(usuario);
			
			Video video=new Video();
			video.setId(rs.getLong("id_video"));
			c.setVideo(video);
			
			
		}
		return c;
	}

}
