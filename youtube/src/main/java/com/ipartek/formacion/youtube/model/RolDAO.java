package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;

public class RolDAO implements CrudAble<Rol> {

	private static RolDAO INSTANCE = null;
	private static List<Rol> Rols = null;

	private final String SQL_GET_ALL = "SELECT id, nombre FROM Rol ORDER BY id DESC LIMIT 50;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM Rol WHERE id = ?;";
	private final String SQL_UPDATE = "UPDATE Rol SET nombre = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM Rol WHERE id = ?;";
	private final String SQL_INSERT = "INSERT INTO Rol (nombre) VALUES (?);";
	
	private final String SQL_NOMBRE_LIBRE = "SELECT id, nombre, password, rol FROM youtube.Rol  WHERE nombre LIKE ?;";
	private final String SQL_Rol = "SELECT id, nombre, password, rol FROM youtube.Rol  WHERE nombre LIKE ? AND password LIKE ?;";

	private RolDAO() {
		Rols = new ArrayList<Rol>();
	}

	public static synchronized RolDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Rol pojo) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, pojo.getNombre().trim());

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

		} 
		return resul;
	}

	@Override
	public List<Rol> getAll() throws Exception {

		ArrayList<Rol> Rols = new ArrayList<Rol>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Rols.add(rowMapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Rols;
	}

	@Override
	public Rol getById(String id) throws Exception{
		Rol u = null;
		try (Connection con = ConnectionManager.getConnection();

		) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {

					u = rowMapper(rs);

				}
			}

		} 
		return u;
	}

	@Override
	public boolean update(Rol pojo) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setLong(2, pojo.getId());

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} 
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception{
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {

			ps.setString(1, id);

			int affectedRows = ps.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		} 
		return resul;
	}
	/**
	 * Funcion que comprueba si el nombre esta en la BBDD
	 * @param nombre
	 * @return devuelve true si el nombre esta en la BBDD
	 */
	public boolean mirarNombre(String nombre) {
		boolean resul = false;
		Rol u = null;
		try (Connection con = ConnectionManager.getConnection();

				) {
					try (PreparedStatement ps = con.prepareStatement(SQL_NOMBRE_LIBRE);) {
						ps.setString(1, nombre);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							
							u = rowMapper(rs);

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		if (u != null) {
			resul = true;
		}
		return resul;
	}

	public Rol comprobarRol(String nombre,String contrasenya) {
		Rol u = null;
		try (Connection con = ConnectionManager.getConnection();

				) {
					try (PreparedStatement ps = con.prepareStatement(SQL_Rol);) {
						ps.setString(1, nombre);
						ps.setString(2, contrasenya);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							
							u = rowMapper(rs);

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return u;
	}
	
	private Rol rowMapper(ResultSet rs) throws Exception {
		Rol u = new Rol();
		if (rs != null) {
			u = new Rol();
			u.setId(rs.getLong("id"));
			u.setNombre(rs.getString("nombre"));

		}
		return u;
	}
}
