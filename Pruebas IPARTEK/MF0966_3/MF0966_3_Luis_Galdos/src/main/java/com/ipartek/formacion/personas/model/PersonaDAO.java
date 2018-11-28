package com.ipartek.formacion.personas.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.personas.connection.ConnectionManager;
import com.ipartek.personas.personas.pojo.Persona;

public class PersonaDAO implements CrudAble<Persona> {

	private static final Logger LOG = Logger.getLogger(PersonaDAO.class);
	
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
		boolean resul = false ;
		
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
	
	public boolean insertMultiple(ArrayList<Persona> personas) throws Exception {
		
		boolean resul = false;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement sp = con.prepareCall("{CALL personaInsert(?, ?, ?, ?, ?, ?, ?)}");) {

			con.setAutoCommit(false);

			int i = 0;

			for (Persona pojo : personas) {	// Para cada persona en personas

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

				if (resultado == 1) {

					int id = sp.getInt("o_id");
					pojo.setId(id);
					LOG.debug(pojo);

				} else {
					
					//con.rollback();
				}
					
				// Eliminar al acabar las pruebas
				/*
				i++;
				if (i == 50) {
					break;
				}
				*/
			}

			con.commit();
			resul = true;

		} 

		return resul;
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
