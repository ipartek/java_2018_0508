package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Video;

public class VideoDAO implements CrudAble<Video> {

	private static VideoDAO INSTANCE = null;
	private static List<Video> videos = null;

	private final String SQL_GET_ALL = "SELECT id, codigo, nombre, id_usuario FROM video ORDER BY id DESC LIMIT 50;";
	private final String SQL_GET_BY_ID = "SELECT id, codigo, nombre, id_usuario FROM video WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE video SET codigo = ?, nombre = ?, id_usuario = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO video (codigo,nombre,id_usuario) VALUES (?,?,?);";

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

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getIdUsuario());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				
				// conseguir id generado
				try (ResultSet rs = ps.getGeneratedKeys()){
					while(rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
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
		Video v = null;
		try (Connection con = ConnectionManager.getConnection();

		) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {

					v = rowMapper(rs);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public boolean update(Video pojo) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getCodigo());
			ps.setString(2, pojo.getNombre());
			ps.setLong(3, pojo.getIdUsuario());
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
	public boolean delete(String id) {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private Video rowMapper(ResultSet rs) throws Exception {
		Video v = new Video();
		if (rs != null) {
			v = new Video();
			v.setId(rs.getLong("id"));
			v.setCodigo(rs.getString("codigo"));
			v.setNombre(rs.getString("nombre"));
			v.setIdUsuario(rs.getLong("id_usuario"));
		}
		return v;
	}
}
