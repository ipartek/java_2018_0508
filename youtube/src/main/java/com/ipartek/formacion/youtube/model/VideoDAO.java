package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public class VideoDAO implements CrudAble<Video> {

	private final String SQL_GET_ALL = "SELECT id,codigo,nombre FROM video ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT id,codigo,nombre FROM video WHERE id= ?;";
	private final String SQL_UPDATE = "UPDATE video SET codigo  = ?, nombre=? WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo, nombre)VALUES(?,?);";
	private final String SQL_DELETE = "DELETE FROM video WHERE id=?>;";

	private static VideoDAO INSTANCE = null;

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
		boolean resul=false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {
			
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			
			int affectedRows= ps.executeUpdate();
			if (affectedRows==1) {
				resul=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resul;
	}

	@Override
	public List<Video> getAll() {
		// Creamos el array que devolveremos siempre
		ArrayList<Video> videos = new ArrayList<Video>();

		// obtener conexion a la BBDD

		// ejecutar sql

		// obtener los resultados
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			// mapear ResultSet a ArrayList
			Video v = null;
			while (rs.next()) {
				videos.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	@Override
	public boolean update(Video pojo) {
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getId());
			int affectedRows= ps.executeUpdate();
			if (affectedRows==1) {
				resul=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}

	@Override
	public Video getById(String id) {
		Video video = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			video = new Video();
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
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
	public boolean delete(String id) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {
			ps.setString(1, id);
			int affectedRows= ps.executeUpdate();
			if (affectedRows==1) {
				resul=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Video rowMapper(ResultSet rs) throws Exception {
		Video v = new Video();
		if (rs != null) {
			v.setId(rs.getLong("id"));
			v.setCodigo(rs.getString("codigo"));
			v.setNombre(rs.getString("nombre"));
		}
		return v;

	}
}
