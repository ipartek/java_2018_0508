package com.formaciion.ipartek.gestor.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.formaciion.ipartek.gestor.conection.ConnectionManager;
import com.formaciion.ipartek.gestor.pojo.Persona;
import com.mysql.jdbc.Statement;

public class PersonaDAO {

	private static PersonaDAO INSTANCE = null;
	
	private static final String SQL_LISTAR = " SELECT id,nombre,apellido1,apellido2,email,dni FROM gestor_persona.persona ORDER BY id DESC LIMIT 50;";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido1,apellido2,email,dni) VALUES (?, ?,?,?,?);";
	private static final String SQL_GET_BY_ID = "SELECT id,nombre,apellido1,apellido2,email,dni FROM gestor_persona.persona WHERE id=?;";
	private static final String SQL_GET_BY_DNI = "SELECT id,nombre,apellido1,apellido2,email,dni FROM gestor_persona.persona WHERE dni=?;";
	private static final String SQL_GET_BY_EMAIL = "SELECT id,nombre,apellido1,apellido2,email,dni FROM gestor_persona.persona WHERE email=?;";
	private static final String SQL_GET_BY_NOMBRE_APELLIDOS = "SELECT id,nombre,apellido1,apellido2,email,dni FROM gestor_persona.persona WHERE nombre LIKE \"?%\" AND apellido1 LIKE \"?%\" AND apellido2 LIKE \"?%\";";
	
	private static final String SQL_UPDATE = "UPDATE persona SET nombre= ? ,apellido1= ?,apellido2=?,email=?,dni=? WHERE id = ?;";

	public static synchronized PersonaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAO();
		}
		return INSTANCE;
	}

	public List<Persona> listar() throws SQLException, Exception {
		List<Persona> personas = new ArrayList<Persona>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LISTAR);
				ResultSet rs = ps.executeQuery();) {

			// Mapear ResultSet a ArrayList
			while (rs.next()) {
				personas.add(rowMapper(rs));
			}

		}

		return personas;
	}

	public boolean insert(Persona pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {

				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getApellido1().trim());
				ps.setString(3, pojo.getApellido2().trim());
				ps.setString(4, pojo.getEmail());
				ps.setString(5, pojo.getDni());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						while (rs.next()) {
							pojo.setId(rs.getLong(1));// devuelve el valor de la primera columna "id" de la bbdd
							resul = true;
						}
					}

				}
			}
		}
		return resul;
	}

	public boolean modificar(Persona p) throws SQLException, Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido1());
			ps.setString(3, p.getApellido2());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getDni());
			ps.setLong(6, p.getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	public Persona buscarPorId(String idtem) throws SQLException, Exception {
		long id = 0;
		if (idtem != null) {
			id = Long.parseLong(idtem);
		}
		Persona p = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					p = rowMapper(rs);
				}
			}

		}

		return p;
	}
	
	public Persona buscarPorDni(String dni) throws SQLException, Exception {
		
		Persona p = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setString(1, dni);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					p = rowMapper(rs);
				}
			}

		}

		return p;
	}
	
public Persona buscarPorEmail(String email) throws SQLException, Exception {
		
		Persona p = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_EMAIL);) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					p = rowMapper(rs);
				}
			}

		}

		return p;
	}
	
	
	public static List<Persona>buscarNombreApellido(String cadena) throws SQLException, Exception {
		
		Persona p=new Persona();
		
		List<Persona> personas = new ArrayList<Persona>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {
		
			ps.setString(1, cadena);
			ps.setString(2, cadena);
			ps.setString(3, cadena);

			try (ResultSet rs = ps.executeQuery();) {

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					p = rowMapper(rs);
					personas.add(p);
				}
			}

		}

		return personas;
	}
	

	private static Persona rowMapper(ResultSet rs) throws Exception {
		Persona p = new Persona();

		if (rs != null) {
			p.setId(rs.getLong("id"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido1(rs.getString("apellido1"));
			p.setApellido2(rs.getString("apellido2"));
			p.setEmail(rs.getString("email"));
			p.setDni(rs.getString("dni"));

		}
		return p;
	}

}
