package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;

public class RolDao implements CrudAble<Rol> {

	private static RolDao INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT  id,  nombre FROM rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE rol SET nombre= ?  WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM rol WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO rol ( nombre) VALUES (?);";

	public static synchronized RolDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDao();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Rol pojo) {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {

				// consegir el id generado
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					pojo.setId(rs.getInt(1));
					resul = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public List<Rol> getAll() {

		ArrayList<Rol> roles = new ArrayList<Rol>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				roles.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return roles;
	}

	@Override
	public Rol getById(String id) throws Exception{
		Rol rol = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					rol = rowMapper(rs);
				}
			}

		} 

		return rol;
	}

	@Override
	public boolean update(Rol pojo) {
		boolean resul = false;
		int affectedRows;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, pojo.getNombre());
			ps.setInt(2, pojo.getId());
			
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

	private Rol rowMapper(ResultSet rs) throws Exception {
		Rol rol = new Rol();
		if (rs != null) {
			rol.setId(rs.getInt("id"));
			rol.setNombre(rs.getString("nombre"));
		}
		return rol;
	}

}
