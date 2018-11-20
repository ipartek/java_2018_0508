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

public class ComentarioArrayDAO implements Crudable<Comentario>{
	
	private static ComentarioArrayDAO INSTANCE = null;
	private static List<Comentario> lista = null;
	public static final String NOT_APROBADO = "0";
	public static final String APROBADO = "1";
	
	//Consultas
	private final String SQL_GET_ALL = "SELECT c.id as 'id_comentario', c.fecha, c.texto, c.aprobado," 
										+ " c.id_usuario,"
										+ " u.nombre as 'nombre_usuario'"
										+ " FROM comentario as c, "
										+ " usuario as u"
										+ " WHERE c.id_usuario = u.id"
										+ " ORDER BY c.id DESC LIMIT 500";
	private final String SQL_GET_ALL_BY_APROBADO = "SELECT c.id as 'id_comentario', c.fecha, c.texto, c.aprobado, v.id as id_video, v.nombre as nombre_video, " 
										+ " c.id_usuario,"
										+ " u.nombre as 'nombre_usuario'"
										+ " FROM comentario as c, "
										+ " usuario as u, video v"
										+ " WHERE c.id_usuario = u.id AND aprobado = 0 AND c.id_video = v.id"
										+ " ORDER BY c.id DESC LIMIT 500";
	private final String SQL_GET_ALL_BY_VIDEO = "SELECT c.id as 'id_comentario', c.fecha, c.texto, c.aprobado," 
										+ " c.id_usuario,"
										+ " c.id_video,"
										+ " v.nombre as 'nombre_video',"
										+ " u.nombre as 'nombre_usuario'"
										+ " FROM comentario as c, "
										+ " video as v,"
										+ " usuario as u"
										+ " WHERE c.id_video = v.id AND "
										+ " c.id_usuario = u.id AND"
										+ " c.id_video = ? AND aprobado = 1"
										+ " ORDER BY c.id DESC LIMIT 500";
//	private final String SQL_GET_BY_ID = "SELECT v.id as 'id_video', v.codigo, v.nombre as 'nombre_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario', u.password"
//										+ " FROM youtube.video as v, youtube.usuario as u"
//										+ " WHERE v.id_usuario = u.id AND v.id = ? LIMIT 1000";
	private final String SQL_UPDATE = "UPDATE comentario SET texto = ?, aprobado = 1 WHERE id = ?;";
	private final String SQL_APROBAR = "UPDATE comentario SET aprobado = 1 WHERE id IN "; //(1,3);
	private final String SQL_INSERT = "INSERT INTO comentario (texto, id_video, id_usuario) VALUES (?, ?, ?);";
	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	
	private ComentarioArrayDAO() {
		super();
	}
	
	public static synchronized ComentarioArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ComentarioArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario comentario) throws Exception {
		boolean resul = false;
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			if(comentario != null) {
				ps.setString(1, comentario.getTexto().trim());
				ps.setLong(2, comentario.getVideo().getId());
				ps.setLong(3, comentario.getUsuario().getId());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					//Conseguir id generado
					ResultSet rs = ps.getGeneratedKeys();
					while(rs.next()) {
						comentario.setId(rs.getLong(1));
						resul = true;
					}
				}				
			}
		}
		return resul;
	}

	@Override
	public List<Comentario> getAll() throws Exception {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);){
			ResultSet rs = ps.executeQuery();
	
			//Mapear ResultSet a ArrayList
			while(rs.next()) {
				comentarios.add(rowMapper(rs));
			}
		}
		return comentarios;
	}
	
	public List<Comentario> getAllByAprobado() throws Exception {
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_APROBADO);){
			ResultSet rs = ps.executeQuery();
	
			//Mapear ResultSet a ArrayList
			while(rs.next()) {
				comentarios.add(rowMapper(rs));
			}
		}
		return comentarios;
	}
	
	public List<Comentario> getAllByVideo(Long idVideo) throws Exception {
		List<Comentario> listaComentarios = new ArrayList<Comentario>();
		try(Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO);){
				
				ps.setLong(1, idVideo);
				
				try (ResultSet rs = ps.executeQuery();){
					//Obtener resultados
					
					//Mapear ResultSet al objeto o array objetos
					while( rs.next() ) {
						listaComentarios.add(rowMapper(rs));				
					}	
				}
				
			}
		return listaComentarios;
	}

	@Override
	public Comentario getById(String id) {
		Comentario resul = null;
		
		return resul;
	}

	@Override
	public boolean update(Comentario comentarioUpdate) throws SQLException {
		boolean resul = false;
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
			
			ps.setString(1, comentarioUpdate.getTexto());
			ps.setLong(2, comentarioUpdate.getId());
			
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}	
		}
		return resul;
	}
	
	public boolean aprobar(String [] ids) throws SQLException {
		boolean resul = false;
		
		String in = "(";
		
		for(int i = 0; i<ids.length;i++) {
			
			if(i != ids.length-1) {
				in += ",";
			}else {
				in += ids[i];
			}
		}
		
		in += ");";
		
		String sql = SQL_APROBAR + in;
		
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			
//			ps.setLong(1, Long.parseLong(id));			
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == ids.length) {
				resul = true;
			}
			
			if(affectedRows == 1) {
				resul = true;
			}	
		}
		return resul;
	}

	@Override
	public boolean delete(String id2) throws Exception {
		boolean resul = false;
		Long id = Long.parseLong(id2);
				
		try(Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
				
			ps.setLong(1, id.longValue());
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}	
		}
		return resul;
	}
	
	public int length() {
		return lista.size();
	}
	
	private Comentario rowMapper(ResultSet rs) throws Exception{
		Comentario c = new Comentario();
		if(rs != null) {
			c.setId(rs.getLong("id_comentario"));
			c.setFecha(rs.getTimestamp("fecha"));
			c.setTexto(rs.getString("texto"));
			c.setAprobado(rs.getBoolean("aprobado"));
			
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			
			c.setUsuario(u);
			
			
			Video v = new Video();
			try {
				v.setId(rs.getLong("id_video"));
				v.setTitulo(rs.getString("nombre_video"));
				c.setVideo(v);
			}catch(Exception e) {
				
			}
		}
		return c;
	}
}