package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import java.sql.CallableStatement;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT v.id as 'id_video', v.codigo as 'codigo_video', v.nombre as 'nombre_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario'" +
										" FROM video as v, usuario as u" +
										" WHERE v.id_usuario = u.id" +
										" ORDER BY v.id DESC LIMIT 1000;";
		
	private final String SQL_GET_BY_ID = "SELECT v.id as 'id_video', v.nombre as 'nombre_video', v.codigo as 'codigo_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario'" + 
										" FROM video as v, usuario as u" + 
										" WHERE v.id_usuario = u.id AND v.id = ?;";
	
	
	private final String SQL_UPDATE = "UPDATE video SET codigo= ?, nombre= ?, id_usuario = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre, id_usuario) VALUES (?,?,?);";
	

	private VideoDAO() {
		super();
	}

	public static synchronized VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) throws Exception {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);){
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getUsuario().getId());
			
			int affectedRows = ps.executeUpdate();
			if ( affectedRows == 1 ) {
				//Conseguir ID generado
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
	public List<Video> getAll() throws Exception {
		
		Video video = null;

		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
			){
			
			try(ResultSet rs = ps.executeQuery()){
			
				while (rs.next()) {				
					videos.add( rowMapper(rs, video) );
				}
			
			}

		} 

		return videos;
	}

	@Override
	public Video getById(long id) throws Exception {
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID); 
			){
						
			ps.setLong(1, id);
			
			try(ResultSet rs = ps.executeQuery()){			
				while (rs.next()) {
					video = rowMapper(rs, video);
				}
			}
			
		}

		return video;
	}

	@Override
	public boolean update(Video pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());	
			ps.setLong(3, pojo.getUsuario().getId());
			ps.setLong(4, pojo.getId());				
			if ( ps.executeUpdate() == 1 ) {
				resul = true;
			}			
			
		}
		return resul;
	}

	@Override
	public boolean delete(long id) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
			
			ps.setLong(1, id);			
			if ( ps.executeUpdate() == 1 ) {
				resul = true;
			}			
			
		}
		return resul;
	}
	
	
	private Video rowMapper(ResultSet rs, Video v) throws Exception {
		
		if(v == null) {
			v = new Video();
		}
		
		if( rs != null) {
			v.setId(rs.getLong("id_video"));
			v.setCodigo(rs.getString("codigo_video"));
			v.setNombre(rs.getString("nombre_video"));
			
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setNombre(rs.getString("nombre_usuario"));
			
			v.setUsuario(u);
		}
		return v;
	}
	
	public String ejemploPA(long idVideo) {
		
		String resul = "PETA FIJO";
		String sql = "{CALL `ejemplo`(?)}";	//Siempre entre llaves
		
		try(Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall(sql)) {
			
			//Preparar parámetros
			cs.setLong(1, idVideo);
			
			//Ejecutar cs
			try(ResultSet rs = cs.executeQuery()){
							
				//TODO Mapear los datos
				while(rs.next()) {
					resul = rs.getString("nombre");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resul += " causa:" + e.getCause();
		}
		
		return resul;
	}
	
	

}
