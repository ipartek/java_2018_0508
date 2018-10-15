package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

public class ComentarioDAO implements CrudAble<Comentario> {

	private static ComentarioDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT c.id, c.fecha, c.texto, c.aprobado, v.id as id_video, v.nombre as n_video,u.id as id_usuario, u.nombre as n_usuario "+
	"FROM Comentario as c "+
	"INNER JOIN Video as v ON c.id_video = v.id "+
	"INNER JOIN Usuario as u ON c.id_usuario = u.id;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM Comentario WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE Comentario SET texto = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM Comentario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO Comentario (texto, id_usuario, id_video) VALUES (?, ?, ?);";

	private final String SQL_GET_NO_APROBADOS = "SELECT c.id, c.fecha, c.texto, c.aprobado, v.id as id_video, v.nombre as n_video,u.id as id_usuario, u.nombre as n_usuario "+
			"FROM Comentario as c "+
			"INNER JOIN Video as v ON c.id_video = v.id "+
			"INNER JOIN Usuario as u ON c.id_usuario = u.id "+
			"WHERE c.aprobado = 0;";
	private final String SQL_UPDATE_APROBAR = "UPDATE Comentario" + 
			"SET aprobado = 1" + 
			"WHERE id IN (?);";
	
	private ComentarioDAO() {
		super();
	}

	public static synchronized ComentarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public boolean insert(Comentario pojo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comentario> getAll() throws Exception {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				comentarios.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * Devuelve comentarios no aprobados
	 * @return Devuelve lista vacia sino hay comentarios no aprobados
	 * @throws Exception
	 */
	public List<Comentario> getAllNoAprobado() throws Exception {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_NO_APROBADOS);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				comentarios.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}
	
	public boolean updateAprobarComentarios(String[] ids) throws Exception{
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE_APROBAR);) {

			ps.setArray(1,con.createArrayOf("id_aprobar", ids));

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}		
		return resul;
	}
	
	private Comentario rowMapper(ResultSet rs) throws Exception {
		Comentario c = new Comentario();
		if (rs != null) {
			c = new Comentario();
			c.setId(rs.getLong("id"));
			c.setFecha(rs.getDate("fecha"));
			c.setTexto(rs.getString("texto"));
			c.setAprobado(rs.getBoolean("aprobado"));
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("n_usuario"));
			c.setUsuario(u);
			Video v = new Video();
			v.setId(rs.getInt("id_video"));
			v.setNombre(rs.getString("n_video"));
			c.setVideo(v);
		}
		return c;
	}
	
}
