package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements CrudAble<Comentario> {

	private static ComentarioDAO INSTANCE = null;
	
	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT c.id as 'id_comentario', texto,  u.id as 'id_usuario', c.id_video, fecha, aprobado,  u.nombre as 'nombre_usuario', v.nombre as 'nombre_video'" +
												   " FROM comentario as c, usuario as u, video as v" +
												   " WHERE c.id_usuario = u.id AND c.id_video = v.id AND c.id_video = ? AND aprobado = '1'" +
												   " ORDER BY c.id DESC" +
												   " LIMIT 500;";
	
	private final String SQL_INSERT = "INSERT INTO comentario (texto,id_video,id_usuario) VALUES (?,?,?);";
	
	private final String SQL_GET_ALL_BY_APROBADO = "SELECT c.id as 'id_comentario', texto, v.id as 'id_video', v.nombre as 'nombre_video',  u.id as 'id_usuario', c.id_video, fecha, aprobado,  u.nombre as 'nombre_usuario'" + 
												   " FROM comentario as c, usuario as u, video as v" + 
												   " WHERE c.id_usuario = u.id AND c.id_video = v.id AND aprobado = ?" + 
												   " ORDER BY c.id DESC" + 
												   " LIMIT 500;";
	
	private final String SQL_APROBAR = "UPDATE comentario SET aprobado = 1 WHERE id IN "; // IN (1,3);
	
	private ComentarioDAO() {
		super();
	}

	public static synchronized ComentarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioDAO();
		}
		return INSTANCE;
	}
	
	public List<Comentario> getAllByVideo(long videoId) throws Exception {
		Comentario comentario = null;
		
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID)){
			
			ps.setLong(1, videoId);
			
			try(ResultSet rs = ps.executeQuery()){

				while (rs.next()) {
					comentarios.add(rowMapper(rs, comentario));
				}
			
			}
			
		}
		
		return comentarios;
	}
	
	public List<Comentario> getAllByAprobado(int aprobado) throws Exception {
		Comentario comentario = null;
		
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_APROBADO)){
			
			ps.setLong(1, aprobado);
						
			try(ResultSet rs = ps.executeQuery()){

				while (rs.next()) {
					comentarios.add(rowMapper(rs, comentario));
				}
			
			}
			
		}
		
		return comentarios;
	}
	
	public boolean aprobar(String[] ids) throws Exception {
		
		boolean resul = false;
		
		String in = "(";
		
		for (int i = 0; i < ids.length; i++) {
			
			if(i == (ids.length - 1)) {
				in += ids[i];
				
			}else {
				in += ids[i] + ",";
			}
			
		}
		
		in += ");";
		
		String sql = SQL_APROBAR + in;
					
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
	
			int affectedRows = ps.executeUpdate();
				
			if(affectedRows == ids.length) {
				resul = true;
			}
	
		} 
		
		return resul;
	}
	
	@Override
	public List<Comentario> getAll() throws Exception {
		 
		return null;
	}
	
	public boolean insert(Comentario pojo) throws Exception {
		boolean resul = false;
	
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
	
			ps.setString(1, pojo.getTexto().trim());			
			ps.setLong(2, pojo.getVideo().getId());
			ps.setLong(3, pojo.getUsuario().getId());
	
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try(ResultSet rs = ps.getGeneratedKeys()){
					while(rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
					}
				}
	
			}
	
		} 
		return resul;
	}

	@Override
	public Comentario getById(long id) throws Exception {
	
		return null;
	}
	
	public boolean update(Comentario pojo) throws Exception {
		
		return false;
	}

	@Override
	public boolean delete(long id) throws Exception {
		return false;
	}

	private Comentario rowMapper(ResultSet rs, Comentario c) throws Exception {
		if (c == null) {
			c = new Comentario();
		} 

		if (rs != null) {

			c.setId(rs.getLong("id_comentario"));
			c.setTexto(rs.getString("texto"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setAprobado(rs.getBoolean("aprobado"));
			
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			
			c.setUsuario(u);
			
			Video v = new Video();
			
			try {
				
				v.setId(rs.getLong("id_video"));
				v.setNombre(rs.getString("nombre_video"));
				
				c.setVideo(v);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return c;
	}

}