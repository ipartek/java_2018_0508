package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class RolDAO implements CrudAble<Rol> {

	private static RolDAO INSTANCE = null;

	private final String SQL_GET_ALL = "SELECT idRol, nombre FROM rol ORDER BY idRol ASC LIMIT 1000;";
	private final String SQL_GET_BY_ID = "SELECT idRol, nombre FROM rol WHERE idRol = ?;";
	private final String SQL_GET_BY_NAME = "SELECT idRol, nombre FROM rol WHERE nombre = ?;";
	
	private final String SQL_INSERT = "INSERT INTO ROL (nombre) VALUES (?);";
	private final String SQL_UPDATE = "UPDATE rol SET nombre = ? WHERE idRol = ?;";
	private final String SQL_DELETE = "DELETE FROM rol WHERE idUsuario = ?;";

	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}
		return INSTANCE;
	}

	//------------ GETTERS ---------------//
	//-----------------------------------//
	@Override
	public List<Rol> getAll() throws SQLException {
		ArrayList<Rol> roles = new ArrayList<Rol>();

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				roles.add(rowMapper(rs)); // Mapear ResultSet
			}
		} 

		return roles;
	}

	@Override
	public Rol getById(long l) throws SQLException {
		Rol rol = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, l);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					rol = rowMapper(rs);
				}

			}
		} 

		return rol;
	}
	
	public Rol getByName(String usuarioNombre) throws SQLException {
		Rol rol = null;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_GET_BY_NAME);) {

			ps.setString(1, usuarioNombre);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					rol = rowMapper(rs);
				}

			}
		} 
		return rol;
	}
	
	//------------ SETTERS ---------------//
	//-----------------------------------//
	@Override
	public boolean insert(Rol pojo) throws SQLException {
		boolean result = false;

		Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, pojo.getNombre());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {

				// Conseguir ID generado
				try (ResultSet rs = ps.getGeneratedKeys()) {

					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						result = true;
					}
				}
			}

		return result;
	}

	@Override
	public boolean update(Rol pojo) throws SQLException {
		boolean result = false;
		
		try (Connection cnx = ConnectionManager.getConnection();
			PreparedStatement ps = cnx.prepareStatement(SQL_UPDATE)) {

			ps.setString(1, pojo.getNombre());
			ps.setLong  (3, pojo.getId());
			
			if (ps.executeUpdate() == 1 ) {
				result = true;
			}			
		}
	
		return result;
	}

	@Override
	public boolean delete(long l) throws SQLException {
		boolean result = false;

		try (Connection cnx = ConnectionManager.getConnection();
				PreparedStatement ps = cnx.prepareStatement(SQL_DELETE);) {

			ps.setLong(1, l);			
			
			if ( ps.executeUpdate() == 1 ) {
				result = true;
			}
		}

		return result;
	}
	
	
	//--------- PRIVATE FUNCITONS --------//
	//-----------------------------------//
	private Rol rowMapper(ResultSet rs) throws SQLException {

		Rol rol = new Rol();

		if (rs != null) {

			rol.setId(rs.getLong("idRol"));
			rol.setNombre(rs.getString("nombre"));
			
		}

		return rol;
	}

}
