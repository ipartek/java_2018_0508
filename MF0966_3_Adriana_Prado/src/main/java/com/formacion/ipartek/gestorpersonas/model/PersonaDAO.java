package com.formacion.ipartek.gestorpersonas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.formacion.ipartek.gestorpersonas.connection.ConnectionManager;
import com.formacion.ipartek.gestorpersonas.pojo.Persona;
import com.mysql.jdbc.Statement;

public class PersonaDAO implements Crudable<Persona> {
	private static PersonaDAO INSTANCE = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(PersonaDAO.class);

	private static final String SQL_LISTADO = "SELECT id, nombre, apellido1, apellido2, dni, email"
			+ " FROM persona ORDER BY id DESC" + " LIMIT 50;";

	private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido1, apellido2, dni, email)"
			+ "VALUES(?,?,?,?,?);";

	private static final String SQL_GET_BY_ID = "SELECT id, nombre, apellido1, apellido2, dni, email" + " FROM persona"
			+ " WHERE id = ?";

	private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, email = ? WHERE id = ?;";

	private static final String SQL_BUSCAR_POR_EMAIL = "SELECT id, nombre, apellido1, apellido2, dni, email"
			+ " FROM persona" + " WHERE email = ?";

	private static final String SQL_BUSCAR_POR_DNI = "SELECT id, nombre, apellido1, apellido2, dni, email"
			+ " FROM persona" + " WHERE dni = ?";

	private PersonaDAO() {
		super();
	}

	public static synchronized PersonaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Persona pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (pojo != null) {
				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getApellido1().trim());
				ps.setString(3, pojo.getApellido2().trim());
				ps.setString(4, pojo.getDni().trim());
				ps.setString(5, pojo.getEmail().trim());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					ResultSet rs = ps.getGeneratedKeys();
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
						resul = true;
					}
					rs.close();
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	@Override
	public List<Persona> getAll() throws Exception {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_LISTADO);) {
			ResultSet rs = ps.executeQuery();
			Persona persona = null;

			while (rs.next()) {
				persona = new Persona();

				persona.setId(rs.getLong("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido1(rs.getString("apellido1"));
				persona.setApellido2(rs.getString("apellido2"));
				persona.setDni(rs.getString("dni"));
				persona.setEmail(rs.getString("email"));

				personas.add(persona);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}

	@Override
	public Persona getById(String id2) throws Exception {
		Long id = (long) 0;
		if (id2 != null) {
			id = Long.parseLong(id2);
		}
		Persona p = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID);) {

			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery();) {
				// Obtener resultados

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					p = new Persona();
					p.setId(rs.getLong("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido1(rs.getString("apellido1"));
					p.setApellido2(rs.getString("apellido2"));
					p.setDni(rs.getString("dni"));
					p.setEmail(rs.getString("email"));
				}
			}

		}
		return p;
	}

	@Override
	public boolean update(Persona pojo) throws Exception {
		boolean resul = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {

			ps.setString(1, pojo.getNombre());
			ps.setString(2, pojo.getApellido1());
			ps.setString(3, pojo.getApellido2());
			ps.setString(4, pojo.getDni());
			ps.setString(5, pojo.getEmail());
			ps.setLong(6, pojo.getId());

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(String id) throws Exception {
		return false;
	}

	/**
	 * Metodo que llama la lectura del fichero para insertar masivamente personas en
	 * la BBDD
	 * 
	 * @param personas List<Persona> con todas las personas leidas del fichero ya
	 *                 listas para insertar
	 */
	public void insertMultiple(List<Persona> personas) {
		Persona pojo = null;
		int cont = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			for (int i = 0; i < personas.size(); i++) {
				pojo = personas.get(i);

				ps.setString(1, pojo.getNombre().trim());
				ps.setString(2, pojo.getApellido1().trim());
				ps.setString(3, pojo.getApellido2().trim());
				ps.setString(4, pojo.getDni().trim());
				ps.setString(5, pojo.getEmail().trim());

				int affectedRows = ps.executeUpdate();

				if (affectedRows == 1) {
					cont++;

					ResultSet rs = ps.getGeneratedKeys();
					while (rs.next()) {
						pojo.setId(rs.getLong(1));
					}
					rs.close();

				} else {
					LOG.error("Algo ha fallado");
				}
			}

			LOG.debug("Lineas correctas DAO: " + cont);

		} catch (Exception e) {
			LOG.error(e);
		}
	}

	/**
	 * Devuelve una lista con los registros cuyos nombres o apellidos contengan el
	 * String que se pasa por parametro
	 * 
	 * @param String palabra por la que se quiere encontrar a un Registro persona
	 * @return List<Persona> de los registros que coincidan con ese String
	 * @throws Exception
	 */
	public List<Persona> buscarNombre(String palabra) throws Exception {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"SELECT id, nombre, apellido1, apellido2, dni, email FROM persona WHERE nombre LIKE '%"
								+ palabra + "%' OR apellido1 LIKE '%" + palabra + "%' OR apellido2 LIKE '%" + palabra
								+ "%';");) {

			ResultSet rs = ps.executeQuery();
			Persona persona = null;

			while (rs.next()) {
				persona = new Persona();

				persona.setId(rs.getLong("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido1(rs.getString("apellido1"));
				persona.setApellido2(rs.getString("apellido2"));
				persona.setDni(rs.getString("dni"));
				persona.setEmail(rs.getString("email"));

				personas.add(persona);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return personas;
	}

	/**
	 * Buscar un registro persona a partir de un dni
	 * 
	 * @param dni String DNI de la persona que se quiere buscar
	 * @return Pojo Persona si lo encuentra, null si no lo encuentra
	 * @throws Exception
	 */
	public Persona buscarDni(String dni) throws Exception {
		Persona persona = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_POR_DNI);) {

			ps.setString(1, dni);

			try (ResultSet rs = ps.executeQuery();) {
				// Obtener resultados

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					persona = new Persona();
					persona.setId(rs.getLong("id"));
					persona.setNombre(rs.getString("nombre"));
					persona.setApellido1(rs.getString("apellido1"));
					persona.setApellido2(rs.getString("apellido2"));
					persona.setDni(rs.getString("dni"));
					persona.setEmail(rs.getString("email"));
				}
			}

		}
		return persona;
	}

	/**
	 * Busca un registro persona a partir de un email
	 * 
	 * @param dni String DNI de la persona que se quiere buscar
	 * @return Pojo Persona si lo encuentra, null si no existe una persona con dicho
	 *         email
	 * @throws Exception
	 */
	public Persona buscarEmail(String email) throws Exception {
		Persona persona = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_POR_EMAIL);) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery();) {
				// Obtener resultados

				// Mapear ResultSet al objeto o array objetos
				while (rs.next()) {
					persona = new Persona();
					persona.setId(rs.getLong("id"));
					persona.setNombre(rs.getString("nombre"));
					persona.setApellido1(rs.getString("apellido1"));
					persona.setApellido2(rs.getString("apellido2"));
					persona.setDni(rs.getString("dni"));
					persona.setEmail(rs.getString("email"));
				}
			}

		}
		return persona;
	}

}
