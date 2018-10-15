package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class ComentarioDAO implements CrudAble<Comentario>{
	
	private static ComentarioDAO INSTANCE = null;
	
	private final String SQL_GET_ALL_BY_VIDEO = "SELECT c.id as 'id_comentario', c.id_usuario as 'id_usuario', fecha, texto, aprobado, u.nombre FROM comentario as c, usuario as u WHERE c.id_usuario = u.id AND c.id_video = ? AND aprobado = 1 ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_ALL_MODERATE = "SELECT c.id as 'id_comentario', c.id_usuario as 'id_usuario', fecha, texto, aprobado, u.nombre FROM comentario as c, usuario as u WHERE c.id_usuario = u.id AND aprobado = 0 ORDER BY c.id DESC LIMIT 500;";
	
	private final String SQL_GET_ALL = "SELECT c.id as 'id_comentario', c.id_usuario as 'id_usuario', fecha, texto, aprobado, u.nombre FROM comentario as c, usuario as u WHERE c.id_usuario = u.id ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "";
	private final String SQL_UPDATE = "";
	private final String SQL_DELETE = "";
	private final String SQL_INSERT = "INSERT INTO `comentario` (`texto`, `id_video`, `id_usuario`) VALUES (?, ?, ?);";
	
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
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getTexto().trim());
			ps.setLong(2, pojo.getVideo().getId());
			ps.setLong(3, pojo.getUsuario().getId() );

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				try ( ResultSet rs = ps.getGeneratedKeys() ){
					while( rs.next() ) {
						pojo.setId( rs.getLong(1) );
						resul = true;						
					}
				}			

			}

		} 
		return resul;
	}

	@Override
	public List<Comentario> getAll() throws Exception {
		Comentario comentario = null;

		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				comentarios.add(rowMapper(rs, comentario));
			}

		}
		return comentarios;
	}
	
	/**
	 * Recuperar comentarios por video
	 * @param videoId
	 * @return comentarios
	 * @throws Exception
	 */
	public List<Comentario> getAllByVideo(long videoId) throws Exception {
		
		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO);
				) {
 				ps.setLong(1, videoId);
				
				try(ResultSet rs = ps.executeQuery()){			
					while (rs.next()) {
						comentarios.add(rowMapper(rs, comentario));
					}
				}	
 		}
		return comentarios;
	}
	
	/**
	 * Recuperar todos los comentarios que necesiten moderacion
	 * @return comentariosModerar
	 * @throws Exception
	 */
	public List<Comentario> getAllModerar() throws Exception {
		
		Comentario comentario = null;
		ArrayList<Comentario> comentariosModerar = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_MODERATE);
				) {
				
				try(ResultSet rs = ps.executeQuery()){			
					while (rs.next()) {
						comentariosModerar.add(rowMapper(rs, comentario));
					}
				}				
						
 		}
		return comentariosModerar;
	}

	@Override
	public Comentario getById(String id) throws Exception {
		return null;
	}

	@Override
	public boolean update(Comentario pojo) throws Exception {
		return false;
	}

	@Override
	public boolean delete(String id) throws Exception {
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
			
			Usuario u = new Usuario();
			u.setId( rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre"));			
			c.setUsuario(u);
		}
		return c;
	}

}
