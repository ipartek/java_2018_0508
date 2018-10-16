package com.andrea.perez.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;
import com.mysql.jdbc.Statement;

public class VideoDAO implements Crudable<Video> {

	private static VideoDAO INSTANCE = null;
//	private final String SQL_GET_ALL = "SELECT id, codigo, nombre FROM video ORDER BY id DESC LIMIT 1000";
	private final String SQL_GET_ALL = "SELECT v.id as 'id_video', v.codigo, v.nombre as 'nombre_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario', u.password"
			+ " FROM youtube.video as v, youtube.usuario as u" + " WHERE v.id_usuario = u.id"
			+ " ORDER BY v.id DESC LIMIT 1000";
//	private final String SQL_GET_BY_ID = "SELECT id, codigo, nombre FROM video WHERE id = ? LIMIT 1000";
	private final String SQL_GET_BY_ID = "SELECT v.id as 'id_video', v.codigo, v.nombre as 'nombre_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario', u.password"
			+ " FROM youtube.video as v, youtube.usuario as u" + " WHERE v.id_usuario = u.id AND v.id = ? LIMIT 1000";
	private final String SQL_UPDATE = "UPDATE video SET codigo = ?, nombre = ?, id_usuario = ? WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre, id_usuario) VALUES (?, ?, ?);";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";

	private final String SQL_GET_ALL_TO_USER = "SELECT v.id as 'id_video', v.codigo, v.nombre as 'nombre_video', id_usuario as 'id_usuario', u.nombre as 'nombre_usuario', u.password"
			+ " FROM youtube.video as v, youtube.usuario as u" + " WHERE v.id_usuario = u.id AND v.id_usuario = ? LIMIT 1000";
	

	/*
	 * "SELECT u.id as 'id_usuario', u.nombre as 'nombre_usuario', u.password, id_rol as 'id_rol', r.nombre as 'rol_nombre'"
	 * +" FROM youtube.usuario as u, youtube.rol as r" +" WHERE u.id_rol = r.id"
	 * +" ORDER BY u.id DESC LIMIT 500";
	 */

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
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {
				// Obtener conexion bbdd
//				Connection con =  ConnectionManager.getConnection();

				// Ejecutar sql
//				PreparedStatement ps = con.prepareStatement(SQL_INSERT);
				ps.setString(1, pojo.getCodigo());
				ps.setString(2, pojo.getTitulo());
				ps.setLong(3, pojo.getUsuario().getId());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					// Conseguir id generado
					try (ResultSet rs = ps.getGeneratedKeys();) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));
							resul = true;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

//			//Obtener conexion bbdd
//			Connection con =  ConnectionManager.getConnection();
//			
//			//Ejecutar sql
//			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
//			
//			//Obtener resultados
//			ResultSet rs = ps.executeQuery();

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				videos.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	@Override
	public Video getById(String id2) {
		Long id = (long) 0;
		if (id2 != null) {
			id = Long.parseLong(id2);
		}
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
//			//Obtener conexion bbdd
//			Connection con =  ConnectionManager.getConnection();
//			
//			//Ejecutar sql
//			PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {
				// Obtener resultados
//				ResultSet rs = ps.executeQuery();

				// Mapear ResultSet al objeto o array objetos
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
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getTitulo());
			ps.setLong(3, pojo.getUsuario().getId());
			ps.setLong(4, pojo.getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean delete(String id2) {
		boolean resul = false;
		Long id = Long.parseLong(id2);

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, id.longValue());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

	public List<Video> getAllToUser(int id) {

		ArrayList<Video> videos = new ArrayList<Video>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_TO_USER);
				) {

			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				videos.add(rowMapper(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return videos;
	}

	private Video rowMapper(ResultSet rs) throws Exception {
		Video v = new Video();
		Usuario u = new Usuario();
		if (rs != null) {
			v.setId(rs.getLong("id_video"));
			v.setCodigo(rs.getString("codigo"));
			v.setTitulo(rs.getString("nombre_video"));

			try {

				u.setId(rs.getLong("id_usuario"));
				u.setNombre(rs.getString("nombre_usuario"));
				u.setContrasena(rs.getString("password"));
				v.setUsuario(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return v;
	}
}
