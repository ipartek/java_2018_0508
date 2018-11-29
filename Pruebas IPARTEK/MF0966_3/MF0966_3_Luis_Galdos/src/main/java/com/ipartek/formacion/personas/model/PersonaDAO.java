package com.ipartek.formacion.personas.model;

import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.ipartek.formacion.personas.connection.ConnectionManager;
import com.ipartek.formacion.personas.pojo.Persona;
import com.mysql.jdbc.Statement;

public class PersonaDAO implements CrudAble<Persona> {

	private static final Logger LOG = Logger.getLogger(PersonaDAO.class);
	
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido1, apellido2, dni, email, rol)"
			+ " VALUES (?, ? , ? , ? , ? , ? )";
	
	private static final String SQL_BUSQUEDA = 
			"SELECT * FROM persona WHERE dni LIKE ?"
			+ " OR nombre LIKE ?"
			+ " OR email LIKE ?"
			+ " LIMIT 100";

	private static PersonaDAO INSTANCE = null;

	public static synchronized PersonaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAO();
		}
		return INSTANCE;
	}

	private PersonaDAO() {
		super();
	}

	/* GETTERS */
	// ----------------------------------------------//
	@Override
	public List<Persona> getAll() throws Exception {

		ArrayList<Persona> Personas = new ArrayList<Persona>();
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaGetAll}");) {

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					Personas.add(rowMapper(rs));
				}
			}
		}

		return Personas;
	}

	/* SETTERS */
	// ----------------------------------------------//
	@Override
	public Persona getById(long id) throws Exception {
		Persona a = null;
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaGetById(?)}");) {

			// Se cargan los parametros de entrada
			sp.setLong("p_id", id);// Tipo String

			// Se ejecuta el procedimiento almacenado

			try (ResultSet rs = sp.executeQuery();) {
				while (rs.next()) {
					a = rowMapper(rs);

				}
			}
		}
		return a;

	}

	@Override
	public boolean insert(Persona pojo) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaInsert(?, ?, ?, ?, ?, ?, ?)}");) {

			// Se cargan los parametros de entrada
			sp.setString("p_nombre", pojo.getNombre());
			sp.setString("p_apellido1", pojo.getApellido1());
			sp.setString("p_apellido2", pojo.getApellido2());
			sp.setString("p_dni", pojo.getDni());
			sp.setString("p_mail", pojo.getEmail());
			sp.setString("p_rol", pojo.getRol());

			// Se registra parametros de salida
			sp.registerOutParameter("o_id", Types.INTEGER);

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			int id = sp.getInt("o_id");
			pojo.setId(id);

			if (resultado == 1) {

				resul = true;

			}

		}
		return resul;
	}

	public void insertMultiple(ArrayList<Persona> personas) throws SQLException {

		final int BATCH_SIZE = 1000;
		int count = 0;		// Si count % 1000 -> executeBatch()
		int successCount = 0;
		int failCount = 0;
		int notAavailable = 0;
		int ind = 0;	// Nos dirá el bloque de inserción actual

		

		try (Connection con = ConnectionManager.getConnection()) {

			PreparedStatement ps = con.prepareStatement(SQL_INSERT);

			try {
				
				LOG.debug("Se van a insertar " + personas.size() + " registros.");
				LOG.debug("Por favor, espere...");
				
				LOG.debug("Preparando BATCH Nº " + ( ind+1 ));
				
				for (Persona pojo : personas) {

					
					// Se cargan los parametros de entrada
					ps.setString(1, pojo.getNombre());
					ps.setString(2, pojo.getApellido1());
					ps.setString(3, pojo.getApellido2());
					ps.setString(4, pojo.getDni());
					ps.setString(5, pojo.getEmail());
					ps.setString(6, pojo.getRol());

					ps.addBatch();

					if (++count % BATCH_SIZE == 0) {	// INSERT 1000 ROWS
						
						ps.executeBatch();
						ind++;			// Siguiente bloque de inserciones 
						
						LOG.debug(count + " registros insertados.");
						LOG.debug("Preparando BATCH Nº " + ( ind+1 ));
						LOG.debug("Por favor, espere...");
					}
				}
				
				LOG.debug("Insertando " + ( count - BATCH_SIZE * ind )+ " registros restantes...");
				ps.executeBatch(); // INSERT REMAINING RECORDS

			} catch (BatchUpdateException buex) {

				buex.printStackTrace();

				LOG.error(buex);

				int[] updateCounts = buex.getUpdateCounts();

				for (int i = 0; i < updateCounts.length; i++) {

					if (updateCounts[i] >= 0) {
						
						successCount++;

					} else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
						
						notAavailable++;

					} else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
						
						failCount++;
						LOG.debug("Falló al insertar el registro:" + i + ( BATCH_SIZE * ind ));

					} 
				}
				
			} finally {

				LOG.info("Número de filas insertadas antes del Batch Error: " + successCount);
				LOG.info("Número de filas con estado No Disponible durante el Batch:" + notAavailable);
				LOG.info("Número de filas que produjeron errores durante el Batch:" + failCount);
				ps.close();
				con.close();
			}
		}

	}

	@Override
	public boolean delete(String id) throws Exception {
		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaDelete(?)}");) {

			// Se cargan los parametros de entrada
			sp.setInt("p_id", Integer.parseInt(id));

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			if (resultado == 1) {

				resul = true;

			}
		}
		return resul;

	}

	@Override
	public boolean update(Persona pojo) throws Exception {

		boolean resul = false;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaUpdate(?, ?, ?, ?, ?, ?, ?)}");) {

			// Se cargan los parametros de entrada

			sp.setLong("p_id", pojo.getId());
			sp.setString("p_nombre", pojo.getNombre());
			sp.setString("p_apellido1", pojo.getApellido1());
			sp.setString("p_apellido2", pojo.getApellido2());
			sp.setString("p_dni", pojo.getDni());
			sp.setString("p_email", pojo.getEmail());
			sp.setString("p_rol", pojo.getRol());

			// Se ejecuta el procedimiento almacenado
			int resultado = sp.executeUpdate();

			if (resultado == 1) {
				resul = true;

			}
		}
		return resul;
	}
	
	public ArrayList<Persona> buscar(String txtBusqueda) throws SQLException {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		LOG.debug( txtBusqueda );
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_BUSQUEDA);) {

				ps.setString(1, "%" + txtBusqueda + "%");
				ps.setString(2, "%" + txtBusqueda + "%");
				ps.setString(3, txtBusqueda);
				
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					personas.add(rowMapper(rs));
				}
			}
		}
		
		LOG.debug(personas.size() + " personas encontradas.");

		return personas;
	}

	private Persona rowMapper(ResultSet rs) throws SQLException {

		Persona persona = new Persona();

		persona.setId(rs.getLong("idPersona"));
		persona.setDni(rs.getString("dni"));
		persona.setNombre(rs.getString("nombre"));
		persona.setApellido1(rs.getString("apellido1"));
		persona.setApellido2(rs.getString("apellido2"));
		persona.setEmail(rs.getString("email"));
		persona.setRol(rs.getString("rol"));

		return persona;

	}


}
