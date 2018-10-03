package com.adriana.prado.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adriana.prado.pojo.Video;
import com.mysql.jdbc.Statement;

public class VideoDAO implements Crudable<Video> {
	
	private static VideoDAO INSTANCE = null;
	private final String SQL_GET_ALL = "SELECT id, codigo, nombre FROM video ORDER BY id DESC LIMIT 1000";
	private final String SQL_GET_BY_ID = "SELECT id, codigo, nombre FROM video WHERE id = ? LIMIT 1000";
	private final String SQL_UPDATE = "UPDATE video SET codigo = ?, nombre = ? WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre) VALUES (?, ?);";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	
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
	public boolean insert(Video pojo) {
		boolean resul = false;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				){
			if(pojo != null) {
				//Obtener conexion bbdd
//				Connection con =  ConnectionManager.getConnection();
				
				//Ejecutar sql
//				PreparedStatement ps = con.prepareStatement(SQL_INSERT);
				ps.setString(1, pojo.getCodigo());
				ps.setString(2, pojo.getTitulo());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					//Conseguir id generado
					try (ResultSet rs = ps.getGeneratedKeys();) {
						while(rs.next()) {
							pojo.setId(rs.getLong(1));
							resul = true;
						}
					}
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();
				){
			
//			//Obtener conexion bbdd
//			Connection con =  ConnectionManager.getConnection();
//			
//			//Ejecutar sql
//			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
//			
//			//Obtener resultados
//			ResultSet rs = ps.executeQuery();
			
			//Mapear ResultSet a ArrayList
			while(rs.next()) {
				videos.add(rowMapper(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}

	@Override
	public Video getById(String id2) {
		Long id = (long) 0;
		if(id2 != null) {
			id = Long.parseLong(id2);
		}
		Video video = null;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);
				){
//			//Obtener conexion bbdd
//			Connection con =  ConnectionManager.getConnection();
//			
//			//Ejecutar sql
//			PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);
			
			ps.setLong(1, id);
			
			try (ResultSet rs = ps.executeQuery();){
				//Obtener resultados
//				ResultSet rs = ps.executeQuery();
				
				//Mapear ResultSet al objeto o array objetos
				while( rs.next() ) {
					video = rowMapper(rs);					
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return video;
	}

	@Override
	public boolean update(Video pojo) {
		boolean resul = false;
		try (Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);){
				
				ps.setString(1, pojo.getCodigo());
				ps.setString(2, pojo.getTitulo());
				ps.setLong(3, pojo.getId());
				
				int affectedRows = ps.executeUpdate();
				
				if(affectedRows == 1) {
					resul = true;
				}	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return resul;
	}

	@Override
	public boolean delete(String id2) {
		boolean resul = false;
		Long id = Long.parseLong(id2);
		
		try (Connection con =  ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);){
			
			ps.setLong(1, id.longValue());
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 1) {
				resul = true;
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}

	private Video rowMapper(ResultSet rs) throws Exception{
		Video v = new Video();
		if(rs != null) {
			v.setId(rs.getLong("id"));
			v.setCodigo( rs.getString("codigo"));
			v.setTitulo(rs.getString("nombre"));
		}
		return v;
	}
}
