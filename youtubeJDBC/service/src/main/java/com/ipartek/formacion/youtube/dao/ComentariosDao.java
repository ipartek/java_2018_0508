package com.ipartek.formacion.youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ipartek.formacion.youtube.conection.ConnectionManager;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentariosDao implements CrudAble<Comentario> {
	private static ComentariosDao INSTANCE = null;
	private final String SQL_GET_ALL = "SELECT c.id, c.fecha,texto, c.aprobado,c.id_video , c.id_usuario , v.id as 'video_id', v.nombre as'video_nombre', u.nombre as 'autor'"
			+ " FROM comentario as c, video as v, usuario as u" + " WHERE c.id_video = v.id and c.id_usuario = u.id"
			+ " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id , c.id_video,   u.id as 'id_usuario',v.nombre as 'video_nombre',    fecha,    texto,    aprobado,  u.nombre as 'autor'"
			+ " FROM comentario as c , usuario as u,video as v "
			+ " WHERE c.id_usuario = u.id AND c.id_video = v.id AND c.id_video = ? " + " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT c.id, c.fecha,texto, c.aprobado,c.id_video , c.id_usuario , v.id as 'video_id', v.nombre as'video_nombre', u.nombre as 'autor'"
			+ " FROM comentario as c, video as v, usuario as u"
			+ " WHERE c.id_video = v.id and c.id_usuario = u.id and c.id = ?" + " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_ALL_BY_USER = "SELECT c.id, c.fecha,texto, c.aprobado,c.id_video , c.id_usuario , v.id as 'video_id', v.nombre as'video_nombre', u.nombre as 'autor'"
			+ " FROM comentario as c, video as v, usuario as u"
			+ " WHERE c.id_video = v.id and c.id_usuario = ? and  u.nombre = ?" + " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO comentario ( texto ,id_video  ,id_usuario ) VALUES (?,?,? );";
	private final String SQL_UPDATE = "UPDATE comentario SET  texto = ?  ,id_video = ?   ,id_usuario = ?  WHERE id = ?;";
	private final String SQL_UPDATE_APROBADO = "UPDATE comentario SET  aprobado = ?  WHERE id = ?;";
	private final String SQL_UPDATE_APROBADO_MASIVO = "UPDATE comentario SET  aprobado = ?  WHERE id = ?;";

	private ComentariosDao() {
		super();
	}

	public static synchronized ComentariosDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentariosDao();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) throws Exception {

		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			int index = 1;

			ps.setString(index++, pojo.getTexto());
			ps.setLong(index++, pojo.getVideo().getId());
			ps.setLong(index++, pojo.getUsuario().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// consegir el id generado
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					pojo.setId(rs.getLong(1));
					resul = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Comentario> getAll() throws Exception {

		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentarios.add(rowMapper(rs, comentario));
				}
			}
		}
		return comentarios;
	}

	public List<Comentario> getAllByActiveUser(Usuario pojo) throws Exception {
		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_USER);) {
			ps.setLong(1, pojo.getId());
			ps.setString(2, pojo.getNombre());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentarios.add(rowMapper(rs, comentario));
				}
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
	public boolean update(Comentario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);) {
			int index = 1;

			ps.setString(index++, pojo.getTexto());
			ps.setLong(index++, pojo.getVideo().getId());
			ps.setLong(index++, pojo.getUsuario().getId());
			ps.setLong(index++, pojo.getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// consegir el id generado
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					pojo.setId(rs.getLong(1));
					resul = true;
					System.out.println(rs.getLong(1));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	public boolean updateAprobado(Comentario pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE_APROBADO, Statement.RETURN_GENERATED_KEYS);) {
			int index = 1;

			ps.setBoolean(index++, pojo.isAprobado());
			ps.setLong(index++, pojo.getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// consegir el id generado
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					pojo.setId(rs.getLong(1));
					resul = true;
					System.out.println(rs.getLong(1));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Comentario rowMapper(ResultSet rs, Comentario c) throws Exception {
		if (c == null) {
			c = new Comentario();
		}
		if (rs != null) {
			c.setId(rs.getLong("id"));
			c.setAprobado(rs.getBoolean("aprobado"));
			Date fecha = (Date) rs.getTimestamp("fecha");
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));

			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("autor"));
			c.setUsuario(u);

			Video v = new Video();
			v.setId(rs.getLong("id_video"));
			v.setNombre(rs.getString("video_nombre"));
			c.setVideo(v);

		}
		return c;
	}

	@Override
	public Comentario getById(long id) throws Exception {
		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					comentario = rowMapper(rs, comentario);
				}
			}
		}
		return comentario;

	}

	@Override
	public boolean delete(String id) throws Exception {
		int affectedRows;
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {
			ps.setString(1, id);
			affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

}