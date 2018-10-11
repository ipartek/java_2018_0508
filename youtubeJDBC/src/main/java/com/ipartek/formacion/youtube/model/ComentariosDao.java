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
 public class ComentariosDao implements CrudAble<Comentario> {
 	private static ComentariosDao INSTANCE = null;
 	private final String SQL_GET_ALL = "SELECT id, nombre FROM comentario ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_ALL_BY_VIDEO_ID = "SELECT 	c.id as 'id_comentario',    u.id as 'id_usuario',    fecha,    texto,    aprobado,    u.nombre "+ 
												  " FROM comentario as c , usuario as u " +
			                                      " WHERE c.id_usuario = u.id AND "+
												  " c.id_video = ? " +
												  " ORDER BY c.id DESC LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE comentario SET nombre= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM comentario WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO comentario ( texto ,id_video  ,id_usuario ) VALUES (?,?,?);";
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
 		//(, texto = ?,aprobado = ?,id_video = ? ,id_usuario = ?) VALUES (?,?,?,?,?)
 		boolean resul = false;
 		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);) {
			int index = 1;
			
			ps.setString(index++, pojo.getTexto());
			ps.setLong(index++, pojo.getVideo().getId());
			ps.setLong(index++, pojo.getUsuario().getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				
				//consegir el id generado 
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
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
 	@Override
	public List<Comentario> getAll() throws Exception {
		
		return null;
	}
	
	public List<Comentario> getAllByVideo(long videoId) throws Exception {
		
		Comentario comentario = null;
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_BY_VIDEO_ID);
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

 	@Override
	public boolean update(Comentario pojo) throws Exception {
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
	@Override
	public Comentario getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
 }