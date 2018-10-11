package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;
	private static UsuariosDaoJDBC usuariosJDBC;
	private static List<Video> videos = null;
	private final String SQL_GET_ALL = "SELECT v.id as 'video_id', codigo, v.nombre as 'nombre_video',id_usuario,  u.nombre as 'nombre_usuario' , u.id_rol as 'rol', r.nombre as 'rol_nombre' " + 
			" FROM video as v , usuario as u , rol as r"+
			" WHERE v.id_usuario = u.id AND u.id_rol = r.id"+
			" order by v.id asc limit 1000;";
	//private final String SQL_GET_ALL_1 = "select id,  codigo,nombre,id_usuario from video";
	
	private final String SQL_GET_BY_ID = "SELECT  v.id as 'video_id', codigo, v.nombre as 'nombre_video',id_usuario"+
			" FROM video as v"+
			" WHERE v.id = ?;";
	private final String SQL_UPDATE = "UPDATE video SET codigo= ? , nombre= ?,id_usuario= ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre, id_usuario) VALUES (?,?,?);";

	private VideoDAO() {
		videos = new ArrayList<Video>();
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

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);) {
			int index = 1;
			ps.setString(index++, pojo.getCodigo());
			ps.setString(index++, pojo.getNombre());
			ps.setInt(index,(int) pojo.getUsuario().getId());

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
	public List<Video> getAll() {
		usuariosJDBC = usuariosJDBC.getInstance();
		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				videos.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public Video getById(String id) {
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					video = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return video;
	}

	@Override
	public boolean update(Video pojo) {
		boolean resul = false;
		int affectedRows;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setInt(3, (int) pojo.getUsuario().getId());
			ps.setInt(4, (int) pojo.getId());
			affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return resul;
	}

	@Override
	public boolean delete(String id) {
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

	private Video rowMapper(ResultSet rs) throws Exception {
		Video video = new Video();
 		if (rs != null) {
			//asi cojeriamos con la query normal los datos ahora debemos usar los 
			//alias de la query
			/*video.setId(rs.getLong("id"));
			video.setCodigo(rs.getString("codigo"));
			video.setNombre(rs.getString("nombre"));
			Usuario usuario = new Usuario();
			usuario.setId( rs.getInt("id_usuario"));
			video.setUsuario_id(usuario);*/
			
			video.setId(rs.getLong("video_id"));
			video.setCodigo(rs.getString("codigo"));//este no usamos alias
			video.setNombre(rs.getString("nombre_video"));
			video.setUsuario(usuariosJDBC.getById(rs.getString("id_usuario")));//no es lo mas optimo
			
		}
		return video;
	}

}
