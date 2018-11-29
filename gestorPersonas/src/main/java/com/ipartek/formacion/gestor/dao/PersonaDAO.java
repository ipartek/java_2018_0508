package com.ipartek.formacion.gestor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.gestor.connection.ConnectionManager;
import com.ipartek.formacion.gestor.pojo.Persona;

public class PersonaDAO {
	private static PersonaDAO INSTANCE = null;

	private static final Logger LOG = Logger.getLogger(PersonaDAO.class);

	private static final String SQL_ULTIMOS_50 = "SELECT id, nombre, apellido1, apellido2, email, dni FROM personas ORDER BY id DESC LIMIT 50;";
	private static final String SQL_BUSCAR_DNI = "SELECT id, nombre, apellido1, apellido2, email, dni FROM personas WHERE dni LIKE ?";
	private static final String SQL_BUSCAR_EMAIL = "SELECT id, nombre, apellido1, apellido2, email, dni FROM personas WHERE email LIKE ?";
	private static final String SQL_BUSCAR_NOMBRE_APELLIDO1_APELLIDO2 = "SELECT id, nombre, apellido1, apellido2, email, dni FROM personas WHERE nombre LIKE ? OR apellido1 LIKE ? OR apellido2 LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO `personas` (`nombre`, `apellido1`, `apellido2`, `email`, `dni`) VALUES ( ?, ?, ?, ?, ? );";
	private static final String SQL_UPDATE = "UPDATE personas SET nombre = ?, apellido1 = ?, apellido2 = ?, email = ?, dni = ? WHERE id = ?";
	private static final String SQL_PERSONA_ID = "SELECT id, nombre, apellido1, apellido2, email, dni FROM personas WHERE id = ?";

	private PersonaDAO() {
		super();
	}

	public static synchronized PersonaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAO();
		}
		return INSTANCE;
	}

	public Persona getById(long id) {
		Persona p = new Persona();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_PERSONA_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setEmail(rs.getString("email"));
				p.setDni(rs.getString("dni"));
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return p;
	}

	public List<Persona> getAll() {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_ULTIMOS_50);
				ResultSet rs = pst.executeQuery();) {

			Persona p = null;
			while (rs.next()) {

				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setEmail(rs.getString("email"));
				p.setDni(rs.getString("dni"));

				personas.add(p);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}
	
	public List<Persona> getAllDni(String palabra) {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_BUSCAR_DNI);) {
			
			pst.setString(1, "%"+palabra+"%");
			
			ResultSet rs = pst.executeQuery();
			
			Persona p = null;
			while (rs.next()) {

				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setEmail(rs.getString("email"));
				p.setDni(rs.getString("dni"));

				personas.add(p);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}
	
	public List<Persona> getAllEmail(String palabra) {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_BUSCAR_EMAIL);) {

			pst.setString(1, "%"+palabra+"%");
			
			ResultSet rs = pst.executeQuery();
			
			Persona p = null;
			while (rs.next()) {

				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setEmail(rs.getString("email"));
				p.setDni(rs.getString("dni"));

				personas.add(p);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}
	
	public List<Persona> getAllNombreApellidos(String palabra) {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_BUSCAR_NOMBRE_APELLIDO1_APELLIDO2);) {

			pst.setString(1, "%"+palabra+"%");
			pst.setString(2, "%"+palabra+"%");
			pst.setString(3, "%"+palabra+"%");
			
			ResultSet rs = pst.executeQuery();

			Persona p = null;
			while (rs.next()) {

				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setEmail(rs.getString("email"));
				p.setDni(rs.getString("dni"));

				personas.add(p);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}

	public boolean crear(Persona persona) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellido1());
			pst.setString(3, persona.getApellido2());
			pst.setString(4, persona.getEmail());
			pst.setString(5, persona.getDni());

			int affetcedRows = pst.executeUpdate();
			if (affetcedRows == 1) {

				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						persona.setId(rs.getLong(1));
						resul = true;
					}

				}

			}

		}

		return resul;
	}

	public boolean modificar(Persona persona) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellido1());
			pst.setString(3, persona.getApellido2());
			pst.setString(4, persona.getEmail());
			pst.setString(5, persona.getDni());
			pst.setLong(6, persona.getId());

			int affetcedRows = pst.executeUpdate();
			if (affetcedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

}
